package it.polito.tdp.librettovoti.model;

import java.util.Objects;

public class Voto {
	
	//ATTRIBUTI:
	private String nomeCorso;
	private int punteggio;
	
	
	//COSTRUTTORE:
	public Voto(String nomeCorso, int punteggio) {
		
		this.nomeCorso = nomeCorso;
		this.punteggio = punteggio;
	}
	
	
	//METODI:
	public String getNomeCorso() {
		return nomeCorso;
	}
	
	public void setNomeCorso(String n) {
		this.nomeCorso = n;
	}
	
	
	public int getPunteggio() {
		return punteggio;
	}
	
	public void setPunteggio(int p) {
		this.punteggio = p;
	}
	
	
	//Metodo di stampa dei voti:
	@Override
	public String toString() {
		return nomeCorso+": "+punteggio;
	}

	//Metodo di confronto tra i voti:
	//affinchè i voti possano confrontarsi, è necessario il metodo equals().
	//Il metodo equals() però deve essere aggiunto necessariamente insieme
	//al metodo hashCode().
	
	//Source -> Generate hashCode() and equals()
	
	@Override
	public int hashCode() {
		return Objects.hash(nomeCorso, punteggio);
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
		return Objects.equals(nomeCorso, other.nomeCorso) && punteggio == other.punteggio;
	}

	
}
