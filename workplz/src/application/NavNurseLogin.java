package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NavNurseLogin
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

 
    public void loginSubmit(ActionEvent e) throws IOException
    {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if ("admin".equals(username) && "password".equals(password)) 
        {
            System.out.println("User successfully logged in");
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("nurseport.fxml"));
			Parent root = loader.load();
			NavNurse NavNurse = loader.getController();
			
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
            
        } 
        else 
        {
            System.out.println("Login failed");
            // Add your code for failed login here
        }
    }
}