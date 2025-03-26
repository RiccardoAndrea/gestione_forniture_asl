package progetto.progetto_asl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

//LOGIN

/*
Questo controller rappresenta la sezione del login dell'applicazione.
La classe ControllerLogin gestisce l'interazione tra l'interfaccia utente e il sistema.*/
public class ControllerLogin {
    //referenziamo le variabili prese dagli input presenti in pagina

    //testo per errore
    @FXML
    Label error;
    @FXML
    private TextField email;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;



    /*La funzione login_action gestisce l'evento del click sul bottone login.*/
    @FXML
    public  void login_action(ActionEvent actionEvent) throws IOException, CloneNotSupportedException, SQLException {

        //definiamo quale interfaccia del pattern strtegy utilizzare
        InterfacciaAutorizzazioneStrategy licenziatoStrategy = new LicenziatoAutorizzazioneStrategy();
        //prendiamo i dati di accesos inseriti dall'utente
        Dipendente accesso = new Dipendente(email.getText(),password.getText());
        //eseguiamo la connessione al database e cerchiamo un dipendente con quella mail
        DipendenteDao connessione = new DipendenteDao();
        connessione.getTByKey(accesso);


        //System.out.println(connessione);
        // OggettoCondiviso.setConnection(connessione);
        AutorizzazioneContext context = new AutorizzazioneContext();
        // Verifica dei privilegi
        context.setStrategy(licenziatoStrategy);
        // al posto di get privilegio ci vuole il privilegio del database.
        //controlliamo il privilegio di accesso, in caso il dipendente non possa entrare
        //neghiamo l'accesso
        if(context.checkPermission(accesso,Integer.toString(accesso.getPrivilego()) )){
            System.out.println("Sono Entrato nell'if");
            Alert alert =new Alert(Alert.AlertType.ERROR,"DATI INSERITI ERRATI");
            alert.showAndWait();
        }
        //caso in ui l'utente possa eseguire l'accesso al sistema
        else{
            //CREIAMO SIN DA SUBITO AL MOMENTO DEL LOGIN IL CLONE DI CONTRATTO
            //così da essere più efficienti nei futuri utilizzi
            Contratto contrattoOriginale = new Contratto("","",0,0,"1", "NO","","", "", "Fornitura ultima istanza","Media tensione Trifase","E","");
           //salviamo il contratto creato
            OggettoCondiviso.setOggettoContratto(contrattoOriginale.clone());
            //salviamo l'utente che sta utilizzando il nostro sistema in quanto
            //dobbiamo tenerne traccia
            OggettoCondiviso.setSharedObject(accesso);
            //controller per cambiare la scena
            ControllerSezionePrincipale controller2 = new ControllerSezionePrincipale();
            controller2.cambioController(actionEvent,"SezionePrincipale.fxml", controller2);
        }

    }
}
