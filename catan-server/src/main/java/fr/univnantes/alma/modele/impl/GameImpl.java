package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Board;
import fr.univnantes.alma.modele.api.Game;
import fr.univnantes.alma.modele.api.Player;
import fr.univnantes.alma.modele.api.Tile;
import fr.univnantes.alma.modele.api.enums.Development;
import fr.univnantes.alma.modele.api.enums.Resource;
import fr.univnantes.alma.modele.api.exceptions.GameStatusException;
import fr.univnantes.alma.modele.api.exceptions.ImpossibleBuildException;
import fr.univnantes.alma.modele.api.exceptions.NotEnoughDevelopmentCardException;
import fr.univnantes.alma.modele.api.exceptions.NotEnoughResourcesException;

import java.util.List;
import java.util.Map;

public class GameImpl implements Game {

    private Map<Integer, Development> deckDevelopment;
    private Map<Integer, Resource> deckResource;
    private List<Player> playerList;
    private Player winner;
    private Board board;

    public GameImpl() {
        this.board = new BoardImpl();
    }

    @Override
    public void calculateStrongestArmy() {

    }

    @Override
    public void calculateLongestRoad() {

    }

    @Override
    public void monopoly(Player player, Resource resource) throws GameStatusException, NotEnoughDevelopmentCardException  {

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

    }

    @Override
    public void buildCity(Player player, int intersectionID) throws GameStatusException, IllegalArgumentException, ImpossibleBuildException, NotEnoughResourcesException {

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
