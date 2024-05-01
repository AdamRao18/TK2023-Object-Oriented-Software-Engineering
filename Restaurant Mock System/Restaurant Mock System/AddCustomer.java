import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener {
    private JLabel nameLabel;
    private JTextField nameText;
    private JLabel userLabel;
    private JTextField userText;
    private JLabel pwLabel;
    private JPasswordField pwText;
    private JButton logButton;
    private JLabel success;
    private static Customer[] customers;
    private static int currentIndex;

    public AddCustomer() {
        JPanel panel = new JPanel();
        setSize(450, 300);
        setTitle("LOG IN");
        add(panel);
        panel.setLayout(null);

        nameLabel = new JLabel("Customer Name");
        nameLabel.setBounds(10, 20, 100, 25);
        panel.add(nameLabel);
        nameText = new JTextField();
        nameText.setBounds(120, 20, 165, 25);
        panel.add(nameText);

        userLabel = new JLabel("Contact Number");
        userLabel.setBounds(10, 50, 100, 25);
        panel.add(userLabel);
        userText = new JTextField(20);
        userText.setBounds(120, 50, 165, 25);
        panel.add(userText);

        pwLabel = new JLabel("Password");
        pwLabel.setBounds(10, 80, 100, 25);
        panel.add(pwLabel);
        pwText = new JPasswordField();
        pwText.setBounds(120, 80, 165, 25);
        panel.add(pwText);

        logButton = new JButton("Log In");
        logButton.setBounds(10, 110, 80, 25);
        logButton.addActionListener(this);
        panel.add(logButton);

        customers = new Customer[10];
        currentIndex = 0;

        success = new JLabel("");
        success.setBounds(10, 140, 300, 25);
        panel.add(success);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logButton) {
            String contactNumber = userText.getText();
            String password = new String(pwText.getPassword());
            String name = nameText.getText();
            Customer newCustomer = new Customer(contactNumber, password, name);

            if (!contactNumber.isEmpty()) {
                customers[currentIndex] = newCustomer;
                currentIndex++;
                success.setText("Login successful! " + name + "!");
            }
        }
    }

    public static Customer[] getArrayUser() {
        return customers;
    }
}