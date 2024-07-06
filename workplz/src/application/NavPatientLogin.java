package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NavPatientLogin
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public void loginSubmit(ActionEvent e) throws IOException
    {
        String username = usernameField.getText();
        String password = passwordField.getText();

        String filename = username + "_PatientInfo.txt";
        if(doesFileExist(filename))
        {
            String actualPassword = "";
            
		try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        	{
        		String line;
        		while((line = reader.readLine()) != null)
        		{
        			if (line.startsWith("Password: "))
        			{
        				actualPassword = line.substring("Password: ".length());
        				break;
        			}
        		}
        	}
        	catch(IOException ee)
        	{
        		ee.printStackTrace();
        	}
        	
        	if(actualPassword.equals(password))
        	{
			System.out.println("User successfully logged in");
            		FXMLLoader loader = new FXMLLoader(getClass().getResource("patientPortal.fxml"));
			Parent root = loader.load();
			NavPatient NavPatient = loader.getController();
			
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else 
            	{
               	 	System.out.println("Login failed");
            	}
        } 
        else 
        {
            System.out.println("Login failed");
        }
    }
   
   public void createAccount(ActionEvent e) throws IOException
   {
	   FXMLLoader loader = new FXMLLoader(getClass().getResource("createAccount.fxml"));
		Parent root = loader.load();
		NavMakeAccount NavMakeAccount = loader.getController();
		
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
