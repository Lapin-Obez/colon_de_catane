package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Joueur;
import fr.univnantes.alma.modele.api.Partie;
import fr.univnantes.alma.modele.api.Tuile;
import fr.univnantes.alma.modele.api.enums.Developpement;
import fr.univnantes.alma.modele.api.enums.Ressource;
import fr.univnantes.alma.modele.api.exceptions.GameStatusException;
import fr.univnantes.alma.modele.api.exceptions.ImpossibleBuildException;
import fr.univnantes.alma.modele.api.exceptions.NotEnoughRessourcesException;

import java.util.List;
import java.util.Map;

public class PartieImpl implements Partie {

    private Map<Integer, Developpement> piocheDeveloppement;
    private Map<Integer, Ressource> piocheRessource;
    private Joueur gagnant;

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
    public void monopole(Joueur joueur, Ressource ressource) {

    }

    @Override
    public void invention(Joueur joueur) {

    }

    /**
     * Calcul le score des joueurs et met fin à la partie si le joueur actuel a plus de 10 points.
     * Met ce joueur en tant que gagnant si c'est le cas.
     */
    private void evalueFinPartie() {

    }

    @Override
    public void construireColonie(Joueur joueur, int idIntersection) throws GameStatusException, IllegalArgumentException, ImpossibleBuildException, NotEnoughRessourcesException {

    }

    @Override
    public void construireVille(Joueur joueur, int idIntersection) throws GameStatusException, IllegalArgumentException, ImpossibleBuildException, NotEnoughRessourcesException {

    }

    @Override
    public void construireRoute(Joueur joueur, int intersectionA, int intersectionB) throws GameStatusException, IllegalArgumentException, ImpossibleBuildException, NotEnoughRessourcesException {

    }

    @Override
    public Joueur endGameTurn(Joueur joueurAct) throws GameStatusException {
        return null;
    }

    @Override
    public boolean partieEstTerminee() {
        return false;
    }

    @Override
    public Joueur getGagnant() throws GameStatusException {
        return null;
    }

    @Override
    public int lancerDes(Joueur joueurAct) throws GameStatusException {
        return 0;
    }

    @Override
    public List<Joueur> jouerVoleur(Joueur joueurAct, int idTuile) throws GameStatusException, IllegalArgumentException {
        return null;
    }

    @Override
    public void volerRessource(Joueur voleur, Joueur victime) throws GameStatusException, NotEnoughRessourcesException {

    }
}
