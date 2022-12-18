package fr.univnantes.alma.gamemanager.manager.impl;

import fr.univnantes.alma.gameconnection.api.GameParameters;
import fr.univnantes.alma.gamefactory.api.GameFactory;
import fr.univnantes.alma.gamefactory.impl.GameFactoryImpl;
import fr.univnantes.alma.gamemanager.lobby.api.Lobby;
import fr.univnantes.alma.gamemanager.lobby.api.enums.LobbyStatus;
import fr.univnantes.alma.gamemanager.lobby.api.exceptions.LobbyGameOverException;
import fr.univnantes.alma.gamemanager.lobby.api.exceptions.LobbyIsFullException;
import fr.univnantes.alma.gamemanager.manager.api.GameManager;
import fr.univnantes.alma.gamemanager.manager.api.exceptions.GameCreationException;
import fr.univnantes.alma.gamemanager.manager.api.exceptions.GameFullException;
import fr.univnantes.alma.gamemanager.manager.api.exceptions.GameNotFoundException;

import java.util.HashMap;
import java.util.Random;

public class GameManagerImpl implements GameManager {

    private final int GAME_NB_LIMIT = 10;
    private HashMap<Integer, Lobby> gamesMap;
    private GameFactory gameFactory;
    private Random randomGenerator;


    public GameManagerImpl() {
        this.gameFactory = new GameFactoryImpl().getInstance();

        this.gamesMap = new HashMap<>();

        this.randomGenerator = new Random();
    }


    @Override
    public GameParameters createGame() throws GameCreationException {
        if (this.gamesMap.size() >= this.GAME_NB_LIMIT)
            throw new GameCreationException("Maximum number of games reached, cannot create new games");

        boolean isUniqueID = false;
        int retries = 0;
        Integer rndInt = -1;

        //  Needed to ensure critical section respect
        //  To avoid potential duplications or deletion by rewrite
        synchronized (GameManagerImpl.class) {
            while (!isUniqueID && retries < 5) {
                rndInt = this.randomGenerator.nextInt(0, Integer.MAX_VALUE);
                isUniqueID = !this.gamesMap.containsKey(rndInt);
                if (!isUniqueID) retries++;
            }
            if (!isUniqueID && retries == 5) throw new GameCreationException("Unable to generate unique game ID");
            //  Just reserve the place for our new Lobby
            this.gamesMap.put(rndInt, null);
        }

        Lobby generatedLobby = this.gameFactory.createLobby(rndInt);
        this.gamesMap.replace(rndInt, generatedLobby);
        //  Now generate playerID

        GameParameters gameParameters;
        try {
            Integer playerID = generatedLobby.addPlayer();
            gameParameters = new GameParameters(String.valueOf(generatedLobby.getGameID()),
                    String.valueOf(playerID));
            generatedLobby.openLobbyToPlayers();
        } catch (Exception e) {
            this.gamesMap.remove(rndInt);
            throw new GameCreationException("Unable to set a game properly");
        }
        return gameParameters;
    }

    @Override
    public GameParameters joinGame(Integer gameID) throws GameFullException, GameNotFoundException {
        if (!this.gamesMap.containsKey(gameID)) throw new GameNotFoundException("That game does not exist");

        Lobby requestedLobby = this.gamesMap.get(gameID);

        if (requestedLobby.getLobbyStatus() == LobbyStatus.CREATED)
            throw new GameNotFoundException("That game does not exist yet");
        if (requestedLobby.getLobbyStatus() == LobbyStatus.FINISHED)
            throw new GameNotFoundException("That game does not exist");

        Integer playerID;

        try {
            playerID = requestedLobby.addPlayer();
        } catch (LobbyIsFullException e) {
            throw new GameFullException("That game is full");
        } catch (LobbyGameOverException e) {
            throw new GameNotFoundException("That game does not exist");
        }

        GameParameters gameParameters = new GameParameters(String.valueOf(gameID), String.valueOf(playerID));

        return gameParameters;
    }
}
