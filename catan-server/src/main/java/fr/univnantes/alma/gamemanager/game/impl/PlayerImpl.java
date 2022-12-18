package fr.univnantes.alma.gamemanager.game.impl;

import fr.univnantes.alma.gamemanager.game.api.Harbor;
import fr.univnantes.alma.gamemanager.game.api.Player;
import fr.univnantes.alma.gamemanager.game.api.enums.Color;
import fr.univnantes.alma.gamemanager.game.api.enums.Development;
import fr.univnantes.alma.gamemanager.game.api.enums.Resource;
import fr.univnantes.alma.gamemanager.game.api.enums.SpecialCard;
import fr.univnantes.alma.gamemanager.game.api.exceptions.NotEnoughDevelopmentCardException;
import fr.univnantes.alma.gamemanager.game.api.exceptions.NotEnoughResourcesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerImpl implements Player {

    private Color color;
    private Map<Resource,Integer> mainResource;
    private Map<Development,Integer> mainDevelopment;
    private int numberOfKnight;
    private List<SpecialCard> specialCards;
    public PlayerImpl(Color color){
        this();
        this.color = color;
        for(Resource r: Resource.values()){
            this.mainResource.put(r,0);
        }
        for(Development d: Development.values()){
            this.mainDevelopment.put(d,0);
        }
        this.specialCards = new ArrayList<>();
    }
    public PlayerImpl(){
        this.numberOfKnight=0;
    }
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
        return this.numberOfKnight;
    }

    @Override
    public void grantSpecialCard(SpecialCard card) {
        if(!this.specialCards.contains(card)){
            this.specialCards.add(card);
        }
    }

    @Override
    public void removeSpecialCard(SpecialCard card) {
        if(this.specialCards.contains(card)){
            this.specialCards.remove(card);
        }
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
    public void addResource(Resource resource,Integer amount) {

    }
    @Override
    public List<SpecialCard> getSpecialCards(){
        return this.specialCards;
    }
}
