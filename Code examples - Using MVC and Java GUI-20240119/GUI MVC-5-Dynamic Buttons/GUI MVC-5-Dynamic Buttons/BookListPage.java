
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class BookListPage extends JFrame implements ActionListener {
	private JButton btnBack = new JButton("Back to Main Page");
	
	private Controller controller;	
	private ArrayList<JButton> btnList;
	
	public BookListPage(Controller controller, ArrayList<String> idList) {
		this.controller = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Book List Page");
		setSize(600, 200);
		setLocationRelativeTo(null);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Book Catalogue:"));
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(idList.size(), 1));
		
		btnList = new ArrayList<JButton>();
		
		for (int i=0; i<idList.size(); i++) {
			String id = idList.get(i);
			
			JButton btnView = new JButton(id);
			btnView.addActionListener(this);
			btnList.add(btnView);
			
			JPanel p = new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			p.add(new JLabel((i+1)+"."));
			p.add(btnView);
			
			p2.add(p);
		}
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p3.add(btnBack);
		
		pane.add(p1, BorderLayout.NORTH);
		pane.add(p2, BorderLayout.CENTER);
		pane.add(p3, BorderLayout.SOUTH);
		
		btnBack.addActionListener(this);
	}
	
	public void display() {
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == btnBack) {
			this.setVisible(false);		
			controller.displayMainPage();
		}
		
		else {
			for (int i=0; i<btnList.size(); i++) {
				if (obj == btnList.get(i)) {
					this.setVisible(false);		
					controller.displayBookPage(i);
				}
			}			
		}			
	}
}
