package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Construction;
import fr.univnantes.alma.modele.api.enums.Color;

abstract class ConstructionImpl implements Construction {

    private Color color;

    @Override
    public Color getColor() {
        return color;
    }
}
