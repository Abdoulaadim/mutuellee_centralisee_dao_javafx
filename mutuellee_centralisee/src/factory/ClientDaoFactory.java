package factory;

import dao.ClientDao;
import daoImpl.ClientDaoImpl;

public class ClientDaoFactory {
	public static ClientDao getClientDAO(String type) { 
        if (type.equalsIgnoreCase("jdbc")) {
            return new ClientDaoImpl();
        } else {
            return new ClientDaoImpl();
        }
    }
}
