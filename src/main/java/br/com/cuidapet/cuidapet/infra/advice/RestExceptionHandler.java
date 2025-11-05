package br.com.cuidapet.cuidapet.infra.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<RestErrorMessage> handleGeneric (Exception e){
        var respostaTratada = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respostaTratada);
    }


}
