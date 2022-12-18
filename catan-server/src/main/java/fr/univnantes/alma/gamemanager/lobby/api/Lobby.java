package fr.univnantes.alma.gamemanager.lobby.api;

import fr.univnantes.alma.gamemanager.lobby.api.enums.LobbyStatus;
import fr.univnantes.alma.gamemanager.lobby.api.exceptions.*;

/**
 *
 */
public interface Lobby {

    /**
     * @throws NotEnoughPlayersException    There is not enough players to start a game
     * @throws LobbyNotReadyException       The lobby cannot start, it just has been created, but it is not ready to start
     * @throws LobbyGameOverException       Cannot start a game that have been already played
     * @throws LobbyAlreadyStartedException Cannot start a game that is already started
     */
    void startGame() throws NotEnoughPlayersException, LobbyNotReadyException, LobbyGameOverException, LobbyAlreadyStartedException;

    /**
     * @throws LobbyGameOverException       Cannot open a game to player with a game that have been already played
     * @throws LobbyAlreadyStartedException Cannot open a game to player with a game that have been already started
     */
    void openLobbyToPlayers() throws LobbyGameOverException, LobbyAlreadyStartedException;


    /**
     * @return Generated playerID
     * @throws LobbyGameOverException Cannot add player to a terminated game
     * @throws LobbyIsFullException   Cannot add player when the game is full
     */
    Integer addPlayer() throws LobbyGameOverException, LobbyIsFullException;

    /**
     * @param playerID The playerID you want to remove form the lobby
     * @throws LobbyGameOverException  Cannot remove a player from a terminated game
     * @throws PlayerNotFoundException Cannot remove a player that does not exist...
     */
    void removePlayer(Integer playerID) throws LobbyGameOverException, PlayerNotFoundException;

    /**
     * @return The id of the game
     */
    int getGameID();


    /**
     * @return The status of the lobby
     */
    LobbyStatus getLobbyStatus();
}
