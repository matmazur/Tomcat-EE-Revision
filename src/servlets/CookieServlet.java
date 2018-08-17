package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;


@WebServlet("/cookie-servlet")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        switch (req.getParameter("value")) {
            case "create":
                createCookie(resp);
                break;
            case "delete":
                deleteCookies(req, resp);
                break;
            case "read":
                readCookies(req, resp);
                break;
            default:
                resp.sendRedirect("/");
                break;
        }
    }

    private void createCookie(HttpServletResponse resp) throws IOException {
        String cookieName = "cookieID" + new Random().nextInt(1000) + 1;
        String value = "cookieVALUE" + new Random().nextInt(1000) + 1;

        Cookie cookie = new Cookie(cookieName, value);

        cookie.setMaxAge(60);
        resp.addCookie(cookie);
        resp.sendRedirect("index.jsp");
    }

    private void deleteCookies(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();

        for (Cookie c : cookies) {
            c.setMaxAge(0);
            resp.addCookie(c);
        }
        resp.sendRedirect("/index.jsp");
    }


    private void readCookies(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                resp.getWriter().println(c.getName() + " " + c.getValue());
            }
            ;


        } else {
            resp.getWriter().println("No cookies found");
        }
    }


}
