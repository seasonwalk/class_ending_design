package pack;

import java.sql.*;

public class insert {
    public static boolean insert(String name) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/webdb?serverTimezone=UTC&charset=utf8";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        String sql = "select* from iddb WHERE user_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        //判断数据库中是否有指定记录
        if (resultSet.next()) {
            connection.close();
            return false;
        } else {
            connection.close();
            return true;
        }

    }
}
