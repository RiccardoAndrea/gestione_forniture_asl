package progetto.progetto_asl;

/*la classe rappresenta un fornitore e gestisce tutti i suoi campi*/
public class Fornitore {
    //numero partita iva
    private final String partitaIva;
    //numero telefono sede
    private final String telefonoSede;
    //numero telefono servizi clienti
    private final String telefonoServiziClienti;
    //indirizzo delle sede
    private final String indirizzoSede;
    //posta elettronica certificata
    private final String pec;
    //fax
    private final String fax;
    //nome del fornitore
    private final String nome;

    //costruttore
    public Fornitore(String partitaIva, String telefonoSede, String telefonoServiziClienti, String indirizzoSede, String pec, String fax, String nome) {
        this.partitaIva = partitaIva;
        this.telefonoSede = telefonoSede;
        this.telefonoServiziClienti = telefonoServiziClienti;
        this.indirizzoSede = indirizzoSede;
        this.pec = pec;
        this.fax = fax;
        this.nome = nome;
    }

    //metodo get per la partita iva
    public String getPartitaIva(){
        return partitaIva;
    }
    //metodo get per il numero di telefono
    public String getTelefonoSede(){
        return telefonoSede;
    }
    //metodo get per il telefono servizio clienti
    public String getTelefonoServiziClienti(){
        return telefonoServiziClienti;
    }
    //metodo get per l'indirizzo della sede
    public String getIndirizzoSede(){
        return indirizzoSede;
    }
    //metodo get per la pec
    public String getPec(){
        return pec;
    }

    //metodo get per il fax
    public String getFax(){
        return fax;
    }
    //metodo get per il nome fornitore
    public String getNome(){
        return nome;
    }
}
