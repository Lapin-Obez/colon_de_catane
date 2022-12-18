package fr.univnantes.alma.gamemanager.lobby.api.enums;

public enum LobbyStatus {
    //  Created but not ready for players
    CREATED,
    //  Ready for players but not enough players to start
    WAIT_FOR_PLAYERS,
    //  Ready for players and enough players to start
    READY_TO_START,
    //  Game started
    IN_PROGRESS,
    //  Game finished
    FINISHED;
}
