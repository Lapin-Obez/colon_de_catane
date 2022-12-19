package fr.univnantes.alma.gamemanager.game.impl;

import fr.univnantes.alma.gamemanager.game.api.Board;
import fr.univnantes.alma.gamemanager.game.api.Game;
import fr.univnantes.alma.gamemanager.game.api.Player;
import fr.univnantes.alma.gamemanager.game.api.enums.*;
import fr.univnantes.alma.gamemanager.game.api.exceptions.*;

import java.awt.*;
import java.util.*;

public class GameImpl implements Game {

    private Map<Development, Integer> deckDevelopment;
    private List<Player> playerList;
    private Player actualPlayer;
    private Board board;

    private GameStatus gameStatus;

    public GameImpl(Integer playerNumber) {
        if(playerNumber<3||playerNumber>4){
            throw new IllegalArgumentException("The number of player is incorrect !");
        }
        for(int i=0;i<playerNumber;i++){
            playerList.add(new PlayerImpl(Color.values()[i]));
        }
        this.board = new BoardImpl();
        this.gameStatus = GameStatus.SetUp;
    }

    /**
     * Récupère la valeur d'armée de tous les joueurs et donne la carte de l'armée la plus puissante au joueur ayant le plus de chevalier
     **/
    private void calculateStrongestArmy() {
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

    /**
     * Récupère la valeur d'armée de tous les joueurs et donne la carte de la plus longue route au joueur ayant la route la plus longue
     **/
    private void calculateLongestRoad() {

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
        return this.gameStatus == GameStatus.GameStop;
    }

    @Override
    public Player getWinner() throws GameStatusException {
        if(this.gameStatus!=GameStatus.GameStop){
            throw new GameStatusException("The game isn't finished");
        }
        return actualPlayer;
    }

    @Override
    public int throwDice(Player playerAct) throws GameStatusException {
        if(this.gameStatus!= GameStatus.SetUp && playerAct != this.playerAct){
            throw new GameStatusException("You don't have the right to throw dice");
        }
        Random r = new Random();
        int d1 = r.nextInt(6)+1;
        int d2 = r.nextInt(6)+1;
        int score = d1+d2;
        return score;
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
