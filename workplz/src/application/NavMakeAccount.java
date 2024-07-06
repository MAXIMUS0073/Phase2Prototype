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
		
		String firstName = firstNameField.getText().toLowerCase();
		String lastName = lastNameField.getText().toLowerCase();
		String DOB = DOBField.getText();
		String email = emailField.getText().toLowerCase();
		String phoneNumber = phoneNumberField.getText();
		
		String userName = firstName.substring(0,1) + lastName + DOB.substring(DOB.length() - 2);
		//patient Pat = new patient(userName, firstName, lastName, DOB, email, phoneNumber, "password");
		String filename = userName + "_PatientInfo.txt";
    	
    		if(doesFileExist(filename))
    		{
    			System.out.println("That username is already taken");
    		}
    		else
    		{
    			patient Pat = new patient(userName, firstName, lastName, DOB, email, phoneNumber, "password");
    			savePatient(Pat);	//create file for patient
	    
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

    private void savePatient(patient Pat)
    {
    	String filename = Pat.getUserName() + "_PatientInfo.txt";
    	
   		try (PrintWriter writer = new PrintWriter(filename, "UTF-8"))
   		{
   			writer.println("Username: " + Pat.getUserName());
   			writer.println("First Name: " + Pat.getFirstName());
   			writer.println("Last Name: " + Pat.getLastName());
   			writer.println("DOB: " + Pat.getDOB());
   			writer.println("Email: " + Pat.getEmail());
    			writer.println("Phone Number: " + Pat.getPhoneNumber());
    			writer.println("Password: " + Pat.getPassword());
    		}
    		catch (IOException e)
    		{
    			System.out.println("An error occurred while trying to save the patient information.");
    			e.printStackTrace();
    		}
    }
	
    private boolean doesFileExist(String filename)
    {
    	return Files.exists(Paths.get(filename));
    }
}
