import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReservationMenu extends JFrame implements ActionListener {
    private JTextField nameTextField;
    private JTextField dateTextField;
    private JTextField timeTextField;
    private JComboBox<String> tableComboBox;
    private JLabel success;
    private JButton viewInfo;
    private JTextArea textArea;
    private ReservationModel reservationModel;

    public ReservationMenu() {
        JPanel panel = new JPanel();
        setSize(450, 400);
        setTitle("Make a Reservation");
        add(panel);

        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Customer Name:");
        nameLabel.setBounds(10, 20, 100, 25);
        panel.add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(120, 20, 165, 25);
        panel.add(nameTextField);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(10, 50, 100, 25);
        panel.add(dateLabel);

        dateTextField = new JTextField();
        dateTextField.setBounds(120, 50, 165, 25);
        panel.add(dateTextField);

        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setBounds(10, 80, 100, 25);
        panel.add(timeLabel);

        timeTextField = new JTextField();
        timeTextField.setBounds(120, 80, 165, 25);
        panel.add(timeTextField);

        JLabel tableLabel = new JLabel("Table Number:");
        tableLabel.setBounds(10, 110, 100, 25);
        panel.add(tableLabel);

        String[] tableNumbers = {"001", "002", "003", "004", "005"};
        tableComboBox = new JComboBox<>(tableNumbers);
        tableComboBox.setBounds(120, 110, 165, 25);
        panel.add(tableComboBox);

        JButton makeReservationButton = new JButton("Make Reservation");
        makeReservationButton.setBounds(10, 140, 140, 25);
        makeReservationButton.addActionListener(this);
        panel.add(makeReservationButton);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 200, 420, 150);
        panel.add(scrollPane);

        success = new JLabel("");
        success.setBounds(10, 170, 300, 25);
        panel.add(success);

        viewInfo = new JButton("View Reservation Information");
        viewInfo.setBounds(160, 140, 220, 25);
        viewInfo.addActionListener(this);
        panel.add(viewInfo);

        setVisible(true);
        
        reservationModel = new ReservationModel();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton sourceButton = (JButton) e.getSource();
            if (sourceButton.getText().equals("Make Reservation")) {
                String customerName = nameTextField.getText();
                String date = dateTextField.getText();
                String time = timeTextField.getText();
                String tableNumber = (String) tableComboBox.getSelectedItem();
                reservationModel.makeReservation(customerName, date, time, tableNumber);
                success.setText("Your reservation has been successfully confirmed.");
            } else if (sourceButton.getText().equals("View Reservation Information")) {
                String reservationInfo = reservationModel.getReservationInformation();
                textArea.append(reservationInfo);
            }
        }
    }

    public static void main(String[] args) {
        ReservationMenu reservation = new ReservationMenu();
        reservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
