package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Construction;
import fr.univnantes.alma.modele.api.enums.Color;

public class City implements Construction {

    private Color color;
    private int power;

    public City(Color color) {
        this.power = 2;
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public int getPower() {
        return this.power;
    }
}
