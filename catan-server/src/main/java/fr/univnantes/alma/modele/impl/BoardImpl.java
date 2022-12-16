package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.*;
import fr.univnantes.alma.modele.api.enums.Color;
import fr.univnantes.alma.modele.api.enums.ExchangeRate;
import fr.univnantes.alma.modele.api.enums.Resource;
import fr.univnantes.alma.modele.api.exceptions.ImpossibleBuildException;

import java.util.*;

public class BoardImpl implements Board {
    private final Integer NBINTERSECTIONS = 54;
    private Integer idTuileVoleur;
    private Map<Integer, Map<Integer, Color>> routes;
    private Map<Integer, Intersection> intersections;
    private Map<Integer, Tile> tiles;

    public BoardImpl() {
        this.intersections = new HashMap<>();
        //Création de la liste des intersections
        for (int i=1; i<=NBINTERSECTIONS;i++){
            Intersection inter = new IntersectionImpl();
            this.intersections.put(i,inter);
        }
        addHarbour();
        this.tiles = new HashMap<>();
        TilesConstructor();
        this.routes= new HashMap<>();
        roadConstructor();
    }

    private void addHarbour(){
        Harbour harbour = new HarbourImpl(ExchangeRate.trois,null);
        Intersection inter = this.intersections.get(1);
        inter.setHarbour(harbour);
        inter = this.intersections.get(2);
        inter.setHarbour(harbour);
        harbour = new HarbourImpl(ExchangeRate.deux,Resource.Laine);
        inter = this.intersections.get(4);
        inter.setHarbour(harbour);
        inter = this.intersections.get(5);
        inter.setHarbour(harbour);
        harbour = new HarbourImpl(ExchangeRate.trois,null);
        inter = this.intersections.get(15);
        inter.setHarbour(harbour);
        inter = this.intersections.get(16);
        inter.setHarbour(harbour);
        harbour = new HarbourImpl(ExchangeRate.trois,null);
        inter = this.intersections.get(27);
        inter.setHarbour(harbour);
        inter = this.intersections.get(38);
        inter.setHarbour(harbour);
        harbour = new HarbourImpl(ExchangeRate.deux,Resource.Argile);
        inter = this.intersections.get(46);
        inter.setHarbour(harbour);
        inter = this.intersections.get(47);
        inter.setHarbour(harbour);
        harbour = new HarbourImpl(ExchangeRate.deux,Resource.Bois);
        inter = this.intersections.get(51);
        inter.setHarbour(harbour);
        inter = this.intersections.get(52);
        inter.setHarbour(harbour);
        harbour = new HarbourImpl(ExchangeRate.trois,null);
        inter = this.intersections.get(48);
        inter.setHarbour(harbour);
        inter = this.intersections.get(49);
        inter.setHarbour(harbour);
        harbour = new HarbourImpl(ExchangeRate.deux,Resource.Blé);
        inter = this.intersections.get(39);
        inter.setHarbour(harbour);
        inter = this.intersections.get(29);
        inter.setHarbour(harbour);
        harbour = new HarbourImpl(ExchangeRate.deux,Resource.Minerai);
        inter = this.intersections.get(8);
        inter.setHarbour(harbour);
        inter = this.intersections.get(18);
        inter.setHarbour(harbour);
    }
    //fill tiles map
    private void TilesConstructor(){
        List<Resource> resources = boardRessources();
        List<Integer> tokenValue = createTokenValue();
        Integer tokenVal;
        Integer intersectionNumber = 0;
        for(int i =0;i<20;i++){
            if (i<8 && i>3){
                intersectionNumber = 1;
            }else if(i<13){
                intersectionNumber = 2;
            }else if(i<17){
                intersectionNumber = 4;
            }else{
                intersectionNumber = 7;
            }
            if(resources.get(0)==null){
                tokenVal = 0;
                this.idTuileVoleur = i;
            }else{
                tokenVal = tokenValue.remove(0);
            }
            this.tiles.put(i,TileGenerator(i,intersectionNumber+i*2,resources.remove(0),tokenVal));
        }
    }
    /*
     * Méthode de création de la liste des valeurs des tuiles
     */
    private List<Integer> createTokenValue(){
        List<Integer> li = new ArrayList<>();
        int[] tab = {5,2,6,10,9,4,3,8,11,5,8,4,3,6,10,11,12,9};
        for (int i=0;i<tab.length;i++){
            li.add(tab[i]);
        }
        return li;
    }
    /*
    * Méthode de création de la liste des ressources présentes sur le plateau.
    */
    private List<Resource> boardRessources(){
        List<Resource> li = new ArrayList<>();
        for(int i =0;i<4;i++){
            li.add(Resource.Bois);
            li.add(Resource.Blé);
            li.add(Resource.Laine);
        }
        for(int i =0;i<3;i++){
            li.add(Resource.Argile);
            li.add(Resource.Minerai);
        }
        li.add(null);
        Collections.shuffle(li);
        return li;
    }
    //Création d'une tuile avec toutes les intersections autour de la tuile
    private Tile TileGenerator(Integer id, Integer intersection, Resource resource, int valJeton){
        List<Intersection> tileOutline;
        tileOutline = new ArrayList<>();
        tileOutline.add(this.intersections.get(intersection-1));
        tileOutline.add(this.intersections.get(intersection));
        tileOutline.add(this.intersections.get(intersection+1));
        //En fonction de ligne de la tuile, l'écart entre les id des intersections en haut et en bas de la tuile peut augmenter
        //Cette conditionnelle est là pour attribuer le bon écart en fonction de la ligne de la tuile.
        if(id<4||id>16){
            intersection = intersection + 8;
        }else if(id<8||id>12){
            intersection = intersection + 10;
        }else{
            intersection = intersection + 11;
        }
        tileOutline.add(this.intersections.get(intersection-1));
        tileOutline.add(this.intersections.get(intersection));
        tileOutline.add(this.intersections.get(intersection+1));
        return new TileImpl(tileOutline, resource,valJeton);
    }
    private void roadConstructor(){
        for(int i =0;i<6;i++){
            switch(i){
                case 1:
                    buildIntersectionLine(1,7,1,8,null);
                    break;
                case 2:
                    buildIntersectionLine(8,16,0,10,8);
                    break;
                case 3:
                    buildIntersectionLine(17,27,1,11,10);
                    break;
                case 4:
                    buildIntersectionLine(28,38,0,10,11);
                    break;
                case 5:
                    buildIntersectionLine(39,47,1,8,10);
                    break;
                default:
                    buildIntersectionLine(48,NBINTERSECTIONS,1,null,8);
                    break;
            }
        }
    }

