
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainPage extends JFrame implements ActionListener {
	private JButton btnViewBookList = new JButton("View book list");
	
	private Controller controller;
	
	public MainPage(Controller controller) {
		this.controller = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Main Page");
		setSize(600, 200);
		setLocationRelativeTo(null);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new FlowLayout());
		
		pane.add(btnViewBookList);
		
		btnViewBookList.addActionListener(this);
	}
	
	public void display() {
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);		
		controller.displayBookListPage();	
	}
}
