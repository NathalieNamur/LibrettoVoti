package it.polito.tdp.librettovoti.model;

public class TestLibretto {

	public static void main(String[] args) {
		
		//Creazione e popolamento del libretto l:
		Libretto l = new Libretto();
		l.add(new Voto("Analisi 1", 30));
		l.add(new Voto("Informatica", 25));
		l.add(new Voto("Fisica 1", 18));
		l.add(new Voto("Algebra lineare", 25));
		
		//Stampa del contenuto del libretto l:
		System.out.println(l) ;
		
		
		Libretto l25 = l.filtraPunteggio(25);
		System.out.println("Esami con voto pari a 25:");
		System.out.println(l25) ;
	
	}
}
