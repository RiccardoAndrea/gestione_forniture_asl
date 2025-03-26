package progetto.progetto_asl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;



//Questa classe gestisce l'inizializzazione del nostro client
//e di tutta la nostra gestione
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //carichiamo la pagina javafx di login
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        //eseguiamo a schermo la nuova pagina, potremmo mettere la grandezza a pixel,
        // ma evitiamo i quanto l'abbiamo precedentemente settata
        Scene scene = new Scene(root);
        // titolo della finestra che si crea
        stage.setTitle("Gestione Forniture ASL");
        stage.setScene(scene);
        //mostriamo a schermo
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}