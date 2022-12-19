package fr.univnantes.alma.gamemanager.game.api;

import fr.univnantes.alma.gamemanager.game.api.enums.Resource;
import fr.univnantes.alma.gamemanager.game.api.exceptions.GameStatusException;
import fr.univnantes.alma.gamemanager.game.api.exceptions.ImpossibleBuildException;
import fr.univnantes.alma.gamemanager.game.api.exceptions.NotEnoughDevelopmentCardException;
import fr.univnantes.alma.gamemanager.game.api.exceptions.NotEnoughResourcesException;

import java.util.List;

public interface Game {

    /**
     * Construit une colonie de la couleur du `joueur` donné, à l'intersection d'id `intersectionID`.
     *
     * Appelle `Plateau.buildColony()`. Cette méthode retourne un potentiel port.
     * Si ce port existe, appelle `joueur.addHarbour(port)`.
     * 
     * Appelle `joueur.incrConstructionPoints()`.
     *
     * @param player le Joueur.
     * @param intersectionID un int, l'id de l'intersection.
     * @throws GameStatusException si le joueur ne peut pas jouer.
     * @throws IllegalArgumentException si l'intersection est invalide.
     * @throws ImpossibleBuildException si l'intersection est déjà occupée ou si elle n'est pas à deux routes minimum
     *                                  d'une autre colonie.
     * @throws NotEnoughResourcesException si le joueur n'a pas les ressources nécessaires.
     */
    void buildColony(Player player, int intersectionID) throws
            GameStatusException,
            IllegalArgumentException,
            ImpossibleBuildException,
            NotEnoughResourcesException;

    /**
     * Améliore une colonie au niveau de ville. Cette ville se trouve à l'intersection d'id `intersectionID`.
     * 
     * Appelle `Plateau.buildCity()`.
     * Appelle `joueur.incrConstructionPoints()`.
     *
     * @param player le Joueur.
     * @param intersectionID un int, l'id de l'intersection.
     * @throws GameStatusException si le joueur ne peut pas jouer.
     * @throws IllegalArgumentException si l'intersection est invalide.
     * @throws ImpossibleBuildException s'il n'y a pas de colonie sur l'intersection ou si la colonie n'appartient pas au joueur.
     * @throws NotEnoughResourcesException si le joueur n'a pas les ressources nécessaires.
     */
    void buildCity(Player player, int intersectionID) throws
            GameStatusException,
            IllegalArgumentException,
            ImpossibleBuildException,
            NotEnoughResourcesException;

    /**
     * Construit une route de la couleur du `joueur` entre deux intersections données.
     * @param player le Joueur.
     * @param intersectionA un int, l'id de la première intersection.
     * @param intersectionB un int, l'id de la deuxième intersection.
     * @throws GameStatusException si le joueur ne peut pas jouer.
     * @throws IllegalArgumentException si une des intersections est invalide.
     * @throws ImpossibleBuildException si la route n'a pas pu être construite.
     * @throws NotEnoughResourcesException si le joueur n'a pas les ressources nécessaires.
     */
    void buildRoad(Player player, int intersectionA, int intersectionB) throws
            GameStatusException,
            IllegalArgumentException,
            ImpossibleBuildException,
            NotEnoughResourcesException;

    /**
     * Termine le tour du joueur actuel et renvoie le joueur à qui c'est maintenant le tour.
     * @param playerAct le Joueur.
     * @return le prochain Joueur.
     * @throws GameStatusException si le joueur donné en paramètre n'est pas le joueur actuel, ou si cette action
     *                             n'est pas possible pour le joueur actuel.
     */
    Player endGameTurn(Player playerAct) throws GameStatusException;

    /**
     * Renvoie vrai si la partie est terminée.
     */
    boolean isGameOver();

    /**
     * Renvoie le gagnant de la partie.
     * @return le Joueur gagnant.
     * @throws GameStatusException si la partie n'est pas finie et qu'il n'y a donc pas encore de gagnant.
     */
    Player getWinner() throws GameStatusException;

    /**
     * Lance les dés (`DiceThrow.throw()`) et renvoie le résultat.
     *
     * Si le résultat est 7, appelle pour chaque joueur `joueur.deleteHalfRessources()`.
     *
     * Si le résultat n'est pas 7, appelle `Plateau.distributeResources()` en fonction du résultat des dés.
     * À l'aide du résultat de cette dernière méthode, distribuer les ressources aux joueurs.
     *
     * @param playerAct le Joueur.
     * @return un int, le résultat aux dés.
     * @throws GameStatusException si le joueur donné en paramètre n'est pas le joueur actuel, ou si cette action
     *                             n'est pas possible pour le joueur actuel.
     */
    int throwDice(Player playerAct) throws GameStatusException;

    /**
     * Change le voleur de tuile et renvoie quels joueurs on peut voler, c'est-à-dire ceux qui ont une construction à une
     * intersection de la tuile où le voleur se déplace et qui ont des ressources.
     *
     * @param playerAct le Joueur.
     * @param tileID un int, l'id de la tuile.
     * @return la liste de Joueur que l'on peut voler.
     * @throws GameStatusException si le joueur donné en paramètre n'est pas le joueur actuel, ou si cette action
     *                             n'est pas possible pour le joueur actuel.
     * @throws IllegalArgumentException si la tuile n'est pas valide.
     */
    List<Player> playStealer(Player playerAct, int tileID) throws GameStatusException, IllegalArgumentException;

    /**
     * Permet de voler une ressource aléatoire au joueur volé et de la donner au stealer.
     * @param stealer le Joueur qui déplace le stealer.
     * @param victim le Joueur volé.
     * @throws GameStatusException si le joueur donné en paramètre n'est pas le joueur actuel, ou si cette action
     *                             n'est pas possible pour le joueur actuel.
     * @throws NotEnoughResourcesException si le joueur volé n'a pas de ressources.
     */
    void stealResources(Player stealer, Player victim) throws GameStatusException, NotEnoughResourcesException;

    /**
     * DOC TODO
     */
    void maritimeTrade(Player player, Resource rDefausse, Resource rRecup) throws GameStatusException, NotEnoughResourcesException;

    /**
     * DOC TODO
     */
    void drawDevelopmentCard(Player player) throws GameStatusException, NotEnoughResourcesException;

    /**
     * DOC TODO
     */
    void monopoly(Player player, Resource resource) throws GameStatusException, NotEnoughDevelopmentCardException;

    /**
     * DOC TODO
     */
    void yearOfPlenty(Player player, Resource resource1, Resource resource2) throws GameStatusException, NotEnoughDevelopmentCardException;

    /**
     * DOC TODO
     */
    void roadBuildingCard(Player player) throws GameStatusException, NotEnoughDevelopmentCardException;

    /**
     * DOC TODO
     */
    void knightCard(Player player) throws GameStatusException, NotEnoughDevelopmentCardException;
}
