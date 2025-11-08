package br.com.cuidapet.cuidapet.repository;

import br.com.cuidapet.cuidapet.models.pet.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PetRepository extends JpaRepository<PetModel, UUID> {
}
