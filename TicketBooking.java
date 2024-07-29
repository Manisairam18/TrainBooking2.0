package Trainbooking2;

public class TicketBooking {
    private char source;
    private char destination;
    private int seats;
    private TicketSystem ticketSystem;

    /**
     * Constructor to initialize the TicketBooking object.
     *
     * @param source The source station of the ticket.
     * @param destination The destination station of the ticket.
     * @param seats The number of seats to book.
     */
    public TicketBooking(char source, char destination, int seats) {
        this.source = source;
        this.destination = destination;
        this.seats = seats;
        this.ticketSystem = TicketSystem.getInstance();
    }

    /**
     * Books a ticket if seats are available. Otherwise, adds the booking to the waiting list.
     */
    private void bookTicket() {
        if (ticketSystem.checkSeatAvailability(source, destination, seats)) {
            Ticket ticket = new Ticket(source, destination, seats, TicketStatus.BOOKED);
            int newPnr = ticket.getPnrNumber();
            ticketSystem.addToBookedTickets(newPnr, ticket);
            ticketSystem.decreaseSeatAvailability(source, destination, seats);
            System.out.println("Ticket booked successfully! Your PNR number is " + newPnr);
        } else {
            handleNoAvailableSeats();
        }
    }

    /**
     * Handles the scenario when no seats are available and adds the booking to the waiting list.
     */
    private void handleNoAvailableSeats() {
        int availableSeats = ticketSystem.getAvailableSeats(source, destination);
        if (availableSeats <= 0) {
            System.out.println("No tickets available from " + source + " to " + destination);
        } else {
            // Move to waiting list
            WaitingListManager waitingListManager = new WaitingListManager();
            waitingListManager.waitingListEntry(source, destination, seats);
            System.out.println("Seats not available immediately. Added to the waiting list.");
        }
    }

    /**
     * Executes the booking process.
     */
    public void execute() {
        bookTicket();
    }
}
