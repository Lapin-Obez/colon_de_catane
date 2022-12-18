package fr.univnantes.alma.gamemanager.manager.api.exceptions;

public class GameAlreadyStartedException extends Exception {
    public GameAlreadyStartedException(String message) {
        super(message);
    }
}
