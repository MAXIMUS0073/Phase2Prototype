package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NavCheckIn
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField usernameField;
	
	@FXML
    private TextField firstNameField;
	
	@FXML
    private TextField lastNameField;
	
	 public void confirmButton(ActionEvent e) throws IOException
	 {
		 String filename = usernameField.getText().toLowerCase() + "_PatientInfo.txt";
		 
		 String username = "";
		 String firstName = "";
		 String lastName = "";
		 String DOB = "";
		 String email = "";
		 String phoneNumber = "";
		 String password = "";
		 
		 if(doesFileExist(filename))
		 {
			 try
			 {
				 File patientFile = new File(filename);
				 BufferedReader br = new BufferedReader(new FileReader(patientFile));
				 String line;
				 while((line = br.readLine()) != null)
				 {
					 String[] parts = line.split(":");
					 if(parts.length >= 2)
					 {
						 String key = parts[0].trim();
						 String value = parts[1].trim();
						 
						 switch (key)
						 {
						 case "Username":
							 username = value;
							 break;
						 case "First Name":
							 firstName = value;
							 break;
						 case "Last Name":
							 lastName = value;
							 break;
						 case "DOB":
							 DOB = value;
							 break;
						 case "Email":
							 email = value;
							 break;
						 case "Phone Number":
							 phoneNumber = value;
							 break;
						 case "Password":
							 password = value;
							 break; 
						 }
					 }
				 }
				 
			 }
			 catch (IOException ee)
			 {
				 ee.printStackTrace();
			 }
			 
			 patient Pat = new patient(username, firstName, lastName, DOB, email, phoneNumber, password); 
			 
			 //PatientList.addPatient(Pat);
			 
			 String checkedInPatientsFile = "checked_in_patients.txt";
			 Files.write(Paths.get(checkedInPatientsFile), (username + "\n").getBytes(), StandardOpenOption.APPEND);
			 System.out.println("Patient Checked-in");
		 }
		 /*else if (true)
		 {
			 firstName = firstNameField.getText().toLowerCase();
			 lastName = lastNameField.getText().toLowerCase();
			 
			 String firstNameTemp = "";
			 
			 int i = 0;
			 while(i < 100)
			 {
				 username = firstName.substring(0,1) + lastName + i;
				 filename = username + "_PatientInfo.txt";
				 if(doesFileExist(filename))
				 {
					 try
					 {
						 File patientFile = new File(filename);
						 BufferedReader br = new BufferedReader(new FileReader(patientFile));
						 String line;
						 while((line = br.readLine()) != null)
						 {
							 String[] parts = line.split(":");
							 if(parts.length >= 2)
							 {
								 String key = parts[0].trim();
								 String value = parts[1].trim();
								 
								 switch (key)
								 {
								 case "Username":
									 username = value;
									 break;
								 case "First Name":
									 firstNameTemp = value;
									 break;
								 case "Last Name":
									 lastName = value;
									 break;
								 case "DOB":
									 DOB = value;
									 break;
								 case "Email":
									 email = value;
									 break;
								 case "Phone Number":
									 phoneNumber = value;
									 break;
								 case "Password":
									 password = value;
									 break; 
								 }
							 }
						 }
						 
					 }
					 catch (IOException ee)
					 {
						 ee.printStackTrace();
					 }
					 
					 if(firstNameTemp.equals(firstName))
					 {
						 patient Pat = new patient(username, firstName, lastName, DOB, email, phoneNumber, password);
						 i = 100;
					 }
				 }
				 else if(i == 99)
				 {
					 System.out.println("Patient does not exist");
				 }
				 
			 }
		 }*/
		 else
		 {
			 System.out.println("Error in checking in patient");
		 }
	 }
	 
	 public void backButton(ActionEvent e) throws IOException
	 {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("nurseport.fxml"));
			Parent root = loader.load();
			NavNurse NavNurse = loader.getController();
			
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	 }

	private boolean doesFileExist(String filename)
	{
		return Files.exists(Paths.get(filename));
	}
}
