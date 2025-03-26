// LA CLASSE BOLLETTA ELETTRICA EREDITA LA BOLLETTA E GESTISCE ATTRIBBUTI DELLA BOLLETTA ELETTRICA
//I METODI SET GENERALMENTE NON LI TROVEREMO IN QUANTO CON IL PATTERN DAO LE MODIFICHE LE EFFETTUIAMO DIRETTAMENTE NEL DATABASE
package progetto.progetto_asl;

public class BollettaElettrica extends Bolletta implements InterfacciaFactory {
    private final float potenzaPrelevata; // la potenza prelevata
    private final float serviziVendita; // i servizi di vendita
    private final float cts; // costi trasporto e sistema
    private final float serviziDiRete; // servizi di rete
    private final float energiaAttiva; // energia attiva
    private final float energiaReattiva; // energia reattiva


    // costruttore che inizializza le proprietà della classe e quelle della superclasse
    BollettaElettrica(String numeroFattura, String periodo, float totPagare, String dataEmissione, float iva, float imposte, String scadenza, float costiGenerali, String codiceMandato, String cig, String pod,float potenzaPrelevata,float serviziVendita,  float cts,  float serviziDiRete, float energiaAttiva, float energiaReattiva) {
        super(numeroFattura, periodo, totPagare, dataEmissione, iva, imposte, scadenza, costiGenerali, codiceMandato, cig, pod);
        this.potenzaPrelevata = potenzaPrelevata;
        this.serviziVendita = serviziVendita;
        this.cts = cts;
        this.serviziDiRete = serviziDiRete;
        this.energiaAttiva = energiaAttiva;
        this.energiaReattiva = energiaReattiva;

    }

    // metodo dell'interfaccia InterfacciaFactory per inserire i dati
    @Override
    public void inserisciDati() {

    }

    // metodo per stampare i dettagli della bolletta elettrica
    @Override
    public void stampaDettagli(){
        System.out.println(getNumeroFattura());
        System.out.println(getPeriodo());
        System.out.println(getTotPagare());
        System.out.println(getDataEmissione());
        System.out.println(getIva());
        System.out.println(getImposte());
        System.out.println(getScadenza());
        System.out.println(getCostiGenerali());
        System.out.println(getCodiceMandato());
        System.out.println(getCig());
        System.out.println(getPod());
        System.out.println(potenzaPrelevata);
        System.out.println(serviziVendita);
        }
    }