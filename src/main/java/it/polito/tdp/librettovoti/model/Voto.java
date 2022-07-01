package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.Objects;

public class Voto {
	
	//ATTRIBUTI:
	//da copiare dalla tabella corrispondente in HeidiSQL
	
	private String nome;
	private int punteggio;
	private LocalDate data;
	
	
	
	//COSTRUTTORE:
	public Voto(String nome, int punteggio, LocalDate data) {
		
		this.nome = nome;
		this.punteggio = punteggio;
		this.data = data;
	}
	
	
	
	//METODI:
	
	//Generare di default i metodi:
	//- getter e setter 
	//- hashCode() ed equals() *
	//- toString()
		
	//*:
	//hashCode() ed equals() della sola chiave primaria (nome), 
	//che identifica univocamente i corsi.
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String n) {
		this.nome = n;
	}
	
	
	public int getPunteggio() {
		return punteggio;
	}
	
	public void setPunteggio(int p) {
		this.punteggio = p;
	}
	
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		return Objects.equals(nome, other.nome);
	}


	@Override
	public String toString() {
		return nome+": "+punteggio+" ("+this.data.toString()+")";
	}

	
	

	
}
