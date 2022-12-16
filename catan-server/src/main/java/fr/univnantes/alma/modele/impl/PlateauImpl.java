package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.*;
import fr.univnantes.alma.modele.api.enums.Couleur;
import fr.univnantes.alma.modele.api.enums.Ressource;
import fr.univnantes.alma.modele.api.exceptions.ImpossibleBuildException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PlateauImpl implements Plateau {

    private Tuile tuileVoleur;
    private Map<Integer, Map<Integer, Couleur>> routes;
    private Map<Integer, Intersection> intersections;
    private Map<Integer, Tuile> tuiles;

    public PlateauImpl() {
    }

    @Override
    public Optional<Port> construireColonie(Couleur couleur, int idIntersection) throws IllegalArgumentException, ImpossibleBuildException {
        return Optional.empty();
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
