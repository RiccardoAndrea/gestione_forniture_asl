package progetto.progetto_asl;
/*
Questa classe ha come scopo quello di gestire la schermata di inserimento di un nuovo contratto.
In particolare, gestisce la pressione dei due bottoni presenti nella schermata (inserisci contratto e torna indietro)
e inoltre gestisce la visualizzazione di un messaggio di errore nel caso in cui non vengano compilati tutti i campi obbligatori.
*/

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControllerInserisciContratto extends Supporto {

    //dichiarazione delle TextField utilizzate nella schermata
    @FXML
    private TextField adeguatezza;

    @FXML
    private TextField centroCosto;

    @FXML
    private TextField cig;

    @FXML
    private TextField codicePod;

    @FXML
    private TextField condizioneMercato;

    @FXML
    private TextField dataAdeguatezza;

    @FXML
    private TextField depositoCauzionale;

    @FXML
    private TextField partitaIva;

    @FXML
    private TextField potenzaContrattuale;

    @FXML
    private TextField protocolloAdeguatezza;

    @FXML
    private TextField stato;

    @FXML
    private TextField tipo;

    @FXML
    private TextField tipoFornitura;

    @FXML
    private Text campiOblligatori;

    @FXML
        //funzione richiamata quando viene premuto il bottone torna indietro
    void tornaIndietro(ActionEvent event) throws IOException {
        //creazione di un nuovo oggetto ControllerSezionePrincipale e chiamata della funzione cambioController
        ControllerSezionePrincipale controller2 = new ControllerSezionePrincipale();
        controller2.cambioController(event,"SezionePrincipale.fxml", controller2);
    }

    @FXML
        //funzione richiamata quando viene premuto il bottone inserisci contratto
    void inserisciContratto(ActionEvent event) throws IOException {
        //variabile utilizzata per gestire il caso in cui il deposito cauzionale non venga inserito, in quanto
        //in campo non è campo obbligatorio, nel caso non sia inserito esso darebbe potroblema
        //con il Float.parse, in quanto un campo vuoto non può esssere convertito in stringa

        String temp2="0";
        if(!depositoCauzionale.getText().isEmpty())
            temp2=depositoCauzionale.getText();
        ControllerInserisciContratto controller2=new ControllerInserisciContratto();
        //eseguiamo il clone del contratto utilizzando il pattern prototipe per risparmiare
        //ed essere più efficienti sulla creazione senza richiamare il costrutture
        //in quanto molto spesso molti campi di contratti diversi sono uguali
        Contratto clonato=OggettoCondiviso.getOggettoContratto();
        //richiamiamo la funzione che controlla i campi obbligatori  nel caso siano inseriti andiamo avanti altrimenti
        //mostriamo errore
        if(controller2.obbligatorio(cig.getText(),centroCosto.getText(),potenzaContrattuale.getText(),stato.getText(),adeguatezza.getText(),partitaIva.getText(),codicePod.getText(),condizioneMercato.getText(),tipoFornitura.getText(),tipo.getText())){
            campiOblligatori.setVisible(true);

        }else {
            //controlliamo quali sono i campi uguali del contratto ed sostiuitamo quelli dievrsi dal clone
            clonato.controlloSet(cig.getText(), centroCosto.getText(), Float.parseFloat(potenzaContrattuale.getText()), Float.parseFloat(temp2), stato.getText(), adeguatezza.getText(), dataAdeguatezza.getText(), partitaIva.getText(), codicePod.getText(), condizioneMercato.getText(), tipoFornitura.getText(), tipo.getText(), protocolloAdeguatezza.getText());
            System.out.println("SONO DOPO IL CLONE");
            controller2.refresh(event);
        }



    }

    public void refresh(ActionEvent event) throws IOException {
        ControllerInserisciContratto controller2 = new ControllerInserisciContratto();
        controller2.cambioController(event,"InserisciContratto.fxml", controller2);

    }
}
