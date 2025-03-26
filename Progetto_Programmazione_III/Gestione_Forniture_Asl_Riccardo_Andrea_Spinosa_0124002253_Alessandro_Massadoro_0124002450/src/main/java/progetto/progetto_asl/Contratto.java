package progetto.progetto_asl;

// LA CLASSE Contratto IMPLEMENTA IL PATTERN CLONEABLE E PROTOTYPE.
// GLI ATTRIBUTI DELLA CLASSE SONO VOLONTARIAMENTE NON FINAL IN QUANTO L'OGGETO CLONATO DEVE AVERE LA POSSIBILTA' DI ESSERE SOVRASCRITTO.
// I METODI SET E GET SONO UTILIZZATI PER MODIFICARE E RECUPERARE I VALORI DEGLI ATTRIBUTI DELLA CLASSE.
public class Contratto implements Cloneable, InterfacciaClonabePrototype{
    private String cig;
    private String centroCosto;
    private float potenzaContrattuale;
    private float depositoCauzionale;
    private String stato;
    private String adeguatezza;
    private String dataAdeguatezza;
    private String partitaIva;
    private String codicePod;
    private String condizioneMercato;
    private String tipoFornitura; //Media o Alta
    private String tipo;//acqua luce o gas
    private String protocolloAdeguatezza;

    public Contratto(String cig, String centroCosto, float potenzaContrattuale, float depositoCauzionale, String stato, String adeguatezza, String dataAdeguatezza, String partitaIva, String codicePod, String condizioneMercato, String tipoFornitura, String tipo, String protocolloAdeguatezza) {
        this.cig = cig;
        this.centroCosto = centroCosto;
        this.potenzaContrattuale = potenzaContrattuale;
        this.depositoCauzionale = depositoCauzionale;
        this.stato = stato;
        this.adeguatezza = adeguatezza;
        this.dataAdeguatezza = dataAdeguatezza;
        this.partitaIva = partitaIva;
        this.codicePod = codicePod;
        this.condizioneMercato = condizioneMercato;
        this.tipoFornitura = tipoFornitura;
        this.tipo = tipo;
        this.protocolloAdeguatezza = protocolloAdeguatezza;
    }
    //il metodo ci permette di ottenere il valore di cig
    public String getCig(){
        return cig;
    }
    //il metodo ci permette di ottenere il valore di cig
    public String getCentroCosto(){

        return centroCosto;
    }
    //il metodo ci permette di ottenere il valore di cig
    public float getPotenzaContrattuale(){

        return potenzaContrattuale;
    }
    //il metodo ci permette di ottenere il valore di cig
    public float getDepositoCauzionale (){

        return depositoCauzionale;
    }
    //il metodo ci permette di ottenere il valore di cig
    public String getStato(){
        return stato;
    }

    //il metodo ci permette di ottenere il valore di adeguatezza
    public String getAdeguatezza(){
        return adeguatezza;
    }


    //il metodo ci permette di ottenere il valore di data adeguatezza
    public String getDataAdeguatezza(){
        return dataAdeguatezza;
    }


    //il metodo ci permette di ottenere il valore di partita iva
    public String getPartitaIva(){
        return partitaIva;
    }

    //il metodo ci permette di ottenere il valore del codice pod
    public String getCodicePod(){
        return codicePod;
    }

    //il metodo ci permette di ottenere il valore della condizione di mercato
    public String getCondizioneMercato(){
        return condizioneMercato;
    }

    //il metodo ci permette di ottenere il valore del tipo di forniura
    public String getTipoFornitura(){
        return tipoFornitura;
    }

    //il metodo ci permette di ottenere il valore di tipo
    public String getTipo(){
        return tipo;
    }

    //il metodo ci permette di ottenere il valore del protocollo adeguatezza
    public String getProtocolloAdeguatezza(){
        return protocolloAdeguatezza;
    }

    // questo metodo permette di modificare il valore dell'attributo cig
    public void setCig(String x){
        this.cig=x;
    }
    // questo metodo permette di modificare il valore dell'attributo centroCosto
    public void setCentroCosto(String x){
        this.centroCosto=x;
    }
    // questo metodo permette di modificare il valore dell'attributo potenzaContrattuale
    public void setPotenzaContrattuale(float x){
        this.potenzaContrattuale=x;
    }
    // questo metodo permette di modificare il valore dell'attributo depositoCauzionale
    public void setDepositoCauzionale(float x){
        this.depositoCauzionale=x;
    }
    // questo metodo permette di modificare il valore dell'attributo stato
    public void setStato(String x){
        this.stato=x;
    }
    // questo metodo permette di modificare il valore dell'attributo adeguatezza
    public void setAdeguatezza (String x){
        this.adeguatezza=x;
    }
    // questo metodo permette di modificare il valore dell'attributo dataAdeguatezza
    public void setDataAdeguatezza(String x){
        this.dataAdeguatezza=x;
    }
    // questo metodo permette di modificare il valore dell'attributo partitaIva
    public void setPartitaIva(String x){
        this.partitaIva=x;
    }
    // questo metodo permette di modificare il valore dell'attributo codicePod
    public void setCodicePod(String x){
        this.codicePod=x;
    }
    // questo metodo permette di modificare il valore dell'attributo condizioneMercato
    public void setCondizioneMercato(String x){
        this.condizioneMercato=x;
    }
    // questo metodo permette di modificare il valore dell'attributo tipoFornitura
    public void setTipoFornitura(String x){
        this.tipoFornitura=x;
    }
    // questo metodo permette di modificare il valore dell'attributo tipo
    public void setTipo(String x){
        this.tipo=x;
    }
    // questo metodo permette di modificare il valore dell'attributo protocolloAdeguatezza
    public void setProtocolloAdeguatezza(String x){
        this.protocolloAdeguatezza=x;
    }



    public void controlloSet(String p1,String p2, float p3,float p4,String p5,String p6,String p7,String p8,String p9,String p10,String p11,String p12,String p13){
        System.out.println("sono dentro controlloSet");
        if(!this.cig.equals(p1))
            setCig(p1);
        System.out.println("cig ok");
        if(!this.centroCosto.equals(p2))
            setCig(p2);

        if(this.potenzaContrattuale!=p3)
            setPotenzaContrattuale(p3);

        if(this.depositoCauzionale!=p4)
            setDepositoCauzionale(p4);

        if(!this.stato.equals(p5))
            setStato(p5);
        if(!this.adeguatezza.equals(p6))
            setStato(p6);
        if(!this.dataAdeguatezza.equals(p7))
            setStato(p7);

        if(!this.partitaIva.equals(p8))
            setStato(p8);
        if(!this.codicePod.equals(p9))
            setStato(p9);
        if(!this.condizioneMercato.equals(p10))
            setStato(p10);
        if(!this.tipoFornitura.equals(p11))
            setStato(p11);
        if(!this.tipo.equals(p12))
            setStato(p12);
        if(!this.protocolloAdeguatezza.equals(p13))
            setStato(p13);
        System.out.println("controllosetfinito");

    }
    // questo metodo permette di clonare l'oggetto
    @Override
        public Contratto clone () throws CloneNotSupportedException {
        try {
            return (Contratto) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("ERRORE");
            e.printStackTrace();
            return null;
        }
    }
}
