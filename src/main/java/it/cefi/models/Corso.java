package it.cefi.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name ="corsi")
public class Corso {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer corsoID;
	private String nomeCorso;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "corsiFrequentati")
	private Set <Persona> frequentanti = new HashSet<>();
	
	public Corso() {
		
	}
	
	public Corso(Integer corsoID, String nomeCorso) {
		super();
		this.corsoID = corsoID;
		this.nomeCorso = nomeCorso;
	}


	public Corso(Integer corsoID, String nomeCorso, Set<Persona> frequentanti) {
		super();
		this.corsoID = corsoID;
		this.nomeCorso = nomeCorso;
		this.frequentanti = frequentanti;
	}

	public Integer getCorsoID() {return corsoID;}

	public void setCorsoID(Integer corsoID) {this.corsoID = corsoID;}

	public String getNomeCorso() {return nomeCorso;}

	public void setNomeCorso(String nomeCorso) {this.nomeCorso = nomeCorso;}

	public Set<Persona> getFrequentanti() {return frequentanti;}

	public void setFrequentanti(Set<Persona> frequentanti) {this.frequentanti = frequentanti;}
	
	
	
	
	
}
