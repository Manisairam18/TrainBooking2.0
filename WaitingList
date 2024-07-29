package Trainbooking2;


public class WaitingList {
    private final char source;
    private final char destination;
    private final int seats;
    private final TicketSystem ticketSystem;

    public WaitingList(char source, char destination, int seats) {
        this.source = source;
        this.destination = destination;
        this.seats = seats;
        this.ticketSystem = TicketSystem.getInstance();
    }

    /**
     * Adds a ticket request to the waiting list.
     * Creates a new ticket with the status of 'WaitingList' and updates the system.
     */
    private void addToWaitingList() {
        // Create a new ticket with WaitingList status
        Ticket ticket = new Ticket(source, destination, seats, TicketStatus.WAITING_LIST);
        int pnrNumber = ticket.getPnrNumber();
        
        // Add the ticket to the waiting list
        ticketSystem.waitingList.put(pnrNumber, ticket);
        ticketSystem.setSeatsBooked(ticketSystem.getSeatsBooked() + seats);

        System.out.println("Your request has been added to the waiting list. Your PNR number is " + pnrNumber);
    }

    /**
     * Executes the process of adding a ticket to the waiting list.
     */
    public void execute() {
        // Ensure the TicketSystem instance is properly initialized
        if (ticketSystem == null) {
            System.out.println("Error: Ticket system is not available.");
            return;
        }
        
        // Proceed with adding to the waiting list
        this.addToWaitingList();
    }
}
