package it.cefi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.cefi.models.Corso;

@Repository
public interface CorsoRepository extends CrudRepository<Corso, Integer>{

	List<Corso> findAllByCorsoID(Integer CorsoID);
	
}
