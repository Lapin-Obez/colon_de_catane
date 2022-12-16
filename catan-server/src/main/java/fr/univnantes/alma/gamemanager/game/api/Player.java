package fr.univnantes.alma.gamemanager.game.api;

import fr.univnantes.alma.gamemanager.game.api.enums.Color;
import fr.univnantes.alma.gamemanager.game.api.enums.Development;
import fr.univnantes.alma.gamemanager.game.api.enums.Resource;
import fr.univnantes.alma.gamemanager.game.api.enums.SpecialCard;
import fr.univnantes.alma.gamemanager.game.api.exceptions.NotEnoughDevelopmentCardException;
import fr.univnantes.alma.gamemanager.game.api.exceptions.NotEnoughResourcesException;

public interface Player {
    int getNumberOfKnight();

    void grantSpecialCard(SpecialCard fiche);

    void removeSpecialCard(SpecialCard fiche);

    void addDevelopmentCard(Development carte);

    /**
     * Retourne la couleur du joueur.
     *
     * @return la Color
     */
    Color getColor();

    /**
     * Retourne le nombre de ressources de type `ressource` du joueur.
     * @param resource la Ressource.
     * @return un int, le nombre de ressources de la ressource donnée.
     */
    int getNumberOfResources(Resource resource);

    /**
     * Supprime `amount` ressources de type `ressource` au joueur.
     * @param resource la Ressource.
     * @param amount le nombre de ressources à supprimer.
     * @throws NotEnoughResourcesException si le joueur n'a pas `amount` ressources de type `ressource`.
     */
    void deleteResources(Resource resource, int amount) throws NotEnoughResourcesException;

    /**
     * DOC TODO
     */
    void addResource(Resource resource);

    /**
     * Calcul le nombre de points du joueur en prenant en compte ses constructions, ses fiches spéciales
     * (plus grande armée et route la plus longue), et ses cartes Victoire.
     * @return un int, le nombre de points de victoire du joueur.
     */
    int getVictoryPoints();

    /**
     * Retourne une ressource aléatoire que le joueur possède.
     * @return la Ressource.
     * @throws NotEnoughResourcesException si le joueur n'a pas de ressources.
     */
    Resource getRandomResources() throws NotEnoughResourcesException;

    /**
     * Supprime la moitié des ressources du joueur.
     *
     * Si le joueur a un nombre impair de ressources, on arrondit le nombre de ressources restantes
     * à la borne inférieur. (e.g. pour 9 ressources de base, on se retrouve avec 4).
     *
     * Tant qu'on n'a pas supprimé la moitié des ressources, on supprime la moitié de chaque type de ressource,
     * un par un. Si le nombre de ressources pour un type est impair, on arrondit le nombre de ressources restantes
     * à la borne supérieure (e.g. pour 3 ressources de base, on se retrouve avec 2).
     */
    void deleteHalfResources();

    /**
     * DOC TODO
     */
    void maritimeTrade(Resource rDefausse, Resource rRecup) throws NotEnoughResourcesException;

    /**
     * DOC TODO
     */
    void addHarbour(Harbor harbor);

    /**
     * DOC TODO
     */
    int deleteResource(Resource resource);

    /**
     * DOC TODO
     */
    void playDevelopmentCard(Development type) throws NotEnoughDevelopmentCardException;

}
