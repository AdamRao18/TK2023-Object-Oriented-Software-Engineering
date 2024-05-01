public class Ticket {
    private String ticketId;
    private String bookingId;
    private String paymentType;
    private double price; // New field for price

    public Ticket(String ticketId, String bookingId, String paymentType, double price) {
        this.ticketId = ticketId;
        this.bookingId = bookingId;
        this.paymentType = paymentType;
        this.price = price;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getPaymentType() {
        return paymentType;
    }
    
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId + "\nBooking ID: " + bookingId + "\nPayment Type: " + paymentType +
               "\nPrice: RM" + String.format("%.2f", price); // Format price to two decimal places
    }
}
