package fr.univnantes.alma.gamemanager.game.impl;

import fr.univnantes.alma.gamemanager.game.api.Harbor;
import fr.univnantes.alma.gamemanager.game.api.enums.ExchangeRate;
import fr.univnantes.alma.gamemanager.game.api.enums.Resource;

import java.util.Optional;

public class HarborImpl implements Harbor {
    private static final Harbor BASIC_HARBOR = new HarborImpl(ExchangeRate.quatre);

    private final ExchangeRate taux;
    private final Resource resource;

    public HarborImpl(ExchangeRate taux, Resource resource) {
        this(taux);
        this.resource = resource;
    }

    public HarborImpl(ExchangeRate taux) {
        this.taux = taux;
    }

    @Override
    public Optional<Resource> getResource() {
        return Optional.empty();
    }

    @Override
    public int exchange(Resource resource) {
        return 0;
    }

    @Override
    public boolean haveBetterRate(Harbor other) {
        return false;
    }
}
