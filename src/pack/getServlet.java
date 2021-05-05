package pack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "getServlet",urlPatterns = "/login")
public class getServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String passWord = request.getParameter("passWord");
        try{
            //判断登陆是否成功，不成功则弹出失败页面
            if(Login.login(name,passWord))
            {
                response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
                request.getRequestDispatcher("/index.html").forward(request, response);

            }
            else
            {
                request.setAttribute("errMessage", "登录失败！");
                request.getRequestDispatcher("/LoginError.jsp").forward(request, response);
            }
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        System.out.println(name+passWord);

    }
}
