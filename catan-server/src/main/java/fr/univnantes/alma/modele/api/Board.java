package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Color;
import fr.univnantes.alma.modele.api.enums.Resource;
import fr.univnantes.alma.modele.api.exceptions.ImpossibleBuildException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Board {
    int getRoadLength(Color color);
    void moveStealer(int tileID);

    /**
     * Construit une colonie de la `color` donnée à l'intersection donnée.
     * @param color la Color.
     * @param idIntersection un int, l'id de l'intersection.
     * @return le potentiel Port de l'intersection.
     * @throws IllegalArgumentException si l'intersection est invalide.
     * @throws ImpossibleBuildException si l'intersection est déjà occupée ou
     *                                  si elle n'est pas à deux de distance minimum d'une autre colonie.
     */
    Optional<Harbor> buildColony(Color color, int idIntersection) throws IllegalArgumentException, ImpossibleBuildException;

    /**
     * Améliore une colonie au niveau de ville. Cette colonie se trouve à l'intersection d'id `idIntersection`.
     * @param color la Color.
     * @param idIntersection un int, l'id de l'intersection.
     * @throws IllegalArgumentException si l'intersection est invalide.
     * @throws ImpossibleBuildException s'il n'y a pas de colonie sur l'intersection ou
     *                                  si la colonie n'appartient pas au joueur.
     */
    void buildCity(Color color, int idIntersection) throws IllegalArgumentException, ImpossibleBuildException;

    /**
     * Construit une route de la color donnée entre deux intersections données.
     * @param color la Color.
     * @param intersectionA un int, l'id de la première intersection.
     * @param intersectionB un int, l'id de la deuxième intersection.
     */
    void buildRoad(Color color, int intersectionA, int intersectionB) throws IllegalArgumentException, ImpossibleBuildException;

    /**
     * Renvoie un dictionnaire attribuant à une `couleur` un couple `(Ressource,Integer)` indiquant le nombre de ressources
     * à distribuer au joueur de cette `couleur`.
     * @param tokenValue unt int, la valeur du jeton.
     * @throws IllegalArgumentException si la `tokenValue` ne correspond à aucune tuile.
     */
    Map<Color, Map<Resource,Integer>> distributeResources(int tokenValue) throws IllegalArgumentException;

    /**
     * Change le voleur de tuile et renvoie quelles couleurs sont sur cette tuile.
     * @param tileID un int, l'id de la tuile.
     * @return la liste des Color présentes sur la tuile volée.
     * @throws IllegalArgumentException si la tuile n'est pas valide.
     */
    List<Player> playStealer(int tileID) throws IllegalArgumentException;
}
