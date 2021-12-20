package controller;

import org.mindrot.jbcrypt.BCrypt;

import dao.UserDao;
import factory.UserDaoFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import methode.MethodeAlert;
import model.User;
import javafx.scene.control.PasswordField;

public class LoginController {
	
   	  	@FXML
	    private Pane login;

	    @FXML
	    private TextField email;

	    @FXML
	    private Button Register;

	    @FXML
	    private PasswordField password;


    @FXML
    void login(ActionEvent event) {
    	User user=new User(email.getText(), password.getText());
    	UserDao userDAO=UserDaoFactory.getUserDAO("jdbc");
    	//call insert method by passing user object
    	boolean i= userDAO.connection(user);
    	if (i) {
    		try {
       		 Parent root =  FXMLLoader.load(getClass().getResource("/view/ViewClient.fxml"));
   	         Scene  scene = new Scene(root);
   	         Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
                page.setScene(scene);
                page.show();
	   		} catch(Exception e) {
	   			e.printStackTrace();
	   		}
    		
		} else {
			MethodeAlert methodeAlert =new MethodeAlert();
    		methodeAlert.afficherAlert("Information Dialog", "Email ou password incorrect ");
    		
		}
    }

    @FXML
    void register(ActionEvent event) {
    	
    	try {
    		 Parent root =  FXMLLoader.load(getClass().getResource("/view/RegisterUser.fxml"));
	         Scene  scene = new Scene(root);
	         Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
             page.setScene(scene);
             page.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
	
}
