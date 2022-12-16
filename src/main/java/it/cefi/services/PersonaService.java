package it.cefi.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cefi.models.Corso;
import it.cefi.models.Persona;
import it.cefi.repositories.CorsoRepository;
import it.cefi.repositories.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private CorsoRepository corsoRepository;
	
	public void addPersona(Persona persona) {
		personaRepository.save(persona);
	}

	public List<Persona> getPersone() {
		List<Persona> persone = new ArrayList<>();
		for (Persona persona : personaRepository.findAll()) {
			persone.add(persona);
		}
		return persone;
	}

	public Persona getPersona(int id) {
		return personaRepository.findById(id).get();
	}

	public void updatePersona(int id, Persona nuovaPersona) {
		Persona persona = personaRepository.findById(id).get();
		persona.setId(nuovaPersona.getId());
		persona.setNome(nuovaPersona.getNome());
		persona.setCognome(nuovaPersona.getCognome());
		personaRepository.save(persona);
	}

	public void deletePersona(int id) {
		personaRepository.deleteById(id);
	}

	public Persona assignProjectToEmployee(Integer personaID, Integer corsoID) {
		
		Set<Corso> corsoSet= new HashSet<>();
		Persona persona = personaRepository.findById(personaID).get();
		Corso corso = corsoRepository.findById(corsoID).get();
		corsoSet = persona.getCorsiFrequentati();
		corsoSet.add(corso);
		
		return personaRepository.save(persona);
	}

}
