// LA CLASSE BOLLETTA E' UNA SUPER CALSSE CHE HA L'UNICO DI ESSERE EREDITATA.
//I METODI SET GENERALMENTE NON LI TROVEREMO IN QUANTO CON IL PATTERN DAO LE MODIFICHE LE EFFETTUIAMO DIRETTAMENTE NEL DATABASE
package progetto.progetto_asl;

// LA CLASSE BOLLETTA E' UNA SUPER CALSSE CHE HA L'UNICO DI ESSERE EREDITATA.
//I METODI SET GENERALMENTE NON LI TROVEREMO IN QUANTO CON IL PATTERN DAO LE MODIFICHE LE EFFETTUIAMO DIRETTAMENTE NEL DATABASE


// classe astratta per rappresentare una bolletta
public abstract class Bolletta {
    // numero fattura
    private final String numeroFattura;
    // periodo di riferimento
    private final String periodo;
    // importo totale da pagare
    private final float totPagare;
    // data di emissione
    private final String dataEmissione;
    // imposta sul valore aggiunto
    private final float iva;
    // altre imposte
    private final float imposte;
    // data di scadenza
    private final String scadenza;
    // costi generali
    private final float costiGenerali;
    // codice mandato
    private final String codiceMandato;
    // codice identificativo gara
    private final String cig;
    // punto di consegna
    private final String pod;

    // costruttore
    Bolletta(final String numeroFattura,final String periodo,final float totPagare,final String dataEmissione,final float iva,final float imposte,String scadenza,final float costiGenerali,final String codiceMandato,final String cig,final String pod){
        this.numeroFattura=numeroFattura;
        this.periodo=periodo;
        this.totPagare=totPagare;
        this.dataEmissione=dataEmissione;
        this.iva=iva;
        this.imposte=imposte;
        this.scadenza=scadenza;
        this.costiGenerali=costiGenerali;
        this.codiceMandato=codiceMandato;
        this.cig=cig;
        this.pod=pod;
    }

    // metodi get per accedere ai campi privati
    public String getNumeroFattura(){
        return numeroFattura;
    }
    public String getPeriodo(){
        return periodo;
    }
    public float getTotPagare(){
        return totPagare;
    }

    public String getDataEmissione(){
        return dataEmissione;
    }

    public float getIva(){
        return iva;
    }

    public float getImposte (){
        return imposte;
    }

    public String getScadenza(){
        return scadenza;
    }

    public float getCostiGenerali(){
        return costiGenerali;
    }

    public String getCodiceMandato(){
        return codiceMandato;
    }

    public String getCig(){
        return cig;
    }
    public String getPod(){
        return pod;
    }
}

