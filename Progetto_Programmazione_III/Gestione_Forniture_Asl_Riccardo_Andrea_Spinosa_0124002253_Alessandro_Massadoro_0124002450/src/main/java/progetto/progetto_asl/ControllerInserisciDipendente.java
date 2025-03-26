package progetto.progetto_asl;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControllerInserisciDipendente extends Supporto {

    @FXML
    private SplitMenuButton Menu;
    @FXML
    private Text campiObbligatori;

    @FXML
    private TextField cognome;

    @FXML
    private TextField emailAziendale;

    @FXML
    private TextField nome;

    @FXML
    private MenuItem Admin;

    @FXML
    private MenuItem Regular;

    @FXML
    private MenuItem Nessuno;

    private int flagPrivilegio=1;



    @FXML
    void inserisciDipendente(ActionEvent event) throws IOException {
        ControllerInserisciDipendente controller2=new ControllerInserisciDipendente();
        if(controller2.obbligatorio(emailAziendale.getText(),nome.getText(), cognome.getText())){
            System.out.println("SONO DENTRO L'IF");
            campiObbligatori.setVisible(true);
            System.out.println("HO RICHIAMATO A FUNZIONE");
        }else {
            Dipendente dipendente = new Dipendente(emailAziendale.getText(),nome.getText(),cognome.getText(), flagPrivilegio);
            DipendenteDao dipendentedao = new DipendenteDao();
            dipendentedao.save(dipendente);
            controller2.refresh(event);
        }
    }




    @FXML
    void tornaIndietro(ActionEvent event) throws IOException {
        ControllerSezionePrincipale controller2 = new ControllerSezionePrincipale();
        controller2.cambioController(event,"SezionePrincipale.fxml", controller2);
    }
    public void refresh(ActionEvent event) throws IOException {
        ControllerInserisciDipendente controller2 = new ControllerInserisciDipendente();
        controller2.cambioController(event,"InserisciDipendente.fxml", controller2);
    }


    public void impostaPivilegio(ActionEvent actionEvent) {
        MenuItem[] idMenuItem={
                Nessuno,
                Regular,
                Admin
        };
        if (idMenuItem[0]==actionEvent.getSource()){
            Menu.setText("NESSUNO");
            flagPrivilegio= 0;
        }
        else if(idMenuItem[1]==actionEvent.getSource()){
            Menu.setText("REGULAR");
            flagPrivilegio= 1;
        }
        else {
            Menu.setText("ADMIN");
            flagPrivilegio= 2;
        }
    }
}
