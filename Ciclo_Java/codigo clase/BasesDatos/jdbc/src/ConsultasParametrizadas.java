import java.sql.*;

public class ConsultasParametrizadas {
    public static void main(String[] args) {
        String host = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "campus2023";
        String db = "world";
        String cadConex = host + db;

        String sql = "SELECT code, name FROM country where name = ? limit 10";

        try (Connection c = DriverManager.getConnection(cadConex, user, password);
             PreparedStatement stmt = c.prepareStatement(sql)) {

            stmt.setString(1, "Argentina");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.print(rs.getString(1));
                System.out.println("\t" + rs.getString("name"));
            }


            System.out.println("Se conectó con éxito");

        } catch (SQLException ex) {
            System.err.println("Error al realizar la conexion a la BD.\n" + ex.getMessage());
        }
    }
}
