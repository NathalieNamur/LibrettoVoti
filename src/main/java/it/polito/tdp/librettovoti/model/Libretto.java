package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import it.polito.tdp.librettovoti.db.VotoDAO;


public class Libretto {

	//ATTRIBUTI:
	private VotoDAO votoDAO;
	
	
	
	//COSTRUTTORE VUOTO:
	public Libretto() {
		this.votoDAO = new VotoDAO();
	}
	
	
	
	//METODI:
	
	public boolean creaVoto(Voto v) {
		return votoDAO.creaVoto(v); 
	}
	

	public List<Voto> getAllVoti(){ 
		return votoDAO.getAllVoti();
	}

	
}