package it.cefi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.cefi.models.Corso;
import it.cefi.services.CorsoService;

@RestController
public class CorsoController {
	
	@Autowired
	private CorsoService corsoService;
	
	
	@RequestMapping(value ="/corso", method=RequestMethod.POST)
	public void addCorso(@RequestBody Corso corso) {
		corsoService.addCorso(corso);
	}
	
	@RequestMapping(value ={"/corso","/corsoID"}, method=RequestMethod.GET)
	public Iterable<Corso> getAllCorsi(@PathVariable(required=false) Integer corsoID){
		
		return corsoService.getCorsoDetails(corsoID);
	}
	
	
	@RequestMapping(value="/corso/delete/{corsoID}", method = RequestMethod.DELETE)
	public void deleteCorso(@PathVariable Integer corsoID) {
		 corsoService.deleteCorso(corsoID);
	}
	
	@RequestMapping(value="/corso/edit/{corsoID}")
	public void updateCorso(@PathVariable Integer id, @RequestBody Corso nuovaPersona) {
		corsoService.updateCorso(id, nuovaPersona);
	}
	
	

}
