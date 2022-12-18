package fr.univnantes.alma.gamemanager.manager.api;

import fr.univnantes.alma.gameconnection.api.GameParameters;
import fr.univnantes.alma.gamemanager.manager.api.exceptions.GameCreationException;
import fr.univnantes.alma.gamemanager.manager.api.exceptions.GameFullException;
import fr.univnantes.alma.gamemanager.manager.api.exceptions.GameNotFoundException;

public interface GameManager {

    GameParameters createGame() throws GameCreationException;

    GameParameters joinGame(Integer gameID) throws GameFullException, GameNotFoundException;
}
