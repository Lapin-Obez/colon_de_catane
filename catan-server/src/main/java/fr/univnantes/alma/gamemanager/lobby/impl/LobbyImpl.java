package fr.univnantes.alma.gamemanager.lobby.impl;

import fr.univnantes.alma.gamemanager.game.api.Game;
import fr.univnantes.alma.gamemanager.game.impl.GameImpl;
import fr.univnantes.alma.gamemanager.lobby.api.Lobby;
import fr.univnantes.alma.gamemanager.lobby.api.enums.LobbyStatus;
import fr.univnantes.alma.gamemanager.lobby.api.exceptions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LobbyImpl implements Lobby {

    private final int gameID;
    private LobbyStatus status;
    private Game game;
    private List<Integer> playerIDList;

    private int maxPlayerNumber;

    public LobbyImpl(int gameID) {
        this.status = LobbyStatus.CREATED;
        this.gameID = gameID;
        this.playerIDList = new ArrayList<>();
        this.maxPlayerNumber = 4;
    }

    private int countActivePlayers() {
        int registeredPlayers = 0;
        for (Integer i : this.playerIDList) if (i != null) registeredPlayers++;

        return registeredPlayers;
    }

    @Override
    public void startGame() throws NotEnoughPlayersException, LobbyNotReadyException, LobbyGameOverException, LobbyAlreadyStartedException {
        synchronized (LobbyImpl.class) {
            if (this.status == LobbyStatus.CREATED) throw new LobbyNotReadyException("The lobby is not ready");
            if (this.status == LobbyStatus.WAIT_FOR_PLAYERS)
                throw new LobbyNotReadyException("The lobby doesn't have enough players to start");
            if (this.status == LobbyStatus.IN_PROGRESS)
                throw new LobbyAlreadyStartedException("The game already started");
            if (this.status == LobbyStatus.FINISHED) throw new LobbyGameOverException("The game is finished");

            int registeredPlayers = countActivePlayers();

            if (registeredPlayers < 3)
                throw new NotEnoughPlayersException("Number of registered players is not enough to start the game");

            this.maxPlayerNumber = registeredPlayers;
            this.game = new GameImpl(this.maxPlayerNumber);
            this.status = LobbyStatus.IN_PROGRESS;
        }
    }

    @Override
    public void openLobbyToPlayers() throws LobbyGameOverException, LobbyAlreadyStartedException {
        if (this.status == LobbyStatus.IN_PROGRESS) throw new LobbyAlreadyStartedException("The game already started");
        if (this.status == LobbyStatus.FINISHED) throw new LobbyGameOverException("The game is finished");

        this.status = LobbyStatus.WAIT_FOR_PLAYERS;
    }

    @Override
    public Integer addPlayer() throws LobbyGameOverException, LobbyIsFullException {
        if (this.status == LobbyStatus.FINISHED) throw new LobbyGameOverException("The game is finished");

        Integer playerID;

        //  Needed to handle concurrency
        synchronized (LobbyImpl.class) {

            int numberOfRegisteredPlayers = countActivePlayers();

            if (numberOfRegisteredPlayers >= this.maxPlayerNumber)
                throw new LobbyIsFullException("This lobby is already full");

            playerID = new Date().hashCode();

            if (this.playerIDList.size() < this.maxPlayerNumber) {
                this.playerIDList.add(playerID);
            } else {
                int emptyPlaceIndex = this.playerIDList.lastIndexOf(null);
                this.playerIDList.set(emptyPlaceIndex, playerID);
            }

            if (numberOfRegisteredPlayers + 1 > 2) this.status = LobbyStatus.READY_TO_START;
        }
        return playerID;
    }

    @Override
    public void removePlayer(Integer playerID) throws LobbyGameOverException, PlayerNotFoundException {
        if (this.status == LobbyStatus.FINISHED) throw new LobbyGameOverException("The game is finished");

        synchronized (LobbyImpl.class) {
            int removedUserIndex = this.playerIDList.indexOf(playerID);
            if (removedUserIndex == -1) throw new PlayerNotFoundException("Player is not registered in this lobby");

            this.playerIDList.set(removedUserIndex, null);

            if (countActivePlayers() < 3) this.status = LobbyStatus.WAIT_FOR_PLAYERS;
        }
    }

    @Override
    public int getGameID() {
        return this.gameID;
    }

    @Override
    public LobbyStatus getLobbyStatus() {
        return this.status;
    }
}
