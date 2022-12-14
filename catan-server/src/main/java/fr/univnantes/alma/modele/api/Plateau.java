package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Couleur;

public interface Plateau {
    int getLongueurRoute(Couleur couleur);
    void deplacerVoleur(int idTuile);
    void distribuerRessources(int valeurJeton);
}
