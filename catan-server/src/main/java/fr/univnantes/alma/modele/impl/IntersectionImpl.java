package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Construction;
import fr.univnantes.alma.modele.api.Intersection;
import fr.univnantes.alma.modele.api.Port;

import java.util.Optional;

public class IntersectionImpl implements Intersection {

    private Construction construction;
    private Port port;

    @Override
    public void setConstruction(Construction construction) {
        this.construction = construction;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    @Override
    public Construction getConstruction() {
        return null;
    }

    @Override
    public Optional<Port> getPort() {
        return Optional.ofNullable(this.port);
    }
}
