package progetto.progetto_asl;
// questa classe non implementa nient'altro che la strategy di un utente che non potrà più accedere al database
// di fatti SE L'UTENTE E' STATO LICENZIATO OPPURE E' ANDATO IN PENSIONE NON AVRA' PIU' GLI ACCESSI, ma teniamo
//comunque traccia della sua esistenza ed operazioni passate nel database

class LicenziatoAutorizzazioneStrategy implements InterfacciaAutorizzazioneStrategy{
    @Override
    //riceve il dipendente e controlla la stringa di operazione, in questo caso permesso
    //se il permesso è 0 allora l'utente è licenziato e non può accedere
    public boolean checkPermission(Dipendente user, String permission) {
        if(permission.equals("0"))
            return true;
        return false;
    }
}
