package progetto.progetto_asl;
//I METODI SET GENERALMENTE NON LI TROVEREMO IN QUANTO CON IL PATTERN DAO LE MODIFICHE LE EFFETTUIAMO DIRETTAMENTE NEL DATABASE
// questa classe gestisce i mandati
public class Mandato {
    //codice del mandato
    private final String codiceMandato ;
    //numero atto
    private final String numeroAtto;
    //data in cui è stato recapitato
    private final String dataRecapito;

    //email del dipendente che l'ha inserito nel db, verrà sempre ottenuta dal dipendente che ha effettuato il login
    private final String email;
   //costruttore
    public Mandato(String codiceMandato, String numeroAtto, String dataRecapito, String email) {
        this.codiceMandato = codiceMandato;
        this.numeroAtto = numeroAtto;
        this.dataRecapito = dataRecapito;
        this.email = email;
    }

   //get del codice mandato
    public String getCodiceMandato(){
      return codiceMandato;
    }

    //get del numero atto
    public String getNumeroAtto(){
        return numeroAtto;
    }

    //get della data recapito
    public String getDataRecapito(){
        return dataRecapito;
    }

    //get dell'email
    public String getEmail(){
        return email;
    }

}
