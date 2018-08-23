package dao;

public class MysqlDAOFactory extends DaoFactory {


    @Override
    public BookDao getBookDAO() {
        return new MysqlBookDao();
    }

    @Override
    public UserDao getUserDAO() {
        return new MysqlUserDao();
    }
}
