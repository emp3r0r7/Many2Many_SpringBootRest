package it.cefi.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persone")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Basic
	private String nome;

	@Basic
	private String cognome;
	
	
	@ManyToMany
	@JoinTable(
			name = "corso_frequentato", 
			joinColumns = @JoinColumn(name = "persona_id"), 
			inverseJoinColumns = @JoinColumn(name = "corso_id"))
	
    private Set<Corso> corsiFrequentati = new HashSet<>();
	

	public Persona() {}

	public Persona(Integer id, String nome, String cognome) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}
	

	public Persona(Integer id, String nome, String cognome, Set<Corso> corsiFrequentati) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.corsiFrequentati = corsiFrequentati;
	}

	public Set<Corso> getCorsiFrequentati() {return corsiFrequentati;}

	public void setCorsiFrequentati(Set<Corso> corsiFrequentati) {this.corsiFrequentati = corsiFrequentati;}


	public Integer getId() {return id;}

	public void setId(Integer id) {this.id = id;}

	public String getNome() {return nome;}

	public void setNome(String nome) {this.nome = nome;}

	public String getCognome() {return cognome;}

	public void setCognome(String cognome) {this.cognome = cognome;}

}
