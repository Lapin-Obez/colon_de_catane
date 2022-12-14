package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Developpement;
import fr.univnantes.alma.modele.api.enums.FicheSpeciale;
import fr.univnantes.alma.modele.api.enums.Ressource;

public interface Joueur {
    void commerceMaritime(Ressource rDefausse, Ressource rRecup);
    int getPointsVictoire();
    int getNbChevaliers();
    void jouerChevalier();
    void occtroyerFicheSpeciale(FicheSpeciale fiche);
    void retirerFicheSpeciale(FicheSpeciale fiche);
    void addCarteDeveloppement(Developpement carte);
    Ressource getRessourceAleatoire();
    int deleteRessource(Ressource ressource);
}
