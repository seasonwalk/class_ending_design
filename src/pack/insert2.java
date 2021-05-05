package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert2 {
    public static void insert2(String name,String passWord) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/webdb?serverTimezone=UTC&charset=utf8";
        Connection connection = DriverManager.getConnection(url,"root","root");
        String sql = "insert into iddb values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,passWord);
        boolean resultSet = preparedStatement.execute();
        System.out.println(resultSet);
        connection.close();
    }

}
