package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Intersection;
import fr.univnantes.alma.modele.api.Tile;
import fr.univnantes.alma.modele.api.enums.Color;
import fr.univnantes.alma.modele.api.enums.Resource;

import java.util.List;
import java.util.Map;

public class TileImpl implements Tile {

    private final List<Intersection> listIntersections;
    private final Resource resource;
    private final int valeurJeton;

    public TileImpl(List<Intersection> listIntersections, Resource resource, int valeurJeton) {
        this.listIntersections = listIntersections;
        this.resource = resource;
        this.valeurJeton = valeurJeton;
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
        return null;
    }

    @Override
    public int getTokenValue() {
        return valeurJeton;
    }
}
