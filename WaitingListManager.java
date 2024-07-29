
package Trainbooking2;

public class WaitingListManager {
    private final TicketSystem ticketSystem;

    public WaitingListManager() {
        this.ticketSystem = TicketSystem.getInstance();
    }

    /**
     * Processes the waiting list to confirm bookings where seats have become available.
     */
    public void processWaitingList() {
        // Iterate over the waiting list to check seat availability
        for (Ticket waitingTicket : ticketSystem.waitingList.values()) {
            char source = waitingTicket.getSource();
            char destination = waitingTicket.getDestination();
            int seats = waitingTicket.getSeats();

            // Check if seats are available for the waiting ticket
            if (ticketSystem.checkSeatAvailability(source, destination, seats)) {
                // Update seat availability and waiting list count
                ticketSystem.decreaseSeatAvailability(source, destination, seats);
                ticketSystem.setSeatsBooked(ticketSystem.getSeatsBooked() - seats);

                // Update ticket status and move to booked tickets
                updateTicketToBookingList(waitingTicket);
            }
        }
    }

    /**
     * Updates the ticket from waiting list to booked list.
     *
     * @param waitingTicket The ticket currently in the waiting list.
     */
    private void updateTicketToBookingList(Ticket waitingTicket) {
        int pnrNumber = waitingTicket.getPnrNumber();
        waitingTicket.setTicketStatus(TicketStatus.BOOKED); // Change status to booked
        ticketSystem.addToBookedTickets(pnrNumber, waitingTicket); // Add to booked tickets list
        ticketSystem.waitingList.remove(pnrNumber); // Remove from waiting list

        System.out.println("Booking confirmed for PNR number " + pnrNumber + "!");
    }

    /**
     * Adds a ticket request to the waiting list.
     *
     * @param source      The source station.
     * @param destination The destination station.
     * @param seats       The number of seats requested.
     */
    public void waitingListEntry(char source, char destination, int seats) {
        WaitingList waitingList = new WaitingList(source, destination, seats);
        waitingList.execute();
    }
}
