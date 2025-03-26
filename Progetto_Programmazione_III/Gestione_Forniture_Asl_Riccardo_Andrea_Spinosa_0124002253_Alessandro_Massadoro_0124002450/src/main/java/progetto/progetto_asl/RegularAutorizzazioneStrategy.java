package progetto.progetto_asl;

//la classe implementa la strategy di autorizzazione per un dipendente con accesso "regolari"
//cioè può connettersi al database ma non ha accesso alle funzioni admin

class RegularAutorizzazioneStrategy implements InterfacciaAutorizzazioneStrategy{
    //CONTROLLO PRIVILEGIO
    @Override
    public boolean checkPermission(Dipendente user, String permission) {
        if(permission.equals("1"))
            return true;
        return false;
    }
}
