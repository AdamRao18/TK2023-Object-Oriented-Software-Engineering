
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
	private JButton btnLogin = new JButton("Login");
	private JTextField textName = new JTextField(10);
	private JPasswordField textPassword = new JPasswordField(10);
	
	private Controller controller;
	
	public LoginPage(Controller controller) {
		this.controller = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login Page");
		setSize(600, 200);
		setLocationRelativeTo(null);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new FlowLayout());
		
		pane.add(new JLabel("Enter name:"));
		pane.add(textName);
		
		pane.add(new JLabel("Enter password :"));
		pane.add(textPassword);
		
		pane.add(btnLogin);
		
		btnLogin.addActionListener(this);		
	}
	
	public void display() {
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = textName.getText();
		textName.setText("");
		
		String password = textPassword.getText();
		textPassword.setText("");
		
		this.setVisible(false);
		
		controller.login(name, password);	
	}

}
