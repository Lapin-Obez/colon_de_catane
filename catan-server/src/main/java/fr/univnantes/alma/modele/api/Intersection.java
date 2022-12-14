package fr.univnantes.alma.modele.api;

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

    Port getPort();
}
