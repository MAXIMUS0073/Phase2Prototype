package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NavNurse
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void checkin(ActionEvent e) throws IOException
	{
		System.out.println("Check-in Patient");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("checkin.fxml"));
		Parent root = loader.load();
		NavCheckIn NavCheckIn = loader.getController();
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void message(ActionEvent e) throws IOException
	{
		System.out.println("Send Message");
	}
	
	public void vitals(ActionEvent e) throws IOException
	{
		System.out.println("Take Vitals");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("vitals.fxml"));
		Parent root = loader.load();
		NavVitals NavVitals = loader.getController();
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void history(ActionEvent e) throws IOException
	{
		System.out.println("View Medical History");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MedicalHistoryN.fxml"));
		Parent root = loader.load();
		NavHistoryN NavHistoryN = loader.getController();
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void logout(ActionEvent e) throws IOException
	{
		//System.out.println("Enter");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("loginPage.fxml"));
		Parent root = loader.load();
		Navigator Navigator = loader.getController();
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
}