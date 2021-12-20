package junitest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import dao.ClientDao;
import factory.ClientDaoFactory;
import model.ChartClient;
import model.Client;

public class ClientTest {

	@Test
	public void testAfficher() {
		ClientDao clientDAO=ClientDaoFactory.getClientDAO("jdbc");	
		List<Client> list = clientDAO.afficher();
		assertNotNull(list);
	}
	
	@Test
	public void testAjouter() {
		Client client = new Client("22", "youcode", new Date(), "brahimi", "mohamed", "sdfjs", null, "0633333", "brahimi@gmail.com", "01 skfdjhs sdfs");
		ClientDao clientDAO=ClientDaoFactory.getClientDAO("jdbc");	
		int i = clientDAO.ajouter(client);
		assertEquals(1, i);
	}
	
	@Test
	public void testRecherer() {
		ClientDao clientDAO=ClientDaoFactory.getClientDAO("jdbc");	
		List<Client> list = clientDAO.rechercher("you", "nom_entreprise");
		assertNotNull(list);
	}
	
	@Test
	public void testRecherer1() {
		ClientDao clientDAO=ClientDaoFactory.getClientDAO("jdbc");	
		List<Client> list = clientDAO.rechercher("you", "all");
		assertNotNull(list);
	}
	
	@Test
	public void testListChart() {
		ClientDao clientDAO=ClientDaoFactory.getClientDAO("jdbc");	
		List<ChartClient> list = clientDAO.listChart();
		assertNotNull(list);
	}

}
