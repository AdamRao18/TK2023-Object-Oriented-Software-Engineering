import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RestaurantMainMenu extends JFrame implements ActionListener {
    private JButton login, order, Payment,Reservation;
    private JLabel title;

    public RestaurantMainMenu() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        ((JComponent) pane).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        title = new JLabel("Welcome to Jibril Restaurant!Experience exquisite dining & exceptional service", JLabel.CENTER);
        login = new JButton("Log In");
        order = new JButton("Order Now");
        Payment = new JButton("Make a payment");
        Reservation = new JButton("Make a reservation");

        JPanel p1 = new JPanel(new GridLayout(5,5,5,5));
        p1.add(title);
        p1.add(login);
        p1.add(order);
        p1.add(Payment);
        p1.add(Reservation);

        login.addActionListener(this);
        order.addActionListener(this);
        Payment.addActionListener(this);
        Reservation.addActionListener(this);

        pane.add(p1, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == login) {
            new AddCustomer();
        } 
        else if (obj == order) {
            new OrderMenu();
        }
       // else if (obj == payment) {
        //    new Payment();
      //  }
        else if (obj == Reservation) {
            new Reservation();
        }
    }

    public static void main(String[] args) {
        RestaurantMainMenu menu = new RestaurantMainMenu();
        menu.setTitle("JIBRIL RESTAURANT");
        menu.setResizable(false);
        menu.setSize(500, 500);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
    }
}
