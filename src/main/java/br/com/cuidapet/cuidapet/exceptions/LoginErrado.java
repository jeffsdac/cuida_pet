package br.com.cuidapet.cuidapet.exceptions;

public class LoginErrado extends RuntimeException{

    public LoginErrado () {
        super("Os dados fornecidos para login estão incorretos");
    }
}
