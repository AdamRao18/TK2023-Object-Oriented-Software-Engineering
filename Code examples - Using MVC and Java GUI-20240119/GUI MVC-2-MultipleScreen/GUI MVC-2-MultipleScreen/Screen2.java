import java.awt.*;
import javax.swing.*;

public class Screen2 extends JFrame {
	
	public Screen2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Second screen");
		setSize(600, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new FlowLayout());
		
		pane.add(new JLabel("This is Screen 2"));
	}
}
