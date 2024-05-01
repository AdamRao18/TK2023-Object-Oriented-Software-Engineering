import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;


public class BookingView {
	private JFrame frame;
	private JComboBox<String> originComboBox;
	private JComboBox<String> destinationComboBox;
	private JTextField seatNumberField;
	private JComboBox<String> departDateComboBox;  // Changed to JComboBox
    private JComboBox<String> timeDepartureComboBox;  // Changed to JComboBox
    private JComboBox<String> busIdComboBox;  // Changed to JComboBox
    private JComboBox<String> busCompanyComboBox;  // Changed to JComboBox
	private JButton bookButton;
	private JTextArea bookingListArea;
	private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JPanel panel_6;
    private JPanel panel_7;
    private JPanel panel_8;
    private JPanel panel_9;

    private BookingModel bookingModel;  // Reference to BusModel
    private List<Bus> buses; 
    private JLabel lblNewLabel;
    private JButton MenuButton;
    private JButton PaymentButton;
    

    public BookingView(BookingModel bookingModel, List<Bus> buses) {
        this.bookingModel = bookingModel;
        this.buses = buses;
        frame = new JFrame("Bus Booking");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(746, 575);
        frame.setLocationRelativeTo(null);

        GridLayout gl_panel = new GridLayout(0, 2);
        gl_panel.setHgap(2);
        gl_panel.setVgap(10);
        JPanel panel = new JPanel(gl_panel);
        panel.setBackground(Color.BLACK);

        JLabel originLabel = new JLabel("Origin:");
        originLabel.setForeground(Color.WHITE);
        originLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        originComboBox = new JComboBox<>(getUniqueOrigins());
        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setForeground(Color.WHITE);
        destinationLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        destinationComboBox = new JComboBox<>(getUniqueDestinations());
        JLabel departDateLabel = new JLabel("Departure Date:");
        departDateLabel.setForeground(Color.WHITE);
        departDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        departDateComboBox = new JComboBox<>(); 
        JLabel timeDepartureLabel = new JLabel("Time Departure:");
        timeDepartureLabel.setForeground(Color.WHITE);
        timeDepartureLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        timeDepartureComboBox = new JComboBox<>();
        JLabel seatNumberLabel = new JLabel("Seat Reserved (1-4 Seat Only)");
        seatNumberLabel.setForeground(Color.WHITE);
        seatNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        seatNumberField = new JTextField();
        seatNumberField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        busIdComboBox = new JComboBox<>();
        busCompanyComboBox = new JComboBox<>();
        
        originComboBox.addActionListener(e -> {
            String selectedOrigin = (String) originComboBox.getSelectedItem();
            String selectedDestination = (String) destinationComboBox.getSelectedItem();
            updateComboBoxes(selectedOrigin, selectedDestination);
        });

        destinationComboBox.addActionListener(e -> {
            String selectedOrigin = (String) originComboBox.getSelectedItem();
            String selectedDestination = (String) destinationComboBox.getSelectedItem();
            updateComboBoxes(selectedOrigin, selectedDestination);
        });

        panel.add(originLabel);
        panel.add(originComboBox);
        panel.add(destinationLabel);
        panel.add(destinationComboBox);
        panel.add(departDateLabel);
        panel.add(departDateComboBox);
        panel.add(timeDepartureLabel);
        panel.add(timeDepartureComboBox);
        panel.add(seatNumberLabel);
        panel.add(seatNumberField);
        JLabel busIdLabel = new JLabel("Bus ID:");  // Change label text to "Bus ID"
        busIdLabel.setForeground(Color.WHITE);
        busIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(busIdLabel);
        panel.add(busIdComboBox);
        JLabel busCompanyLabel = new JLabel("Bus Company:");
        busCompanyLabel.setForeground(Color.WHITE);
        busCompanyLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(busCompanyLabel);
        panel.add(busCompanyComboBox);

        frame.getContentPane().add(BorderLayout.CENTER, panel);

        panel_1 = new JPanel();
        panel_1.setBackground(Color.BLACK);
        frame.getContentPane().add(panel_1, BorderLayout.NORTH);
        
        lblNewLabel = new JLabel("Lets! Booking Bus");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.WHITE);
        panel_1.add(lblNewLabel);

