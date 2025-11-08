package br.com.cuidapet.cuidapet.models.pet.dtos;

import java.time.Instant;

public record PetUpdateDTO(String primeiroNome, String ultimoNome, Instant dataDeNascimento, String observacoes, String tipo) {
}
