package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Harbor;
import fr.univnantes.alma.modele.api.enums.Resource;
import fr.univnantes.alma.modele.api.enums.ExchangeRate;

import java.util.Optional;

public class HarborImpl implements Harbor {
    private final ExchangeRate taux;
    private final Resource resource;

    public HarborImpl(ExchangeRate taux, Resource resource) {
        this.taux = taux;
        this.resource = resource;
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
