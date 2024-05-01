// EditBusWindow class
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditBusWindow {
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

    private Bus bus;

    public EditBusWindow(Bus bus) {
        this.bus = bus;

        frame = new JFrame("Edit Bus");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(394, 517);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));

        JLabel busNumberLabel = new JLabel("Bus Number:");
        busNumberLabel.setBounds(39, 51, 128, 27);
        busNumberLabel.setForeground(new Color(255, 255, 255));
        busNumberField = new JTextField();
        busNumberField.setBounds(214, 51, 128, 27);

        JLabel driverNameLabel = new JLabel("Driver Name:");
        driverNameLabel.setBounds(39, 88, 128, 27);
        driverNameLabel.setForeground(new Color(255, 255, 255));
        driverNameField = new JTextField();
        driverNameField.setBounds(214, 88, 128, 27);

        JLabel coDriverNameLabel = new JLabel("Co-Driver Name:");
        coDriverNameLabel.setBounds(39, 121, 128, 27);
        coDriverNameLabel.setForeground(new Color(255, 255, 255));
        coDriverNameField = new JTextField();
        coDriverNameField.setBounds(214, 121, 128, 27);

        JLabel originLabel = new JLabel("Origin:");
        originLabel.setBounds(39, 158, 128, 27);
        originLabel.setForeground(new Color(255, 255, 255));
        originField = new JTextField();
        originField.setBounds(214, 158, 128, 27);

        JLabel directionLabel = new JLabel("Direction:");
        directionLabel.setBounds(39, 195, 128, 27);
        directionLabel.setForeground(new Color(255, 255, 255));
        directionField = new JTextField();
        directionField.setBounds(214, 195, 128, 27);

        JLabel departureDateLabel = new JLabel("Departure Date:");
        departureDateLabel.setBounds(39, 232, 128, 27);
        departureDateLabel.setForeground(new Color(255, 255, 255));
        departureDateField = new JTextField();
        departureDateField.setBounds(214, 232, 128, 27);

        JLabel timeOfDepartureLabel = new JLabel("Time of Departure:");
        timeOfDepartureLabel.setBounds(39, 269, 128, 27);
        timeOfDepartureLabel.setForeground(new Color(255, 255, 255));
        timeOfDepartureField = new JTextField();
        timeOfDepartureField.setBounds(214, 269, 128, 27);

        JLabel etaLabel = new JLabel("ETA:");
        etaLabel.setBounds(39, 306, 128, 27);
        etaLabel.setForeground(new Color(255, 255, 255));
        etaField = new JTextField();
        etaField.setBounds(214, 306, 128, 27);

        JLabel totalPassengersLabel = new JLabel("Total Passengers:");
        totalPassengersLabel.setBounds(39, 343, 128, 27);
        totalPassengersLabel.setForeground(new Color(255, 255, 255));
        totalPassengersField = new JTextField();
        totalPassengersField.setBounds(214, 343, 128, 27);

        JLabel busCompanyLabel = new JLabel("Bus Company:");
        busCompanyLabel.setBounds(39, 380, 128, 27);
        busCompanyLabel.setForeground(new Color(255, 255, 255));
        busCompanyField = new JTextField();
        busCompanyField.setBounds(214, 380, 128, 27);

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(new Color(0, 255, 0));
        saveButton.setBounds(58, 432, 128, 27);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveBus();
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(255, 0, 0));
        cancelButton.setBounds(196, 432, 128, 27);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
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
        panel.add(saveButton);
        panel.add(cancelButton);

        frame.getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("BUS EDITOR");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(129, 10, 122, 31);
        panel.add(lblNewLabel);
        populateFields();
        frame.setVisible(true);
    }

    private void populateFields() {
        if (bus != null) {
            busNumberField.setText(bus.getBusNumber());
            driverNameField.setText(bus.getDriverName());
            coDriverNameField.setText(bus.getCoDriverName());
            originField.setText(bus.getOrigin());
            directionField.setText(bus.getDirection());
            departureDateField.setText(bus.getDepartureDate());
            timeOfDepartureField.setText(bus.getTimeOfDeparture());
            etaField.setText(bus.getEta());
            totalPassengersField.setText(String.valueOf(bus.getTotalPassengers()));
            busCompanyField.setText(bus.getBusCompany());
        }
    }

    private void saveBus() {
        // Update the bus object with the new values
        bus.setBusNumber(busNumberField.getText().trim());
        bus.setDriverName(driverNameField.getText().trim());
        bus.setCoDriverName(coDriverNameField.getText().trim());
        bus.setOrigin(originField.getText().trim());
        bus.setDirection(directionField.getText().trim());
        bus.setDepartureDate(departureDateField.getText().trim());
        bus.setTimeOfDeparture(timeOfDepartureField.getText().trim());
        bus.setEta(etaField.getText().trim());

        try {
            int passengers = Integer.parseInt(totalPassengersField.getText().trim());
            bus.setTotalPassengers(passengers);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid value for Total Passengers.");
            return;
        }

        bus.setBusCompany(busCompanyField.getText().trim());

        MainController.getInstance().updateBusList();
        frame.dispose();
    }
}