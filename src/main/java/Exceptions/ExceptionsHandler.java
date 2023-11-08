package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsPayload badRequestHandlerMethod(BadRequestException e){
        return new ErrorsPayload(e.getMessage(), new Date());
    }
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayload notFoundHandlerMethod(NotFoundException e){
        return new ErrorsPayload(e.getMessage(), new Date());
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsPayload GenericErrorHandlerMethod(Exception e){
        e.printStackTrace(); //this prunts out the error position
        return new ErrorsPayload("Server error, in maintenance", new Date());
    }


}