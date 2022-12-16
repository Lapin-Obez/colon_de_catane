package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.*;
import fr.univnantes.alma.modele.api.enums.Couleur;
import fr.univnantes.alma.modele.api.enums.Ressource;
import fr.univnantes.alma.modele.api.exceptions.ImpossibleBuildException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PlateauImpl implements Plateau {
    private final Integer NBINTERSECTIONS = 54;
    private int idTuileVoleur;
    private Map<Integer, Map<Integer, Couleur>> routes;
    private Map<Integer, Intersection> intersections;
    private Map<Integer, Tuile> tuiles;

    public PlateauImpl() {
        this.intersections = new HashMap<>();
        //Création de la liste des intersections
        for (int i=1; i<=NBINTERSECTIONS;i++){
            this.intersections.put(i,new IntersectionImpl());
        }
        this.tuiles = new HashMap<>();
        ConstructeurTuile();
    }
    //méthode de création et remplissage de la map tuiles
    private void ConstructeurTuile(){
        for(int i =0;i<20;i++){
            //CreateurTuile(i,,,);
        }

    }
    //Création d'une tuile avec toutes les intersections autour de la tuile
    private Tuile CreateurTuile(Integer id, Integer intersection, Ressource ressource, int valJeton){
        List<Intersection> contourTuile;
        contourTuile = new ArrayList<>();
        contourTuile.add(this.intersections.get(intersection));
        contourTuile.add(this.intersections.get(intersection+1));
        contourTuile.add(this.intersections.get(intersection+2));
        //En fonction de ligne de la tuile, l'écart entre les id des intersections en haut et en bas de la tuile peut augmenter
        //Cette conditionnelle est là pour attribuer le bon écart en fonction de la ligne de la tuile.
        if(id<4||id>16){
            intersection = intersection + 8;
        }else if(id<8||id>12){
            intersection = intersection + 10;
        }else{
            intersection = intersection + 11;
        }
        contourTuile.add(this.intersections.get(intersection));
        contourTuile.add(this.intersections.get(intersection+1));
        contourTuile.add(this.intersections.get(intersection+2));
        return new TuileImpl(contourTuile,ressource,valJeton);
    }
    @Override
    public int getLongueurRoute(Couleur couleur) {
        return 0;
    }

    @Override
    public void deplacerVoleur(int idTuile) {

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
    public Map<Couleur, Map<Ressource, Integer>> distribuerRessources(int valeurJeton) {

        return null;
    }

    @Override
    public List<Joueur> jouerVoleur(int idTuile) throws IllegalArgumentException {
        return null;
    }
}
