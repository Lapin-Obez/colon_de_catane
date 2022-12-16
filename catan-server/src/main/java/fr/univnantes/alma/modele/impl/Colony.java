package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Construction;
import fr.univnantes.alma.modele.api.enums.Color;

public class Colony implements Construction {

    private Color color;
    private int power;

    public Colony(Color color) {
        this.power = 1;
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public int getPower() {
        return this.power;
    }
}
