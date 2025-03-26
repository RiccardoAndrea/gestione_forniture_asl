package progetto.progetto_asl;

import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.List;
//interfaccia da implementare per tutte le classi che richiedono il DAO

public interface InterfacciaDao<T> {

        //operazione per ottenere tutte le instanze di una determinata classe
        ObservableList <T> getAllObj();
        //operazione per filtrare l'stanza per chiave
        T getTByKey(T x);
        //operazione che ci permette di salvare l'oggetto allinterno del database
        void save(T x);

        //operazione che consente la cancellazione del determinato oggetto, se presente nel database
        void delete(T x);

}
