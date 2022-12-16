package fr.univnantes.alma.gamemanager.game.impl;

import fr.univnantes.alma.gamemanager.game.api.Construction;
import fr.univnantes.alma.gamemanager.game.api.enums.Color;

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
