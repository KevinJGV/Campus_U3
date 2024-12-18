import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static void main(String[] args) {
        // protocol//[hosts][/database][?properties]
        // Ejemplo jdbc:mysql://host1:33060/sakila

        String host = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "campus2023";
        String db = "world";
        String cadConex = host + db;

        Connection c = null;
        try {
            DriverManager.getConnection(cadConex, user, password);

            System.out.println("Se conectó con éxito");

        } catch (SQLException ex) {
            System.err.println("Error al realizar la conexion a la BD.\n" + ex.getMessage());
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion a la BD\n" + ex.getMessage());
            }


        }
    }
}
