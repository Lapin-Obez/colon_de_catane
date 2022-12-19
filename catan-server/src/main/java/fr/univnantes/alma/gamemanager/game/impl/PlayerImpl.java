package fr.univnantes.alma.gamemanager.game.impl;

import fr.univnantes.alma.gamemanager.game.api.Harbor;
import fr.univnantes.alma.gamemanager.game.api.Player;
import fr.univnantes.alma.gamemanager.game.api.enums.*;
import fr.univnantes.alma.gamemanager.game.api.exceptions.NotEnoughDevelopmentCardException;
import fr.univnantes.alma.gamemanager.game.api.exceptions.NotEnoughResourcesException;

import java.util.*;

public class PlayerImpl implements Player {

    private Color color;
    private Map<Resource,Integer> mainResource;
    private Map<Development,Integer> mainDevelopment;
    private int numberOfKnight;
    private int constructionPoints;
    private List<SpecialCard> specialCards;
    private Map<Resource, Harbor> harbors;

    public PlayerImpl(Color color){
        this();
        this.color = color;

        this.mainResource = new HashMap<>();
        for(Resource r: Resource.values()){
            this.mainResource.put(r,0);
        }

        this.mainDevelopment = new HashMap<>();
        for(Development d: Development.values()){
            this.mainDevelopment.put(d,0);
        }

        this.specialCards = new ArrayList<>();
        this.initHarbors();
    }

    public PlayerImpl(){
        this.numberOfKnight=0;
    }

    private initHarbors() {
        this.harbors = new HashMap<>();
        for(Resource resource : Resource.values())
            this.harbors.put(resource, HarborImpl.BASIC_HARBOR);
    }

    @Override
    public void maritimeTrade(Resource rDefausse, Resource rRecup) throws NotEnoughResourcesException {
        int nbResources =  this.harbors.get(rDefausse).exchange(rDefausse);
        
        if (nbResources > this.mainResource.get(rDefausse))
            throw new NotEnoughResourcesException("Player does not have enough "+resource);
        
        this.mainResource.replace(rDefausse, this.mainResource.get(rDefausse)-nbResources);
        this.mainResource.replace(rRecup, this.mainResource.get(rRecup)+1);
    }

    @Override
    public void addHarbour(Harbor harbor) {
        for(Resource r : this.harbors.values())
            if(harbor.haveBetterRate(this.harbors.get(r)))
                this.harbors.replace(r, harbor);
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
    public void incrConstructionPoints() {
        this.constructionPoints++;
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
        boolean exception = true;
        List<Resource> li = new ArrayList<>();
        for (Resource r:this.mainResource.keySet()) {
            if(this.mainResource.get(r)>0){
                li.add(r);
                exception = false;
            }
        }
        if(exception){
            throw new NotEnoughResourcesException("Player "+this.color+" doesn't have any resource.");
        }
        Random r = new Random();
        int i = r.nextInt(li.size());
        Resource res = li.get(i);
        this.mainResource.replace(res, this.mainResource.get(res)-1);
        return res;
    }

    @Override
    public void deleteHalfResources() {
        // TODO ne respecte pas entièrement la documentation
        for(Resource key : this.mainResource.keySet()){
            this.mainResource.replace(key,this.mainResource.get(key)/2);
        }
    }


    @Override
    public void playDevelopmentCard(Development type) throws NotEnoughDevelopmentCardException {
        // TODO ne respecte pas entièrement la documentation
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
            throw new NotEnoughResourcesException("Player does not have enough "+resource);
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
