package fr.univnantes.alma.gameconnection.api;

public class GameParameters {
    private String gameID;
    private String playerID;

    public GameParameters() {
    }

    public GameParameters(String gameID, String playerID) {
        this.gameID = gameID;
        this.playerID = playerID;
    }

    public String getGameID() {
        return gameID;
    }

    public String getPlayerID() {
        return playerID;
    }
}
