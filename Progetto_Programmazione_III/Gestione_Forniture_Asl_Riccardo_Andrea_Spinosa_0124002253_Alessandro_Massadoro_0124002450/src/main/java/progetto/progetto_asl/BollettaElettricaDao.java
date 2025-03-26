package progetto.progetto_asl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Classe che implementa l'interfaccia InterfacciaDao per la classe VistaLuce
 * Utilizzo del pattern DAO per la gestione dei dati delle bollette elettriche
 */
public class BollettaElettricaDao extends ConnessioneDao implements InterfacciaDao<VistaLuce> {
    @Override
    public ObservableList<VistaLuce> getAllObj() {
        try{
            // Creo la query per recuperare tutti i dati dalla tabella TABELLONE_STRUTTURA_LUCE
        String query ="SELECT * FROM TABELLONE_STRUTTURA_LUCE";
        PreparedStatement pstmt  = getConn().prepareStatement(query);
        // Creo una lista osservabile per i dati delle bollette elettriche
        ObservableList<VistaLuce> data = FXCollections.observableArrayList();
        ResultSet rs = pstmt.executeQuery();
        // Ciclo per recuperare tutti i dati dalla tabella
        while(rs.next()){
            // Recupero i dati dalla tabella
            System.out.println("sono entrato nel cilo while");
            String centroCosto = rs.getString("CENTRO_COSTO");
            String dataEmissione = rs.getString("DATA_EMISSIONE");
            String numeroFattura  = rs.getString("NUMERO_FATTURA");
            String costo = rs.getString("COSTO");
            String energiaAttiva= rs.getString("ENERGIA_ATTIVA");
            String energiaReattiva = rs.getString("ENERGIA_REATTIVA");
            String potenzaPrelevata  = rs.getString("POTENZA_PRELEVATA");
            String serviziDiVendita = rs.getString("SERVIZI_DI_VENDITA");
            String serviziDiRete= rs.getString("SERVIZI_RETE");
            String imposte  = rs.getString("IMPOSTE");
            String iva = rs.getString("IVA");
            String codicePod= rs.getString("CODICE_POD");
            System.out.println(" centroCosto: " + centroCosto + " dataEmissione: " + dataEmissione + "numeroFattura: " + numeroFattura + " costo: " + costo + " energiaAttiva: " + energiaAttiva + " energiaReattiva: " + energiaReattiva + " potenzaPrelevata: " + potenzaPrelevata+ " serviziDiVendita: " + serviziDiVendita +  " ServiziDiRete: " + serviziDiRete + " imposte: " + imposte + " iva: " + iva +  " CodicePod" + codicePod);
            //passiamo vistaluce per observer
            VistaLuce vistaluce = new VistaLuce(centroCosto,dataEmissione,numeroFattura,costo,energiaAttiva,energiaReattiva,potenzaPrelevata,serviziDiVendita,serviziDiRete,imposte,iva,codicePod);
            data.add(vistaluce);
        }
        System.out.println("ho terminato");
        return data;
        }catch(SQLException e){
            System.out.println("ECCEZIONE SQL");
            return null;
        }
    }

    // Tali operazioni sono gestite in un altra classe dao chiama BollettaElettricaInsDao dato che qui ci occupiamo della restituzione dei risultati delle tabelle
    @Override
    public VistaLuce getTByKey(VistaLuce x) {
        return null;
    }

    @Override
    public void save(VistaLuce x) {

    }

    @Override
    public void delete(VistaLuce x) {

    }
}
