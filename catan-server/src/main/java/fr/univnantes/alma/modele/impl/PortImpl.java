package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Port;
import fr.univnantes.alma.modele.api.enums.Ressource;
import fr.univnantes.alma.modele.api.enums.Taux_Echange;

import java.util.Optional;

public class PortImpl implements Port {
    private Taux_Echange taux;
    private Ressource ressource;

    @Override
    public Optional<Ressource> getRessource() {
        return Optional.empty();
    }

    @Override
    public int echange(Ressource ressource) {
        return 0;
    }

    @Override
    public boolean aMeilleurTaux(Port other) {
        return false;
    }
}
