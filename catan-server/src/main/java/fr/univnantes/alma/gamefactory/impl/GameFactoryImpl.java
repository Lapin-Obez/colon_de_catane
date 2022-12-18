package fr.univnantes.alma.gamefactory.impl;

import fr.univnantes.alma.gamefactory.api.GameFactory;
import fr.univnantes.alma.gamemanager.lobby.api.Lobby;
import fr.univnantes.alma.gamemanager.lobby.impl.LobbyImpl;

public class GameFactoryImpl implements GameFactory {

    private static volatile GameFactory factory;

    @Override
    public GameFactory getInstance() {
        if (factory == null) {
            synchronized (GameFactoryImpl.class) {
                if (factory == null) factory = new GameFactoryImpl();
            }
        }
        return factory;
    }

    @Override
    public Lobby createLobby(int gameID) {
        return new LobbyImpl(gameID);
    }
}
