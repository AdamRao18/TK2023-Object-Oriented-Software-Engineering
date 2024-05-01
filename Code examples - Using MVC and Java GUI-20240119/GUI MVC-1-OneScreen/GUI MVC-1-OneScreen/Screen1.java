
import java.awt.*;
import javax.swing.*;

public class Screen1 extends JFrame {
	private JButton btn1 = new JButton("Go To Screen 2");
	private JButton btn2 = new JButton("Go To Screen 3");
		
	public Screen1() {
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
	}
}
