package Godwin.WebApi.Exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(int id){
        super("This element with id " + id + " was not found");
    }
}
