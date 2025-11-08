package br.com.cuidapet.cuidapet.exceptions;

import java.util.UUID;

public class PetNaoEncontrado extends RuntimeException{

    public PetNaoEncontrado(){
        super("Não foi encontrado nenhum peto com os parametros fornecidos.");
    }

    public PetNaoEncontrado(UUID id){
        super( String.format(  "Não foi encontrado nenhum pet com id: '%s'.",id.toString() ) );
    }

}
