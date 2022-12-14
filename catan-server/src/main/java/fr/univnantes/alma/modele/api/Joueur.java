package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Developpement;
import fr.univnantes.alma.modele.api.enums.FicheSpecial;
import fr.univnantes.alma.modele.api.enums.Ressource;

public interface Joueur {
    void commerceMaritime(Ressource rDefausse, Ressource rRecup);
    int getPointsVictoire();
    int getNbChevaliers();
    void jouerChevalier();
    void occtroyerFicheSpeciale(FicheSpecial fiche);
    void retirerFicheSpeciale(FicheSpecial fiche);
    void addCarteDeveloppement(Developpement carte);
    Ressource getRessourceAleatoire();
    int deleteRessource(Ressource ressource);
}
