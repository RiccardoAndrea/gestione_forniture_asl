package progetto.progetto_asl;
//I METODI SET GENERALMENTE NON LI TROVEREMO IN QUANTO CON IL PATTERN DAO LE MODIFICHE LE EFFETTUIAMO DIRETTAMENTE NEL DATABASE
//la classe rappresenra un distretto sanitario
public class Distretto {
    //nome distretto
    private final String nomeDistretto;
    //codice distretto
    private final String codiceDistretto;

    //costruttore
    public Distretto(String nomeDistretto, String codiceDistretto) {
        this.nomeDistretto = nomeDistretto;
        this.codiceDistretto = codiceDistretto;
    }

    //get del nomeDistretto
    public String getNomeDistretto(){
        return nomeDistretto;
    }

    //get del codice Distretto
    public String getCodiceDistretto(){
        return codiceDistretto;
    }
}
