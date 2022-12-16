package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Player;
import fr.univnantes.alma.modele.api.Harbour;
import fr.univnantes.alma.modele.api.enums.Color;
import fr.univnantes.alma.modele.api.enums.Developpement;
import fr.univnantes.alma.modele.api.enums.Resource;
import fr.univnantes.alma.modele.api.enums.SpecialCard;
import fr.univnantes.alma.modele.api.exceptions.NotEnoughResourcesException;

import java.util.List;
import java.util.Map;

public class PlayerImpl implements Player {

    private Color color;
    private Map<Integer, Resource> mainRessource;
    private Map<Integer, Developpement> mainDeveloppement;
    private int nbChevaliers;
    private List<SpecialCard> fichesSpeciales;

    @Override
    public void maritimeTrade(Resource rDefausse, Resource rRecup) {

    }

    @Override
    public void addHarbour(Harbour harbour) {

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
    public void playKnight() {

    }

    @Override
    public void grantSpecialCard(SpecialCard fiche) {

    }

    @Override
    public void removeSpecialCard(SpecialCard fiche) {

    }

    @Override
    public void addDevelopmentCard(Developpement carte) {

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
}
