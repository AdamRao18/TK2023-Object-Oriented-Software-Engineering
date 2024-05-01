import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class LoginView {
    private JFrame frame;
    private JButton loginButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_4;
    private JLabel lblNewLabel;

    public LoginView() {
        frame = new JFrame("Login");
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(460, 255);
        frame.setLocationRelativeTo(null);

        GridLayout gl_panel = new GridLayout(2, 2);
        gl_panel.setVgap(4);
        gl_panel.setHgap(4);
        JPanel panel = new JPanel(gl_panel);
        panel.setBackground(Color.BLACK);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        usernameLabel.setForeground(Color.WHITE);
        usernameField = new JTextField();
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordLabel.setForeground(Color.WHITE);
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{usernameLabel, usernameField, passwordLabel, passwordField}));
        
        panel_1 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
        flowLayout_1.setVgap(9);
        panel_1.setBackground(new Color(0, 0, 0));
        frame.getContentPane().add(panel_1, BorderLayout.NORTH);
        
        lblNewLabel = new JLabel("Welcome To Login Page");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(255, 255, 255));
        panel_1.add(lblNewLabel);
        
        panel_2 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
        flowLayout.setVgap(9);
        panel_2.setBackground(Color.BLACK);
        frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
        
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_2.add(loginButton);
        
        panel_3 = new JPanel();
        panel_3.setBackground(Color.BLACK);
        frame.getContentPane().add(panel_3, BorderLayout.WEST);
        
        panel_4 = new JPanel();
        panel_4.setBackground(Color.BLACK);
        frame.getContentPane().add(panel_4, BorderLayout.EAST);
    }

    public void createAndShowGUI() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    public void addLoginButtonListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }
    
    

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void closeWindow() {
        frame.dispose();
    }

    public JFrame getFrame() {
        return frame;
    }
}
