package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NavCheckIn
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField usernameField;
	
	@FXML
    private TextField firstNameField;
	
	@FXML
    private TextField lastNameField;
	
	 public void confirmButton(ActionEvent e) throws IOException
	 {
		 System.out.println("Patient Checked-in");
	 }
	 
	 public void backButton(ActionEvent e) throws IOException
	 {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("nurseport.fxml"));
			Parent root = loader.load();
			NavNurse NavNurse = loader.getController();
			
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	 }
}