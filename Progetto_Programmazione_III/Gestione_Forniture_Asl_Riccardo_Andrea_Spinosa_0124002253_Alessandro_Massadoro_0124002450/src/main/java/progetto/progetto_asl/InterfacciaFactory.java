package progetto.progetto_asl;
// QUESTA INTERFACCIA RICHIAMA I METODI COMUNI ALL'INTERNO DELLE BOLLETTE
// e la utilizziamo in quanto utilizziamo il Pattern factory per gestire la creazione
//delle bollette
public interface InterfacciaFactory
{

    //metodo per inserire i dati all'interno della bolletta
    public void inserisciDati();// INSERIMENTO DENTRO DATABASE


    //metodo che mostra tutti i dati presenti nella bolletta
    public void stampaDettagli();

}
