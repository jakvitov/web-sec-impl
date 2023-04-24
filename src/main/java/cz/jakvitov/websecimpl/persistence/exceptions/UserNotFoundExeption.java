package cz.jakvitov.websecimpl.persistence.exceptions;

public class UserNotFoundExeption extends RuntimeException {

    public UserNotFoundExeption(Throwable t){
        super(t);
    }

    public UserNotFoundExeption(Throwable t, String message){
        super(message, t);
    }

    public UserNotFoundExeption(String message){
        super(message, null);
    }

}
