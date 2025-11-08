package br.com.cuidapet.cuidapet.controllers;

import br.com.cuidapet.cuidapet.models.pet.dtos.PetCreateDTO;
import br.com.cuidapet.cuidapet.models.pet.dtos.PetSenderDTO;
import br.com.cuidapet.cuidapet.models.pet.dtos.PetUpdateDTO;
import br.com.cuidapet.cuidapet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/pet")
public class PetController {

    @Autowired
    PetService petService;


    @PostMapping("/register")
    public ResponseEntity<PetSenderDTO> savePet (@RequestBody PetCreateDTO dto){
        var createdPet = petService.createPet(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body( new PetSenderDTO( createdPet.getPrimeiroNome() ) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetSenderDTO> findById (@RequestParam UUID id){
        var petModel = petService.findById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body( new PetSenderDTO( petModel.getPrimeiroNome() ) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetSenderDTO> updateById (@RequestParam UUID id, @RequestBody PetUpdateDTO dto){
        var petModel = petService.updatePet(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body( new PetSenderDTO ( petModel.getPrimeiroNome() ) );
    }

}
