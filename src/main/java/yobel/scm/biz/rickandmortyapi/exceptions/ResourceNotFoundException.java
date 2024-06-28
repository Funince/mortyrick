package yobel.scm.biz.rickandmortyapi.exceptions;

public class ResourceNotFoundException  extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
