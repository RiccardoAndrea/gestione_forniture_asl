package progetto.progetto_asl;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 Classe che gestisce il controller per l'inserimento di un fornitore
 */
public class ControllerInserisciFornitore extends Supporto {

    // elementi grafici dell'interfaccia
    @FXML
    private Text campiObbligatori;

    @FXML
    private TextField fax;

    @FXML
    private TextField indirizzoSede;

    @FXML
    private TextField nome;

    @FXML
    private TextField partitaIva;

    @FXML
    private TextField pec;

    @FXML
    private TextField telefonoSede;

    @FXML
    private TextField telefonoServizioCliente;


            /*
             Metodo per l'inserimento di un nuovo fornitore nel sistema
             @param event evento scatenato dall'azione dell'utente
             @throws IOException in caso di problemi con il cambio di pagina
             */
    @FXML
    void inserisciFornitore(ActionEvent event) throws IOException {

        ControllerInserisciFornitore controller2=new ControllerInserisciFornitore();
        //controllo sui campi obbligatori
        if(controller2.obbligatorio(partitaIva.getText(),indirizzoSede.getText(),nome.getText())){
            //caso in cui i campi obbligatori non siano inseriti, mostriamo un testo di errore
            campiObbligatori.setVisible(true);

        }
        else{
            //caso in cui tutti i campi obbligatori sono inseririti di conseguenza facciamo il refresh
            // e salviamo i dati inseriti

            Fornitore fornitore = new Fornitore(partitaIva.getText(),telefonoSede.getText(),telefonoServizioCliente.getText(),telefonoSede.getText(),pec.getText(),fax.getText(),nome.getText());
            controller2.refresh(event);
        }
    }




       /*
             Metodo per tornare alla pagina principale
             @param event evento scatenato dall'azione dell'utente
             @throws IOException in caso di problemi con il cambio di pagina
             */

    @FXML
    void tornaIndietro(ActionEvent event) throws IOException {
        ControllerSezionePrincipale controller2 = new ControllerSezionePrincipale();
        controller2.cambioController(event,"SezionePrincipale.fxml", controller2);

    }

     /*
             Metodo per refreshare la pagina corrente
             @param event evento scatenato dall'azione dell'utente
             @throws IOException in caso di problemi con il cambio di pagina
             */

    public void refresh(ActionEvent event) throws IOException {
        ControllerInserisciFornitore controller2 = new ControllerInserisciFornitore();
        controller2.cambioController(event,"InserisciFornitore.fxml", controller2);

    }
}
