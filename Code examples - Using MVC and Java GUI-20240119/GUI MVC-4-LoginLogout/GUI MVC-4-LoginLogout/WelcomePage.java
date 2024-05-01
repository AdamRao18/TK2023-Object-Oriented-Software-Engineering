
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WelcomePage extends JFrame implements ActionListener {
	private JButton btnLogout = new JButton("Logout");
	private JLabel textName = new JLabel(""); 
	
	private Controller controller;
	
	public WelcomePage(Controller controller) {
		this.controller = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Welcome Page");
		setSize(600, 200);
		setLocationRelativeTo(null);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new FlowLayout());
		
		pane.add(textName);
		pane.add(btnLogout);
		
		btnLogout.addActionListener(this);
	}
	
	public void display(String name) {
		textName.setText("Welcome "+name+"!");
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);		
		controller.logout();	
	}
}
