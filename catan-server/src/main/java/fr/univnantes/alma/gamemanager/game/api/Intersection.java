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

    /**
     * Permet de set le port de l'intersection.
     * @param harbor le Port.
     */
    void setHarbour(Harbor harbor);
}
