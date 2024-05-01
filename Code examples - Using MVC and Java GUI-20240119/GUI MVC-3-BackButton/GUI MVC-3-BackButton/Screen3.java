import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Screen3 extends JFrame implements ActionListener {
	private JButton btnBack = new JButton("Back to Screen 1");
	
	private Controller controller;
	
	public Screen3(Controller controller) {
		this.controller = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Third screen");
		setSize(600, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new FlowLayout());
		
		pane.add(new JLabel("This is Screen 3"));
		pane.add(btnBack);
		
		btnBack.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		controller.displayScreen(1); // ask Controller to display Screen 1
	}
}
