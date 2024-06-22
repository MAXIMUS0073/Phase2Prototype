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
import javafx.stage.Stage;

public class NavHistoryN implements Initializable
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private ChoiceBox<String> patientName; 
	
	@FXML
	private TextArea displayHistory;

	private String[] options = {"John Doe", "Jane Doe"};		//Patient Names

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		patientName.getItems().addAll(options);
		patientName.setOnAction(this::getHistory);
	}
	
	public void getHistory(ActionEvent e)
	{
		if("John Doe" == patientName.getValue())
		{
			displayHistory.setText("This is John Doe's history");
		}
		else if("Jane Doe" == patientName.getValue())
		{
			displayHistory.setText("This is Jane Doe's history");
		}
		else
		{
			displayHistory.setText("No history to display");
		}
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