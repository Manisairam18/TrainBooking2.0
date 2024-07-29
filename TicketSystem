package Trainbooking2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TicketSystem {
    // Ticket storage
    private final Map<Integer, Ticket> ticketsBooked = new HashMap<>();
    private final Map<Integer, Ticket> ticketsCanceled = new HashMap<>();
    final ConcurrentHashMap<Integer, Ticket> waitingList = new ConcurrentHashMap<>();

    // Seat availability
    private final int[] seatsAvailable = new int[5];
    private final Map<Integer, Integer> partiallyCanceled = new HashMap<>();
    private int seatsBooked = 0;

    private static TicketSystem instance = null;

    private TicketSystem() {
        Arrays.fill(seatsAvailable, 8); // Initialize all seats to 8 per section
    }

    public static TicketSystem getInstance() {
        if (instance == null) {
            instance = new TicketSystem();
        }
        return instance;
    }

    // --- Booking Methods ---
    
    public void addToBookedTickets(int newPnr, Ticket ticket) {
        ticketsBooked.put(newPnr, ticket);
    }

    public boolean checkSeatAvailability(char source, char destination, int seats) {
        for (int i = source - 'A'; i < destination - 'A'; i++) {
            if (seatsAvailable[i] < seats) {
                return false;
            }
        }
        return true;
    }

    public void decreaseSeatAvailability(char source, char destination, int seats) {
        for (int i = source - 'A'; i < destination - 'A'; i++) {
            seatsAvailable[i] -= seats;
        }
    }

    // --- Cancellation Methods ---
    
    public Ticket getTicket(int pnr) {
        return ticketsBooked.get(pnr);
    }

    public void increaseSeatAvailability(char source, char destination, int seats) {
        for (int i = source - 'A'; i < destination - 'A'; i++) {
            seatsAvailable[i] += seats;
        }
    }

    public void storePartiallyCanceledSeats(int pnr, int seats) {
        partiallyCanceled.merge(pnr, seats, Integer::sum);
    }

    public void processCancellation(int pnr, Ticket ticket) {
        int additionalSeats = partiallyCanceled.getOrDefault(pnr, 0);
        ticket.setSeats(ticket.getSeats() + additionalSeats);
        addToCanceledTickets(pnr, ticket);
    }

    public void addToCanceledTickets(int pnr, Ticket ticket) {
        ticket.setTicketStatus(TicketStatus.CANCELED);
        ticketsCanceled.put(pnr, ticket);
        removeFromBookedTickets(pnr);
    }

    public void removeFromBookedTickets(int pnr) {
        ticketsBooked.remove(pnr);
    }

    // --- Waiting List Methods ---
    
    public void addToWaitingList(int pnr, Ticket ticket) {
        waitingList.put(pnr, ticket);
    }

    public void processWaitingList() {
        // Logic to process the waiting list and book available tickets
        // This should ideally be implemented based on specific requirements
    }

    // --- Print Methods ---
    
    public void printChart() {
        System.out.println("\n--- Tickets Booked ---");
        ticketsBooked.values().forEach(System.out::println);

        System.out.println("\n--- Tickets Canceled ---");
        ticketsCanceled.values().forEach(System.out::println);

        System.out.println("\n--- Tickets in Waiting List ---");
        waitingList.values().forEach(System.out::println);

        System.out.println("\n--- Seat Availability ---");
        System.out.println(Arrays.toString(seatsAvailable));

        System.out.println("\n--- Seat Map ---");
        System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8");
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.print(c);
            int seatsBooked = 8 - seatsAvailable[c - 'A'];
            for (int i = 0; i < seatsBooked; i++) {
                System.out.print("\t*");
            }
            System.out.println();
        }
        System.out.println();
    }

	public int getAvailableSeats(char source, char destination) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getSeatsBooked() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setSeatsBooked(int i) {
		// TODO Auto-generated method stub
		
	}
}
