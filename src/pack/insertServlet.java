package pack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "insertServlet",urlPatterns = "/insert")
public class insertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String passWord = request.getParameter("passWord");
        try{
            //判断是否已有相同用户名
            if(!insert.insert(name)){
                request.setAttribute("errMessage", "该用户名已存在！");
                request.getRequestDispatcher("/regerror.jsp").forward(request, response);
            }
            else
            {
                //没有相同记录。插入用户数据
                insert2.insert2(name,passWord);
                request.setAttribute("errMessage", "注册成功");
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            }
        }

        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }


    }
}
