package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class NavVitals implements Initializable
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField feet;
	
	@FXML
	private TextField inches;
	
	@FXML
	private TextField lbs;
	
	@FXML
	private TextField topBlood;
	
	@FXML
	private TextField bottomBlood;
	
	@FXML
	private TextField temperature;
	
	@FXML
	private TextArea allergies;
	
	@FXML
	private TextArea healthConcerns;
	
	@FXML
	private ChoiceBox<String> patientName; 

	private String[] options = {};		//Patient Names

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// Path to the checked-in patients file
	    String checkedInPatientsFile = "checked_in_patients.txt";

	    try (BufferedReader reader = new BufferedReader(new FileReader(checkedInPatientsFile))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            // Add each line (username) to the ChoiceBox
	            patientName.getItems().add(line);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		// TODO Auto-generated method stub
		patientName.getItems().addAll(options);
	}
	
	public void confirmButton(ActionEvent e) throws IOException
	 {
		 System.out.println("Vitals Recorded");
	 }
	
	public void backToNursePort(ActionEvent e) throws IOException
	{
			System.out.println("Back");
	        
			FXMLLoader loader = new FXMLLoader(getClass().getResource("nurseport.fxml"));
			Parent root = loader.load();
			NavNurse NavNurse = loader.getController();
			
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	}
}
