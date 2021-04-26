/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */

package it.edu.isspitagora.indovinanumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class PrimaryController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="layoutTentativo"
    private HBox layoutTentativo; // Value injected by FXMLLoader

    @FXML // fx:id="btnNuovaPartita"
    private Button btnNuovaPartita; // Value injected by FXMLLoader

    @FXML // fx:id="textTentativi"
    private TextArea textTentativi; // Value injected by FXMLLoader

    @FXML // fx:id="textTentativoUtente"
    private TextField textTentativoUtente; // Value injected by FXMLLoader

    @FXML // fx:id="btnAvvioProva"
    private Button btnAvvioProva; // Value injected by FXMLLoader

    @FXML // fx:id="textRisultato"
    private TextArea textRisultato; // Value injected by FXMLLoader
    
    @FXML // fx:id="layoutTentativoUtente"
    private HBox layoutTentativoUtente; // Value injected by FXMLLoader
    
    public int numeroSegreto= 0;
    public int numeroMassimo=100;
    public int MaxTentativi= 8;
    public int numeroUtente;
    public int Tentativi;
    @FXML
    void handleNuovaPartita(ActionEvent event) 
    {
        numeroSegreto = (int) ((Math.random() * numeroMassimo) + 1);
        String txt = Integer.toString(MaxTentativi);
        textTentativi.setText(txt);
        btnNuovaPartita.setDisable(true);
    }

    @FXML
    void handleTentativo(ActionEvent event) 
    {
        
        
        try{
            String txtUtente = textTentativoUtente.getText();
            numeroUtente = Integer.parseInt(txtUtente);
            Tentativi++;
            String txt2 = Integer.toString(MaxTentativi-Tentativi);
             textTentativi.setText(txt2);
        }
        catch (NumberFormatException e)
        {
            textRisultato.setText("Devi inserire un numero interno, non dei caratteri !\n");
            textTentativoUtente.clear();
            return;
        }
        if (numeroUtente == numeroSegreto)
        {
            textRisultato.setText("GOOD JOB, HAI INDOVINATO IN " + Tentativi + " tentativi\n");
             
             textTentativoUtente.clear();
        }
        else if (numeroUtente != numeroSegreto)
        {
            textRisultato.setText("Ritenta sarai più fortunato\n");
            textTentativoUtente.clear();
            if(numeroUtente<numeroSegreto)
            {
                textRisultato.setText("Il numero da te inserito è più basso del numero segreto...");
                return;
            }
            else if(numeroUtente>numeroSegreto)
            {
                textRisultato.setText("Il numero da te inserito è più alto del numero segreto...");
                return;
            }
            else if (numeroUtente>100)
            {
                textRisultato.setText("Il numero da te inserito sfora il range previsto, riprova con un numero tra 1 e 100");
                return;
            }
            else if (numeroUtente<=0)
            {
                textRisultato.setText("Il numero da te inserito sfora il range previsto, riprova con un numero tra 1 e 100\n");
            }
        }
        if (Tentativi == MaxTentativi)
        {
            textRisultato.setText("Hai perso, inizia un'altra partita...\n");
            layoutTentativoUtente.setDisable(true);
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert layoutTentativo != null : "fx:id=\"layoutTentativo\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnNuovaPartita != null : "fx:id=\"btnNuovaPartita\" was not injected: check your FXML file 'primary.fxml'.";
        assert textTentativi != null : "fx:id=\"textTentativi\" was not injected: check your FXML file 'primary.fxml'.";
        assert textTentativoUtente != null : "fx:id=\"textTentativoUtente\" was not injected: check your FXML file 'primary.fxml'.";
        assert btnAvvioProva != null : "fx:id=\"btnAvvioProva\" was not injected: check your FXML file 'primary.fxml'.";
        assert textRisultato != null : "fx:id=\"textRisultato\" was not injected: check your FXML file 'primary.fxml'.";
        assert layoutTentativoUtente != null : "fx:id=\"layoutTentativoUtente\" was not injected: check your FXML file 'primary.fxml'.";
    }
}
