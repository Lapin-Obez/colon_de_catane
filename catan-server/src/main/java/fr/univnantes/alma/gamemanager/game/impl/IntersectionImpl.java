package fr.univnantes.alma.gamemanager.game.impl;

import fr.univnantes.alma.gamemanager.game.api.Construction;
import fr.univnantes.alma.gamemanager.game.api.Harbor;
import fr.univnantes.alma.gamemanager.game.api.Intersection;

import java.util.Optional;

public class IntersectionImpl implements Intersection {

    private Construction construction;
    private Harbor harbor;

    @Override
    public void setConstruction(Construction construction) {
        this.construction = construction;
    }

    @Override
    public void setPort(Harbor harbor) {
        this.harbor = harbor;
    }

    @Override
    public Construction getConstruction() {
        return this.construction;
    }

    @Override
    public void setHarbour(Harbor harbor){
        this.harbor = harbor;
    }
    @Override
    public Optional<Harbor> getHarbour() {
        return Optional.ofNullable(this.harbor);
    }
}
