// AddBusWindow class
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBusWindow {
    private JFrame frame;
    private JTextField busNumberField;
    private JTextField driverNameField;
    private JTextField coDriverNameField;
    private JTextField originField;
    private JTextField directionField;
    private JTextField departureDateField;
    private JTextField timeOfDepartureField;
    private JTextField etaField;
    private JTextField totalPassengersField;
    private JTextField busCompanyField;

    public AddBusWindow() {
        frame = new JFrame("Add Bus");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 530);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));

        JLabel busNumberLabel = new JLabel("Bus Number:");
        busNumberLabel.setBounds(44, 71, 128, 26);
        busNumberLabel.setForeground(new Color(255, 255, 255));
        busNumberField = new JTextField();
        busNumberField.setBounds(231, 72, 128, 26);

        JLabel driverNameLabel = new JLabel("Driver Name:");
        driverNameLabel.setBounds(44, 108, 128, 26);
        driverNameLabel.setForeground(new Color(255, 255, 255));
        driverNameField = new JTextField();
        driverNameField.setBounds(231, 108, 128, 26);

        JLabel coDriverNameLabel = new JLabel("Co-Driver Name:");
        coDriverNameLabel.setBounds(44, 143, 128, 26);
        coDriverNameLabel.setForeground(new Color(255, 255, 255));
        coDriverNameField = new JTextField();
        coDriverNameField.setBounds(231, 144, 128, 26);

        JLabel originLabel = new JLabel("Origin:");
        originLabel.setBounds(44, 179, 128, 26);
        originLabel.setForeground(new Color(255, 255, 255));
        originField = new JTextField();
        originField.setBounds(231, 180, 128, 26);

        JLabel directionLabel = new JLabel("Direction:");
        directionLabel.setBounds(44, 215, 128, 26);
        directionLabel.setForeground(new Color(255, 255, 255));
        directionField = new JTextField();
        directionField.setBounds(231, 216, 128, 26);

        JLabel departureDateLabel = new JLabel("Departure Date:");
        departureDateLabel.setBounds(44, 251, 128, 26);
        departureDateLabel.setForeground(new Color(255, 255, 255));
        departureDateField = new JTextField();
        departureDateField.setBounds(231, 252, 128, 26);

        JLabel timeOfDepartureLabel = new JLabel("Time of Departure:");
        timeOfDepartureLabel.setBounds(44, 287, 128, 26);
        timeOfDepartureLabel.setForeground(new Color(255, 255, 255));
        timeOfDepartureField = new JTextField();
        timeOfDepartureField.setBounds(231, 288, 128, 26);

        JLabel etaLabel = new JLabel("ETA:");
        etaLabel.setBounds(44, 323, 128, 26);
        etaLabel.setForeground(new Color(255, 255, 255));
        etaField = new JTextField();
        etaField.setBounds(231, 324, 128, 26);

        JLabel totalPassengersLabel = new JLabel("Total Passengers:");
        totalPassengersLabel.setBounds(44, 359, 128, 26);
        totalPassengersLabel.setForeground(new Color(255, 255, 255));
        totalPassengersField = new JTextField();
        totalPassengersField.setBounds(231, 360, 128, 26);

        JLabel busCompanyLabel = new JLabel("Bus Company:");
        busCompanyLabel.setBounds(44, 395, 128, 26);
        busCompanyLabel.setForeground(new Color(255, 255, 255));
        busCompanyField = new JTextField();
        busCompanyField.setBounds(231, 396, 128, 26);
        panel.setLayout(null);

        panel.add(busNumberLabel);
        panel.add(busNumberField);
        panel.add(driverNameLabel);
        panel.add(driverNameField);
        panel.add(coDriverNameLabel);
        panel.add(coDriverNameField);
        panel.add(originLabel);
        panel.add(originField);
        panel.add(directionLabel);
        panel.add(directionField);
        panel.add(departureDateLabel);
        panel.add(departureDateField);
        panel.add(timeOfDepartureLabel);
        panel.add(timeOfDepartureField);
        panel.add(etaLabel);
        panel.add(etaField);
        panel.add(totalPassengersLabel);
        panel.add(totalPassengersField);
        panel.add(busCompanyLabel);
        panel.add(busCompanyField);

        frame.getContentPane().add(panel);
        
                JButton addButton = new JButton("Add Bus");
                addButton.setBackground(new Color(0, 255, 0));
                addButton.setBounds(56, 445, 128, 26);
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addBus();
                    }
                });
                panel.add(addButton);
                
                        JButton cancelButton = new JButton("Cancel");
                        cancelButton.setBackground(new Color(255, 0, 0));
                        cancelButton.setBounds(207, 445, 128, 26);
                        cancelButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                            }
                        });
                        panel.add(cancelButton);
                        
                        JLabel lblNewLabel = new JLabel("Add Bus");
                        lblNewLabel.setForeground(new Color(255, 255, 255));
                        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
                        lblNewLabel.setBounds(144, 10, 113, 36);
                        panel.add(lblNewLabel);
        frame.setVisible(true);
    }

    private void addBus() {
        String busNumber = busNumberField.getText().trim();
        String driverName = driverNameField.getText().trim();
        String coDriverName = coDriverNameField.getText().trim();
        String origin = originField.getText().trim();
        String direction = directionField.getText().trim();
        String departureDate = departureDateField.getText().trim();
        String timeOfDeparture = timeOfDepartureField.getText().trim();
        String eta = etaField.getText().trim();

        int totalPassengers;
        try {
            totalPassengers = Integer.parseInt(totalPassengersField.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid value for Total Passengers.");
            return;
        }

        String busCompany = busCompanyField.getText().trim();

        Bus newBus = new Bus(busNumber, driverName, coDriverName, origin, direction,
                departureDate, timeOfDeparture, eta, totalPassengers, busCompany);

        MainController.getInstance().addBus(newBus);
        frame.dispose();
    }
}