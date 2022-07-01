package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	//ATTRIBUTO DI RIFERIMENTO AL MODEL:
	private Libretto model; 
		
	private List<Voto> voti;
		
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> cmbPunteggi;

    @FXML
    private TextField txtNomeCorso;

    @FXML
    private Label txtStatus;

    @FXML
    private TextArea txtVoti;

    
    
    
    @FXML
    void doAggiungiVoto(ActionEvent event) {
    	
    	String nome = txtNomeCorso.getText();
		Integer punteggio = cmbPunteggi.getValue(); //*
   	
		//* 
		//dichiarato come Integer per permettere al programma
		//di assicurarsi che non sia null.
   	
		if(nome.equals("") || punteggio==null) {
			txtStatus.setText("Inserire Nome Corso e Punteggio.");
			return; 
		}
   	
   	
		boolean creazione = model.creaVoto(new Voto(nome, punteggio, LocalDate.now()));
   	
		//NB:
		//Nel Controller non c'è un campo per la data dell'esame
		//inserito, quindi di default la inizializziamo alla data odierna.
   	
   	
		if(creazione) {
   		
			voti = model.getAllVoti();
   		
			txtVoti.clear();
			txtVoti.setText("Hai superato "+voti.size()+" esami: \n");
			for(Voto v : voti)
				txtVoti.appendText(v.toString()+"\n");
   	
			txtNomeCorso.clear();
			cmbPunteggi.setValue(null);
			txtStatus.setText("");
		}
   	
		txtStatus.setText("ERRORE: esame non inseribile (già presente).");

    }

    
    
    //METODO setModel():
    public void setModel(Libretto model) {
    	
    	//PER ASSOCIARE IL MODEL ALL' ATTRIBUTO DI RIFERIMENTO
		this.model = model;
		
		//PER L'INSERIMENTO DEI VOTI:
    	voti = model.getAllVoti();
    	
		txtVoti.clear();
		txtVoti.setText("Hai superato "+voti.size()+" esami: \n");
		for(Voto v : voti)
			txtVoti.appendText(v.toString()+"\n");	
		
	}

    
    
	@FXML
    void initialize() {
        
		//Inizializzazzioni di default. Inserite in automatico:
		assert cmbPunteggi != null : "fx:id=\"cmbPunteggi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNomeCorso != null : "fx:id=\"txtNomeCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStatus != null : "fx:id=\"txtStatus\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";

        //Inizializzazione e polamento del menù a tendina dei punteggi:
        cmbPunteggi.getItems().clear();
        for(int p=18; p<=30; p++)
        	cmbPunteggi.getItems().add(p);
    
	}
	

	
}