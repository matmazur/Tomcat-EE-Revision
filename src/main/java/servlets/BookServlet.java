package servlets;

import dao.BookDao;
import dao.DaoFactory;
import dao.MysqlBookDao;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/book-servlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String isbn = req.getParameter("isbn");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String option = req.getParameter("option");
        BookDao dao = DaoFactory.getDaoFactory(DaoFactory.MYSQL_DAO).getBookDAO();
        Book book = null;
        String operation = null;
        boolean result = false;

        if ("show-all".equals(option)) {
            List<String> list = dao.showAll().stream().map(Book::getTitle).collect(Collectors.toList());
            if (list != null && !list.isEmpty()) {
                req.setAttribute("list", list);
                req.getRequestDispatcher("book-list.jsp").forward(req, resp);
            }
        } else if ("search".equals(option)) {
            book = dao.read(isbn);
            result = book != null;
            operation = "search";
        } else if ("add".equals(option)) {
            book = new Book(isbn, title, description);
            result = dao.create(book);
            operation = "add";
        } else if ("update".equals(option)) {
            book = new Book(isbn, title, description);
            result = dao.update(book);
            operation = "update";
        } else if ("delete".equals(option)) {
            book = new Book(isbn, title, description);
            result = dao.delete(book);
            operation = "delete";
        }


       ForwardIfBookIsValidAndResultIsTrue(req, resp, book, operation, result);

    }

    private void ForwardIfBookIsValidAndResultIsTrue(HttpServletRequest req, HttpServletResponse resp, Book book, String operation, boolean result) throws ServletException, IOException {
        if (book != null && result) {
            req.setAttribute("option", operation);
            req.setAttribute("book", book);
            req.getRequestDispatcher("result.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}