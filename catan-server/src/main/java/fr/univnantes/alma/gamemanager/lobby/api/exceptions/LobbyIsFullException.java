package fr.univnantes.alma.gamemanager.lobby.api.exceptions;

public class LobbyIsFullException extends Exception {
    public LobbyIsFullException(String message) {
        super(message);
    }
}
