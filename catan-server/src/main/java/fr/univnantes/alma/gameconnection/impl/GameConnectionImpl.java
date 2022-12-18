package fr.univnantes.alma.gameconnection.impl;

import fr.univnantes.alma.gameconnection.api.GameConnection;
import fr.univnantes.alma.gameconnection.api.GameParameters;
import fr.univnantes.alma.gamemanager.manager.api.GameManager;
import fr.univnantes.alma.gamemanager.manager.api.exceptions.GameCreationException;
import fr.univnantes.alma.gamemanager.manager.api.exceptions.GameFullException;
import fr.univnantes.alma.gamemanager.manager.api.exceptions.GameIDWrongFormatException;
import fr.univnantes.alma.gamemanager.manager.api.exceptions.GameNotFoundException;

public class GameConnectionImpl implements GameConnection {


    private GameManager gameManager;

    public GameConnectionImpl(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public GameParameters createGame() throws GameCreationException {
        return this.gameManager.createGame();
    }

    @Override
    public GameParameters joinGame(String gameID) throws GameFullException, GameNotFoundException, GameIDWrongFormatException {
        Integer parsedGameID;

        try {
            parsedGameID = Integer.parseInt(gameID);
        } catch (NumberFormatException e) {
            throw new GameIDWrongFormatException("Provided gameID is not formatted correctly");
        }

        if (parsedGameID < 0) throw new GameIDWrongFormatException("Provided gameID is not formatted correctly");

        return this.gameManager.joinGame(parsedGameID);
    }
}
