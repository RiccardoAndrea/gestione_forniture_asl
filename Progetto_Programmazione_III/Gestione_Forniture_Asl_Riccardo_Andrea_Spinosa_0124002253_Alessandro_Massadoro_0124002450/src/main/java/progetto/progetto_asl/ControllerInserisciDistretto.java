package progetto.progetto_asl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


import java.io.IOException;

public class ControllerInserisciDistretto extends Supporto{
    @FXML
    private Text campiObbligatori;

    @FXML
    private TextField codiceDistretto;

    @FXML
    private TextField nomeDistretto;

    @FXML
    void inserisciDistretto(ActionEvent event) throws IOException {
        ControllerInserisciDistretto controller2=new ControllerInserisciDistretto();
        if(controller2.obbligatorio(codiceDistretto.getText(),nomeDistretto.getText())){
            System.out.println("SONO DENTRO L'IF");
            campiObbligatori.setVisible(true);
            System.out.println("HO RICHIAMATO A FUNZIONE");
        }else {
            Distretto distretto = new Distretto(codiceDistretto.getText(),nomeDistretto.getText());
            controller2.refresh(event);
        }
    }


    @FXML
    void tornaIndietro(ActionEvent event) throws IOException {
        ControllerSezionePrincipale controller2 = new ControllerSezionePrincipale();
        controller2.cambioController(event,"SezionePrincipale.fxml", controller2);
    }

    public void refresh(ActionEvent event) throws IOException {
        ControllerInserisciDistretto controller2 = new ControllerInserisciDistretto();
        controller2.cambioController(event,"InserisciDistretto.fxml", controller2);
    }


}
