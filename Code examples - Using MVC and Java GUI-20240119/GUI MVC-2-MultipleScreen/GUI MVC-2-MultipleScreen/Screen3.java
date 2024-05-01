import java.awt.*;
import javax.swing.*;

public class Screen3 extends JFrame {
	
	public Screen3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Third screen");
		setSize(600, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new FlowLayout());
		
		pane.add(new JLabel("This is Screen 3"));
	}
}
