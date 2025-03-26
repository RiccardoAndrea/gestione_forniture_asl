package progetto.progetto_asl;
// LA CLASSE BOLLETTA ACQUA EREDITA LA BOLLETTA E GESTISCE ATTRIBBUTI DELLA BOLLETTA D'ACQUA

public class BollettaAcqua extends Bolletta implements InterfacciaFactory {
    private final float acquedotto; // Importo per l'approvvigionamento idrico
    private final float fognatura; // Importo per la fognatura
    private final float depurazione; // Importo per la depurazione
    private final float consumoAcqua; // Importo per il consumo dell'acqua
    private final float oneriPerequazione; // Importo per gli oneri di perequazione

    // Costruttore per la classe BollettaAcqua
    BollettaAcqua(String numeroFattura, String periodo, float totPagare, String dataEmissione, float iva, float imposte, String scadenza, float costiGenerali, String codiceMandato, String cig, String pod, float acquedotto, float fognatura, float depurazione, float consumoAcqua, float oneriPerequazione) {
        super(numeroFattura, periodo, totPagare, dataEmissione, iva, imposte, scadenza, costiGenerali, codiceMandato, cig, pod);
        this.acquedotto = acquedotto;
        this.fognatura = fognatura;
        this.depurazione = depurazione;
        this.consumoAcqua = consumoAcqua;
        this.oneriPerequazione = oneriPerequazione;
    }

    //FactoryMethod NON SAPPIAMO IN ANTICIPO QUALE OGGETTO DOVRà ESSERE CREATO

    // Il metodo FactoryMethod non è stato implementato in questo codice
    @Override
    public void inserisciDati() {

    }
    @Override
    public void stampaDettagli(){
        // Stampa a video tutti i dettagli della bolletta, inclusi quelli specifici dell'acqua
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
        System.out.println(acquedotto);
        System.out.println(fognatura);
        System.out.println(depurazione);
        System.out.println(consumoAcqua);
        System.out.println(oneriPerequazione);
    }
}