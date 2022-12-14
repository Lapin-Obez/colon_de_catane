package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Construction;
import fr.univnantes.alma.modele.api.Intersection;
import fr.univnantes.alma.modele.api.Port;

public class IntersectionImpl implements Intersection {

    private Construction construction;
    private Port port;

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
    public Port getPort() {
        return null;
    }
}
