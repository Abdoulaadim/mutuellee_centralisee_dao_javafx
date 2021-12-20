package dao;

import model.User;

public abstract class UserDao {
	public int inscription(User user) {
		return 0;
	};
	public boolean connection(User user) {
		return false;
	}
}
