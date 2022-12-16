package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Couleur;
import fr.univnantes.alma.modele.api.enums.Developpement;
import fr.univnantes.alma.modele.api.enums.FicheSpeciale;
import fr.univnantes.alma.modele.api.enums.Ressource;
import fr.univnantes.alma.modele.api.exceptions.NotEnoughRessourcesException;

public interface Joueur {
    int getNbChevaliers();
    void jouerChevalier();
    void occtroyerFicheSpeciale(FicheSpeciale fiche);
    void retirerFicheSpeciale(FicheSpeciale fiche);
    void addCarteDeveloppement(Developpement carte);
    int deleteRessource(Ressource ressource);

    /**
     * Retourne la couleur du joueur.
     * @return la Couleur
     */
    Couleur getCouleur();

    /**
     * Retourne le nombre de ressources de type `ressource` du joueur.
     * @param ressource la Ressource.
     * @return un int, le nombre de ressources de la ressource donnée.
     */
    int getNbRessources(Ressource ressource);

    /**
     * Supprime `amount` ressources de type `ressource` au joueur.
     * @param ressource la Ressource.
     * @param amount le nombre de ressources à supprimer.
     * @throws NotEnoughRessourcesException si le joueur n'a pas `amount` ressources de type `ressource`.
     */
    void supprimeRessources(Ressource ressource, int amount) throws NotEnoughRessourcesException;

    /**
     * Calcul le nombre de points du joueur en prenant en compte ses constructions, ses fiches spéciales
     * (plus grande armée et route la plus longue), et ses cartes Victoire.
     * @return un int, le nombre de points de victoire du joueur.
     */
    int getPointsVictoire();

    /**
     * Retourne une ressource aléatoire que le joueur possède.
     * @return la Ressource.
     * @throws NotEnoughRessourcesException si le joueur n'a pas de ressources.
     */
    Ressource getRessourceAleatoire() throws NotEnoughRessourcesException;

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
    void supprimeMoitieRessources();

    /**
     * DOC TODO
     */
    void commerceMaritime(Ressource rDefausse, Ressource rRecup);

    /**
     * DOC TODO
     */
    void ajoutePort(Port port);
}
