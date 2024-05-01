
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BookPage extends JFrame implements ActionListener {
	private JButton btnBack = new JButton("Back");
	private JLabel imgFile = new JLabel("");
	
	private Controller controller;
	
	public BookPage(Controller controller) {
		this.controller = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Book Page");
		setSize(600, 200);
		setLocationRelativeTo(null);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new BorderLayout());		
		
		JPanel p1 = new JPanel();
		p1.add(imgFile);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p2.add(btnBack);
		
		pane.add(p1, BorderLayout.CENTER);
		pane.add(p2, BorderLayout.SOUTH);
		
		btnBack.addActionListener(this);
	}
	
	public void display(String fileName) {
		ImageIcon icon = new ImageIcon(fileName);
		imgFile.setIcon(icon);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);		
		controller.displayBookListPage();	
	}

}
