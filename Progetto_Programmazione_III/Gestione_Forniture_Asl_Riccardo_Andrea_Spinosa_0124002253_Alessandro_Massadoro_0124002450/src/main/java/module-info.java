module progetto.progetto_asl {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens progetto.progetto_asl to javafx.fxml;
    exports progetto.progetto_asl;
}