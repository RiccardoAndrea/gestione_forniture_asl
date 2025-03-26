package progetto.progetto_asl;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import progetto.progetto_asl.*;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ControllerSezionePrincipale extends Supporto implements Initializable {


    @FXML
    private TableColumn<VistaLuce, String> colonna1;

    @FXML
    private TableColumn<VistaLuce, String> colonna10;

    @FXML
    private TableColumn<VistaLuce, String> colonna2;

    @FXML
    private TableColumn<VistaLuce, String> colonna3;

    @FXML
    private TableColumn<VistaLuce, String> colonna4;

    @FXML
    private TableColumn<VistaLuce, String> colonna5;

    @FXML
    private TableColumn<VistaLuce, String> colonna6;

    @FXML
    private TableColumn<VistaLuce, String> colonna7;

    @FXML
    private TableColumn<VistaLuce, String> colonna8;

    @FXML
    private TableColumn<VistaLuce, String> colonna9;

    @FXML
    private TableColumn<VistaLuce, String> colonna11;

    @FXML
    private TableColumn<VistaLuce, String> colonna12;

    @FXML
    private TableView<VistaLuce> tabella;

    //carichiamo tutti gli elementi necessari dalla pagina fxml, per poi poterci operare
    @FXML
    private TextField label;

    //i restanti elementi restano tutti privati in quanto sono bottoni

    @FXML
    private Button fornitore;
    @FXML
    private Button cerca;
    @FXML
    private Button pod;
    @FXML
    private Button n_fattura;
    @FXML
    private Button inserisciBolletta;

    @FXML
    private Button distretto;
    @FXML
    private Button struttura;
    @FXML
    private Button cessaContratto;

    @FXML
    private Button mandato;
    @FXML
    private Button ultimoPagamento;

    @FXML
    private Button modificaAdeguatezza;

    @FXML
    private Button contratto;

    @FXML
    private Button confrontoLettura;


    @FXML
    private Button dipendente;

    @FXML
    private Button distretto1;

    @FXML
    private Button distretto2;

    @FXML
    private Button insBolletta;
    @FXML
    private Button insMandato;
    @FXML
    private Button insContratto;
    @FXML
    private Button insFornitore;
    @FXML
    private Button insStrtuttura;
    @FXML
    private Button insDistretto;

    @FXML
    private Button insDipendente;

    //METODI GET

    public TextField getLabel(){
        return this.label;
    }



    public Button getUltimoPagamento(){
        return this.ultimoPagamento;
    }

    public Button getModificaAdeguatezza(){
        return this.modificaAdeguatezza;
    }

    public Button getCessaContratto(){
        return this.cessaContratto;
    }

    public Button getConfrontoLettura(){
        return this.confrontoLettura;
    }

    public Button getDistretto1(){
        return this.distretto1;
    }

    public Button getDistretto2(){
        return this.distretto2;
    }

    //questo metodo nascone le funzioni e le adatta a seconda
    //del pulsante premuto, di fatti a seconda del bottone premuto e del tipo di ricerca che si vuole fare
    //i pulsanti mostrano ed attivano funzioni sul database diverse.
    public void nascondiFunzione(int i){
        ControllerSezionePrincipale controller = new ControllerSezionePrincipale();
        String[] nomeFunzioni = controller.getNomeFunzioniP();
        //array di bottoni scottibile nel ciclo
        final Button [] funzioni_bottoni={
                getUltimoPagamento(),
                getModificaAdeguatezza(),
                getCessaContratto(),
                getConfrontoLettura(),
                getDistretto1(),
                getDistretto2()
        };
          //lo switch a seconda di quali bottoni l'utente preme si adatta e mostra
          // e nasconde i bottoni e le funzioni
        switch (i){
            case 0:
            case 1:
                for (int j=0; j<6; j++){
                    if(j<4){
                        //nome funzioni è l'array ereditato da supporto
                        funzioni_bottoni[j].setText(nomeFunzioni[j]);
                        funzioni_bottoni[j].setVisible(true);
                    }
                    else
                        //nascondiamo i bottoni extra
                        funzioni_bottoni[j].setVisible(false);
                }
                break;
            case 2:
                for (int j=4; j<10; j++){
                    funzioni_bottoni[j-4].setText(nomeFunzioni[j]);
                    funzioni_bottoni[j-4].setVisible(true);
                }
                break;
            case 5:
                for (int j=1; j<7; j++){
                    if(j<3){
                        funzioni_bottoni[j-1].setText(nomeFunzioni[j]);
                        funzioni_bottoni[j-1].setVisible(true);}
                    else
                        funzioni_bottoni[j-1].setVisible(false);
                }
                break;
            case 6:
                for (int j=10; j<16; j++){
                    if(j<12){
                        funzioni_bottoni[j-10].setText(nomeFunzioni[j]);
                        funzioni_bottoni[j-10].setVisible(true);
                    }
                    else
                        funzioni_bottoni[j-10].setVisible(false);
                }
                break;
            default:
                //il caso di default nasconde tutti i bottoni
                //in quanto non si hanno funzionalità legate a quella ricerca
                for (int j=0; j<6; j++){
                    funzioni_bottoni[j].setVisible(false);
                }
                break;



        }
    }


    /*
     * Questa funzione gestisce l'evento di pressione di un bottone all'interno di una lista di bottoni (idButton).
     Per ogni bottone nella lista, viene controllato se è stato premuto quello corrente (singleButton)
     rispetto a quello che ha generato l'evento (actionEvent.getSource()). Se è stato premuto quello corrente,
     * viene cambiato il suo colore e viene modificato l'ID e il testo del label,
     * inoltre viene chiamata la funzione nascondiFunzione().
     * Se non è stato premuto quello corrente, viene ripristinato il suo colore di default.
     * In caso i==6 si verifica se l'utente che ha effettuato il login ha privilegi da admin.
     * Se non li ha, viene mostrato un messaggio d'errore.
     */


    public void changeButton(ActionEvent actionEvent) {
        ControllerSezionePrincipale controller = new ControllerSezionePrincipale();
        String [] stringIdButton=controller.getStringIdButtonP();
        //array di bottoni di supporto
        Button [] idButton={
                pod,
                n_fattura,
                distretto,
                fornitore,
                struttura,
                contratto,
                dipendente,
                mandato
        };


        int i =0;
        //capiamo quale bottone è stato premuto e a seconda di cio adattiamo la pagina
        for(Button singleButton:idButton)
        {

            if (singleButton==actionEvent.getSource()){
                if(i==6){
                    Dipendente myObject = OggettoCondiviso.getSharedObject();
                    AutorizzazioneContext context = new AutorizzazioneContext();
                    AdminAutorizzazioneStrategy strategy = new AdminAutorizzazioneStrategy();
                    context.setStrategy(strategy);
                    if(context.checkPermission(myObject,Integer.toString(myObject.getPrivilego()))){
                        singleButton.setStyle("-fx-background-color: gray; -fx-border-color: black; -fx-text-fill: white");
                        label.setId("label_"+stringIdButton[i]);
                        System.out.println(label.getId());
                        label.setPromptText("Ricerca per "+stringIdButton[i]);
                        nascondiFunzione(i);

                    }
                    else{
                        Alert alert =new Alert(Alert.AlertType.ERROR,"PERMESSO NEGATO NON HAI L'ACCESO");
                        alert.showAndWait();
                    }
                }else{
                    if(i==0 || i==1){
                        tabella.setVisible(true);
                    }
                    else
                        tabella.setVisible(false);
                singleButton.setStyle("-fx-background-color: gray; -fx-border-color: black; -fx-text-fill: white");
                label.setId("label_"+stringIdButton[i]);
                System.out.println(label.getId());
                label.setPromptText("Ricerca per "+stringIdButton[i]);
                nascondiFunzione(i);}
            }
            else{
                singleButton.setStyle("-fx-background-color: white; -fx-border-color: black;-fx-text-fill: black");

            }
            i++;
        }

    }



    /*
    * I metodi sottostanti si attivano quando l'utente vuole spostarsi dalla sezione principale
    * alla sezione che permette inserimenti nel database, utilizza il metodo esteso dalla classe supporto
    * */
    public  void caricaBolletta(ActionEvent actionEvent) throws IOException {
        //per caricare la pagina della nuova bolletta abbiamo necessità di instanziare un nuovo controller e di passarlo come parametro al metodo
        ControllerInserisciBolletta controllerNuovo = new ControllerInserisciBolletta();


        controllerNuovo.cambioController(actionEvent,"InserisciBolletta.fxml", controllerNuovo);
    }


    public void caricaMandato(ActionEvent actionEvent) throws IOException {

        ControllerInserisciMandato controllerNuovo = new ControllerInserisciMandato();
        controllerNuovo.cambioController(actionEvent,"InserisciMandato.fxml", controllerNuovo);
    }

    public void caricaContratto(ActionEvent actionEvent) throws IOException{
        ControllerInserisciContratto controllerNuovo = new ControllerInserisciContratto();
        controllerNuovo.cambioController(actionEvent,"InserisciContratto.fxml", controllerNuovo);
    }

    public void caricaStruttura(ActionEvent actionEvent) throws IOException{
        ControllerInserisciStruttura controllerNuovo = new ControllerInserisciStruttura();
        controllerNuovo.cambioController(actionEvent,"InserisciStruttura.fxml", controllerNuovo);
    }

    public void caricaDistretto(ActionEvent actionEvent) throws IOException{
        ControllerInserisciDistretto controllerNuovo = new ControllerInserisciDistretto ();
        controllerNuovo.cambioController(actionEvent,"InserisciDistretto.fxml", controllerNuovo);
    }


    /*
    * Nel caso venga premuto il bototne che sposta alla sezione per inserire un dipendente
    * dobbiamo prima controllare il privilegio del dipedente connesso e che utilizza il sistema
    * utilizziamo quindi il pattern policy con interfaccia di autorizzazione admin, in questo modo solo
    * un admin può accedere a questa sezione
    * */
    public void caricaDipendente(ActionEvent actionEvent) throws IOException{
        Dipendente myObject = OggettoCondiviso.getSharedObject();
        AutorizzazioneContext context = new AutorizzazioneContext();
        AdminAutorizzazioneStrategy strategy = new AdminAutorizzazioneStrategy();
        context.setStrategy(strategy);
        System.out.println(Integer.toString(myObject.getPrivilego())+" sono stringa");
        if(context.checkPermission(myObject,Integer.toString(myObject.getPrivilego()))){
            System.out.println("sono entrato");
            ControllerInserisciDipendente controllerNuovo = new ControllerInserisciDipendente();
            controllerNuovo.cambioController(actionEvent,"InserisciDipendente.fxml", controllerNuovo);
        }
        else{
            Alert alert =new Alert(Alert.AlertType.ERROR,"PERMESSO NEGATO NON HAI L'ACCESO");
            alert.showAndWait();
        }
    }


    //sposta l'utente alla sezione di caricamento di un fornitore
    public void caricaFornitore(ActionEvent actionEvent) throws IOException {
        ControllerInserisciFornitore controllerNuovo = new ControllerInserisciFornitore();
        controllerNuovo.cambioController(actionEvent,"InserisciFornitore.fxml", controllerNuovo);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*Per scopo solo di usabilità per definire l'interfaccia all'avvio verranno mostrate
        solo le bollette elettriche in quanto lo scopo non è restituire fedelmente tutti i dati
        ma solo capire e migliroare l'usabilità dell'interfaccia*/
        BollettaElettricaDao bollettaElettricaDao = new BollettaElettricaDao();
        bollettaElettricaDao.getAllObj();
        System.out.println("no sono cushato");
        //avendo utilizzato il pattern observer settiamo la vista riportata dal database all'interno delle colonne della tabella
        //Passiamo dunque il tipo della colonna da cui deve recuperarare i fati attraverso i metodi get e la stringa che corrispondono agli attributi della classe
        colonna1.setCellValueFactory(new PropertyValueFactory<VistaLuce, String>("codicePod"));
        colonna2.setCellValueFactory(new PropertyValueFactory<VistaLuce, String>("iva"));
        colonna3.setCellValueFactory(new PropertyValueFactory<VistaLuce, String>("numeroFattura"));
        colonna4.setCellValueFactory(new PropertyValueFactory<VistaLuce, String>("costo"));
        colonna5.setCellValueFactory(new PropertyValueFactory<VistaLuce, String>("energiaAttiva"));
        colonna6.setCellValueFactory(new PropertyValueFactory<VistaLuce, String>("energiaReattiva"));
        colonna7.setCellValueFactory(new PropertyValueFactory<VistaLuce, String>("potenzaPrelevata"));
        colonna8.setCellValueFactory(new PropertyValueFactory<VistaLuce, String>("serviziDiVendita"));
        colonna9.setCellValueFactory(new PropertyValueFactory<VistaLuce, String>("serviziDiRete"));
        colonna10.setCellValueFactory(new PropertyValueFactory<VistaLuce, String>("imposte"));
        colonna11.setCellValueFactory(new PropertyValueFactory<VistaLuce, String>("centroCosto"));
        colonna12.setCellValueFactory(new PropertyValueFactory<VistaLuce, String>("dataEmissione"));
        ObservableList vista = bollettaElettricaDao.getAllObj();
        tabella.setItems(vista);
    }

    public void buttonCerca(ActionEvent actionEvent) {
    }
}