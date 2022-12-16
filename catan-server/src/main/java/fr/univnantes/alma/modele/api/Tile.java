package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Color;
import fr.univnantes.alma.modele.api.enums.Resource;

import java.util.List;
import java.util.Map;

public interface Tile {

    /**
     * Renvoie la liste des intersections autour de la tuile.
     */
    List<Intersection> getIntersections();

    /**
     * Renvoie la ressource de la tuile.
     */
    Resource getResource();

    /**
     * Renvoie un dictionnaire attribuant à une `couleur` un couple `(Ressource,Integer)` indiquant le nombre de ressources
     * à distribuer au joueur de cette `couleur`.
     *
     * Récupère les constructions des intersections autour de la tuile.
     * Pour chacune de ces constructions, récupérer sa couleur et sa `puissance`, et modifier le dictionnaire ainsi :
     * `result[couleur][ressource] += puissance`, `ressource` étant la ressource de la tuile.
     */
    Map<Color, Map<Resource,Integer>> distributeResources();

    /**
     * Renvoie la valeur du jeton de la tuile.
     */
    int getTokenValue();
}
