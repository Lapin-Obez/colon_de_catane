package fr.univnantes.alma.gamemanager.game.api;

import fr.univnantes.alma.gamemanager.game.api.enums.Resource;

import java.util.Optional;

public interface Harbor {

    /**
     * DOC TODO
     */
    Optional<Resource> getResource();

    /**
     * DOC TODO
     */
    int exchange(Resource resource);

    /**
     * DOC TODO
     */
    boolean haveBetterRate(Harbor other);

    /**
     * DOC TODO
     */
    ExchangeRate getRate();
}
