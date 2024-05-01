
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ErrorPage extends JFrame implements ActionListener {
	private JButton btnBack = new JButton("Back to Login Page");
	
	private Controller controller;
	
	public ErrorPage(Controller controller) {
		this.controller = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Error Page");
		setSize(600, 200);
		setLocationRelativeTo(null);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new FlowLayout());
		
		pane.add(new JLabel("ID not found or wrong password"));
		pane.add(btnBack);
		
		btnBack.addActionListener(this);
	}
	
	public void display() {
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		controller.displayLoginPage();
	}
}
