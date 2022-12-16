package fr.univnantes.alma.modele.api;

import fr.univnantes.alma.modele.api.enums.Resource;

import java.util.Optional;

public interface Harbour {

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
    boolean haveBetterRate(Harbour other);

}
