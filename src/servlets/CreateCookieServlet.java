package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;


@WebServlet("/create-cookie")
public class CreateCookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String cookieName = "id = " + new Random().nextInt(1000) + 1;
        String value = "value = " + new Random().nextInt(1000) + 1;

        Cookie cookie = new Cookie(cookieName, value);

        cookie.setMaxAge(60);
    }


}
