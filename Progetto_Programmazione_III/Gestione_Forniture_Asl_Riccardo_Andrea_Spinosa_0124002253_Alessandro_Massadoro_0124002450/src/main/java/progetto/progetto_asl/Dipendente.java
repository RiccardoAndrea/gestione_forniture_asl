package progetto.progetto_asl;

// Questa classe rappresenta un dipendente dell'azienda
// Ha i seguenti attributi: email aziendale, nome, cognome, privilegi e password
public class Dipendente {
    private final String emailAziendale;
    private final String nome;
    private final String cognome;
    private int privilego;
    private final String password;// PASSWORD SI UTILIZZA QUANDO LOGGA IL DIPENDENTE,


      //I METODI SET GENERALMENTE NON LI TROVEREMO IN QUANTO CON IL PATTERN DAO LE MODIFICHE
     // LE EFFETTUIAMO DIRETTAMENTE NEL DATABASE
    //IL PRIMO COSTRUTTORE LO RICHIAMIAMO QUANDO INSERIAMO UN DIPENDENTE NEL DATABASE
    // mentre il secondop lo utilizziamo quando il dipendente effettua il login all'intenro del nostro sistema


    public Dipendente(String emailAziendale, String nome, String cognome, int privilego) {
        this.emailAziendale = emailAziendale;
        this.nome = nome;
        this.cognome = cognome;
        this.privilego = privilego;
        this.password = null;
    }
    // QUESTO COSTRUTTORE VA RICHIAMATO QUANDO ESEGUIAMO IL LOGIN
    public Dipendente(String emailAziendale, String password){
        this.emailAziendale=emailAziendale;
        this.nome = null;
        this.cognome = null;
        this.password=password;
        this.privilego=0;
    }
    //Ha i seguenti metodi get: getNome, getCognome, getEmailAziendale, getPrivilego e getPassword,
    // che restituiscono i valori degli attributi corrispondenti.
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public String getEmailAziendale(){
        return emailAziendale;
    }
    public int getPrivilego(){
        return privilego;
    }
    public String getPassword(){
        return password;
    }

    public void setPrivilego(int privilego) {
        this.privilego = privilego;
    }
}
