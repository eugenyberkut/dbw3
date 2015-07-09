/**
 * Created by Yevhen on 09.07.2015.
 */
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lesson", "root", "nbuser");
            Statement query = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = query.executeQuery("SELECT * FROM person");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                int zp = resultSet.getInt("zp");
                System.out.println(id + " " + firstname + " " + lastname + " " + zp);
            }
        } catch (SQLException ex) {
            System.err.println("Error");
        }
    }
}
