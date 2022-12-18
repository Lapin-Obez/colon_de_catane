package fr.univnantes.alma.gamemanager.lobby.api.exceptions;

public class NotEnoughPlayersException extends Exception {
    public NotEnoughPlayersException(String message) {
        super(message);
    }
}
