import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TicketInfoView {
    private JFrame frame;
    private JComboBox<String> ticketIdComboBox;
    private JButton viewButton;
    private JTextArea detailsTextArea;

    private ArrayList<Ticket> tickets;
    private ArrayList<Booking> bookings;
    private JPanel panel;
    private JPanel panel_1;
    private JLabel lblNewLabel;
    private JPanel panel_2;
    private JLabel lblNewLabel_1;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;

    public TicketInfoView(ArrayList<Ticket> tickets, ArrayList<Booking> bookings) {
        this.tickets = tickets;
        this.bookings = bookings;
        

        frame = new JFrame("Ticket Information");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(422, 361);
        frame.setLocationRelativeTo(null);
        
        

        initComponents();
        populateTicketIdComboBox();
        

        frame.setVisible(true);
        
        

 
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Initialize Ticket ID ComboBox
        ticketIdComboBox = new JComboBox<>();
        populateTicketIdComboBox(); // Populate after initialization

        // TextArea for Details
        detailsTextArea = new JTextArea();
        detailsTextArea.setRows(8);
        detailsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(detailsTextArea);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        
        panel = new JPanel();
        mainPanel.add(panel, BorderLayout.NORTH);
                panel.setLayout(new BorderLayout(0, 0));
        
                // Ticket ID ComboBox
                panel.add(ticketIdComboBox, BorderLayout.SOUTH);
                
                panel_1 = new JPanel();
                panel_1.setBackground(Color.BLACK);
                panel.add(panel_1, BorderLayout.CENTER);
                
                lblNewLabel = new JLabel("Choose The Ticket: ");
                lblNewLabel.setForeground(Color.WHITE);
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
                panel_1.add(lblNewLabel);
                
                panel_2 = new JPanel();
                panel_2.setBackground(Color.BLACK);
                panel.add(panel_2, BorderLayout.NORTH);
                
                lblNewLabel_1 = new JLabel("Ticket View Information");
                lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
                lblNewLabel_1.setForeground(Color.WHITE);
                panel_2.add(lblNewLabel_1);
                
                panel_3 = new JPanel();
                panel_3.setBackground(Color.BLACK);
                mainPanel.add(panel_3, BorderLayout.CENTER);
                        panel_3.setLayout(null);
                
                        // View Button
                        viewButton = new JButton("View Ticket ");
                        viewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
                        viewButton.setBounds(96, 11, 180, 45);
                        panel_3.add(viewButton);
                        
                        JLabel lblNewLabel_2 = new JLabel("Ticket Information : ");
                        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
                        lblNewLabel_2.setForeground(Color.WHITE);
                        lblNewLabel_2.setBounds(10, 67, 134, 14);
                        panel_3.add(lblNewLabel_2);
                        
                        panel_4 = new JPanel();
                        panel_4.setBackground(Color.BLACK);
                        mainPanel.add(panel_4, BorderLayout.WEST);
                        
                        panel_5 = new JPanel();
                        panel_5.setBackground(Color.BLACK);
                        mainPanel.add(panel_5, BorderLayout.EAST);
                        
                                // ActionListener for View Button
                                viewButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        displayTicketDetails();
                                    }
                                });
    }


    private void populateTicketIdComboBox() {
        // Clear existing items
        ticketIdComboBox.removeAllItems();

        // Populate the combo box with ticket IDs
        for (Ticket ticket : tickets) {
            ticketIdComboBox.addItem(ticket.getTicketId());
        }
    }

    // New method to update the ticket list dynamically
    public void updateTicketList(ArrayList<Ticket> updatedTickets, ArrayList<Booking> updatedBookings) {
        this.tickets = updatedTickets;
        this.bookings = updatedBookings;
        populateTicketIdComboBox();
    }


    private void displayTicketDetails() {
        String selectedTicketId = (String) ticketIdComboBox.getSelectedItem();

        // Find the selected ticket
        Ticket selectedTicket = null;
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId().equals(selectedTicketId)) {
                selectedTicket = ticket;
                break;
            }
        }

        if (selectedTicket != null) {
            // Display Ticket details
            StringBuilder details = new StringBuilder("Ticket Details:\n");
            details.append(selectedTicket.toString()).append("\n\n");

            // Find corresponding Booking details
            for (Booking booking : bookings) {
                if (booking.getBookingId().equals(selectedTicket.getBookingId())) {
                    details.append("Booking Details:\n");
                    details.append(bookingDetailsToString(booking));
                    break;
                }
            }

            detailsTextArea.setText(details.toString());
        } else {
            detailsTextArea.setText("Ticket not found.");
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    private String bookingDetailsToString(Booking booking) {
        return String.format("Booking ID: %s%nOrigin: %s%nDestination: %s%nDepart Date: %s%nTime Departure: %s%n" +
                        "Seat Reserved: %d%nBus ID: %s%nBus Company: %s",
                booking.getBookingId(), booking.getOrigin(), booking.getDestination(), booking.getDepartDate(),
                booking.getTimeDeparture(), booking.getSeatNumber(), booking.getBusId(), booking.getBusCompany());
    }

    
}
