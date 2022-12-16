package it.cefi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cefi.models.Corso;
import it.cefi.repositories.CorsoRepository;

@Service
public class CorsoService {
	
	@Autowired
	private CorsoRepository corsoRepository;
	
	public void addCorso (Corso corso) {
		corsoRepository.save(corso);
		
	}
	
	public Iterable<Corso> getCorsoDetails(Integer id){
		
		if(id!=null) {
			return corsoRepository.findAllByCorsoID(id);
		}else {
			return corsoRepository.findAll();
		}
	}
	
	public void deleteCorso(Integer id) {
		corsoRepository.deleteById(id);
	}

	public void updateCorso(Integer id, Corso nuovaPersona) {
		
		Corso corso = corsoRepository.findById(id).get();
		corso.setCorsoID(id);
		corso.setNomeCorso(nuovaPersona.getNomeCorso());
		corso.setFrequentanti(nuovaPersona.getFrequentanti());
		corso.setCorsoID(nuovaPersona.getCorsoID());
		corsoRepository.save(corso);
	
	}
	

}
