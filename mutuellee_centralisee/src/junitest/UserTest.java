package junitest;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.UserDao;
import factory.UserDaoFactory;
import model.User;

public class UserTest {

	@Test
	public void testLogin() {
		User user=new User("imane@gmail.com", "123456");
    	UserDao userDAO=UserDaoFactory.getUserDAO("jdbc");
    	boolean log= userDAO.connection(user);
    	assertEquals(true, log);
	}

}
