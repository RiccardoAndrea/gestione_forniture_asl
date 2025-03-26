package progetto.progetto_asl;

public class BollettaFactory {
    /*La classe BollettaFactory utilizza il pattern di progettazione Factory Method per creare oggetti di tipo Bolletta
     (BollettaElettrica, BollettaAcqua, BollettaGas) senza dover specificare esattamente la classe dell'oggetto da creare.
     Utilizzando i metodi statici creaBolletta(), l'utente che utilizza il sistema può inserire una bolletta elettrica,
      acqua o gas in modo dinamico, senza dover sapere in anticipo quale tipo di bolletta creare.
      La logica di creazione viene spostata in questa classe, separandola dal client.*/



    /*
     Il metodo creaBolletta() è un metodo statico che permette di creare un'istanza di un oggetto Bolletta.
     In base ai parametri passati, verrà creata una Bolletta di tipo specifico (Elettrica, Acqua o Gas)
    */
    public static Bolletta creaBolletta(String numeroFattura,String periodo,float totPagare, String dataEmissione,float iva, float imposte, String scadenza, float costiGenerali, String codiceMandato, String cig, String pod, float primo, float secondo, float terzo, float quarto,float quinto, float sesto)
        {
            return new BollettaElettrica(numeroFattura,periodo,totPagare,dataEmissione,iva,imposte,scadenza,costiGenerali,codiceMandato,cig,pod,primo,secondo,terzo,quarto,quinto,sesto);

        }

    public static Bolletta creaBolletta(String numeroFattura,String periodo,float totPagare, String dataEmissione,float iva, float imposte, String scadenza, float costiGenerali, String codiceMandato, String cig, String pod, float primo, float secondo, float terzo, float quarto,float quinto)
    {
        return new BollettaAcqua(numeroFattura,periodo,totPagare,dataEmissione,iva,imposte,scadenza,costiGenerali,codiceMandato,cig,pod,primo,secondo,terzo,quarto,quinto);
    }

    public static Bolletta creaBolletta(String numeroFattura,String periodo,float totPagare, String dataEmissione,float iva, float imposte, String scadenza, float costiGenerali, String codiceMandato, String cig, String pod, float primo, float secondo, float terzo, float quarto)
    {
        return new BollettaGas(numeroFattura,periodo,totPagare,dataEmissione,iva,imposte,scadenza,costiGenerali,codiceMandato,cig,pod,primo,secondo,terzo,quarto);
    }


}



