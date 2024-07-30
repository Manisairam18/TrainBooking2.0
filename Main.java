package Trainbooking2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Display the main menu
            printMenu();
            int option = getUserOption(sc);

            switch (option) {
                case 1 -> {
                    // Get booking details from the user
                    char source = getUserSource(sc);
                    char destination = getUserDestination(sc);
                    int seats = getNumberOfSeats(sc);

                    if (source != destination) {
                        // Create a booking and execute it
                        TicketBooking booking = new TicketBooking(source, destination, seats);
                        booking.execute();
                    } else {
                        System.out.println("Source and destination cannot be the same. Please try again.");
                    }
                }
                case 2 -> {
                    // Get cancellation details from the user
                    int pnr = getPnrNumber(sc);
                    int seats = getNumberOfSeatsToCancel(sc);

                    // Create a cancellation and execute it
                    TicketCanceling canceling = new TicketCanceling(pnr, seats);
                    canceling.execute();
                }
                case 3 -> {
                    // Print the current booking chart
                    TicketSystem.getInstance().printChart();
                }
                case 4 -> {
                    // Exit the system
                    System.out.println("Exiting the system. Thank you!");
                    sc.close();
                    return;
                }
                default -> {
                    System.out.println("Invalid option. Please choose again.");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Railway Reservation System ---");
        System.out.println("1. Book Ticket");
        System.out.println("2. Cancel Ticket");
        System.out.println("3. Print Chart");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getUserOption(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static char getUserSource(Scanner sc) {
        System.out.print("Enter the source station (A, B, C, etc.): ");
        return sc.next().toUpperCase().charAt(0);
    }

    private static char getUserDestination(Scanner sc) {
        System.out.print("Enter the destination station (A, B, C, etc.): ");
        return sc.next().toUpperCase().charAt(0);
    }

    private static int getNumberOfSeats(Scanner sc) {
        System.out.print("Enter number of seats to book: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid number of seats: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static int getPnrNumber(Scanner sc) {
        System.out.print("Enter the PNR number: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid PNR number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static int getNumberOfSeatsToCancel(Scanner sc) {
        System.out.print("Enter number of seats to cancel: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid number of seats to cancel: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
