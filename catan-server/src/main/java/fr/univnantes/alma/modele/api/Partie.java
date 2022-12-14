package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Ressource;

import java.util.List;

public interface Partie {
    void calculerArmeePlusPuissante();
    void calculerRoutePlusLongue();
    List<Joueur> jouerVoleur(Tuile tuile);
    Ressource volerRessource(Joueur voleur, Joueur victime);
    void monopole(Joueur joueur, Ressource ressource);
    void invention(Joueur joueur);
}
