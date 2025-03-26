package progetto.progetto_asl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


import java.io.IOException;


/*
* Questo codice è un controller JavaFX che gestisce la finestra di
* inserimento di una bolletta. Il controller utilizza la libreria JavaFX per
* creare interfacce grafiche e gestire gli eventi dell'utente, estendiamo la classe supporto
* per utilizzare alcuni metodi necessari ed array di supporto
* */
public class ControllerInserisciBolletta extends Supporto {


    //prendiamo tutti i bottoni e campi necessari per gestire gli eventi dell'utente
    @FXML
    private Text campiObbligatori;

    @FXML
    private Button freccia;

    @FXML
    private TextField labelTotPagare;

    @FXML
    private TextField labelPeriodo;

    @FXML
    private TextField labelCostiGenerali;

    @FXML
    private TextField labelEnergiaReattiva;

    @FXML
    private TextField labelPod;

    @FXML
    private TextField labelPotenzaPrelevata;

    @FXML
    private TextField labelScadenza;

    @FXML
    private TextField labelCodiceAtto;

    @FXML
    private TextField labelEnergiaAttiva;

    @FXML
    private TextField labelImposte;

    @FXML
    private TextField labelDataEmissione;

    @FXML
    private TextField labelIva;
    @FXML
    private TextField labelCts;

    @FXML
    private TextField labelCig;

    @FXML
    private TextField labelServiziDiRete;

    @FXML
    private TextField labelNfattura;

    @FXML
    private TextField labelServiziDiVendita;

    @FXML
    private MenuItem gas;

    @FXML
    private SplitMenuButton Menu;

    @FXML
    private MenuItem elettrica;

    @FXML
    private MenuItem acqua;


    /*in questo metodo dinamiziamo la scelta della bolletta, di fatti a seconda del menu premuto dall'utente
    * compaiono o scompaiono le label d'insrimento con i rispettivi testi mostrati
    * inoltre si noti come le bollette hanno tra loro campi obbligatori diversi*/
    public void scegliBolletta(ActionEvent actionEvent) {
       //array di menu item per capire quale menù è stato premuto
        MenuItem[] idMenuItem={
                gas,
                elettrica,
                acqua
        };

        //array delle laber da modificare, sono al più 6 i TextField che cambiano
        //in quanto cambiano solo i TextField che non sono in comune
        TextField[] idTextField={
                labelPotenzaPrelevata,
                labelServiziDiVendita,
                labelCts,
                labelServiziDiRete,
                labelEnergiaAttiva,
                labelEnergiaReattiva
        };

        ControllerInserisciBolletta controller = new ControllerInserisciBolletta();
        //prendiamo tutte le informazioni necessarie da mostrare a schermo dagli array di supporto
        String[] infoGas = controller.getInfoGasP();
        String[] infoElettrica = controller.getInfoElettricaP();
        String[] infoAcqua = controller.getInfoAcquaP();


        // questo if controlla quale elemento del menu é stato premuto a seconda del tipo settiamo il promp delle label in maniera diversa
        //inoltre settiamo le label non necessarie non visibili
        if (idMenuItem[0]==actionEvent.getSource()){
            Menu.setText("Gas");
            //nel caso sia stato premuto il menu del gas cambiamo i 4 textField e nascondiamo quelli che risultano essere inutili
            for(int i=0; i<6; i++){
                if(i<4) {
                    idTextField[i].setPromptText(infoGas[i]);
                    idTextField[i].setVisible(true);
                }
                else {
                    idTextField[i].setVisible(false);
                }
            }
        }
        //nel caso sia stato premuto il menu elettrico cambiamo i 6 textField tutti i textField sono visibili
        else if(idMenuItem[1]==actionEvent.getSource()){
            Menu.setText("Elettrica");
            for(int i=0; i<6; i++){
                idTextField[i].setPromptText(infoElettrica[i]);
                idTextField[i].setVisible(true);
            }
        }
        else {
            //nel caso sia stato premuto il menu acqua cambiamo i 6 textField tutti i textField sono visibili
            Menu.setText("Acqua");
            for(int i=0; i<6; i++){
                idTextField[i].setPromptText(infoAcqua[i]);
                idTextField[i].setVisible(true);
            }
        }


        }


