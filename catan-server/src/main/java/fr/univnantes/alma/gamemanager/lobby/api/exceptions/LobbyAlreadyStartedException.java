package fr.univnantes.alma.gamemanager.lobby.api.exceptions;

public class LobbyAlreadyStartedException extends Exception {
    public LobbyAlreadyStartedException(String message) {
        super(message);
    }
}
