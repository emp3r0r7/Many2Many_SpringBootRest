package it.cefi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.cefi.models.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
}
