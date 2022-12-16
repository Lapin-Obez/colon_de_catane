package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Harbor;
import fr.univnantes.alma.modele.api.Player;
import fr.univnantes.alma.modele.api.enums.Color;
import fr.univnantes.alma.modele.api.enums.Development;
import fr.univnantes.alma.modele.api.enums.Resource;
import fr.univnantes.alma.modele.api.enums.SpecialCard;
import fr.univnantes.alma.modele.api.exceptions.NotEnoughDevelopmentCardException;
import fr.univnantes.alma.modele.api.exceptions.NotEnoughResourcesException;

import java.util.List;
import java.util.Map;

public class PlayerImpl implements Player {

    private Color color;
    private Map<Integer, Resource> mainResource;
    private Map<Integer, Development> mainDevelopment;
    private int numberOfKnight;
    private List<SpecialCard> specialCards;

    @Override
    public void maritimeTrade(Resource rDefausse, Resource rRecup) {

    }

    @Override
    public void addHarbour(Harbor harbor) {

    }

    @Override
    public int getVictoryPoints() {
        return 0;
    }

    @Override
    public int getNumberOfKnight() {
        return 0;
    }

    @Override
    public void grantSpecialCard(SpecialCard card) {

    }

    @Override
    public void removeSpecialCard(SpecialCard card) {

    }

    @Override
    public void addDevelopmentCard(Development card) {

    }

    @Override
    public Resource getRandomResources() throws NotEnoughResourcesException {
        return null;
    }

    @Override
    public void deleteHalfResources() {

    }

    @Override
    public int deleteResource(Resource resource) {
        return 0;
    }

    @Override
    public void playDevelopmentCard(Development type) throws NotEnoughDevelopmentCardException {

    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int getNumberOfResources(Resource resource) {
        return 0;
    }

    @Override
    public void deleteResources(Resource resource, int amount) throws NotEnoughResourcesException {

    }

    @Override
    public void addResource(Resource resource) {

    }
}
