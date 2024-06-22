package application;

import java.awt.TextField;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Navigator
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private RadioButton nurseButton;
	
	@FXML
	private RadioButton doctorButton;
	
	@FXML
	private RadioButton patientButton;
	
	/*@FXML
	private TextField usernameField;

	@FXML
	private PasswordField passwordField;*/
	
	
	public void enter(ActionEvent e) throws IOException
	{
		//System.out.println("Enter");
		if (nurseButton.isSelected()) 
		{
	        //System.out.println("Nurse selected");
			//Parent root = FXMLLoader.load(getClass().getResource("loginCreds.fxml"));
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("loginCredsNurse.fxml"));
			Parent root = loader.load();
			NavNurseLogin NavNurseLogin = loader.getController();
			
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
			

		} 
		else if (doctorButton.isSelected()) 
	    {
	        //System.out.println("Doctor selected");
			//Parent root = FXMLLoader.load(getClass().getResource("loginCreds.fxml"));
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("loginCreds.fxml"));
			Parent root = loader.load();
			Navlogin Navlogin = loader.getController();
			
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    } 
		else if (patientButton.isSelected()) 
		{
	        //System.out.println("Patient selected");
			//Parent root = FXMLLoader.load(getClass().getResource("loginCreds.fxml"));
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("loginCredsPatient.fxml"));
			Parent root = loader.load();
			NavPatientLogin NavPatientLogin = loader.getController();
			
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    } 
		else 
	    {
	        //System.out.println("No selection");
	    }
	}
	
	/*
	@FXML
	public void loginSubmit(ActionEvent e)
	{
	    String username = usernameField.getText();
	    String password = passwordField.getText();

	    if ("admin".equals(username) && "password".equals(password)) 
	    {
	        System.out.println("User successfully logged in");
	        // Add your code for successful login here
	    } 
	    else 
	    {
	        System.out.println("Login failed");
	        // Add your code for failed login here
	    }
	}*/
}