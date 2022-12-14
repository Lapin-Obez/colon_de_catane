package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Intersection;
import fr.univnantes.alma.modele.api.Plateau;
import fr.univnantes.alma.modele.api.Tuile;
import fr.univnantes.alma.modele.api.enums.Couleur;

import java.util.Map;

public class PlateauImpl implements Plateau {

    private int idTuileVoleur;
    private Map<Integer, Map<Integer, Couleur>> routes;
    private Map<Integer, Intersection> intersections;
    private Map<Integer, Tuile> tuiles;

    public PlateauImpl() {
    }


    @Override
    public int getLongueurRoute(Couleur couleur) {
        return 0;
    }

    @Override
    public void deplacerVoleur(int idTuile) {

    }

    @Override
    public void distribuerRessources(int valeurJeton) {

    }
}
