package br.com.cuidapet.cuidapet.infra.advice;

import org.springframework.http.HttpStatus;

public record RestErrorMessage(HttpStatus status, String message) {
}
