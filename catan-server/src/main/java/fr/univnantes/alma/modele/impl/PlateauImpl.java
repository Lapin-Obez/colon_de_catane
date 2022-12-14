package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Intersection;
import fr.univnantes.alma.modele.api.Joueur;
import fr.univnantes.alma.modele.api.Plateau;
import fr.univnantes.alma.modele.api.Tuile;
import fr.univnantes.alma.modele.api.enums.Couleur;
import fr.univnantes.alma.modele.api.enums.Ressource;
import fr.univnantes.alma.modele.api.exceptions.ImpossibleBuildException;

import java.util.List;
import java.util.Map;

public class PlateauImpl implements Plateau {

    private int idTuileVoleur;
    private Map<Integer, Map<Integer, Couleur>> routes;
    private Map<Integer, Intersection> intersections;
    private Map<Integer, Tuile> tuiles;

    public PlateauImpl() {
    }

    @Override
    public void construireColonie(Couleur couleur, int idIntersection) throws IllegalArgumentException, ImpossibleBuildException {

    }

    @Override
    public void construireVille(Couleur couleur, int idIntersection) throws IllegalArgumentException, ImpossibleBuildException {

    }

    @Override
    public void construireRoute(Couleur couleur, int intersectionA, int intersectionB) throws IllegalArgumentException, ImpossibleBuildException {

    }

    @Override
    public Map<Couleur, Map<Ressource, Integer>> distribuerRessources(int valeurJeton) throws IllegalArgumentException {
        return null;
    }

    @Override
    public List<Joueur> jouerVoleur(int idTuile) throws IllegalArgumentException {
        return null;
    }

    @Override
    public int getLongueurRoute(Couleur couleur) {
        return 0;
    }

    @Override
    public void deplacerVoleur(int idTuile) {

    }
}
