package br.com.cuidapet.cuidapet.service;

import br.com.cuidapet.cuidapet.exceptions.PetNaoEncontrado;
import br.com.cuidapet.cuidapet.models.pet.PetModel;
import br.com.cuidapet.cuidapet.models.pet.dtos.PetCreateDTO;
import br.com.cuidapet.cuidapet.models.pet.dtos.PetUpdateDTO;
import br.com.cuidapet.cuidapet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    public PetModel createPet (PetCreateDTO dto){
        var petModel = PetModel.builder()
                .primeiroNome(dto.primeiroNome())
                .dataDeNascimento(dto.dataDeNascimento())
                .ultimoNome(dto.ultimoNome())
                .tipo(dto.tipo())
                .observacoes(dto.obseracoes())
                .build();

        return petRepository.save(petModel);
    }

    public PetModel findById(UUID id){
        return petRepository.findById(id)
                .orElseThrow( () -> new PetNaoEncontrado(id));
    }

    public PetModel updatePet(UUID id, PetUpdateDTO dto){

        var model = petRepository.findById(id)
                .orElseThrow( () -> new PetNaoEncontrado(id));

        model.setPrimeiroNome(dto.primeiroNome());
        model.setUltimoNome(dto.ultimoNome());
        model.setObservacoes(dto.observacoes());
        model.setDataDeNascimento(dto.dataDeNascimento());
        model.setTipo(dto.tipo());

        return petRepository.save(model);
    }

}
