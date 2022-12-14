package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Couleur;

public interface Construction {
    public abstract Couleur getCouleur();

    public abstract int getPuissance();
}