    private void buildIntersectionLine(Integer begin, Integer end,Integer isodd,Integer increase,Integer decrease){
        for(Integer i = begin;i<=end;i++){
            Map<Integer,Color> map = new HashMap<>();

            //Si on est pas le premier élément de la ligne, on se lie a son i-1
            if(i!=begin){
                map.put(i-1,null);
            }
            //Si on est pas le dernier élément de la ligne, on se lie à son i+1
            if (i!=end) {
                map.put(i+1,null);
            }
            if(isodd==1){
                if(i%2==0){
                    if(increase!=null){
                        map.put(i+increase,null);
                    }
                }else{
                    if(decrease!=null){
                        map.put(i-decrease,null);
                    }
                }
            }else{
                if(i%2==0){
                    if(decrease!=null){
                        map.put(i-decrease,null);
                    }
                }else{
                    if(increase!=null){
                        map.put(i+increase,null);
                    }
                }
            }
            this.routes.put(i,map);
        }
    }
    @Override
    public int getRoadLength(Color color) {
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

    public Integer getIdTuileVoleur() {
        return idTuileVoleur;
    }

    public Map<Integer, Map<Integer, Color>> getRoutes() {
        return routes;
    }

    public Map<Integer, Intersection> getIntersections() {
        return intersections;
    }

    public Map<Integer, Tile> getTiles() {
        return tiles;
    }
}
