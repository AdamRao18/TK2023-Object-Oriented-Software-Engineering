
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Screen1 extends JFrame implements ActionListener {
	private JButton btn1 = new JButton("Go To Screen 2");
	private JButton btn2 = new JButton("Go To Screen 3");
	
	private Controller controller;
		
	public Screen1(Controller controller) {
		this.controller = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("First screen");
		setSize(600, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new FlowLayout());
		
		pane.add(btn1);
		pane.add(btn2);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		this.setVisible(false);
		
		if (obj == btn1) {
			controller.displayScreen(2); // ask Controller to display Screen 2
		}
		
		else if (obj == btn2) {
			controller.displayScreen(3); // ask Controller to display Screen 3
		}
	}
}
