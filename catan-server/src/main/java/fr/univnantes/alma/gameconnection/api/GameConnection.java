package fr.univnantes.alma.gameconnection.api;

import fr.univnantes.alma.gamemanager.manager.api.exceptions.GameCreationException;
import fr.univnantes.alma.gamemanager.manager.api.exceptions.GameFullException;
import fr.univnantes.alma.gamemanager.manager.api.exceptions.GameIDWrongFormatException;
import fr.univnantes.alma.gamemanager.manager.api.exceptions.GameNotFoundException;

public interface GameConnection {
    /**
     * @return Returns a GameParameters object with will contain connection for WebSocket initialization and connection
     * @throws GameCreationException If something goes wrong during the game creation process, an exception is thrown
     */
    GameParameters createGame() throws GameCreationException;

    /**
     * @param gameID The gameID of the game you want to join
     * @return Returns a GameParameters object with will contain connection for WebSocket initialization and connection
     * @throws GameFullException          Cannot join a game if it is already full
     * @throws GameNotFoundException      Cannot find the game
     * @throws GameIDWrongFormatException The provided gameID is formatted wrongly
     */
    GameParameters joinGame(String gameID) throws GameFullException, GameNotFoundException, GameIDWrongFormatException;
}