        panel_2 = new JPanel();
        frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
        panel_2.setLayout(new BorderLayout(0, 0));

        panel_5 = new JPanel();
        panel_5.setBackground(Color.BLACK);
        FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
        flowLayout.setHgap(0);
        panel_2.add(panel_5, BorderLayout.NORTH);

        bookButton = new JButton("Book Bus");
        bookButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel_5.add(bookButton);

        panel_6 = new JPanel();
        panel_6.setBackground(Color.BLACK);
        panel_2.add(panel_6);
        panel_6.setLayout(new BorderLayout(0, 0));

        // Add a JTextArea for displaying the booking list inside panel_6
        JLabel label = new JLabel("Booking List:");
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setVerticalAlignment(SwingConstants.TOP);
        panel_6.add(label, BorderLayout.NORTH);

        bookingListArea = new JTextArea();
        bookingListArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        bookingListArea.setRows(8);
        bookingListArea.setEditable(false);
        bookingListArea.setTabSize(20);
        JScrollPane scrollPane = new JScrollPane(bookingListArea);
        panel_6.add(scrollPane);

        panel_7 = new JPanel();
        panel_7.setBackground(Color.BLACK);
        panel_2.add(panel_7, BorderLayout.SOUTH);
        
        MenuButton = new JButton("Menu");
        MenuButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel_7.add(MenuButton);
        
        PaymentButton = new JButton("Make Payment");
        PaymentButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel_7.add(PaymentButton);

        panel_8 = new JPanel();
        panel_8.setBackground(Color.BLACK);
        panel_2.add(panel_8, BorderLayout.WEST);

        panel_9 = new JPanel();
        panel_9.setBackground(Color.BLACK);
        panel_2.add(panel_9, BorderLayout.EAST);

        panel_3 = new JPanel();
        panel_3.setBackground(Color.BLACK);
        frame.getContentPane().add(panel_3, BorderLayout.WEST);

        panel_4 = new JPanel();
        panel_4.setBackground(Color.BLACK);
        frame.getContentPane().add(panel_4, BorderLayout.EAST);
        
