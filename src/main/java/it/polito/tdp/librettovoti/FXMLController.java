package it.polito.tdp.librettovoti;

import java.net.URL;
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

	/**ATTRIBUTO DI RIFERIMENTO AL MODEL:**/
	private Libretto model; 
	
	
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
    void handleNuovoVoto(ActionEvent event) {
    	
    	/**1.ACQUISIZIONE E CONTROLLO DATI:**/
    	
    	String nome = txtNomeCorso.getText();
    	Integer punteggio = cmbPunteggi.getValue(); //*
    	
    	//* 
    	//dichiarato come Integer per permettere al programma
    	//di assicurarsi che non sia null.
    	
    	if(nome.equals("") || punteggio==null) {
    		txtStatus.setText("ERRORE: occorre inserire Nome Corso e Punteggio.");
    		return; 
    	}
    	
    		
    	/**2.ESECUZIONE DELL'OPERAZIONE (MODEL).**/
    	boolean ok = model.add(new Voto(nome, punteggio));
    	
    	
    	/**3.VISUALIZZAZIONE/AGGIORNAMENTO DEL RISULTATO:**/
    	if(ok) {
    		List<Voto> voti = model.getVoti();
    	
    		txtVoti.clear();
    		txtVoti.setText("Hai superato "+voti.size()+" esami: \n");
    		for(Voto v : voti)
    			txtVoti.appendText(v.toString()+"\n");
    	
    		txtNomeCorso.clear();
    		cmbPunteggi.setValue(null);
    		txtStatus.setText("");
    	}
    	
    	txtStatus.setText("ERRORE: esame già presente.");
    }

    
    /**METODO CHE CONSENTE DI ASSOCIARE IL MODEL ALL'ATTRIBUTO DI RIFERIMENTO:**/
    public void setModel(Libretto model) {
    	this.model = model; 
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
        for(int p=18; p<30; p++)
        	cmbPunteggi.getItems().add(p);
    }

}
