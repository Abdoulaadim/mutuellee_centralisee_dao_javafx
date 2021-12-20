package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import connection.DbConnection;
import dao.UserDao;
import model.User;

public class UserDaoImpl extends UserDao {
	
	

	@Override
	public int inscription(User user) {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		try {
			PreparedStatement preparedStatement =connection.prepareStatement("INSERT INTO user (firstname,lastname,email,password) VALUES (?,?,?,?);");
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			
			 int resultSet = preparedStatement.executeUpdate();
	         return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public boolean connection(User user) {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		try {
			PreparedStatement preparedStatement =connection.prepareStatement("select * from user where email = ?;");
			preparedStatement.setString(1, user.getEmail());
			ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            	if(BCrypt.checkpw(user.getPassword(), resultSet.getString(5))) {
            		return true;
            	} else {
            		return false;
            	}
            } else {
            	return false;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
