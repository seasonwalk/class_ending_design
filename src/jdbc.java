import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
    public static void main(String [] args) throws SQLException,ClassNotFoundException {
//        Driver driver = new com.mysql.jdbc.Driver();
//        DriverManager.registerDriver(driver);
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/web db";
        Connection connection = DriverManager.getConnection(url,"root","root");
        connection.close();


    }
}
