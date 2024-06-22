package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class NavPatient
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextArea recentVisit;
	
	
	
	public void contactOffice(ActionEvent e) throws IOException
	{
		System.out.println("Contact Medical Office");
	}

	
	public void info(ActionEvent e) throws IOException
	{
		System.out.println("Patient Information");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PatInfo.fxml"));
		Parent root = loader.load();
		NavPatInfo NavPatInfo = loader.getController();
		
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