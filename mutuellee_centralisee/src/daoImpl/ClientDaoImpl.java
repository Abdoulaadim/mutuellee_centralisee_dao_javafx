package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import connection.DbConnection;
import dao.ClientDao;
import model.ChartClient;
import model.Client;
import model.User;

public class ClientDaoImpl extends ClientDao {

	@Override
	public List<Client> afficher() {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		try {
			PreparedStatement preparedStatement =connection.prepareStatement("select * from client");
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Client> clients = new ArrayList<Client>();
            while (resultSet.next()) {
				clients.add(new Client(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11)));
			}
            return clients;
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public int ajouter(Client client) {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		
		try {
			PreparedStatement preparedStatement =connection.prepareStatement("INSERT INTO client (nbadge,nom_entreprise,date_debut,prenom,nom,cin,passport,telephone,email,adresse) VALUES (?,?,?,?,?,?,?,?,?,?);");
			preparedStatement.setString(1, client.getNbadge());
			preparedStatement.setString(2, client.getNom_entreprise());
			preparedStatement.setDate(3, new java.sql.Date(client.getDate_debut().getTime()));
			preparedStatement.setString(4, client.getPrenom());
			preparedStatement.setString(5, client.getNom());
			preparedStatement.setString(6, client.getCin());
			preparedStatement.setString(7, client.getPassport());
			preparedStatement.setString(8, client.getTelephone());
			preparedStatement.setString(9, client.getEmail());
			preparedStatement.setString(10, client.getAdresse());
			
			 int resultSet = preparedStatement.executeUpdate();
	         return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Client> rechercher(String filter, String check) {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		try {
			PreparedStatement preparedStatement;
			if (!check.equals("all")) {
				//System.out.println(check +"    " + "%"+filter+"%");
				if (check.equals("nom_entreprise")) {
					preparedStatement =connection.prepareStatement("select * from client where nom_entreprise LIKE ?;");
				} else if (check.equals("cin")) {
					preparedStatement =connection.prepareStatement("select * from client where cin LIKE ?;");
				} else if (check.equals("nom")) {
					preparedStatement =connection.prepareStatement("select * from client where nom LIKE ?;");
				} else if (check.equals("prenom")) {
					preparedStatement =connection.prepareStatement("select * from client where prenom LIKE ?;");
				} else {
					preparedStatement =connection.prepareStatement("select * from client where email LIKE ?;");
				}
				preparedStatement.setString(1, "%"+filter+"%");
			} else {
				preparedStatement =connection.prepareStatement("select * from client where nom_entreprise like ? or cin like ? or nom like ? or prenom like ? or email like ? or nbadge like ? or date_debut like ?;"); 
				preparedStatement.setString(1, '%'+filter+'%');
				preparedStatement.setString(2, '%'+filter+'%');
				preparedStatement.setString(3, '%'+filter+'%');
				preparedStatement.setString(4, '%'+filter+'%');
				preparedStatement.setString(5, '%'+filter+'%');
				preparedStatement.setString(6, '%'+filter+'%');
				preparedStatement.setString(7, '%'+filter+'%');
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Client> clients = new ArrayList<Client>();
            while (resultSet.next()) {
				clients.add(new Client(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11)));
			}
            return clients;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ChartClient> listChart() {
		DbConnection dbConnection = new DbConnection();
		Connection connection = dbConnection.getConnection();
		try {
			PreparedStatement preparedStatement =connection.prepareStatement("SELECT count(*), date_debut FROM client group by date_debut;");
			ResultSet resultSet = preparedStatement.executeQuery();
			List<ChartClient> chartClients = new ArrayList<ChartClient>();
            while (resultSet.next()) {
            	chartClients.add(new ChartClient(resultSet.getDate(2), resultSet.getInt(1)));
			}
            return chartClients;
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
