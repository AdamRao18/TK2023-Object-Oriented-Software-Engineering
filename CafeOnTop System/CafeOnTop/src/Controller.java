import javax.swing.*;

public class Controller {
    private MainMenu mainMenu;
    private LoginMenu loginMenu;
    private LoginModel[] users;
    private int currentUserIndex;

    public Controller() {
        users = new LoginModel[10]; // Assuming max 10 users
        currentUserIndex = 0;
        loginMenu = new LoginMenu(this);
    }

    public boolean authenticateUser(String name, String contactNumber, String password) {
        for (LoginModel user : users) {
            if (user != null && user.getName().equals(name) &&
                    user.getContactNumber().equals(contactNumber) &&
                    user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void addUser(LoginModel user) {
        if (currentUserIndex < users.length) {
            users[currentUserIndex++] = user;
        } else {
            JOptionPane.showMessageDialog(null, "Maximum user capacity reached!");
        }
    }

    public void openMainMenu() {
        mainMenu = new MainMenu();
        loginMenu.dispose();
    }

    public void openLoginMenu() {
        loginMenu.setVisible(true);
    }
    
    public static void main(String[] args) {
        Controller controller = new Controller();
        
        controller.addUser(new LoginModel("Adam", "0987654321", "cba321"));
        controller.addUser(new LoginModel("Momo", "0123456789", "abc123"));
        
        controller.openLoginMenu();
    }
}
