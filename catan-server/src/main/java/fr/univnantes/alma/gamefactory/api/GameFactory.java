package fr.univnantes.alma.gamefactory.api;

import fr.univnantes.alma.gamemanager.lobby.api.Lobby;

public interface GameFactory {

    /**
     * @return An initialized instance of GameFactory
     */
    GameFactory getInstance();

    /**
     * @param gameID The gameID of the created Lobby
     * @return The initialized Lobby object with the provided gameID
     */
    Lobby createLobby(int gameID);

}
