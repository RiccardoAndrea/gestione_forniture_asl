package progetto.progetto_asl;

public class VistaLuce {
        private String centroCosto;
        private String dataEmissione;
        private String numeroFattura;
        private String costo;
        private String energiaAttiva;
        private String energiaReattiva;
        private String potenzaPrelevata;
        private String serviziDiVendita;
        private String serviziDiRete;
        private String imposte;
        private String iva;
        private String codicePod;

    public VistaLuce(String centroCosto, String dataEmissione, String numeroFattura, String costo, String energiaAttiva, String energiaReattiva, String potenzaPrelevata, String serviziDiVendita, String serviziDiRete, String imposte, String iva, String codicePod) {
        this.centroCosto = centroCosto;
        this.dataEmissione = dataEmissione;
        this.numeroFattura = numeroFattura;
        this.costo = costo;
        this.energiaAttiva = energiaAttiva;
        this.energiaReattiva = energiaReattiva;
        this.potenzaPrelevata = potenzaPrelevata;
        this.serviziDiVendita = serviziDiVendita;
        this.serviziDiRete = serviziDiRete;
        this.imposte = imposte;
        this.iva = iva;
        this.codicePod = codicePod;
    }
    public String getCentroCosto (){
        return centroCosto;
    }
    public String getDataEmissione(){
        return dataEmissione;
    }

    public String getNumeroFattura(){
        return numeroFattura;
    }

    public String getCosto(){
        return costo;
    }
    public String getEnergiaAttiva (){
        return energiaAttiva;
    }
    public String getEnergiaReattiva (){
        return energiaReattiva;
    }
    public String getPotenzaPrelevata(){
        return potenzaPrelevata;
    }
    public String getServiziDiVendita(){
        return serviziDiVendita;
    }
    public String getServiziDiRete(){
        return serviziDiRete;
    }
    public String getImposte (){
        return imposte;
    }
    public String getIva (){
        return iva;
    }
    public String getCodicePod(){
        return codicePod;
    }





        //getters and setters

}
