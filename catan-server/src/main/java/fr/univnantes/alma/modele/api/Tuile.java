package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Ressource;
import fr.univnantes.alma.modele.api.enums.Couleur;

import java.util.List;
import java.util.Map;

public interface Tuile {

    /**
     * Renvoie la liste des intersections autour de la tuile.
     */
    List<Intersection> getIntersections();

    /**
     * Renvoie la ressource de la tuile.
     */
    Ressource getRessource();

    /**
     * Renvoie un dictionnaire attribuant à une `couleur` un couple `(Ressource,Integer)` indiquant le nombre de ressources
     * à distribuer au joueur de cette `couleur`.
     *
     * Récupère les constructions des intersections autour de la tuile.
     * Pour chacune de ces constructions, récupérer sa couleur et sa `puissance`, et modifier le dictionnaire ainsi :
     * `result[couleur][ressource] += puissance`, `ressource` étant la ressource de la tuile.
     */
    Map<Couleur, Map<Ressource,Integer>> distribuerRessources();

    /**
     * Renvoie la valeur du jeton de la tuile.
     */
    int getValeurJeton();
}
