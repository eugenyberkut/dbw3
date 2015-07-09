/**
 * Created by Yevhen on 09.07.2015.
 */
import java.sql.*;
import java.util.Properties;

public class Main {

    String login = "root";
    String passw = "nbuser";

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", login);
            properties.setProperty("password", passw);
            properties.setProperty("characterEncoding","utf8");
            properties.setProperty("useUnicode", "true");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lesson", properties);
            Statement query = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = query.executeQuery("SELECT * FROM person");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                int zp = resultSet.getInt("zp");
                System.out.println(id + " " + firstname + " " + lastname + " " + zp);
            }
            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println(metaData.getColumnLabel(1));
            System.out.println(metaData.getColumnLabel(2));
            System.out.println(metaData.getColumnLabel(3));
            System.out.println(metaData.getColumnLabel(4));

            DatabaseMetaData metaData1 = connection.getMetaData();
            System.out.println(metaData1.getSQLKeywords());
//            PreparedStatement query2 = connection.prepareStatement("INSERT INTO person (firstname, lastname, zp) VALUES (? , ? , ?)");
//            query2.setString(1, "Sergey");
//            query2.setString(2, "Sidorov");
//            query2.setInt(3, 2323);
//            query2.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error");
        }
    }
}
