package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Construction;
import fr.univnantes.alma.modele.api.enums.Couleur;

abstract class ConstructionImpl implements Construction {

    private Couleur couleur;

    @Override
    public Couleur getCouleur() {
        return couleur;
    }
}
