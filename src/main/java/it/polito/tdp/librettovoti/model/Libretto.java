package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;


public class Libretto {

	//ATTRIBUTI:
	private List<Voto> librettoVoti;
	
	//NB: 
	//Utilizzare l'interfaccia generica List.
	//Specificare l'implementazione ArrayList nel costruttore.
	
	
	
	//COSTRUTTORE:
	public Libretto() {
		this.librettoVoti = new ArrayList<Voto>();
	}
	
	
	
	//METODI:
	public boolean add(Voto v) {
		
		if(!isDuplicato(v) && !isConflitto(v)) {
			this.librettoVoti.add(v);
			return true; 
		}
		
		return false; 
	}
	
	
	public String toString() {
		return this.librettoVoti.toString() ;
	}
	
	
	//Metodo che crea un nuovo libretto a partire da quello esistente, 
	//filtrando rispetto al punteggio dei voti: 
	public Libretto filtraPunteggio(int punteggio) {
		
		Libretto lResult = new Libretto();
		
		for(Voto v : librettoVoti) 
			if(v.getPunteggio() == punteggio)
				lResult.add(v);
		
		return lResult ;
	}
	
	
	//Metodo che restituisce il voto dell'esame il cui nome 
	//è passato come parametro: 
	public Integer punteggioEsame(String nome) {
		
		for(Voto v : librettoVoti) 
			if( v.getNomeCorso().equals(nome) ) 
				return v.getPunteggio() ;
			
		
		return null; //(Integer)
		
		//NB:
		//meglio "return null" che "return -1" perchè costituisce un 
		//controllo automatico di errore più completo.
		
		//Qualora ad esempio si volesse fare la media dei voti, 
		//-1 potrebbe essere considerato dal programma come un voto valido
		//invece che come messsaggio di errore.
		
		//in alternativa:
		//throw new IllegalArgumentException("Corso non trovato") ;
	}
	
	
	//Metodo che verifica se nel libretto è presente un duplicato,
	//ossia stesso esame e stesso voto:
	public boolean isDuplicato(Voto voto) {
		
		for(Voto v : librettoVoti) 
			if(v.equals(voto))
				return true ;
		
		return false;
		
		//NB: 
		//Il confronto tra voti viene però delegato ai voti stessi, con 
		//l'aggiunta del metodo equals alla classe Voto.
	}
	
	
	//Metodo che verifica se nel libretto è presente un conflitto,
	//ossia stesso esame e voto diverso:
	public boolean isConflitto(Voto v) {
		
		Integer punteggioEsame = punteggioEsame(v.getNomeCorso()) ;
		
		if(punteggioEsame != null && punteggioEsame != v.getPunteggio())
			return true;
		
		return false;
	}
	
	
	//Metodo che consente di stampare decentemente il libretto 
	//nell'interfaccia grafica: 
	public List<Voto> getVoti() {
		return librettoVoti;
	}
	
	
	//Metodo che crea un nuovo libretto avente tutti i voti migliorati
	//(senza modificare i voti del libretto di partenza):
	public Libretto votiMigliorati() {
	
		Libretto nuovoLibretto = new Libretto() ;
		
		for(Voto v : librettoVoti) {
			
			int punteggio = v.getPunteggio() ;
			
			if(punteggio >= 24)
				punteggio +=2 ;
			else 
				punteggio++ ;
			
			if (punteggio > 30)
				punteggio = 30 ;

			nuovoLibretto.add(new Voto(v.getNomeCorso(), punteggio)) ;
		}
		
		return nuovoLibretto ;
	}
	
	
	//Metodo per cancellare dal libretto (da una lista) tutti i voti
	//minori di un certo punteggio:
	public void cancellaVotiMinori(int p) {
	
		for(Voto v : librettoVoti) 
			if(v.getPunteggio() < p)
				librettoVoti.remove(v);
		
		//QUESTO METODO FUNZIONA?! NO.
		//PERCHE'? COME SI CORREGGE?!
		
		//...
	}
	
	
	

}
