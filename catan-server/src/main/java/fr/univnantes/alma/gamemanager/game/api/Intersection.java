package fr.univnantes.alma.gamemanager.game.api;

import java.util.Optional;

public interface Intersection {

    /**
     * Retourne la construction construite à l'intersection.
     * @return la Construction.
     */
    Construction getConstruction();

    /**
     * Permet de set la Construction construite à l'intersection.
     * @param construction la Construction.
     */
    void setConstruction(Construction construction);

    /**
     * Renvoie le potentiel port de l'intersection.
     */
    Optional<Harbor> getHarbour();

    void setHarbour(Harbor h);
}
