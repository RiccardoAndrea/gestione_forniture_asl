package progetto.progetto_asl;

import javafx.collections.ObservableList;

import java.sql.*;


//la classe dipendente dao implementa l'interfaccia dao per eseguire i metodi CRUD
//inoltre eredita le operazioni di chiusura ed apertura di connessione da ConnessioneDao

public class DipendenteDao extends ConnessioneDao implements InterfacciaDao<Dipendente>{


    //il metodo ci permette di ritornare a schermo tutti i dipendenti presenti nel database
    @Override
    public ObservableList getAllObj() {

        return null;
    }

    @Override
    public  Dipendente getTByKey(Dipendente x) {
        try{
            System.out.println("SONO DENTRO DIPENDENTE DAO");
            // crea un oggeto per poter eseguire la query
            //PER MOTIVI DI SICUREZZA CONVIENE UTILIZZARE STATMENT PER PREVENIRE ATTACCHI SQL IJECTION
            PreparedStatement stmt = getConn().prepareStatement("SELECT * FROM DIPENDENTE WHERE EMAIL_AZIENDALE = ? AND CHIAVE_ACCESSO = ? ");
            System.out.println(getConn().isClosed());
            stmt.setString(1,x.getEmailAziendale());
            stmt.setString(2,x.getPassword());
            // Esegue la query
            ResultSet rs = stmt.executeQuery();
            System.out.println("HO ESEGUITO LA QUERY");

            // Lavora con i dati restituiti dalla query
            while (rs.next()) {
                System.out.println("sono dentro il while");
                String Email = rs.getString("EMAIL_AZIENDALE");
                String nome = rs.getString("NOME");
                String cognome = rs.getString("COGNOME");
                x.setPrivilego(rs.getInt("PRIVILEGIO"));
                int privilegio=x.getPrivilego();
                System.out.println("Email: " + Email + " Nome: " + nome + "Cognome: " + cognome + "Privilegio: " + privilegio );
            }
            System.out.println("HO FINITO");
            chiudiConnessione();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    //il metodo esegue la ricerca di un dipendente tramite key e ritorna l'eventuale dipendente trovato





    //metodo di salvataggio dei dati all'interno del database, il dipendente inserito
    //viene salvato all'interno del database
    @Override
    public void save(Dipendente x) {
        try{
            System.out.println("SONO DENTRO DIPENDENTE DAO");
            String call= "{call ?:=FUNZIONE_DI_HASHING(?,?,?,?)}";
            CallableStatement pstmt = getConn().prepareCall(call);
            pstmt.registerOutParameter(1, Types.VARCHAR);
            pstmt.setInt(2,3);
            pstmt.setInt(3,3);
            pstmt.setInt(4,4);
            pstmt.setInt(5,4);
            pstmt.executeUpdate();
            System.out.println("HO SUPERATO LA CHIAMATA DI FUNZIONE");
            System.out.println("SONO ANCORA IN GARA");
            String pw = pstmt.getString(1);
            System.out.println(pw);
            //query
            String query = "INSERT INTO DIPENDENTE (EMAIL_AZIENDALE,NOME,COGNOME,PRIVILEGIO,CHIAVE_ACCESSO) VALUES (?,?,?,?,?)";
            // apriamo la connessione e crea un oggeto per poter eseguire la query
            PreparedStatement stmt = getConn().prepareStatement(query);
            // chiudiamo la funzione dopo aver richiamato la procedura contenente la funzione che genera una password forte di 16 cifre sicura
            System.out.println(getConn().isClosed());
            System.out.println("HO ESEGUITO LA QUERY");
            stmt.setString(1,x.getEmailAziendale());
            stmt.setString(2,x.getNome());
            stmt.setString(3,x.getCognome());
            stmt.setString(4,Integer.toString(x.getPrivilego()));
            stmt.setString(5,pw);
            //Esegue la query
            int rowsAffected = stmt.executeUpdate();
            System.out.println("HO FINITO");
            chiudiConnessione();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    // L'ELIMINAZIONE è SOLO LOGICA SETTIAMO IL PRIVILEGIO A 0 IN MODO CHE NON POSSA IU ENTRARE
    //questo è il metodo di cancellazione di  un dipendente
    //dopo che il privileggio viene settato a 0 non si hanno più i permessi per entrare
    public void delete(Dipendente x) {
            try{
                String query = "UPDATE DIPENDENTE SET PRIVILEGIO = 0 WHERE EMAIL = ?";
                System.out.println("SONO DENTRO DIPENDENTE DAO");
                // crea un oggeto per poter eseguire la query
                PreparedStatement stmt = getConn().prepareStatement(query);
                System.out.println(getConn().isClosed());
                System.out.println("HO ESEGUITO LA QUERY");
                stmt.setString(1,x.getEmailAziendale());
                //Esegue la query
                int rowsAffected = stmt.executeUpdate();
                System.out.println("HO FINITO");
                chiudiConnessione();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }



        }



}


