import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMenu extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField contactNumberField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;
    private Controller controller;

    public LoginMenu(Controller controller) {
        this.controller = controller;
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(100, 20, 160, 25);
        panel.add(nameField);

        JLabel contactNumberLabel = new JLabel("Contact Number:");
        contactNumberLabel.setBounds(10, 50, 80, 25);
        panel.add(contactNumberLabel);
        contactNumberField = new JTextField();
        contactNumberField.setBounds(100, 50, 160, 25);
        panel.add(contactNumberField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 80, 80, 25);
        panel.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 80, 160, 25);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 110, 80, 25);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        statusLabel = new JLabel("");
        statusLabel.setBounds(10, 140, 250, 25);
        panel.add(statusLabel);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String name = nameField.getText();
            String contactNumber = contactNumberField.getText();
            String password = new String(passwordField.getPassword());

            if (controller.authenticateUser(name, contactNumber, password)) {
                statusLabel.setText("Login successful!");
                controller.openMainMenu();
            } else {
                statusLabel.setText("Invalid credentials. Please try again.");
            }
        }
    }
}
