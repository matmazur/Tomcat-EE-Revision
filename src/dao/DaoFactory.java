package dao;

public abstract class DaoFactory {

    public static final int MYSQL_DAO = 1;

    public abstract BookDao getBookDAO();

    public abstract UserDao getUserDAO();


    private static DaoFactory instance;


    public static DaoFactory getDaoFactory(int factoryType){
        if (instance==null){

            if (factoryType==MYSQL_DAO){
                instance= new MysqlDAOFactory();

            }

        }
        return instance;
    }

}
