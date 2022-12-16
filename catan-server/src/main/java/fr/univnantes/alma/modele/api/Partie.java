package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Ressource;
import fr.univnantes.alma.modele.api.exceptions.GameStatusException;
import fr.univnantes.alma.modele.api.exceptions.ImpossibleBuildException;
import fr.univnantes.alma.modele.api.exceptions.NotEnoughRessourcesException;

import java.util.List;

public interface Partie {
    void calculerArmeePlusPuissante();
    void calculerRoutePlusLongue();
    List<Joueur> jouerVoleur(Tuile tuile);
    void monopole(Joueur joueur, Ressource ressource);
    void invention(Joueur joueur);


    /**
     * Construit une colonie de la couleur du `joueur` donné, à l'intersection d'id `idIntersection`.
     *
     * Appelle `Plateau.construireColonie()`. Cette méthode retourne un potentiel port.
     * Si ce port existe, appelle `joueur.ajoutePort(port)`.
     *
     * @param joueur le Joueur.
     * @param idIntersection un int, l'id de l'intersection.
     * @throws GameStatusException si le joueur ne peut pas jouer.
     * @throws IllegalArgumentException si l'intersection est invalide.
     * @throws ImpossibleBuildException si l'intersection est déjà occupée ou si elle n'est pas à deux routes minimum
     *                                  d'une autre colonie.
     * @throws NotEnoughRessourcesException si le joueur n'a pas les ressources nécessaires.
     */
    void construireColonie(Joueur joueur, int idIntersection) throws
            GameStatusException,
            IllegalArgumentException,
            ImpossibleBuildException,
            NotEnoughRessourcesException;

    /**
     * Améliore une colonie au niveau de ville. Cette ville se trouve à l'intersection d'id `idIntersection`.
     * @param joueur le Joueur.
     * @param idIntersection un int, l'id de l'intersection.
     * @throws GameStatusException si le joueur ne peut pas jouer.
     * @throws IllegalArgumentException si l'intersection est invalide.
     * @throws ImpossibleBuildException s'il n'y a pas de colonie sur l'intersection ou si la colonie n'appartient pas au joueur.
     * @throws NotEnoughRessourcesException si le joueur n'a pas les ressources nécessaires.
     */
    void construireVille(Joueur joueur, int idIntersection) throws
            GameStatusException,
            IllegalArgumentException,
            ImpossibleBuildException,
            NotEnoughRessourcesException;

    /**
     * Construit une route de la couleur du `joueur` entre deux intersections données.
     * @param joueur le Joueur.
     * @param intersectionA un int, l'id de la première intersection.
     * @param intersectionB un int, l'id de la deuxième intersection.
     * @throws GameStatusException si le joueur ne peut pas jouer.
     * @throws IllegalArgumentException si une des intersections est invalide.
     * @throws ImpossibleBuildException si la route n'a pas pu être construite.
     * @throws NotEnoughRessourcesException si le joueur n'a pas les ressources nécessaires.
     */
    void construireRoute(Joueur joueur, int intersectionA, int intersectionB) throws
            GameStatusException,
            IllegalArgumentException,
            ImpossibleBuildException,
            NotEnoughRessourcesException;

    /**
     * Termine le tour du joueur actuel et renvoie le joueur à qui c'est maintenant le tour.
     * @param joueurAct le Joueur.
     * @return le prochain Joueur.
     * @throws GameStatusException si le joueur donné en paramètre n'est pas le joueur actuel, ou si cette action
     *                             n'est pas possible pour le joueur actuel.
     */
    Joueur endGameTurn(Joueur joueurAct) throws GameStatusException;

    /**
     * Renvoie vrai si la partie est terminée.
     */
    boolean partieEstTerminee();

    /**
     * Renvoie le gagnant de la partie.
     * @return le Joueur gagnant.
     * @throws GameStatusException si la partie n'est pas finie et qu'il n'y a donc pas encore de gagnant.
     */
    Joueur getGagnant() throws GameStatusException;

    /**
     * Lance les dés (`DiceThrow.throw()`) et renvoie le résultat.
     *
     * Si le résultat est 7, appelle pour chaque joueur `joueur.deleteHalfRessources()`.
     *
     * Si le résultat n'est pas 7, appelle `Plateau.distribuerRessources()` en fonction du résultat des dés.
     * À l'aide du résultat de cette dernière méthode, distribuer les ressources aux joueurs.
     *
     * @param joueurAct le Joueur.
     * @return un int, le résultat aux dés.
     * @throws GameStatusException si le joueur donné en paramètre n'est pas le joueur actuel, ou si cette action
     *                             n'est pas possible pour le joueur actuel.
     */
    int lancerDes(Joueur joueurAct) throws GameStatusException;

    /**
     * Change le voleur de tuile et renvoie quels joueurs on peut voler, c'est-à-dire ceux qui ont une construction à une
     * intersection de la tuile où le voleur se déplace et qui ont des ressources.
     *
     * @param joueurAct le Joueur.
     * @param idTuile un int, l'id de la tuile.
     * @return la liste de Joueur que l'on peut voler.
     * @throws GameStatusException si le joueur donné en paramètre n'est pas le joueur actuel, ou si cette action
     *                             n'est pas possible pour le joueur actuel.
     * @throws IllegalArgumentException si la tuile n'est pas valide.
     */
    List<Joueur> jouerVoleur(Joueur joueurAct, int idTuile) throws GameStatusException, IllegalArgumentException;

    /**
     * Permet de voler une ressource aléatoire au joueur volé et de la donner au voleur.
     * @param voleur le Joueur qui déplace le voleur.
     * @param victime le Joueur volé.
     * @throws GameStatusException si le joueur donné en paramètre n'est pas le joueur actuel, ou si cette action
     *                             n'est pas possible pour le joueur actuel.
     * @throws NotEnoughRessourcesException si le joueur volé n'a pas de ressources.
     */
    void volerRessource(Joueur voleur, Joueur victime) throws GameStatusException, NotEnoughRessourcesException;

    /**
     * DOC TODO
     */
    void commerceMaritime(Joueur joueur, Ressource rDefausse, Ressource rRecup);
}
