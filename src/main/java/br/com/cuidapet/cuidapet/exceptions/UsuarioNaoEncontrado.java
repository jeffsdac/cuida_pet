package br.com.cuidapet.cuidapet.exceptions;

import java.util.UUID;

public class UsuarioNaoEncontrado extends RuntimeException{

    public UsuarioNaoEncontrado(){
        super("Não foi possível encontrar um usuário com as informações recebidas");
    }

    public UsuarioNaoEncontrado(UUID id){
        super(String.format("Não foi possível encontrar um usuário com o ID fornecido %s", id.toString()));
    }

}
