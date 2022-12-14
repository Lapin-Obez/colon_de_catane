package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Construction;
import fr.univnantes.alma.modele.api.enums.Couleur;

public class ConstructionImpl implements Construction {

    private Couleur couleur;

    private Integer puissance;
    @Override
    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public int getPuissance() {
        return puissance;
    }
}
