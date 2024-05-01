public class Booking {
    private String bookingId;
    private String origin;
    private String destination;
    private String departDate;
    private String timeDeparture;
    private int seatNumber;
    private String busId;  // Change variable name to busId
    private String busCompany;

    public Booking(String origin, String destination, String departDate, String timeDeparture, int seatNumber, String busId, String busCompany) {
        this.origin = origin;
        this.destination = destination;
        this.departDate = departDate;
        this.timeDeparture = timeDeparture;
        this.seatNumber = seatNumber;
        this.busId = busId;
        this.busCompany = busCompany;  // Set busCompany directly in the constructor
    }

    public String getBookingId() {
        return bookingId;
    }
    
    public String getBusCompany() {
        return busCompany;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartDate() {
        return departDate;
    }

    public String getTimeDeparture() {
        return timeDeparture;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getBusId() {
        return busId;  // Change variable name to busId
    }
}
