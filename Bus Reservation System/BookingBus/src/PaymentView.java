import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class PaymentView {
    private JFrame frame;
    private JComboBox<String> bookingIdComboBox;
    private JComboBox<String> paymentTypeComboBox;
    private JButton paymentButton;
    private JTextArea ticketListArea;
    private JLabel priceLabel; // Added price label
    private TicketModel ticketModel;
    private BookingModel bookingModel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JPanel panel_6;
    private JLabel lblNewLabel;
    private JPanel panel_7;
    private JPanel panel_8;

    public PaymentView(ArrayList<Booking> bookings, TicketModel ticketModel, BookingModel bookingModel) {
        // ... Existing code
        this.bookingModel = bookingModel;
        this.ticketModel = ticketModel; 
        frame = new JFrame("Payment");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(507, 431);
        frame.setLocationRelativeTo(null);
        
        priceLabel = new JLabel("Price: RM0.00");
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        priceLabel.setForeground(Color.WHITE);
        
     

        GridLayout gl_panel = new GridLayout(0, 2);
        gl_panel.setVgap(5);
        gl_panel.setHgap(5);
        JPanel panel = new JPanel(gl_panel);
        panel.setBackground(Color.BLACK);

        JLabel bookingIdLabel = new JLabel("Booking ID:");
        bookingIdLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        bookingIdLabel.setForeground(Color.WHITE);
        bookingIdComboBox = new JComboBox<>();
        // Add default "Please select" option
        bookingIdComboBox.addItem("Please select");
        for (Booking booking : bookings) {
            bookingIdComboBox.addItem(booking.getBookingId());
        }

        JLabel paymentTypeLabel = new JLabel("Payment Type:");
        paymentTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        paymentTypeLabel.setForeground(Color.WHITE);
        paymentTypeComboBox = new JComboBox<>();
        // Add default "Please select" option
        paymentTypeComboBox.addItem("Please select");
        paymentTypeComboBox.addItem("Card");
        paymentTypeComboBox.addItem("E-wallet");
        paymentTypeComboBox.addItem("Online Banking");

        panel.add(bookingIdLabel);
        panel.add(bookingIdComboBox);
        panel.add(paymentTypeLabel);
        panel.add(paymentTypeComboBox);
        panel.add(priceLabel);

        ticketListArea = new JTextArea();
        ticketListArea.setRows(6);
        ticketListArea.setText("Ticket List");
        ticketListArea.setColumns(18);
        ticketListArea.setTabSize(10);
        ticketListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(ticketListArea);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        
        
        panel_1 = new JPanel();
        panel_1.setBackground(Color.BLACK);
        frame.getContentPane().add(panel_1, BorderLayout.NORTH);
        
        lblNewLabel = new JLabel("Make A Payment");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.WHITE);
        panel_1.add(lblNewLabel);
        
        panel_2 = new JPanel();
        frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
        panel_2.setLayout(new BorderLayout(0, 0));
        
        panel_2.add(scrollPane);
        
        panel_3 = new JPanel();
        panel_3.setBackground(Color.BLACK);
        panel_2.add(panel_3, BorderLayout.NORTH);
        
                paymentButton = new JButton("Make Payment");
                paymentButton.setFont(new Font("Tahoma", Font.BOLD, 14));
                panel_3.add(paymentButton);
                
                panel_4 = new JPanel();
                panel_4.setBackground(Color.BLACK);
                panel_2.add(panel_4, BorderLayout.SOUTH);
                
                panel_5 = new JPanel();
                panel_5.setBackground(Color.BLACK);
                panel_2.add(panel_5, BorderLayout.WEST);
                
                panel_6 = new JPanel();
                panel_6.setBackground(Color.BLACK);
                panel_2.add(panel_6, BorderLayout.EAST);
                
                panel_7 = new JPanel();
                panel_7.setBackground(Color.BLACK);
                frame.getContentPane().add(panel_7, BorderLayout.WEST);
                
                panel_8 = new JPanel();
                panel_8.setBackground(Color.BLACK);
                frame.getContentPane().add(panel_8, BorderLayout.EAST);
                
                        paymentButton.addActionListener(e -> makePayment());
        
     // Add an ActionListener to bookingIdComboBox
        bookingIdComboBox.addActionListener(e -> updatePriceLabel());

        // Add an ActionListener to paymentTypeComboBox
        paymentTypeComboBox.addActionListener(e -> updatePriceLabel());
        
     // Add an ActionListener to bookingIdComboBox
        bookingIdComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePriceLabel();  // Update the price label when Booking ID is selected
            }
        });

        // Add an ActionListener to paymentTypeComboBox
        paymentTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePriceLabel();  // Update the price label when Payment Type is selected
            }
        });
    }

    public void createAndShowGUI() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    public void addPaymentButtonListener(ActionListener listener) {
        paymentButton.addActionListener(listener);
    }
    
    private void updatePriceLabel() {
        // Retrieve the selected Booking ID and Payment Type
        String selectedBookingId = (String) bookingIdComboBox.getSelectedItem();
        String selectedPaymentType = (String) paymentTypeComboBox.getSelectedItem();

        if (selectedBookingId != null && selectedPaymentType != null) {
            // Retrieve the seat number from the selected booking
            int seatNumber = getSeatNumberFromBooking(selectedBookingId);

            // Calculate the price based on the seat number (assuming RM20 per seat)
            double price = seatNumber * 20.0;

            // Update the price label
            priceLabel.setText("Price: RM" + String.format("%.2f", price));
        }
    }

    private void makePayment() {
        String selectedBookingId = (String) bookingIdComboBox.getSelectedItem();
        String selectedPaymentType = (String) paymentTypeComboBox.getSelectedItem();

        if ("Please select".equals(selectedBookingId) || "Please select".equals(selectedPaymentType)) {
            JOptionPane.showMessageDialog(frame, "Please select a valid Booking ID and Payment Type.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int seatNumber = getSeatNumberFromBooking(selectedBookingId);
        double price = seatNumber * 20.0;
        priceLabel.setText("Price: RM" + String.format("%.2f", price));

        String ticketId = ticketModel.generateTicketId();
        Ticket ticket = new Ticket(ticketId, selectedBookingId, selectedPaymentType, price);
        ticketModel.addTicket(ticket); // Add the ticket to the TicketModel
        updateTicketList();

        JOptionPane.showMessageDialog(frame, "Payment successful!\nTicket ID: " + ticketId, "Payment Success", JOptionPane.INFORMATION_MESSAGE);
        
    }

    
    private int getSeatNumberFromBooking(String bookingId) {
        // Implement logic to retrieve seat number from the Booking model
        // You might need to modify the Booking model to store seat numbers
        // For now, a placeholder method is used, assuming seat numbers are stored in Booking model
        return bookingModel.getSeatNumberForBooking(bookingId);
    }

    public void updateTicketList() {
        ticketListArea.setText("");
        for (Ticket ticket : ticketModel.getTickets()) {
            ticketListArea.append(ticket.toString() + "\n\n");
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}