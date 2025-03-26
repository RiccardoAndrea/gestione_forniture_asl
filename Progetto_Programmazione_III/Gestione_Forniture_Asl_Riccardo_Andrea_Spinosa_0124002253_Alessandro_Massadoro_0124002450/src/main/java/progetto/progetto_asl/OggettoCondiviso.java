package progetto.progetto_asl;
// SIGNLETON QUESTO PATTERN SI NECESSITA PER IL PASSAGGIO DI UN OGGETTO
public class OggettoCondiviso {
    private static Dipendente sharedObject; //oggetto condiviso tra le classi
    private static Contratto oggettoContratto; //oggetto condiviso per il contratto

    private OggettoCondiviso() {}  // costruttore privato



    //metodo per impostare l'oggetto condiviso
    public static void setSharedObject(Dipendente obj)
    {
        sharedObject = obj;
    }

    //metodo per ottenere l'oggetto condiviso
    public static Dipendente getSharedObject()
    {
        return sharedObject;
    }

    //metodo per ottenere l'oggetto condiviso del contratto, utilizzato per instanziare il contratto
    //prototipe una sola volta
    public static Contratto getOggettoContratto()
    {
        return oggettoContratto;
    }

    //metodo per settare l'oggetto condiviso di contratto, utilizzato per instanziare il contratto
    //prototipe una sola volta

    public static void setOggettoContratto(Contratto obj)
    {
        oggettoContratto=obj;
    }
}





