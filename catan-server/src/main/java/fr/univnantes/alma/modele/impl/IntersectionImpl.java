package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Construction;
import fr.univnantes.alma.modele.api.Harbour;
import fr.univnantes.alma.modele.api.Intersection;

import java.util.Optional;

public class IntersectionImpl implements Intersection {

    private Construction construction;
    private Harbour harbour;

    @Override
    public void setConstruction(Construction construction) {
        this.construction = construction;
    }

    public void setPort(Harbour harbour) {
        this.harbour = harbour;
    }

    @Override
    public Construction getConstruction() {
        return null;
    }
    @Override
    public void setHarbour(Harbour h){
        this.harbour = h;
    }
    @Override
    public Optional<Harbour> getHarbour() {
        return Optional.ofNullable(this.harbour);
    }
}
