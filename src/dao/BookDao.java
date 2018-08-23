package dao;

import model.Book;

public interface BookDao {


    public boolean create(Book book);
    public Book read(String isbn);
    public boolean update(Book book);
    public boolean delete (Book book);


}
