import java.util.ArrayList;

public class LoginModel {
    private ArrayList<User> users;

    public LoginModel() {
        // Initialize users (replace this with a database)
        users = new ArrayList<>();
        users.add(new User("123", "123"));
        users.add(new User("asd", "asd"));
    }

    public boolean validateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Valid credentials
            }
        }
        return false; // Invalid credentials
    }

    // User class inside LoginModel
    private class User {
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
	