package progetto.progetto_asl;

//interfaccia dovuta al pattern Strategy
public interface InterfacciaAutorizzazioneStrategy {
    //IL METODO CI CONSENTE DI EFFETTUARE IL LOGIN DI UN UTENTE REGULAR O
    // ADMIN E DI FAR VISUALIZZARE DETERMINATE FUNZIONALITA' A SECONDA DEI
    // LORO PRIVILEGI
    boolean checkPermission(Dipendente user, String permission);
}
