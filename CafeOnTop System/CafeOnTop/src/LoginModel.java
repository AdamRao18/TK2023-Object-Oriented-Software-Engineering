public class LoginModel {
    private String name;
    private String contactNumber;
    private String password;

    public LoginModel(String name, String contactNumber, String password) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getPassword() {
        return password;
    }
}
