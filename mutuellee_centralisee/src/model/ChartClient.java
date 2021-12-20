package model;

import java.util.Date;

public class ChartClient {
	private Date date_debut;
	private int num_client;
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public int getNum_client() {
		return num_client;
	}
	public void setNum_client(int num_client) {
		this.num_client = num_client;
	}
	public ChartClient(Date date_debut, int num_client) {
		super();
		this.date_debut = date_debut;
		this.num_client = num_client;
	}
	
}
