
/*Questa classe ci serve come supporto a tutti i metodo dei controller in comune*/

package progetto.progetto_asl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


abstract class Supporto {
    //array di supporto con il prompt text della bolletta del gas
    private final String [] infoGasP={
            "TRASPORTO E GESTIONE*",
            "FORNITURA GAS*",
            "CONSUMO PDR*",
            "ONERI DI SISTEMA*"

    };
    //array di supporto con il prompt text della bolletta dell'acqua

    private final String [] infoAcquaP={
            "ACQUEDOTTO*", //ACQUA
            "FOGNATURA*",//ACQUA
            "DEPURAZIONE*",//ACQUA
            "CONSUMO ACQUA*",//ACQUA
            "ONERI PEREQUAZIONE*",//ACQUA
            "NUMERO FATTURA*",//ACQUA
    };
    //array di supporto con il prompt text della bolletta elettrica
    private final String [] infoElettricaP={
            "POTENZA PRELEVATA*", //Elettrica
            "SERVIZI DI VENDITA", //Elettrica
            "CTS", //Elettrica
            "SERVIZI DI RETE", //Elettrica
            "ENERGIA ATTIVA*", //Elettrica
            "ENERGIA REATTIVA*" //Elettrica
    };

    //array di appoggio per poter aggiornare i nomi visualizzati sulle funzionni nella sezione principale
    private final String [] nomeFunzioniP={
            "Ultimo Pagamento",//POD, N_FATTURA,
            "Adeguatezza", // POD, N_FATTURA, CONTRATTO
            "Cessa Contratto",// POD, N_FATTURA, CONTRATTO
            "Confronto Lettura",//POD, N_FATTURA
            "Iva Totale",//DISTRETTO
            "Potenza Media Annua",// DISTRETTO
            "Potenza Annua",//DISTRETTO
            "Totale Pagato",//DISTRETTO
            "Consumo Annuo",//DISTRETTO
            "Spese Totali",//DISTRETTO
            "Cambio Permessi",// DIPENDENTE
            "Crea Nuova Chiave"//DIPENDENTE
    };

    //array di appoggio con gli id dei bottoni presenti nella sezione principale
    private final String [] stringIdButtonP={
            "pod",
            "numero fattura",
            "distretto",
            "fornitore",
            "struttura",
            "contratto",
            "dipendente",
            "mandato"
    };



    /*Questo metodo ci permette di cambiare il controller e la scena quando eseguiamo dei cambi tra pagine statiche, ogni pagina che ha bisogno del cambio scena
    * erediterà il metod dalla classe supporto*/

    public <T> void cambioController(ActionEvent actionEvent, String pagina, T x) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(pagina));
        Object root = loader.load();
        x = loader.getController();
        /*Questi attributi gestiscono il cambio delle scene*/
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();
    }

    //metodo get che ritorna l'array con le informazioni del prompt text dei TextField per la boleltta gas
    public String[] getInfoGasP(){
        return infoGasP;
    }

    //metodo get che ritorna l'array con le informazioni del prompt text dei TextField per la boleltta acqua
    public String[] getInfoAcquaP(){
        return infoAcquaP;
    }

    //metodo get che ritorna l'array con le informazioni del prompt text dei TextField per la boleltta elettrica
    public String[] getInfoElettricaP(){
        return infoElettricaP;
    }

    //metodo che ritorna gli id dei bottoni per il controllo del bottone premuto
    public String[] getStringIdButtonP(){
        return stringIdButtonP;
    }

    //metodo che ritorna l'aray di appoggio con i nomi delle funzioni da visualizzare nei pulsanti dinamici della pagina
    //sezione principale
    public String[] getNomeFunzioniP(){
        return nomeFunzioniP;
    }



    //questo metodo controlla tutti i campi obbligatori per ogni inserimento, nel caso
    //uno dei campi obbligagori non venga inserito la funzione ritorna true
    //altrimenti ritorna false
    //sono presenti diversi overload della funzione in quanto sono necessari
    //per i diversi controlli
    public boolean obbligatorio(String cig,String centroCosto, String potenzaContrattuale,String stato,String adeguatezza,String partitaIva,String codicePod,String condizioneMercato,String tipoFornitura,String tipo)
    {
        //mettiamo tutti i campi passati come attributi all'interno dell'array così da poterlo scorrere
        System.out.println("siamo dentro la funzione obbligatorio");
        String []array={
                cig,
                centroCosto,
                potenzaContrattuale,
                stato,
                adeguatezza,
                partitaIva,
                codicePod,
                condizioneMercato,
                tipoFornitura,
                tipo,

        };

        for(String singolo:array){
            //i campi sono ciò che l'utente ha inserito in un TextField, quindi se non è stato inserito
            //risulterà essere vuoto
            if(singolo.isEmpty()){

                return true;}
        }
        System.out.println("Obbligatorio è terminato");
        return false;
    }

    //@OVERLOAD
    public boolean obbligatorio(String p1,String p2, String p3,String p4,String p5,String p6,String p7,String p8,String p9,String p10,String p11,String p12,String p13,String p14)
    {
        System.out.println("siamo dentro la funzione obbligatorio");
        String []array={
                p1,
                p2,
                p3,
                p4,
                p5,
                p6,
                p7,
                p8,
                p9,
                p10,
                p11,
                p12,
                p13,
                p14

        };


        for(String singolo:array){
            if(singolo.isEmpty()){

                return true;}
        }
        System.out.println("Obbligatorio è terminato");
        return false;
    }
    //@OVERLOAD
    public boolean obbligatorio(String p1,String p2, String p3,String p4,String p5,String p6,String p7,String p8,String p9,String p10,String p11,String p12,String p13,String p14,String p15)
    {
        System.out.println("siamo dentro la funzione obbligatorio");
        String []array={
                p1,
                p2,
                p3,
                p4,
                p5,
                p6,
                p7,
                p8,
                p9,
                p10,
                p11,
                p12,
                p13,
                p14,
                p15

        };


        for(String singolo:array){
            if(singolo.isEmpty()){

                return true;}
        }
        System.out.println("Obbligatorio è terminato");
        return false;
    }
    //@OVERLOAD
    public boolean obbligatorio(String p1,String p2, String p3,String p4,String p5,String p6,String p7,String p8,String p9,String p10,String p11,String p12,String p13,String p14,String p15,String p16)
    {
        System.out.println("siamo dentro la funzione obbligatorio");
        String []array={
                p1,
                p2,
                p3,
                p4,
                p5,
                p6,
                p7,
                p8,
                p9,
                p10,
                p11,
                p12,
                p13,
                p14,
                p15,
                p16

        };


        for(String singolo:array){
            if(singolo.isEmpty()){

                return true;}
        }
        System.out.println("Obbligatorio è terminato");
        return false;
    }
    //@OVERLOAD
    public boolean obbligatorio(String p1,String p2, String p3)
    {
        System.out.println("siamo dentro la funzione obbligatorio");
        String []array={
                p1,
                p2,
                p3,

        };


        for(String singolo:array){
            if(singolo.isEmpty()){

                return true;}
        }
        System.out.println("Obbligatorio è terminato");
        return false;
    }

    public boolean obbligatorio(String p1,String p2)
    {
        System.out.println("siamo dentro la funzione obbligatorio");
        String []array={
                p1,
                p2
        };


        for(String singolo:array){
            if(singolo.isEmpty()){

                return true;}
        }
        System.out.println("Obbligatorio è terminato");
        return false;
    }
}
