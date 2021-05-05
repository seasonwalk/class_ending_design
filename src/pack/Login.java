package pack;

import java.math.BigDecimal;
import java.sql.*;

public class Login {
    public static boolean login(String account,String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/webdb?serverTimezone=UTC&charset=utf8";
        Connection connection = DriverManager.getConnection(url,"root","root");
        String sql = "select* from iddb WHERE user_id=? AND password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,account);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean flag=false;
        if (resultSet.next()){
            String name = resultSet.getString("user_id");
            System.out.println(name+" Login success");
            flag=true;
        }
        else
        {
            System.out.println("Login failed");
        }
        preparedStatement.close();
        resultSet.close();
        connection.close();
        return flag;
    }
}
