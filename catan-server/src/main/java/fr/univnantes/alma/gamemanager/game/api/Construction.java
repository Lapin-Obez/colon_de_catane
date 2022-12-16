package fr.univnantes.alma.gamemanager.game.api;

import fr.univnantes.alma.gamemanager.game.api.enums.Color;

public interface Construction {

    /**
     * Retourne la couleur de la construction.
     * @return la Color.
     */
    Color getColor();

    /**
     * Retourne la puissance de la construction. 1 pour une colonie, 2 pour une ville.
     * @return un int, la puissance.
     */
    int getPower();
}
