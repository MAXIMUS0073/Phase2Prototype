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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NavPatInfo
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField firstName;
	
	@FXML
	private TextField lastName;
	
	@FXML
	private TextField DOB;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField phoneNumber;
	
	public void saveInfo(ActionEvent e) throws IOException
	{
		System.out.println("Info Saved");
	}
	
	public void backtoPatPort(ActionEvent e) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("patientPortal.fxml"));
		Parent root = loader.load();
		NavPatient NavPatient = loader.getController();
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}