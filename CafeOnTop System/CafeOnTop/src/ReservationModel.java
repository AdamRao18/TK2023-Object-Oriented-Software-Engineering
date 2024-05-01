public class ReservationModel {
    private String customerName;
    private String date;
    private String time;
    private String tableNumber;

    public void makeReservation(String customerName, String date, String time, String tableNumber) {
        this.customerName = customerName;
        this.date = date;
        this.time = time;
        this.tableNumber = tableNumber;
    }

    public String getReservationInformation() {
        return "Reservation Information: \n\nCustomer Name: " + customerName + "\nDate: " + date +
                "\nTime: " + time + "\nTable Number: " + tableNumber;
    }
}
