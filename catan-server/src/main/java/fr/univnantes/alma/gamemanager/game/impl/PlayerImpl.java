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
import java.util.Objects;

public class PlayerImpl implements Player {

    private Color color;
    private Map<Resource,Integer> mainResource;
    private Map<Development,Integer> mainDevelopment;
    private int numberOfKnight;
    private List<SpecialCard> specialCards;
    private List<Harbor> harbor;
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
        this.harbor = new ArrayList<>();
    }
    public PlayerImpl(){
        this.numberOfKnight=0;
    }
    @Override
    public void maritimeTrade(Resource rDefausse, Resource rRecup) {

    }

    @Override
    public void addHarbour(Harbor harbor) {
        this.harbor.add(harbor);
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
        this.mainDevelopment.replace(card,this.mainDevelopment.get(card)+1);
    }

    @Override
    public Resource getRandomResources() throws NotEnoughResourcesException {
        return null;
    }

    @Override
    public void deleteHalfResources() {
        for(Resource key : this.mainResource.keySet()){
            this.mainResource.replace(key,this.mainResource.get(key)/2);
        }
    }


    @Override
    public void playDevelopmentCard(Development type) throws NotEnoughDevelopmentCardException {
        if(this.mainDevelopment.get(type)<1){
            throw new NotEnoughDevelopmentCardException("Your don't have enough "+type+" card");
        }
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public int getNumberOfResources(Resource resource) {
        return this.mainResource.get(resource);
    }

    @Override
    public void deleteResources(Resource resource, int amount) throws NotEnoughResourcesException {
        if(this.mainResource.get(resource)<amount){
            throw new NotEnoughResourcesException("You don't have enough "+resource);
        }
        this.mainResource.replace(resource,this.mainResource.get(resource)-amount);
    }

    @Override
    public void addResource(Resource resource,Integer amount) {
        this.mainResource.replace(resource,this.mainResource.get(resource)+amount);
    }
    @Override
    public List<SpecialCard> getSpecialCards(){
        return this.specialCards;
    }
}
