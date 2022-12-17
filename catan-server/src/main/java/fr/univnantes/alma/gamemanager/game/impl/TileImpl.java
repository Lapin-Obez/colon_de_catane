package fr.univnantes.alma.gamemanager.game.impl;

import fr.univnantes.alma.gamemanager.game.api.Intersection;
import fr.univnantes.alma.gamemanager.game.api.Tile;
import fr.univnantes.alma.gamemanager.game.api.enums.Color;
import fr.univnantes.alma.gamemanager.game.api.enums.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TileImpl implements Tile {

    private final List<Intersection> listIntersections;
    private final Resource resource;
    private final int tokenValue;

    public TileImpl(List<Intersection> listIntersections, Resource resource, int tokenValue) {
        this.listIntersections = listIntersections;
        this.resource = resource;
        this.tokenValue = tokenValue;
    }

    @Override
    public List<Intersection> getIntersections() {
        return this.listIntersections;
    }

    @Override
    public Resource getResource() {
        return resource;
    }

    @Override
    public Map<Color, Map<Resource, Integer>> distributeResources() {
        Map<Color, Map<Resource, Integer>> distributeResources = new HashMap<>();
        for(Intersection i:this.listIntersections){
            if(i.getConstruction().getClass()== Colony.class){
                Map<Resource,Integer> res = new HashMap<Resource,Integer>();
                res.put(this.resource,1);
                distributeResources.put(i.getConstruction().getColor(),res);
            }else if(i.getConstruction().getClass()== City.class){
                Map<Resource,Integer> res = new HashMap<Resource,Integer>();
                res.put(this.resource,2);
                distributeResources.put(i.getConstruction().getColor(),res);
            }
        }
        return distributeResources;
    }

    @Override
    public int getTokenValue() {
        return tokenValue;
    }
}
