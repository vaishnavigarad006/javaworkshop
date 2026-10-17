package CabBookingProject;

import java.util.Scanner;
import java.util.Random;

public class CabBookingChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] sources = {
            "Pune Station", "Swargate", "Hinjawadi"
        };

        String[] destinations = {
            "Shivajinagar", "Kothrud", "Wakad"
        };

        int[] distances = {5, 8, 10};

        while (true) {

            System.out.println("\n==================================");
            System.out.println("       CAB BOOKING CHATBOT");
            System.out.println("==================================");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();

            if (choice == 2) {
                System.out.println("Thank you for using our chatbot!");
                System.out.println("Goodbye!");
                break;
            }

            if (choice != 1) {
                System.out.println("Invalid choice! Please select 1 or 2.");
                continue;
            }

            // Select cab type
            System.out.println("\nSelect Cab Type:");
            System.out.println("1. Auto  - Rs.12/km");
            System.out.println("2. Sedan - Rs.18/km");
            System.out.println("3. SUV   - Rs.25/km");
            System.out.print("Enter cab choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Returning to menu.");
                sc.nextLine();
                continue;
            }

            int cabChoice = sc.nextInt();

            String cabType;
            int rate;

            if (cabChoice == 1) {
                cabType = "Auto";
                rate = 12;
            } else if (cabChoice == 2) {
                cabType = "Sedan";
                rate = 18;
            } else if (cabChoice == 3) {
                cabType = "SUV";
                rate = 25;
            } else {
                System.out.println("Invalid cab choice!");
                continue;
            }

            // Select source
            System.out.println("\nSelect Source:");

            for (int i = 0; i < sources.length; i++) {
                System.out.println((i + 1) + ". " + sources[i]);
            }

            System.out.print("Enter source choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Returning to menu.");
                sc.nextLine();
                continue;
            }

            int sourceChoice = sc.nextInt();

            if (sourceChoice < 1 || sourceChoice > sources.length) {
                System.out.println("Invalid source choice!");
                continue;
            }

            String source = sources[sourceChoice - 1];

            // Select destination
            System.out.println("\nSelect Destination:");

            for (int i = 0; i < destinations.length; i++) {
                System.out.println((i + 1) + ". " + destinations[i]);
            }

            System.out.print("Enter destination choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Returning to menu.");
                sc.nextLine();
                continue;
            }

            int destinationChoice = sc.nextInt();

            if (destinationChoice < 1 ||
                destinationChoice > destinations.length) {

                System.out.println("Invalid destination choice!");
                continue;
            }

            String destination =
                    destinations[destinationChoice - 1];

            // Distance depends on the selected destination
            int distance = distances[destinationChoice - 1];

            // Calculate fare
            int fare = distance * rate;

            // Display ride details
            System.out.println("\n========== RIDE DETAILS ==========");
            System.out.println("Cab Type    : " + cabType);
            System.out.println("Source      : " + source);
            System.out.println("Destination : " + destination);
            System.out.println("Distance    : " + distance + " km");
            System.out.println("Rate        : Rs." + rate + "/km");
            System.out.println("Total Fare  : Rs." + fare);
            System.out.println("==================================");

            // Confirm or cancel before sharing OTP
            System.out.println("\n1. Confirm & Share OTP");
            System.out.println("2. Cancel Ride");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Ride not confirmed.");
                sc.nextLine();
                continue;
            }

            int confirmChoice = sc.nextInt();

            if (confirmChoice == 2) {
                System.out.println("Ride cancelled successfully.");
                System.out.println("No OTP has been shared.");
                continue;
            }

            if (confirmChoice != 1) {
                System.out.println("Invalid choice! Ride not confirmed.");
                continue;
            }

            // Generate a four-digit OTP
            int otp = 1000 + random.nextInt(9000);

            System.out.println("\nBooking confirmed successfully!");
            System.out.println("Your OTP is: " + otp);
            System.out.println("OTP shared successfully.");
            System.out.println(
                "IMPORTANT: After OTP sharing, cancellation is not allowed."
            );

            System.out.println("Have a safe journey!");
        }

        sc.close();
    }
}
