package it.polito.tdp.librettovoti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.librettovoti.model.Voto;

public class VotoDAO {

	//METODO PER LA CREAZIONE DI UN NUOVO VOTO:
	public boolean creaVoto(Voto v) {
	
		//Stringa contentente la query:
		String sql = "INSERT INTO voti (nome, punteggio) VALUES(?,?)"; //*
		
		//*
		//Copiare la stringa da HeidySQL e inserirla tra "":
		//Sostituire i parametri usati come esempio con ? (pd = ?).
		//Eliminare tutti gli \r\n. E qualora fosse necessario andare a
		//capo inserire sempre uno spazio dopo ciascun elemento.
		
		
		//Valore di ritorno:
		//- 
		
		
		//Codice di accesso effettivo al database (try-catch):
		try {
			
			//Connessione:
			Connection conn = DBConnect.getConnection();
			
			//PreparedStatement:
			PreparedStatement st = conn.prepareStatement(sql);  	
			
			//Inserimento paramentri nella query:
			st.setString(1, v.getNome());  //i parametri della query 							
			st.setInt(2, v.getPunteggio());		//sono numerati a partire da 1
			
			//Esecuzione della query e salvataggio del risultato:
			int res = st.executeUpdate();
			
			
			//Chiusura di tutti gli elementi:
			st.close();
			conn.close();
			
			//Ritorno esito creazione:
			return(res==1);
		

		} catch (SQLException e) {
			
			System.out.println(e);
			e.printStackTrace();
			return false; 
		}
		
	}
	
	
	
	//METODO PER OTTENERE TUTTI I VOTI SALVATI NEL DB
	//(AL FINE DI POPOLARE IL LBRETTO):
	public List<Voto> getAllVoti(){
		
		//Stringa contenente la query:
		String sql = "SELECT * FROM voti"; //*
		
		//*
		//Copiare la stringa da HeidySQL e inserirla tra "":
		//Sostituire i parametri usati come esempio con ? (pd = ?).
		//Eliminare tutti gli \r\n. E qualora fosse necessario andare a
		//capo inserire sempre uno spazio dopo ciascun elemento.

		
		//Struttura dati dei valori di ritorno:
		List<Voto> voti = new ArrayList<>();
		
		
		//Codice di accesso effettivo al database (try-catch):
		try {
			
			//Connessione:
			Connection conn = DBConnect.getConnection();
			
			//PreparedStatement:
			PreparedStatement st = conn.prepareStatement(sql);
			
			//Inserimento paramentri nella query (metodo set corretto):
			//-
			
			//Esecuzione dela query e salvataggio del risultato:
			
			ResultSet res = st.executeQuery();
			
			while (res.next()) {
				
				//Creazione di un Voto temporaneo in cui salvare 
				//le informazioni della riga del database letta:
				String nome = res.getString("nome");
				int punteggio = res.getInt("punteggio");
				LocalDate dataEsame = res.getDate("data").toLocalDate();
				
				//Inserimento di tale Voto nella struttura dati risultante:
				voti.add(new Voto(nome, punteggio, dataEsame));	
			}
			
			//Chiusura di tutti gli elementi:
			st.close();
			conn.close();
			
			//Ritorno della struttura dati creata:
			return voti; 
			
			
		} catch (SQLException e) {
			
			System.out.println(e);
			e.printStackTrace();
			return null; 
		}
				
	}
	

	
}
