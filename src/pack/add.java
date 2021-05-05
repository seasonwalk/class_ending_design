package pack;

import java.sql.*;

public class add{
    //用来添加用户联系方式的java类
    public static void add(String id, String phone, String like) throws ClassNotFoundException, SQLException {
        //数据库的连接
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/webdb?serverTimezone=UTC&charset=utf8";
        Connection connection = DriverManager.getConnection(url,"root","root");

        String sql = "insert into idinfo values(?,?,? )";
        //创建一个绑定sql语句的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //123分别对应三个问号，防止sql注入
        preparedStatement.setString(1,id);
        preparedStatement.setString(2,phone);
        preparedStatement.setString(3,like);
        //执行操作
        boolean resultSet = preparedStatement.execute();
        //控制台判断是否插入成功，false为成功
        System.out.println(resultSet);
        connection.close();
    }

}
