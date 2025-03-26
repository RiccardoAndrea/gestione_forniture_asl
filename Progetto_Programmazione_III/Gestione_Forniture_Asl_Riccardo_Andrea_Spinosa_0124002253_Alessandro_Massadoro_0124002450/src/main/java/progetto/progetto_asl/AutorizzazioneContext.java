package progetto.progetto_asl;
/* AutorizzazioneContext E' UNA CLASSE CHE SERVE AD UTILIZZARE LA STRATEGIA DI AUTORIZZAZIONE,
LA SUA FUNZIONE PRINCIPALE E' QUELLA DI INCAPSULARE LA LOGIXA DI INCAPSULARE LA LOGIXA DI AUTORIZZAZIONE
E DI FORNIRE UN PUNTO UNICO PER CONTROLLARE I PRIVILEGI DEGLI UTENTI. IN GENERALE LA CLASSE MANTIENE UN
RIFERIMENTO ALLA STRATEGIA DI AUTORIZZAZIONE CORRENTE CHE PUO' ESSERE IMPOSTATA IN BASE ALLE ESIGENZE DEL
SISTEMA.
 */
class AutorizzazioneContext {
    // variabile per contenere la strategia di autorizzazione corrente
    private InterfacciaAutorizzazioneStrategy strategy;

    // metodo per impostare la strategia di autorizzazione
    public void setStrategy(InterfacciaAutorizzazioneStrategy strategy) {
        this.strategy = strategy;
    }

    // metodo per verificare le autorizzazioni dell'utente
    // delega la verifica alla strategia di autorizzazione corrente
    public boolean checkPermission(Dipendente user, String permission) {
        return strategy.checkPermission(user, permission);
    }
}