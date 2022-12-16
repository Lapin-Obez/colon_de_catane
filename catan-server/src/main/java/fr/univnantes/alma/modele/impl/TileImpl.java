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
        return null;
    }

    @Override
    public int getTokenValue() {
        return tokenValue;
    }
}
