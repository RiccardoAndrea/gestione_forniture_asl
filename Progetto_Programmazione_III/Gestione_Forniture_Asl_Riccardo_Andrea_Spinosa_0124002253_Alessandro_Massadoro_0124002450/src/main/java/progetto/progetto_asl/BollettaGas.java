package progetto.progetto_asl;
// LA CLASSE BOLLETTA GAS EREDITA LA CLASSE BOLLETTA E GESTISCE GLI ATTRIBUTI SPECIFICI DELLA BOLLETTA GAS
// I METODI SET GENERALMENTE NON LI TROVEREMO IN QUESTA CLASSE POICHE' CON IL PATTERN DAO LE MODIFICHE VENGONO EFFETTUATE DIRETTAMENTE NEL DATABASE
public class BollettaGas extends Bolletta implements InterfacciaFactory {
    private final float transportoGestione; // variabile per memorizzare il costo del trasporto e gestione del gas
    private final float fornituraGas; // variabile per memorizzare il costo della fornitura del gas
    private final float consumoPdr; // variabile per memorizzare il consumo PDR (Punto di consegna remoto)
    private final float oneriSistema; // variabile per memorizzare gli oneri di sistema


    // costruttore per inizializzare gli attributi specifici della bolletta gas, e quelli ereditati dalla classe Bolletta
    BollettaGas(String numeroFattura, String periodo, float totPagare, String dataEmissione, float iva, float imposte, String scadenza, float costiGenerali, String codiceMandato, String cig, String pod, float transportoGestione, float fornituraGas, float consumoPdr, float oneriSistema) {
        super(numeroFattura, periodo, totPagare, dataEmissione, iva, imposte, scadenza, costiGenerali, codiceMandato, cig, pod);

        this.transportoGestione = transportoGestione;
        this.fornituraGas = fornituraGas;
        this.consumoPdr = consumoPdr;
        this.oneriSistema = oneriSistema;
    }

    // metodo dell'interfaccia per inserire i dati nel database (in questa classe non viene implementato)
    @Override
    public void inserisciDati() {

    }

    // metodo dell'interfaccia per stampare i dettagli della bolletta gas (includendo anche quelli ereditati dalla classe Bolletta)
    @Override
    public void stampaDettagli(){
        System.out.println(this.transportoGestione);
        System.out.println(this.fornituraGas);
        System.out.println(this.consumoPdr);
        System.out.println(this.oneriSistema);
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
     }
}




