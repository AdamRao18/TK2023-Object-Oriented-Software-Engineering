import java.util.ArrayList;

public class TicketModel {
    private ArrayList<Ticket> tickets;
    private int nextTicketId;

    public TicketModel() {
        tickets = new ArrayList<>();
        nextTicketId = 1;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public String generateTicketId() {
        String ticketId = "T" + String.format("%03d", nextTicketId);
        nextTicketId++;
        return ticketId;
    }
}

