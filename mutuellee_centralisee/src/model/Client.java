package model;

import java.util.Date;

public class Client {
	
	private int id;
	private String nbadge;
	private String nom_entreprise;
	private Date date_debut;
	private String prenom;
	private String nom;
	private String cin;
	private String passport;
	private String telephone;
	private String email;	
	private String adresse;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(int id, String nbadge, String nom_entreprise, Date date_debut, String prenom, String nom, String cin,
			 String passport,String telephone, String email, String adresse) {
		super();
		this.id = id;
		this.nbadge = nbadge;
		this.nom_entreprise = nom_entreprise;
		this.date_debut = date_debut;
		this.prenom = prenom;
		this.nom = nom;
		this.cin = cin;
		this.passport = passport;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
	}
	
	public Client(String nbadge, String nom_entreprise, Date date_debut, String prenom, String nom, String cin,
			String passport, String telephone, String email, String adresse) {
		super();
		this.nbadge = nbadge;
		this.nom_entreprise = nom_entreprise;
		this.date_debut = date_debut;
		this.prenom = prenom;
		this.nom = nom;
		this.cin = cin;
		this.passport = passport;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNbadge() {
		return nbadge;
	}

	public void setNbadge(String nbadge) {
		this.nbadge = nbadge;
	}

	public String getNom_entreprise() {
		return nom_entreprise;
	}

	public void setNom_entreprise(String nom_entreprise) {
		this.nom_entreprise = nom_entreprise;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	

}
