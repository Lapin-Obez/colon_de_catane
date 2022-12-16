package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Ressource;

import java.util.Optional;

public interface Port {

    /**
     * DOC TODO
     */
    Optional<Ressource> getRessource();

    /**
     * DOC TODO
     */
    int echange(Ressource ressource);

    /**
     * DOC TODO
     */
    boolean aMeilleurTaux(Port other);

}
