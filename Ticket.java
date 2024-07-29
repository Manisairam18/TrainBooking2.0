package Trainbooking2;

// Enum for Ticket Status
enum TicketStatuss {
    BOOKED, CANCELLED, AVAILABLE
}

public class Ticket {
    private static int pnrGenerator = 1; // Static counter for generating PNR numbers

    private final int pnrNumber = pnrGenerator++; // Unique PNR number for each ticket
    private final char source; // Source station
    private final char destination; // Destination station
    private int seats; // Number of seats booked
    private TicketStatus ticketStatus; // Status of the ticket (e.g., booked, cancelled)

    /**
     * Constructor to initialize a Ticket object.
     *
     * @param source The source station of the ticket.
     * @param destination The destination station of the ticket.
     * @param seats The number of seats booked.
     * @param ticketStatus The status of the ticket (BOOKED, CANCELLED, etc.).
     */
    Ticket(char source, char destination, int seats, TicketStatus ticketStatus) {
        this.source = source;
        this.destination = destination;
        this.seats = seats;
        this.ticketStatus = ticketStatus;
    }

    // Getter for source station
    public char getSource() {
        return source;
    }

    // Getter for destination station
    public char getDestination() {
        return destination;
    }

    // Getter for number of seats
    public int getSeats() {
        return seats;
    }

    // Getter for PNR number
    public int getPnrNumber() {
        return pnrNumber;
    }

    // Setter for number of seats
    public void setSeats(int seats) {
        this.seats = seats;
    }

    // Getter for ticket status
    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    // Setter for ticket status
    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    /**
     * Provides a string representation of the ticket details.
     *
     * @return A formatted string with ticket details.
     */
    @Override
    public String toString() {
        return String.format("PNR Number: %d | Source: %c | Destination: %c | Seats: %d | Status: %s",
                pnrNumber, source, destination, seats, ticketStatus);
    }
}
