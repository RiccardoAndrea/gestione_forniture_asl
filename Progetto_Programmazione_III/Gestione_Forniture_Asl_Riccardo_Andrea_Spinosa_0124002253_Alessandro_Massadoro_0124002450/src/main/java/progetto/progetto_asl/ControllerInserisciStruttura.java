package progetto.progetto_asl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
public class ControllerInserisciStruttura extends Supporto {


    // TextField per la inserzione del cap
    @FXML
    private TextField cap;

    //TextField per la inserzione del centro costo
    @FXML
    private TextField centroCosto;

    // TextField per la inserzione del codice distretto
    @FXML
    private TextField codiceDistretto;

    // Text per la visualizzazione dell'errore in caso di campi obbligatori non compilati
    @FXML
    private Text inserisciStruttura;

    // TextField per la inserzione della situazione giuridica
    @FXML
    private TextField situazuineGiuridica;

    // TextField per la inserzione dell'indirizzo
    @FXML
    private TextField via;

    // Metodo per l'inserimento della struttura
    @FXML
    public void inserisciStruttura(ActionEvent event) throws IOException {
        ControllerInserisciStruttura controller2=new ControllerInserisciStruttura();
        // Verifica dei campi obbligatori, in caso di campi non compilati viene visualizzato un messaggio di errore
        if(controller2.obbligatorio(centroCosto.getText(),via.getText(),codiceDistretto.getText())){
            System.out.println("SONO DENTRO L'IF");
            inserisciStruttura.setVisible(true);
            System.out.println("HO RICHIAMATO A FUNZIONE");
        }else {
            // Creazione di un nuovo oggetto struttura con i valori inseriti nei TextField
            Struttura struttura = new Struttura(centroCosto.getText(),cap.getText(),via.getText(),situazuineGiuridica.getText(),codiceDistretto.getText());
            System.out.println("SONO DOPO IL CLONE");
            controller2.refresh(event);
        }
    }

    @FXML
    // Metodo per il ritorno alla schermata principale
    public void tornaIndietro(ActionEvent event) throws IOException {
        ControllerSezionePrincipale controller2 = new ControllerSezionePrincipale();
        controller2.cambioController(event,"SezionePrincipale.fxml", controller2);

    }


    // Metodo per il ritorno alla schermata corrente resettata dopo che l'inserimento
    //è stato completato con successo
    public void refresh(ActionEvent event) throws IOException {
        ControllerInserisciStruttura controller2 = new ControllerInserisciStruttura();
        controller2.cambioController(event,"InserisciStruttura.fxml", controller2);

    }
}
