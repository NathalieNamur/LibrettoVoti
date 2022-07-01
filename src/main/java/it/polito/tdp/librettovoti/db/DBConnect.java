package it.polito.tdp.librettovoti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static Connection getConnection() {
		
		//1.Definire la stringa di connessione JDBC:
		String url = "jdbc:mysql://localhost:3306/libretto?user=root&password=moustache";
					//jdbc: <tipo di database> :// <server fisico> / <tabella> ? <username> & <password>
		
		//2.Cercare di aprire la connessione:
		try {
			Connection conn = DriverManager.getConnection(url);
			return conn; 
			
		} catch (SQLException e) {
			System.out.println("ERRORE di connessione al database.");
			e.printStackTrace();
			return null;
		}
		
	}

	
	
}
