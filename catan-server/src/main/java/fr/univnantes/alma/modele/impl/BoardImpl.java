package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.*;
import fr.univnantes.alma.modele.api.enums.Color;
import fr.univnantes.alma.modele.api.enums.Resource;
import fr.univnantes.alma.modele.api.exceptions.ImpossibleBuildException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BoardImpl implements Board {
    private final Integer NBINTERSECTIONS = 54;
    private int idTuileVoleur;
    private Map<Integer, Map<Integer, Color>> routes;
    private Map<Integer, Intersection> intersections;
    private Map<Integer, Tile> tiles;

    public BoardImpl() {
        this.intersections = new HashMap<>();
        //Création de la liste des intersections
        for (int i=1; i<=NBINTERSECTIONS;i++){
            this.intersections.put(i,new IntersectionImpl());
        }
        this.tiles = new HashMap<>();
        TilesConstructor();
    }
    //fill tiles map
    private void TilesConstructor(){
        for(int i =0;i<20;i++){
            this.tiles.put(i,TileGenerator(i,null,null,0));
        }
    }
    //Création d'une tuile avec toutes les intersections autour de la tuile
    private Tile TileGenerator(Integer id, Integer intersection, Resource resource, int valJeton){
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
        return new TileImpl(contourTuile, resource,valJeton);
    }
    @Override
    public int getLongueurRoute(Color color) {
        return 0;
    }

    @Override
    public void moveStealer(int tileID) {

    }

    @Override
    public Optional<Harbour> buildColony(Color color, int idIntersection) throws IllegalArgumentException, ImpossibleBuildException {
        return Optional.empty();
    }

    @Override
    public void buildCity(Color color, int idIntersection) throws IllegalArgumentException, ImpossibleBuildException {

    }

    @Override
    public void buildRoad(Color color, int intersectionA, int intersectionB) throws IllegalArgumentException, ImpossibleBuildException {

    }

    @Override
    public Map<Color, Map<Resource, Integer>> distributeResources(int tokenValue) {

        return null;
    }

    @Override
    public List<Player> playStealer(int tileID) throws IllegalArgumentException {
        return null;
    }
}
