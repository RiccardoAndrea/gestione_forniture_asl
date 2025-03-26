// UTILIZZIAMO IL PATTERN DAO PER ISOLARE LOGICAMENTE TUTTELE OPERAZIONI DEL DATABASE.

package progetto.progetto_asl;
import java.sql.*;

public abstract class ConnessioneDao {
    private Connection conn;

     {
        try {
            // Carica il driver JDBC per Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Crea la connessione al database
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##tecnico_dipendente", "tecnico");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    // metodo getter per ottenere l'oggetto Connection
    public Connection getConn() {
        return conn;
    }

    // metodo per chiudere la connessione
    public void chiudiConnessione() throws SQLException {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


