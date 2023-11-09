package Godwin.WebApi.Exceptions;

import Godwin.WebApi.payloadPackage.ErrorsDTO;
import Godwin.WebApi.payloadPackage.ErrorsResponseDTO;
import Godwin.WebApi.payloadPackage.ErrorsResponseWithListDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsResponseWithListDTO badRequestHandlerMethod(BadRequestException e){
        if(e.getErrorsList() != null) {
            List<String> errorsList = e.getErrorsList().stream().map(objectError -> objectError.getDefaultMessage()).toList();
            return new ErrorsResponseWithListDTO(e.getMessage(), new Date(), errorsList);
        } else {
            return new ErrorsResponseWithListDTO(e.getMessage(), new Date(), new ArrayList<>());
        }
    }
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsDTO notFoundHandlerMethod(NotFoundException e){
        return new ErrorsDTO(e.getMessage(), new Date());
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsDTO GenericErrorHandlerMethod(Exception e){
        e.printStackTrace(); //this prunts out the error position
        return new ErrorsDTO("Server error, in maintenance", new Date());
    }


}
