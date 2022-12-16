package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Construction;
import fr.univnantes.alma.modele.api.Harbor;
import fr.univnantes.alma.modele.api.Intersection;

import java.util.Optional;

public class IntersectionImpl implements Intersection {

    private Construction construction;
    private Harbor harbor;

    @Override
    public void setConstruction(Construction construction) {
        this.construction = construction;
    }

    public void setPort(Harbor harbor) {
        this.harbor = harbor;
    }

    @Override
    public Construction getConstruction() {
        return null;
    }
    @Override
    public void setHarbour(Harbor h){
        this.harbor = h;
    }
    @Override
    public Optional<Harbor> getHarbour() {
        return Optional.ofNullable(this.harbor);
    }
}
