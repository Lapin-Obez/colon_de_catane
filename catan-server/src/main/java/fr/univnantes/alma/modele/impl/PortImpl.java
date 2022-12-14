package fr.univnantes.alma.modele.impl;

import fr.univnantes.alma.modele.api.Port;
import fr.univnantes.alma.modele.api.enums.Ressource;
import fr.univnantes.alma.modele.api.enums.Taux_Echange;

public class PortImpl implements Port {
    private Taux_Echange taux;
    private Ressource ressource;

    @Override
    public int echange(Ressource ressource) {
        return 0;
    }
}
