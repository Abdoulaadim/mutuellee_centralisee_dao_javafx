package dao;

import java.util.List;

import model.ChartClient;
import model.Client;

public abstract class ClientDao {
	public List<Client> afficher(){
		return null;
	};
	public int ajouter(Client client){
		return 0;
	};
	public List<Client> rechercher(String filter, String check){
		return null;
	};
	public List<ChartClient> listChart(){
		return null;
	};
}
