package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Intersection;
import fr.univnantes.alma.modele.api.Tuile;
import fr.univnantes.alma.modele.api.enums.Ressource;

public class TuileImpl implements Tuile {

    private Intersection[] listIntersections;
    private final Ressource ressource;
    private int valeurJeton;

    public TuileImpl(Intersection[] listIntersections, Ressource ressource, int valeurJeton) {
        this.listIntersections = listIntersections;
        this.ressource = ressource;
        this.valeurJeton = valeurJeton;
    }

    @Override
    public Intersection[] getAllIntersections() {
        return listIntersections;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public int getValeurJeton() {
        return valeurJeton;
    }
}
