import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    private MainMenuView mainMenuView;
    private BookingModel bookingModel;
    private BookingView bookingView;
    private LoginView loginView;
    private LoginModel loginModel;
    private UserSelect userSelect;
    private BusManagementView view;
    private TicketModel ticketModel;
    private PaymentView paymentView;
    private TicketInfoView ticketInfoView;
    private FeedbackView feedbackView;
    private static MainController instance;
    
    
    
    private List<Bus> buses;

    public MainController() {
        mainMenuView = new MainMenuView();
        bookingModel = new BookingModel();
        loginModel = new LoginModel();
        userSelect = new UserSelect();
        loginView = new LoginView();
        ticketModel = new TicketModel();
        feedbackView = null;
        paymentView = new PaymentView(bookingModel.getBookings(), ticketModel, bookingModel);
        paymentView.addPaymentButtonListener(new PaymentButtonListener());
        userSelect.addUserSelectListener(new UserSelectListener());
        mainMenuView.addUserFeedbackButtonListener(new UserFeedbackButtonListener());
        mainMenuView.addUserButtonListener(new UserButtonListener());
        
        buses = new ArrayList<>();
        view = new BusManagementView();
        

        // Sample data for testing
        buses.add(new Bus("001", "Encik Ariff", "Encik Aiman", "Johor", "Terminal Bersepadu Selatan",
                "2024-02-10", "12:00 PM", "3:00 PM", 50, "JohorStarline"));
        buses.add(new Bus("002", "Encik Prasad", "Encik John", "Selangor", "Terminal Larkin",
                "2024-02-11", "01:00 PM", "4:30PM", 40, "REDBUS"));
        buses.add(new Bus("003", "Encik Lee", "Encik Seo", "Pulau Pinang", "Terminal Seremban",
                "2024-02-11", "01:00 PM", "7:00PM", 40, "PenangCruise"));

        
    }


    private class UserSelectListener implements UserSelect.UserSelectListener {
        @Override
        public void onCustomerSelected() {
            // Handle Customer button click
            showMainMenuView();
            userSelect.setVisible(false);
           
        }

        @Override
        public void onStaffSelected() {
            // Handle Staff button click
            showLoginView();
            userSelect.setVisible(false);
           
        }
    }

    
    
    
    private class PaymentButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            showPaymentView();
        }
    }

    public void showPaymentView() {
        // Check if there are bookings available
        if (bookingModel.hasBookings()) {
            ArrayList<Booking> bookings = bookingModel.getBookings(); // Retrieve bookings
            paymentView = new PaymentView(bookings, ticketModel, bookingModel); // Pass bookings to PaymentView
            paymentView.createAndShowGUI();
        } else {
            JOptionPane.showMessageDialog(
                    mainMenuView.getFrame(),
                    "Please book a bus first.",
                    "No Booking Found",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
    
    private class UserButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Show UserSelect view
            userSelect.setVisible(true);
            // Close MainMenuView
            mainMenuView.getFrame().dispose();
        }
    }




    // Add a method to handle the payment process
    private void handlePayment(String selectedBookingId, String selectedPaymentType) {
        if (selectedBookingId == null || selectedPaymentType == null) {
            JOptionPane.showMessageDialog(paymentView.getFrame(), "Please select a Booking ID and Payment Type.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Retrieve the seat number from the selected booking
        int seatNumber = getSeatNumberFromBooking(selectedBookingId);

        // Calculate the price based on the seat number (assuming RM20 per seat)
        double price = seatNumber * 20.0;

        // Generate a unique ticket ID
        String ticketId = ticketModel.generateTicketId();

        // Create a new Ticket with the calculated price
        Ticket ticket = new Ticket(ticketId, selectedBookingId, selectedPaymentType, price);

        // Add the Ticket to the list
        ticketModel.addTicket(ticket);

        // Update the ticket list in the PaymentView
        paymentView.updateTicketList();

        // Optionally, you can perform other actions like updating the Booking model, etc.
    }

    private int getSeatNumberFromBooking(String bookingId) {
        // Implement logic to retrieve seat number from the Booking model
        // Use the provided bookingModel instance
        return bookingModel.getSeatNumberForBooking(bookingId);
    }


    
    private void showLoginView() {
        loginView = new LoginView();
        loginView.createAndShowGUI();
        loginView.addLoginButtonListener(new LoginButtonListener());
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Validate login details
            String username = loginView.getUsername();
            String password = new String(loginView.getPassword());

            if (loginModel.validateUser(username, password)) {
                loginView.closeWindow();
                showBusManagementView(); // Change to showBusManagementView
            } else {
                JOptionPane.showMessageDialog(loginView.getFrame(),
                        "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }


    private class BookingBusButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            showBusBookingView();
        }
    }

    private class TicketViewButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            showTicketInfoView();
        }
    }
    
    private void showTicketInfoView() {
        // Check if ticketInfoView is already initialized
        if (ticketInfoView == null) {
            ticketInfoView = new TicketInfoView(ticketModel.getTickets(), bookingModel.getBookings());
        } else {
            // Update ticket list dynamically
            ticketInfoView.updateTicketList(ticketModel.getTickets(), bookingModel.getBookings());
        }
        // Ensure that the frame is set to visible
        ticketInfoView.getFrame().setVisible(true);
    }


    
    

    private class UserFeedbackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (feedbackView == null) {
                feedbackView = new FeedbackView(buses);
                feedbackView.addSubmitButtonListener(new SubmitButtonListener());
            }
            feedbackView.createAndShowGUI();
        }
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String busId = feedbackView.getSelectedBusId();
            String name = feedbackView.getName();
            String email = feedbackView.getEmail();
            int starScale = feedbackView.getStarScale();
            String feedbackText = feedbackView.getFeedback();

            // Create Feedback object
            Feedback feedback = new Feedback(busId, name, email, starScale, feedbackText);

            // Add feedback to the list
            feedbackView.addFeedbackToList(feedback);

            // Clear fields after submission
            feedbackView.clearFields();
        }
    }

    
   
    

    private class BookButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Booking newBooking = bookingView.getBookingDetails();

            if (newBooking != null) {
                String bookingIdString = bookingModel.generateBookingId();
                newBooking.setBookingId(bookingIdString);
                bookingModel.addBooking(newBooking);

                JOptionPane.showMessageDialog(bookingView.getFrame(),
                        "Booking successful! Booking ID: " + bookingIdString,
                        "Booking Confirmation", JOptionPane.INFORMATION_MESSAGE);

                ArrayList<Booking> bookings = bookingModel.getBookings();
                bookingView.updateBookingList(bookings);
            }
        }
    }

    public void showMainMenuView() {
        mainMenuView.createAndShowGUI();

        mainMenuView.addBookingBusButtonListener(new BookingBusButtonListener());
        mainMenuView.addTicketViewButtonListener(new TicketViewButtonListener());
        mainMenuView.addUserFeedbackButtonListener(new UserFeedbackButtonListener());
        
    }

    private void showBusBookingView() {
        // Check if there are buses available
        if (buses.isEmpty()) {
            JOptionPane.showMessageDialog(
                mainMenuView.getFrame(),
                "There are no buses available. Please add buses first.",
                "No Buses Available",
                JOptionPane.WARNING_MESSAGE
            );
        } else {
            if (bookingView == null) {
                bookingView = new BookingView(bookingModel, buses);
                bookingView.addPaymentButtonListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Handle the payment button click here.
                        showPaymentView(); // or call your payment handling logic
                    }
                });
                bookingView.createAndShowGUI();

                bookingView.addBookButtonListener(new BookButtonListener());
                
                // Add an ActionListener for the "MenuButton" in the BookingView
                bookingView.addMenuButtonListener(new MenuButtonListener());
            } else {
                // If the bookingView is already created, just bring it to the front
                bookingView.getFrame().setVisible(true);
            }
        }
    }

    
    private class MenuButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle the "MenuButton" click event here
            showMainMenuView();
            bookingView.getFrame().dispose();
        }
    }


    private void showTicketsView() {
        StringBuilder ticketsMessage = new StringBuilder("Tickets:\n");
        for (Booking booking : bookingModel.getBookings()) {
            ticketsMessage.append(bookingDetailsToString(booking)).append("\n");
        }
        JOptionPane.showMessageDialog(mainMenuView.getFrame(), ticketsMessage.toString(), "Ticket View", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showUserFeedbackView() {
        JOptionPane.showMessageDialog(mainMenuView.getFrame(),
                "User Feedback feature not implemented yet.",
                "User Feedback", JOptionPane.INFORMATION_MESSAGE);
    }

    private String bookingDetailsToString(Booking booking) {
        return String.format("Booking ID: %s%nOrigin: %s%nDestination: %s%nDepart Date: %s%nTime Departure: %s%nSeat Reserved: %d%nBus ID: %s%nBus Company: %s",
                booking.getBookingId(), booking.getOrigin(), booking.getDestination(), booking.getDepartDate(),
                booking.getTimeDeparture(), booking.getSeatNumber(), booking.getBusId(), booking.getBusCompany());
    }


    public void showUserSelectView() {
        userSelect.setVisible(true);
    }

    
    private void showBusManagementView() {
        view = new BusManagementView();  // Assuming you have an instance of BusManagementView
        view.updateBusList(buses);
        view.show();
    }
    
    public void addBus(Bus bus) {
        buses.add(bus);
        view.updateBusList(buses);
    }

    public void deleteBus(int index) {
        if (index >= 0 && index < buses.size()) {
            buses.remove(index);
            view.updateBusList(buses);
        }
    }

    public void editBus(int index, String newBusNumber, String newDriverName, String newCoDriverName,
                        String newOrigin, String newDirection, String newDepartureDate, String newTimeOfDeparture,
                        String newEta, int newTotalPassengers, String newBusCompany) {
        if (index >= 0 && index < buses.size()) {
            Bus bus = buses.get(index);
            bus.setBusNumber(newBusNumber);
            bus.setDriverName(newDriverName);
            bus.setCoDriverName(newCoDriverName);
            bus.setOrigin(newOrigin);
            bus.setDirection(newDirection);
            bus.setDepartureDate(newDepartureDate);
            bus.setTimeOfDeparture(newTimeOfDeparture);
            bus.setEta(newEta);
            bus.setTotalPassengers(newTotalPassengers);
            bus.setBusCompany(newBusCompany);
            view.updateBusList(buses);
        }
    }

    public Bus getBus(int index) {
        if (index >= 0 && index < buses.size()) {
            return buses.get(index);
        }
        return null;
    }

    public boolean hasBuses() {
        return !buses.isEmpty();
    }

    public void updateBusList() {
        view.updateBusList(buses);
    }
    
   
    
    public static void main(String[] args) {
        MainController mainController = MainController.getInstance();
        mainController.showUserSelectView();
    }

}