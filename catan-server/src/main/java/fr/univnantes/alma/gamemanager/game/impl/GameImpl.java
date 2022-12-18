package fr.univnantes.alma.gamemanager.game.impl;

import fr.univnantes.alma.gamemanager.game.api.Board;
import fr.univnantes.alma.gamemanager.game.api.Game;
import fr.univnantes.alma.gamemanager.game.api.Player;
import fr.univnantes.alma.gamemanager.game.api.enums.Color;
import fr.univnantes.alma.gamemanager.game.api.enums.Development;
import fr.univnantes.alma.gamemanager.game.api.enums.Resource;
import fr.univnantes.alma.gamemanager.game.api.enums.SpecialCard;
import fr.univnantes.alma.gamemanager.game.api.exceptions.GameStatusException;
import fr.univnantes.alma.gamemanager.game.api.exceptions.ImpossibleBuildException;
import fr.univnantes.alma.gamemanager.game.api.exceptions.NotEnoughDevelopmentCardException;
import fr.univnantes.alma.gamemanager.game.api.exceptions.NotEnoughResourcesException;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class GameImpl implements Game {

    private Map<Integer, Development> deckDevelopment;
    private List<Player> playerList;
    private Player actualPlayer;
    private Board board;

    public GameImpl(Integer playerNumber) {
        if(playerNumber<3||playerNumber>4){
            throw new IllegalArgumentException("The number of player is incorrect !");
        }
        for(int i=0;i<playerNumber;i++){
            playerList.add(new PlayerImpl(Color.values()[i]));
        }
        this.board = new BoardImpl();
    }

    @Override
    public void calculateStrongestArmy() {
        Player strongest = new PlayerImpl();
        for(Player p:playerList){
            if(p.getSpecialCards().contains(SpecialCard.ArmeePlusPuissante)){
                p.removeSpecialCard(SpecialCard.ArmeePlusPuissante);
            }
            if (p.getNumberOfKnight()>strongest.getNumberOfKnight()){
                strongest=p;
            }
        }
        strongest.grantSpecialCard(SpecialCard.ArmeePlusPuissante);
    }

    @Override
    public void calculateLongestRoad() {

    }

    @Override
    public void monopoly(Player player, Resource resource) throws GameStatusException, NotEnoughDevelopmentCardException {

    }

    @Override
    public void yearOfPlenty(Player player, Resource resource1, Resource resource2) throws GameStatusException, NotEnoughDevelopmentCardException {

    }

    @Override
    public void roadBuildingCard(Player player) throws GameStatusException, NotEnoughDevelopmentCardException {

    }

    @Override
    public void knightCard(Player player) throws GameStatusException, NotEnoughDevelopmentCardException {

    }

    @Override
    public void invention(Player player) {

    }

    /**
     * Calcul le score des joueurs et met fin à la partie si le joueur actuel a plus de 10 points.
     * Met ce joueur en tant que gagnant si c'est le cas.
     */
    private void evaluateEndGame() {

    }

    @Override
    public void buildColony(Player player, int intersectionID) throws GameStatusException, IllegalArgumentException, ImpossibleBuildException, NotEnoughResourcesException {
        this.board.buildColony(player.getColor(),intersectionID);
    }

    @Override
    public void buildCity(Player player, int intersectionID) throws GameStatusException, IllegalArgumentException, ImpossibleBuildException, NotEnoughResourcesException {
        this.board.buildCity(player.getColor(),intersectionID);
    }

    @Override
    public void buildRoad(Player player, int intersectionA, int intersectionB) throws GameStatusException, IllegalArgumentException, ImpossibleBuildException, NotEnoughResourcesException {

    }

    @Override
    public Player endGameTurn(Player playerAct) throws GameStatusException {
        return null;
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public Player getWinner() throws GameStatusException {
        return null;
    }

    @Override
    public int throwDice(Player playerAct) throws GameStatusException {
        return 0;
    }

    @Override
    public List<Player> playStealer(Player playerAct, int tileID) throws GameStatusException, IllegalArgumentException {
        return null;
    }

    @Override
    public void stealResources(Player stealer, Player victim) throws GameStatusException, NotEnoughResourcesException {

    }

    @Override
    public void maritimeTrade(Player player, Resource rDefausse, Resource rRecup) throws GameStatusException, NotEnoughResourcesException {

    }

    @Override
    public void drawDevelopmentCard(Player player) throws GameStatusException, NotEnoughResourcesException {

    }
}
