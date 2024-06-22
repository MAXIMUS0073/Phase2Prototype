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

public class NavDoc
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	Label nameLabel;
	
	public void displayName(String lastName)
	{
		nameLabel.setText("Hello Doctor " + lastName);
	}
	
	public void physical(ActionEvent e) throws IOException
	{
		System.out.println("Perform a Physical");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("physicalForm.fxml"));
		Parent root = loader.load();
		NavPhysical NavPhysical = loader.getController();
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void message(ActionEvent e) throws IOException
	{
		System.out.println("Send Message");
	}
	
	public void history(ActionEvent e) throws IOException
	{
		System.out.println("View Medical History");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MedicalHistoryD.fxml"));
		Parent root = loader.load();
		NavHistoryD NavHistoryD = loader.getController();
		
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