package Trainbooking2;

public enum TicketStatus {
    BOOKED("Booked"),
    CANCELED("Canceled"),
    WAITING_LIST("Waiting List");

    private final String description;

    TicketStatus(String description) {
        this.description = description;
    }

    /**
     * Gets the description of the ticket status.
     *
     * @return A user-friendly description of the status.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a TicketStatus from its description.
     *
     * @param description The description of the ticket status.
     * @return The corresponding TicketStatus.
     * @throws IllegalArgumentException if the description is not valid.
     */
    public static TicketStatus fromDescription(String description) {
        for (TicketStatus status : TicketStatus.values()) {
            if (status.description.equalsIgnoreCase(description)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid description: " + description);
    }
}
