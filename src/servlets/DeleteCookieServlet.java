package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/delete-cookie")
public class DeleteCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Cookie [] cookies = req.getCookies();

        for(Cookie c:cookies){
            c.setMaxAge(0);
            resp.addCookie(c);
        }
        resp.sendRedirect("/index.jsp");
    }
}