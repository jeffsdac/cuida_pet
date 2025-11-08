package br.com.cuidapet.cuidapet.infra.advice;

import br.com.cuidapet.cuidapet.exceptions.PetNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PetNaoEncontrado.class)
    private ResponseEntity<RestErrorMessage> handlePetNotFind (PetNaoEncontrado e){
        var respostaTratada = new RestErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respostaTratada);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<RestErrorMessage> handleGeneric (Exception e){
        var respostaTratada = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respostaTratada);
    }


}
