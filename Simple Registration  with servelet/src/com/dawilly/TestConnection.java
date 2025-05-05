import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/dawilly";
        String user = "dawilly";
        String password = "babalaolau";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}