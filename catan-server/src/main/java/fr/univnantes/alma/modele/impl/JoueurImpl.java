package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Joueur;
import fr.univnantes.alma.modele.api.Port;
import fr.univnantes.alma.modele.api.enums.Couleur;
import fr.univnantes.alma.modele.api.enums.Developpement;
import fr.univnantes.alma.modele.api.enums.FicheSpeciale;
import fr.univnantes.alma.modele.api.enums.Ressource;
import fr.univnantes.alma.modele.api.exceptions.NotEnoughRessourcesException;

import java.util.List;
import java.util.Map;

public class JoueurImpl implements Joueur {

    private Couleur couleur;
    private Map<Integer, Ressource> mainRessource;
    private Map<Integer, Developpement> mainDeveloppement;
    private int nbChevaliers;
    private List<FicheSpeciale> fichesSpeciales;

    @Override
    public void commerceMaritime(Ressource rDefausse, Ressource rRecup) {

    }

    @Override
    public void ajoutePort(Port port) {

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
    public void occtroyerFicheSpeciale(FicheSpeciale fiche) {

    }

    @Override
    public void retirerFicheSpeciale(FicheSpeciale fiche) {

    }

    @Override
    public void addCarteDeveloppement(Developpement carte) {

    }

    @Override
    public Ressource getRessourceAleatoire() throws NotEnoughRessourcesException {
        return null;
    }

    @Override
    public void supprimeMoitieRessources() {

    }

    @Override
    public int deleteRessource(Ressource ressource) {
        return 0;
    }

    @Override
    public Couleur getCouleur() {
        return null;
    }

    @Override
    public int getNbRessources(Ressource ressource) {
        return 0;
    }

    @Override
    public void supprimeRessources(Ressource ressource, int amount) throws NotEnoughRessourcesException {

    }
}
