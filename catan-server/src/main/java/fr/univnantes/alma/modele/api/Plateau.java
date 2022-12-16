package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Couleur;
import fr.univnantes.alma.modele.api.enums.Ressource;
import fr.univnantes.alma.modele.api.exceptions.ImpossibleBuildException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Plateau {
    int getLongueurRoute(Couleur couleur);
    void deplacerVoleur(int idTuile);

    /**
     * Construit une colonie de la `couleur` donnée à l'intersection donnée.
     * @param couleur la Couleur.
     * @param idIntersection un int, l'id de l'intersection.
     * @return le potentiel Port de l'intersection.
     * @throws IllegalArgumentException si l'intersection est invalide.
     * @throws ImpossibleBuildException si l'intersection est déjà occupée ou
     *                                  si elle n'est pas à deux de distance minimum d'une autre colonie.
     */
    Optional<Port> construireColonie(Couleur couleur, int idIntersection) throws IllegalArgumentException, ImpossibleBuildException;

    /**
     * Améliore une colonie au niveau de ville. Cette colonie se trouve à l'intersection d'id `idIntersection`.
     * @param couleur la Couleur.
     * @param idIntersection un int, l'id de l'intersection.
     * @throws IllegalArgumentException si l'intersection est invalide.
     * @throws ImpossibleBuildException s'il n'y a pas de colonie sur l'intersection ou
     *                                  si la colonie n'appartient pas au joueur.
     */
    void construireVille(Couleur couleur, int idIntersection) throws IllegalArgumentException, ImpossibleBuildException;

    /**
     * Construit une route de la couleur donnée entre deux intersections données.
     * @param couleur la Couleur.
     * @param intersectionA un int, l'id de la première intersection.
     * @param intersectionB un int, l'id de la deuxième intersection.
     */
    void construireRoute(Couleur couleur, int intersectionA, int intersectionB) throws IllegalArgumentException, ImpossibleBuildException;

    /**
     * Renvoie un dictionnaire attribuant à une `couleur` un couple `(Ressource,Integer)` indiquant le nombre de ressources
     * à distribuer au joueur de cette `couleur`.
     * @param valeurJeton unt int, la valeur du jeton.
     * @throws IllegalArgumentException si la `valeurJeton` ne correspond à aucune tuile.
     */
    Map<Couleur, Map<Ressource,Integer>> distribuerRessources(int valeurJeton) throws IllegalArgumentException;

    /**
     * Change le voleur de tuile et renvoie quelles couleurs sont sur cette tuile.
     * @param idTuile un int, l'id de la tuile.
     * @return la liste des Couleur présentes sur la tuile volée.
     * @throws IllegalArgumentException si la tuile n'est pas valide.
     */
    List<Joueur> jouerVoleur(int idTuile) throws IllegalArgumentException;
}
