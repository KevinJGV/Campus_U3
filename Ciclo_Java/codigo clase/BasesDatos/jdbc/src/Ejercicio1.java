import java.sql.*;
import java.util.Scanner;

public class Ejercicio1 {
    private static void ejecutar(String pais) {
        String host = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "campus2023";
        String db = "world";
        String cadConex = host + db;

        String sql = "SELECT C.name FROM country P JOIN city C ON P.code = C.countrycode where P.name = ? order by C.Name";

        try (Connection c = DriverManager.getConnection(cadConex, user, password);
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, pais);

            ResultSet rs = ps.executeQuery();
            System.out.println("Listados de ciudades del país: " + pais);
            while(rs.next()) {
                System.out.println(rs.getString(1));
            }


            System.out.println("Se conectó con éxito");

        } catch (SQLException ex) {
            System.err.println("Error al realizar la conexion a la BD.\n" + ex.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Pais a listar ciudades: ");
        String pais = sc.nextLine();

        ejecutar(pais);

        sc.close();
    }
}
