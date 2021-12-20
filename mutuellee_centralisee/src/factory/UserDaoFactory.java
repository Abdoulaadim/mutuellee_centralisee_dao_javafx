package factory;

import dao.UserDao;
import daoImpl.UserDaoImpl;

public class UserDaoFactory {
	public static UserDao getUserDAO(String type) { 
        if (type.equalsIgnoreCase("jdbc")) {
            return new UserDaoImpl();
        } else {
            return new UserDaoImpl();
        }
    }
}
