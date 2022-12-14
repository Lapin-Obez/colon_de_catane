package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Intersection;
import fr.univnantes.alma.modele.api.Tuile;
import fr.univnantes.alma.modele.api.enums.Couleur;
import fr.univnantes.alma.modele.api.enums.Ressource;

import java.util.List;
import java.util.Map;

public class TuileImpl implements Tuile {

    private List<Intersection> listIntersections;
    private final Ressource ressource;
    private int valeurJeton;

    public TuileImpl(List<Intersection> listIntersections, Ressource ressource, int valeurJeton) {
        this.listIntersections = listIntersections;
        this.ressource = ressource;
        this.valeurJeton = valeurJeton;
    }

    @Override
    public List<Intersection> getIntersections() {
        return this.listIntersections;
    }

    @Override
    public Ressource getRessource() {
        return ressource;
    }

    @Override
    public Map<Couleur, Map<Ressource, Integer>> distribuerRessources() {
        return null;
    }

    @Override
    public int getValeurJeton() {
        return valeurJeton;
    }
}
