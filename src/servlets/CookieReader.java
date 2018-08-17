package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/read-cookies")
public class CookieReader extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        if(cookies!=null){
        for(Cookie c:cookies){
           resp.getWriter().println(c.getName() +" "+ c.getValue());
        };


    }else {
            resp.getWriter().println("No cookies found");

        }


    }
}
