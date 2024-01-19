package sarahguarneri.BEU2W2L5.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException{
    public NotFoundException(UUID id){
        super("elemento con id " + id + " non trovato");
    }
}
