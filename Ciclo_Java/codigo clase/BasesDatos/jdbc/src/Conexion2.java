import java.sql.*;

public class Conexion2 {
    public static void main(String[] args) {
        String host = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "campus2023";
        String db = "world";
        String cadConex = host + db;

        String sql = "SELECT id as code, name FROM city limit 10";

        try (Connection c = DriverManager.getConnection(cadConex, user, password);
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while(rs.next()) {
                System.out.print(rs.getString(1));
                System.out.println("\t" + rs.getString("name"));
            }


            System.out.println("Se conectó con éxito");

        } catch (SQLException ex) {
            System.err.println("Error al realizar la conexion a la BD.\n" + ex.getMessage());
        }
    }
}
