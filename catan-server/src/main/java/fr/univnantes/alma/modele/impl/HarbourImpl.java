package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Harbour;
import fr.univnantes.alma.modele.api.enums.Resource;
import fr.univnantes.alma.modele.api.enums.ExchangeRate;

import java.util.Optional;

public class HarbourImpl implements Harbour {
    private final ExchangeRate taux;
    private final Resource resource;

    public HarbourImpl(ExchangeRate taux, Resource resource) {
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
    public boolean haveBetterRate(Harbour other) {
        return false;
    }
}
