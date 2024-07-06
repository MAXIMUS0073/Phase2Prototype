package application;

public class patient
{
	private String userName;
	private String firstName;
	private String lastName;
	private String DOB;
	private String email;
	private String phoneNumber;
	private String password;
	
	
	public patient()
	{
		this.userName = "";
		this.firstName = "";
		this.lastName = "";
		this.DOB = "";
		this.email = "";
		this.phoneNumber = "";
		this.password = "";
		//this.setPassword("password");
	}
	
	public patient(String userName, String firstName, String lastName, String DOB, String email, String phoneNumber, String password)
	{
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.DOB = DOB;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		//this.setPassword(password);
	}
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
