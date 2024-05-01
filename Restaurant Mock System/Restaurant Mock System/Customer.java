public class Customer {
	private String Name;
	private String 	ContactNumber;
	private String Password;
	
	
	public Customer (String Name, String ContactNumber, String Password) {
		this.Name =Name;
		this.ContactNumber = ContactNumber;
		this.Password = Password;
	}
	
	public String getName() {
		return Name;
	}
	public String getContactNumber() {
		return ContactNumber;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public String toString() {
		return ("");
	}
}
			
