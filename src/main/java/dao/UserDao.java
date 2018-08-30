package dao;

import model.User;

public interface UserDao {

    public boolean create(User user);
    public User read(String pesel);
    public boolean update(User user);
    public boolean delete (User user);

}
