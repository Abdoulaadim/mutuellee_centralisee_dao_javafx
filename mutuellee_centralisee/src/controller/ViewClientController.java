package controller;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;

import dao.ClientDao;
import dao.UserDao;
import factory.ClientDaoFactory;
import factory.UserDaoFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import methode.MethodeAlert;
import model.ChartClient;
import model.Client;
import model.User;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ViewClientController implements Initializable {
	
	
    @FXML
    private TextField entreprise;

    @FXML
    private TextField prenom;

    @FXML
    private TextField email;

    @FXML
    private TextField nom;

    @FXML
    private TextField telephone;

    @FXML
    private RadioButton cin;

    @FXML
    private ToggleGroup radius;

    @FXML
    private RadioButton passport;

    @FXML
    private TextField cin_passport;

    @FXML
    private DatePicker date;

    @FXML
    private TextArea adresse;

    @FXML
    private TextField badge;

    @FXML
    private ChoiceBox<?> country_list;

    @FXML
    private TableView<Client> Ttable;

    @FXML
    private TableColumn<Client, String> Tbadge;

    @FXML
    private TableColumn<Client, String> Tentreprise;

    @FXML
    private TableColumn<Client, Date> Tdate;

    @FXML
    private TableColumn<Client, String> Tprenom;

    @FXML
    private TableColumn<Client, String> Tnom;

    @FXML
    private TableColumn<Client, String> Tcin;

    @FXML
    private TableColumn<Client, String> Tpassport;

    @FXML
    private TableColumn<Client, String> Ttelephone;

    @FXML
    private TableColumn<Client, String> Temail;

    @FXML
    private TableColumn<Client, String> Tadresse;

    @FXML
    private TextField Recherche;
    

    @FXML
    private ToggleGroup cherchegroup;
    

    @FXML
    private RadioButton f_entreprise;

    @FXML
    private RadioButton f_cin;

    @FXML
    private RadioButton f_nom;

    @FXML
    private RadioButton f_prenom;

    @FXML
    private RadioButton f_email;
    
    @FXML
    private LineChart<?, ?> chartclient;
    
    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

  


    @FXML
    void Register(ActionEvent event) {
    	System.out.println(checkinput());
    if (checkinput()) {
    	LocalDate localDate = this.date.getValue();
    	Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    	Date date_debut = Date.from(instant);
    	Client client=new Client(badge.getText(),entreprise.getText(),date_debut,prenom.getText(),nom.getText(),null,null,telephone.getText(),email.getText(),adresse.getText());
    	if (cin.isSelected()) {
			client.setCin(cin_passport.getText());
		} else {
			client.setPassport(cin_passport.getText());
		}
    	ClientDao clientDAO=ClientDaoFactory.getClientDAO("jdbc");
    	//call insert method by passing user object
    	int i= clientDAO.ajouter(client);
    	if (i==1) {
    		MethodeAlert methodeAlert =new MethodeAlert();
    		methodeAlert.afficherAlert("Information Dialog", "A été ajouter avec succés");
    		
		} else {
			MethodeAlert methodeAlert =new MethodeAlert();
    		methodeAlert.afficherAlert("Information Dialog", "Erreur d'ajout ");
		}
    	
    }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ClientDao clientDAO=ClientDaoFactory.getClientDAO("jdbc");	
		ObservableList<Client> list = FXCollections.observableArrayList(clientDAO.afficher());
		//clientDAO.afficher();	
		Tbadge.setCellValueFactory(new PropertyValueFactory<Client,String>("nbadge"));
		Tentreprise.setCellValueFactory(new PropertyValueFactory<Client,String>("nom_entreprise"));
		Tdate.setCellValueFactory(new PropertyValueFactory<Client,Date>("date_debut"));
		Tprenom.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));
    	 Tnom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
    	 Tcin.setCellValueFactory(new PropertyValueFactory<Client,String>("cin"));
    	 Tpassport.setCellValueFactory(new PropertyValueFactory<Client,String>("passport"));
    	 Ttelephone.setCellValueFactory(new PropertyValueFactory<Client,String>("telephone"));
    	 Temail.setCellValueFactory(new PropertyValueFactory<Client,String>("email"));		
    	 Tadresse.setCellValueFactory(new PropertyValueFactory<Client,String>("adresse"));
		 
    	 Ttable.setItems(list);
				
    	 List<ChartClient> chartClients = clientDAO.listChart();
    	 XYChart.Series series = new XYChart.Series();
    	 
    	 for (int i = 0; i < chartClients.size(); i++) {
    		 series.getData().add(new XYChart.Data(chartClients.get(i).getDate_debut().toString(),chartClients.get(i).getNum_client()));
         }
    	 
    	 XYChart.Series series1 = new XYChart.Series();
    	 series1.getData().add(new XYChart.Data("2021-02-08",5));
         series1.getData().add(new XYChart.Data("2021-01-08", 2));
         series1.getData().add(new XYChart.Data("2021-04-08", 1));
         series1.getData().add(new XYChart.Data("2021-05-08", 6));
         series1.getData().add(new XYChart.Data("2021-06-08", 8));
         series1.getData().add(new XYChart.Data("2021-07-08", 3));
         series1.getData().add(new XYChart.Data("2021-08-08", 2));
         series1.getData().add(new XYChart.Data("2021-09-08", 1));
         series1.getData().add(new XYChart.Data("2021-10-08", 4));
         series1.getData().add(new XYChart.Data("2021-10-22", 3));
         series1.getData().add(new XYChart.Data("2021-01-22", 2));
         series1.getData().add(new XYChart.Data("2021-03-11", 3));
         series1.getData().add(new XYChart.Data("2021-12-08", 5));
         
    	 XYChart.Series series2 = new XYChart.Series();
    	 series2.getData().add(new XYChart.Data("2021-02-11",5));
         series2.getData().add(new XYChart.Data("2021-01-23", 2));
         series2.getData().add(new XYChart.Data("2021-04-28", 1));
         series2.getData().add(new XYChart.Data("2021-05-03", 6));
         series2.getData().add(new XYChart.Data("2021-06-22", 8));
         series2.getData().add(new XYChart.Data("2021-07-11", 3));
         series2.getData().add(new XYChart.Data("2021-08-10", 2));
         series2.getData().add(new XYChart.Data("2021-09-15", 1));
         series2.getData().add(new XYChart.Data("2021-10-30", 4));
         series2.getData().add(new XYChart.Data("2021-10-01", 3));
         series2.getData().add(new XYChart.Data("2021-01-16", 2));
         series2.getData().add(new XYChart.Data("2021-03-18", 3));
         series2.getData().add(new XYChart.Data("2021-12-13", 5));
         
         chartclient.getData().clear();
         chartclient.getData().addAll(series,series1,series2);
         
         
         
         
         

    	 
	}
	
	
    @FXML
    void filtre(KeyEvent  event) {
    	ClientDao clientDAO=ClientDaoFactory.getClientDAO("jdbc");	
    	String check="";
    	if (f_entreprise.isSelected()) {
			check = "nom_entreprise";
		} else if (f_cin.isSelected()) {
			check = "cin";
		} else if (f_nom.isSelected()) {
			check = "nom";
		} else if (f_prenom.isSelected()) {
			check = "prenom";
		} else if (f_email.isSelected()) {
			check = "email";
		} else {
    		check = "all";
		}
		ObservableList<Client> list = FXCollections.observableArrayList(clientDAO.rechercher(Recherche.getText(), check));
		//clientDAO.afficher();	
		Tbadge.setCellValueFactory(new PropertyValueFactory<Client,String>("nbadge"));
		Tentreprise.setCellValueFactory(new PropertyValueFactory<Client,String>("nom_entreprise"));
		Tdate.setCellValueFactory(new PropertyValueFactory<Client,Date>("date_debut"));
		Tprenom.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));
    	 Tnom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
    	 Tcin.setCellValueFactory(new PropertyValueFactory<Client,String>("cin"));
    	 Tpassport.setCellValueFactory(new PropertyValueFactory<Client,String>("passport"));
    	 Ttelephone.setCellValueFactory(new PropertyValueFactory<Client,String>("telephone"));
    	 Temail.setCellValueFactory(new PropertyValueFactory<Client,String>("email"));		
    	 Tadresse.setCellValueFactory(new PropertyValueFactory<Client,String>("adresse"));
		 
    	 Ttable.setItems(list);
    }
    
    
    public boolean checkinput () {
    	
        String regexPhone = "[0-9]+";
        String regexEmail = "^(.+)@(\\S+)$";
        String regexCin = "[a-zA-Z]{2}\\d{6}";
        String regexPassport = "[a-zA-Z]{2}\\d{7}";

        Pattern p = Pattern.compile(regexPhone);
        Pattern e = Pattern.compile(regexEmail);
        Pattern c = Pattern.compile(regexCin);
        Pattern ps = Pattern.compile(regexPassport);

        Matcher mp = p.matcher(this.telephone.getText());
        Matcher me = e.matcher(this.email.getText());
        Matcher mc = c.matcher(this.cin_passport.getText());
        Matcher mps = ps.matcher(this.cin_passport.getText());

        RadioButton selectedRadioButton = (RadioButton) radius.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
    	
    	MethodeAlert methodeAlert = new MethodeAlert();
    	
    	 if (this.badge.getLength() > 10 || this.badge.getText().isEmpty() ){
             methodeAlert.afficherAlert("information","il doit etre badge > 10 ");
         }else if (this.nom.getLength() > 50 || this.nom.getText().isEmpty() ){
             methodeAlert.afficherAlert("information","il doit etre le nom > 50 ");
         }else if (this.prenom.getLength() > 50 || this.prenom.getText().isEmpty()){
        	 methodeAlert.afficherAlert("information","il doit etre le prenom > 50 ");
         }else if (this.entreprise.getLength() > 50 || this.entreprise.getText().isEmpty()){
        	 methodeAlert.afficherAlert("information","il doit etre l'entreprise > 50 ");
         }else  if (this.telephone.getText().isEmpty() || this.telephone.getLength() < 9 || !mp.matches()){
        	 methodeAlert.afficherAlert("information","il doit le telephone contenir < 9 ");     
         }else if (this.email.getText().isEmpty() || !me.matches()){
        	 
        	 methodeAlert.afficherAlert("information","email incorrect ");     
         }else if (cin.isSelected()  && (this.cin_passport.getText().isEmpty() || !mc.matches())){
            	 methodeAlert.afficherAlert("information","Cin incorrect");     
         }else if(passport.isSelected() && (this.cin_passport.getText().isEmpty() || !mps.matches())){
            	 methodeAlert.afficherAlert("information","passport incorrect"); 
         }else if (this.adresse.getText().isEmpty()){
        	 methodeAlert.afficherAlert("information","adresse incorrect");   
         }else if (this.date.getValue() == null){
        	 methodeAlert.afficherAlert("information","date vide");   
         }else {
        	 return true;
         }
             return false;
         
    }


}
