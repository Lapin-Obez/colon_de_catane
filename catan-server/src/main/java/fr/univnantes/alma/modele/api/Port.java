package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Ressource;

public interface Port {
    int echange(Ressource ressource);
}
