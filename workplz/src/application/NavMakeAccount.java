package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NavMakeAccount
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
    private TextField firstNameField;
	
	@FXML
    private TextField lastNameField;
	
	@FXML
    private TextField DOBField;
	
	@FXML
    private TextField emailField;
	
	@FXML
    private TextField phoneNumberField;
	
	
    public void confirmButton(ActionEvent e) throws IOException
    {
		System.out.println("Account created");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("patientPortal.fxml"));
		Parent root = loader.load();
		NavPatient NavPatient = loader.getController();
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
}