package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Resource;

import java.util.Optional;

public interface Harbor {

    /**
     * DOC TODO
     */
    Optional<Resource> getResource();

    /**
     * DOC TODO
     */
    int exchange(Resource resource);

    /**
     * DOC TODO
     */
    boolean haveBetterRate(Harbor other);


}
