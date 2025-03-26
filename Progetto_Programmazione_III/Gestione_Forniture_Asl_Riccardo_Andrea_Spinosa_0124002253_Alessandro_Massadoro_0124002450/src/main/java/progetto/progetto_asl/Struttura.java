package progetto.progetto_asl;
//I METODI SET GENERALMENTE NON LI TROVEREMO IN QUANTO CON IL PATTERN DAO LE MODIFICHE LE EFFETTUIAMO DIRETTAMENTE NEL DATABASE
//la classe rappresente una struttura
public class Struttura {
    //centro costo
    private final String centroCosto;
    //cap
    private final String cap;
    //via in cui è situata
    private final String via;
    //situazione giuridica attuale
    private final String situazioneGiuridica;

    //distretto a cui è associata
    private final String codiceDistretto;

    //costruttore
    public Struttura(String centroCosto, String cap, String via, String situazioneGiuridica, String codiceDistretto) {
        this.centroCosto = centroCosto;
        this.cap = cap;
        this.via = via;
        this.situazioneGiuridica = situazioneGiuridica;
        this.codiceDistretto = codiceDistretto;
    }

    //metodo get per ottenere il centro costo
    public String getCentroCosto(){
        return centroCosto;
    }

    //metodo get per ottenere il cap

    public String getCap(){
        return cap;
    }
    //metodo get per ottenere la via

    public String getVia(){
        return via;
    }

    //metodo get per ottenere la situazione giuridica

    public String getSituazioneGiuridica(){
        return situazioneGiuridica;
    }

    //metodo get per ottenere il codice del distretto a cui appartiene

    public String getCodiceDistretto(){
        return codiceDistretto;
    }
}
