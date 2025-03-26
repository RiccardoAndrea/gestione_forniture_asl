package progetto.progetto_asl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.IOException;


/*

 Classe Controller per la gestione dell'inserimento di un mandato
 */
public class ControllerInserisciMandato extends Supporto {


    //TextField per l'inserimento dei dati del mandato
    @FXML
    private Text totaleMandato;

    @FXML
    private TextField numeroAtto;

    @FXML
    private TextField codiceMandato;

    @FXML
    private TextField dataRecapito;

    @FXML
    private TextField email;

    @FXML
    //Text per la visualizzazione dei messaggi di errore in caso di campi obbligatori non
    private Text campiObbligatori;


    /*
     Metodo per l'inserimento di un mandato nel sistema
     @param event evento generato dalla pressione del bottone per l'inserimento del mandato
     @throws IOException eccezione generata in caso di problemi con il cambio di scena
     */

    @FXML
    void inserisciMandato(ActionEvent event) throws IOException {
        String temp2="0";
        //creazione di un oggetto controller per accedere al metodo obbligatorio
        ControllerInserisciMandato controller2=new ControllerInserisciMandato();
        //obbligatorio controlla tutti i parametri obbligatori
        if(controller2.obbligatorio(codiceMandato.getText(),numeroAtto.getText(),dataRecapito.getText())){
            //se non sono inseriti tutti mostriamo errore
            campiObbligatori.setVisible(true);

        }
        else{
            //se sono inseriti tutti salviamo i parametri in mandato e refreshiamo la pagina
            Mandato mandato = new Mandato(codiceMandato.getText(),numeroAtto.getText(),dataRecapito.getText(),OggettoCondiviso.getSharedObject().getEmailAziendale());
            System.out.println(mandato.getEmail());
            controller2.refresh(event);
        }
    }


    //metodo per tornare indietro , attivato dall'utente
    @FXML
    void tornaIndietro(ActionEvent event) throws IOException {
        ControllerSezionePrincipale controller2 = new ControllerSezionePrincipale();
        controller2.cambioController(event,"SezionePrincipale.fxml", controller2);
    }

    //metodo per regreshare la pagina dopo inserimeno completo
    public void refresh(ActionEvent event) throws IOException {
        ControllerInserisciMandato controller2 = new ControllerInserisciMandato();
        controller2.cambioController(event,"InserisciMandato.fxml", controller2);

    }
}