        originComboBox.setSelectedItem("Please select");
        destinationComboBox.setSelectedItem("Please select");
        
        
    }

    public void createAndShowGUI() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    public void addBookButtonListener(ActionListener listener) {
        bookButton.addActionListener(listener);

        
    }
    
    public void addMenuButtonListener(ActionListener listener) {
        MenuButton.addActionListener(listener);
    }
    
    public JButton getMenuButton() {
        return MenuButton;
    }

    public Booking getBookingDetails() {
        String selectedOrigin = getSelectedOrigin();
        String selectedDestination = getSelectedDestination();
        String departDate = (String) departDateComboBox.getSelectedItem();
        String timeDeparture = (String) timeDepartureComboBox.getSelectedItem();
        String seatNumberStr = seatNumberField.getText().trim(); // Trim any leading/trailing whitespace

        // Check if the selected origin and destination are valid
        if ("Please select".equals(selectedOrigin) || "Please select".equals(selectedDestination)) {
            JOptionPane.showMessageDialog(frame, "Please select a valid Origin and Destination.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Check if the seat number is empty or not a number
        if (departDate == null || timeDeparture == null || seatNumberStr.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try {
            int seatNumber = Integer.parseInt(seatNumberStr);

            // Check if the seat number is within the valid range (1-4)
            if (seatNumber < 1 || seatNumber > 4) {
                JOptionPane.showMessageDialog(frame, "Invalid seat number. Please enter a number between 1 and 4.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            String busId = (String) busIdComboBox.getSelectedItem();
            String busCompany = (String) busCompanyComboBox.getSelectedItem();

            return new Booking(selectedOrigin, selectedDestination, departDate, timeDeparture, seatNumber, busId, busCompany);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid seat number. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }



   

    public void updateBookingList(ArrayList<Booking> bookings) {
        bookingListArea.setText("");
        for (Booking booking : bookings) {
            bookingListArea.append(bookingDetailsToString(booking) + "\n");
        }
    }

    private String bookingDetailsToString(Booking booking) {
        return String.format("Booking ID: %s%nOrigin: %s%nDestination: %s%nDepart Date: %s%nTime Departure: %s%nSeat Reserved: %d%nBus ID: %s%nBus Company: %s",
                booking.getBookingId(), booking.getOrigin(), booking.getDestination(), booking.getDepartDate(),
                booking.getTimeDeparture(), booking.getSeatNumber(), booking.getBusId(), booking.getBusCompany());
    }

    public String getSelectedOrigin() {
        return (String) originComboBox.getSelectedItem();
    }

    public String getSelectedDestination() {
        return (String) destinationComboBox.getSelectedItem();
    }

 // Modify the getUniqueOrigins method
    private String[] getUniqueOrigins() {
        Set<String> uniqueOrigins = new LinkedHashSet<>();  // Use LinkedHashSet to maintain order of insertion
        uniqueOrigins.add("Please select");  // Add "Please select" option
        for (Bus bus : buses) {
            uniqueOrigins.add(bus.getOrigin());
        }
        return uniqueOrigins.toArray(new String[0]);
    }

    // Modify the getUniqueDestinations method
    private String[] getUniqueDestinations() {
        Set<String> uniqueDestinations = new LinkedHashSet<>();  // Use LinkedHashSet to maintain order of insertion
        uniqueDestinations.add("Please select");  // Add "Please select" option
        for (Bus bus : buses) {
            uniqueDestinations.add(bus.getDirection());
        }
        return uniqueDestinations.toArray(new String[0]);
    }


    private void updateComboBoxes(String selectedOrigin, String selectedDestination) {
        // Filter buses based on selected origin and destination
        List<Bus> filteredBuses = filterBusesByOriginAndDestination(selectedOrigin, selectedDestination);

        // Update departDateComboBox, timeDepartureComboBox, busIdComboBox, and busCompanyComboBox
        departDateComboBox.removeAllItems();
        timeDepartureComboBox.removeAllItems();
        busIdComboBox.removeAllItems();
        busCompanyComboBox.removeAllItems();

        Set<String> uniqueDepartureDates = new LinkedHashSet<>();
        for (Bus bus : filteredBuses) {
            uniqueDepartureDates.add(bus.getDepartureDate());
            timeDepartureComboBox.addItem(bus.getTimeOfDeparture());
            busIdComboBox.addItem(bus.getBusNumber());
            busCompanyComboBox.addItem(bus.getBusCompany());
        }
        
        // Add unique departure dates to departDateComboBox
        for (String departureDate : uniqueDepartureDates) {
            departDateComboBox.addItem(departureDate);
        }

        // Check if departDateComboBox has any items, and select the first item if available
        if (departDateComboBox.getItemCount() > 0) {
            departDateComboBox.setSelectedIndex(0);
        }
    }

    
    private List<Bus> filterBusesByOriginAndDestination(String selectedOrigin, String selectedDestination) {
        List<Bus> filteredBuses = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getOrigin().equals(selectedOrigin) && bus.getDirection().equals(selectedDestination)) {
                filteredBuses.add(bus);
            }
        }
        return filteredBuses;
    }
    public void addPaymentButtonListener(ActionListener listener) {
        PaymentButton.addActionListener(listener);
    }

    public JFrame getFrame() {
        return frame;
    }
}