        /*
        * Questo è il metodo che viene richiamato quando viene premuto il pulsante per inserire la bolletta
        * a seconda della bolletta inserita dobbiamo controllare che tutti i campi obbligatori siano stati inseriti
        * */
    public void inserisiBolletta(ActionEvent actionEvent) throws IOException {
        ControllerInserisciBolletta controller2=new ControllerInserisciBolletta();
        //utilizziamo queste variabili di appoggio in quanto abbiamo bisogno di convertire la stringa presa in input
        //in dati float, ma nel caso i campi non sono obbligatori questi risultano essere vuoti
        // e manderebbero in errore il Float.parse che troviamo quando richiamiavo l'interfaccia Factory

        String temp="0",temp1="0",temp2="0";
        switch (Menu.getText()){
            case "Elettrica":
                // se tutti i campi obbligatori sono stati inseriti allora andiamo avanti, altrimenti
                //impostiamo come visibile la label di errore e non procediamo all'inserimento
                if(!controller2.obbligatorio(labelNfattura.getText(),labelPeriodo.getText(),labelTotPagare.getText(),labelDataEmissione.getText(),labelIva.getText(),labelImposte.getText(), labelScadenza.getText(), labelCostiGenerali.getText(),labelCodiceAtto.getText(),labelCig.getText(), labelPod.getText(),labelPotenzaPrelevata.getText(),labelEnergiaAttiva.getText(),labelEnergiaReattiva.getText())) {
                    if (!labelCts.getText().isEmpty())
                        temp=labelCts.getText();
                    if(!labelServiziDiRete.getText().isEmpty())
                        temp1=labelServiziDiRete.getText();
                    if(!labelServiziDiVendita.getText().isEmpty())
                        temp2=labelServiziDiVendita.getText();
                    InterfacciaFactory bollettaElettrica = (InterfacciaFactory) BollettaFactory.creaBolletta(labelNfattura.getText(), labelPeriodo.getText(), Float.parseFloat(labelTotPagare.getText()), labelDataEmissione.getText(), Float.parseFloat(labelIva.getText()), Float.parseFloat(labelImposte.getText()), labelScadenza.getText(), Float.parseFloat(labelCostiGenerali.getText()), labelCodiceAtto.getText(), labelCig.getText(), labelPod.getText(), Float.parseFloat(labelPotenzaPrelevata.getText()), Float.parseFloat(temp2), Float.parseFloat(temp), Float.parseFloat(temp1), Float.parseFloat(labelEnergiaAttiva.getText()), Float.parseFloat(labelEnergiaReattiva.getText()));
                    //refershiamo la pagina per pulirla da tutti i campi inseriti
                    refresh(actionEvent);

                }
                else{
                        campiObbligatori.setVisible(true);
                }

                break;
            case "Acqua":
                // se tutti i campi obbligatori sono stati inseriti allora andiamo avanti, altrimenti
                //impostiamo come visibile la label di errore e non procediamo all'inserimento
                if(!controller2.obbligatorio(labelNfattura.getText(),labelPeriodo.getText(),labelTotPagare.getText(),labelDataEmissione.getText(),labelIva.getText(),labelImposte.getText(), labelScadenza.getText(), labelCostiGenerali.getText(),labelCodiceAtto.getText(),labelCig.getText(), labelPod.getText(),labelPotenzaPrelevata.getText(),labelEnergiaAttiva.getText(),labelCts.getText(),labelServiziDiRete.getText(),labelServiziDiVendita.getText())) {
                    InterfacciaFactory bollettaAcqua = (InterfacciaFactory) BollettaFactory.creaBolletta(labelNfattura.getText(),labelPeriodo.getText(),Float.parseFloat(labelTotPagare.getText()),labelDataEmissione.getText(),Float.parseFloat(labelIva.getText()),Float.parseFloat(labelImposte.getText()), labelScadenza.getText(), Float.parseFloat(labelCostiGenerali.getText()),labelCodiceAtto.getText(),labelCig.getText(), labelPod.getText(),Float.parseFloat(labelPotenzaPrelevata.getText()),Float.parseFloat(labelServiziDiVendita.getText()),Float.parseFloat(labelCts.getText()),Float.parseFloat(labelServiziDiRete.getText()),Float.parseFloat(labelEnergiaAttiva.getText()));
                    refresh(actionEvent);
                }
                else{
                    //refershiamo la pagina per pulirla da tutti i campi inseriti
                    campiObbligatori.setVisible(true);
                }

                break;
            case "Gas":
                ;
                // se tutti i campi obbligatori sono stati inseriti allora andiamo avanti, altrimenti
                //impostiamo come visibile la label di errore e non procediamo all'inserimento
                if(!controller2.obbligatorio(labelNfattura.getText(),labelPeriodo.getText(),labelTotPagare.getText(),labelDataEmissione.getText(),labelIva.getText(),labelImposte.getText(), labelScadenza.getText(), labelCostiGenerali.getText(),labelCodiceAtto.getText(),labelCig.getText(), labelPod.getText(),labelPotenzaPrelevata.getText(),labelCts.getText(),labelServiziDiRete.getText(),labelServiziDiVendita.getText())) {
                    InterfacciaFactory bollettaGas = (InterfacciaFactory) BollettaFactory.creaBolletta(labelNfattura.getText(),labelPeriodo.getText(),Float.parseFloat(labelTotPagare.getText()),labelDataEmissione.getText(),Float.parseFloat(labelIva.getText()),Float.parseFloat(labelImposte.getText()), labelScadenza.getText(), Float.parseFloat(labelCostiGenerali.getText()),labelCodiceAtto.getText(),labelCig.getText(), labelPod.getText(),Float.parseFloat(labelPotenzaPrelevata.getText()),Float.parseFloat(labelServiziDiVendita.getText()),Float.parseFloat(labelCts.getText()),Float.parseFloat(labelServiziDiRete.getText()));                    refresh(actionEvent);
                }
                else{
                    //refershiamo la pagina per pulirla da tutti i campi inseriti
                    campiObbligatori.setVisible(true);
                }

                break;
        }
    }
    //il metodo è utilizzato per ritornare alla sezione precedente del client
    public void tornaIndietro(ActionEvent event) throws IOException {
        ControllerSezionePrincipale controller2 = new ControllerSezionePrincipale();
        controller2.cambioController(event,"SezionePrincipale.fxml", controller2);

    }


    //il metodo è utilizzato per refreshare il client dopo un inserimento
    public void refresh(ActionEvent event) throws IOException {
        ControllerInserisciBolletta controller2 = new ControllerInserisciBolletta();
        controller2.cambioController(event,"InserisciBolletta.fxml", controller2);

    }


}




