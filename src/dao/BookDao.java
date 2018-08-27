package dao;

import model.Book;

import java.util.List;

public interface BookDao {


    public boolean create(Book book);
    public Book read(String isbn);
    public boolean update(Book book);
    public boolean delete (Book book);
    public List<Book> showAll();


}
