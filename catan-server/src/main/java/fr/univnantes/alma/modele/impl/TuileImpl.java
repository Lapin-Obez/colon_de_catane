package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Intersection;
import fr.univnantes.alma.modele.api.Tuile;
import fr.univnantes.alma.modele.api.enums.Ressource;

public class TuileImpl implements Tuile {

    Intersection[] listIntersections;
    Ressource ressource;
    int valeurJeton;
    @Override
    public Intersection[] getAllIntersections() {
        return new Intersection[0];
    }
}
