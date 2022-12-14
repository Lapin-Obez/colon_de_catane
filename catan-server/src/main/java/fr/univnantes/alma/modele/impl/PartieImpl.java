package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Joueur;
import fr.univnantes.alma.modele.api.Partie;
import fr.univnantes.alma.modele.api.Tuile;
import fr.univnantes.alma.modele.api.enums.Developpement;
import fr.univnantes.alma.modele.api.enums.Ressource;

import java.util.List;
import java.util.Map;

public class PartieImpl implements Partie {

    Map<Integer, Developpement> piocheDeveloppement;
    Map<Integer, Ressource> piocheRessource;

    @Override
    public void calculerArmeePlusPuissante() {

    }

    @Override
    public void calculerRoutePlusLongue() {

    }

    @Override
    public List<Joueur> jouerVoleur(Tuile tuile) {
        return null;
    }

    @Override
    public Ressource volerRessource(Joueur voleur, Joueur victime) {
        return null;
    }

    @Override
    public void monopole(Joueur joueur, Ressource ressource) {

    }

    @Override
    public void invention(Joueur joueur) {

    }
}
