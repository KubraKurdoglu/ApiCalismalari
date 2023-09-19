package requesss;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Veritabanı bağlantısını kurma
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");

            // SQL komutlarını çalıştırma
            Statement statement = connection.createStatement();

            // Tablo oluşturma
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT, email TEXT)";
            statement.executeUpdate(createTableSQL);

            // Veri ekleme
            String insertDataSQL = "INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com')";
            statement.executeUpdate(insertDataSQL);

            // Verileri sorgulama
            String query = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(query);

            // Sonuçları işleme
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

            // Bağlantıyı kapatma
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
