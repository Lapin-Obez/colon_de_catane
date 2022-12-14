package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Joueur;
import fr.univnantes.alma.modele.api.enums.Couleur;
import fr.univnantes.alma.modele.api.enums.Developpement;
import fr.univnantes.alma.modele.api.enums.FicheSpecial;
import fr.univnantes.alma.modele.api.enums.Ressource;

import java.util.List;
import java.util.Map;

public class JoueurImpl implements Joueur {

    private Couleur couleur;
    private Map<Integer, Ressource> mainRessource;
    private Map<Integer, Developpement> mainDeveloppement;
    private int nbChevaliers;
    private List<FicheSpecial> fichesSpeciales;
    @Override
    public void commerceMaritime(Ressource rDefausse, Ressource rRecup) {

    }

    @Override
    public int getPointsVictoire() {
        return 0;
    }

    @Override
    public int getNbChevaliers() {
        return 0;
    }

    @Override
    public void jouerChevalier() {

    }

    @Override
    public void occtroyerFicheSpeciale(FicheSpecial fiche) {

    }

    @Override
    public void retirerFicheSpeciale(FicheSpecial fiche) {

    }

    @Override
    public void addCarteDeveloppement(Developpement carte) {

    }

    @Override
    public Ressource getRessourceAleatoire() {
        return null;
    }

    @Override
    public int deleteRessource(Ressource ressource) {
        return 0;
    }
}
