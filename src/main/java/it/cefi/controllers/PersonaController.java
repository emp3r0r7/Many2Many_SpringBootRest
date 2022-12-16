package it.cefi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.cefi.models.Persona;
import it.cefi.services.PersonaService;

@RestController
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@RequestMapping(value = "/persona", method = RequestMethod.POST)
	public void addPersona(@RequestBody Persona persona) {
		personaService.addPersona(persona);
	}
	
	@RequestMapping(value = "/persona", method = RequestMethod.GET)
	public List<Persona> getPersona() {
		return personaService.getPersone();
	}
	
	@RequestMapping(value = "/persona/{id}", method = RequestMethod.GET)
	public Persona getPersona(@PathVariable int id) {
		return personaService.getPersona(id);
	}
	
	@RequestMapping(value = "/persona/{id}", method = RequestMethod.PUT)
	public void updatePersona(@PathVariable int id, @RequestBody Persona nuovaPersona) {
		personaService.updatePersona(id, nuovaPersona);
	}
	
	@RequestMapping(value = "/persona/{id}", method = RequestMethod.DELETE)
	public void deletePersona(@PathVariable int id) {
		personaService.deletePersona(id);
	}
	
	@RequestMapping(value="{id}/corsi/{corsoID}", method=RequestMethod.PUT)
	public Persona assignCorsoToPersona(@PathVariable Integer id, @PathVariable Integer corsoID) {
		
		return personaService.assignProjectToEmployee(id, corsoID);
	}
			
			
	
}
