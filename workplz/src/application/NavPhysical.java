package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class NavPhysical implements Initializable
{
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
    private TextField height;
	
	@FXML
    private TextField weight;
	
	@FXML
    private TextField bloodPressure;
	
	@FXML
    private TextField temperature;
	
	@FXML
    private TextField allergies;
	
	@FXML
	private ChoiceBox<String> smoker;
	
	@FXML
	private ChoiceBox<String> drinker;
	
	@FXML
	private ChoiceBox<String> healthConditions;
	
	private String[] options = {"yes", "no"};
	
	
	@FXML
    private TextArea healthDesc;
	
	public void finalizeForm(ActionEvent e) throws IOException
	{
		System.out.println("Finalize Physical");
        
        String lastName = "Doe";
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("docPortal.fxml"));
		Parent root = loader.load();
		NavDoc NavDoc = loader.getController();
		NavDoc.displayName(lastName);
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void prescribe(ActionEvent e) throws IOException
	{
		System.out.println("Prescribe Medication");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PrescribeMedicine.fxml"));
		Parent root = loader.load();
		NavPrescribe NavPrescribe = loader.getController();
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		smoker.getItems().addAll(options);
		drinker.getItems().addAll(options);
		healthConditions.getItems().addAll(options);
	}
}