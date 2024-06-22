package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NavPrescribe
{
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
    private TextField medicine;
	
	@FXML
    private TextField dosage;

	public void pharmacy(ActionEvent e) throws IOException
	{
		System.out.println("Send to Pharmacy");
	}
	
	public void back(ActionEvent e) throws IOException
	{
		System.out.println("Send to Pharmacy");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("physicalForm.fxml"));
		Parent root = loader.load();
		NavPhysical NavPhysical = loader.getController();
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}