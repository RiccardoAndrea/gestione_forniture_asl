package progetto.progetto_asl;

// Classe che implementa l'interfaccia InterfacciaAutorizzazioneStrategy
// per gestire le autorizzazioni degli amministratori
class AdminAutorizzazioneStrategy implements InterfacciaAutorizzazioneStrategy {

    // Implementazione del metodo checkPermission dell'interfaccia
    // che verifica se l'utente passato come parametro è un amministratore e ha i privilegi per eseguire l'azione specifica
    @Override
    public boolean checkPermission(Dipendente user, String permission) {
        // controlla se l'input "permission" è uguale a "2"
        if(permission.equals("2")){

            System.out.println("ho stampato admin");
            return true;

        }
        // Restituisce false se non soddisfa la condizione
        return false;
    }
}
