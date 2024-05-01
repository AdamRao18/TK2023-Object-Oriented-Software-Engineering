public class Bus {
    private String busNumber;
    private String driverName;
    private String coDriverName;
    private String origin;
    private String direction;
    private String departureDate;
    private String timeOfDeparture;
    private String eta;
    private int totalPassengers;
    private String busCompany;

    public Bus(String busNumber, String driverName, String coDriverName, String origin,
               String direction, String departureDate, String timeOfDeparture, String eta,
               int totalPassengers, String busCompany) {
        this.busNumber = busNumber;
        this.driverName = driverName;
        this.coDriverName = coDriverName;
        this.origin = origin;
        this.direction = direction;
        this.departureDate = departureDate;
        this.timeOfDeparture = timeOfDeparture;
        this.eta = eta;
        this.totalPassengers = totalPassengers;
        this.busCompany = busCompany;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCoDriverName() {
        return coDriverName;
    }

    public void setCoDriverName(String coDriverName) {
        this.coDriverName = coDriverName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(String timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public int getTotalPassengers() {
        return totalPassengers;
    }

    public void setTotalPassengers(int totalPassengers) {
        this.totalPassengers = totalPassengers;
    }

    public String getBusCompany() {
        return busCompany;
    }

    public void setBusCompany(String busCompany) {
        this.busCompany = busCompany;
    }
}