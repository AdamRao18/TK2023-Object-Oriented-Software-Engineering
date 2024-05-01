import java.util.ArrayList;

public class BookingModel {
    private ArrayList<Booking> bookings;
    private int nextBookingId;

    public BookingModel() {
        bookings = new ArrayList<>();
        nextBookingId = 1;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }
    public boolean hasBookings() {
        return !bookings.isEmpty();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
    
    public int getSeatNumberForBooking(String bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                return booking.getSeatNumber();
            }
        }
        return 0; // Return a default value if bookingId is not found
    }

    public String generateBookingId() {
        String bookingId = "B" + String.format("%03d", nextBookingId);
        nextBookingId++;
        return bookingId;
    }
}
