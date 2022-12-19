package fr.univnantes.alma.gamemanager.game.impl;

import fr.univnantes.alma.gamemanager.game.api.Harbor;
import fr.univnantes.alma.gamemanager.game.api.enums.ExchangeRate;
import fr.univnantes.alma.gamemanager.game.api.enums.Resource;

import java.util.Optional;

public class HarborImpl implements Harbor {
    private static final Harbor BASIC_HARBOR = new HarborImpl(ExchangeRate.quatre);

    private final ExchangeRate rate;
    private final Resource resource;

    public HarborImpl(ExchangeRate rate, Resource resource) {
        this(rate);
        this.resource = resource;
    }

    public HarborImpl(ExchangeRate rate) {
        this.rate = rate;
    }

    @Override
    public Optional<Resource> getResource() {
        return Optional.empty();
    }

    @Override
    public ExchangeRate getRate() {
        return this.rate;
    }

    @Override
    public int exchange(Resource resource) {
        if (resource == this.resource)
            return this.rate.value;
        return ExchangeRate.quatre.value;
    }

    @Override
    public boolean haveBetterRate(Harbor other) {
        return this.rate.value > other.getRate().value;
    }
}
