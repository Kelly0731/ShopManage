import java.util.Scanner;

public class IntroScreen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display introductory message
        System.out.println("Welcome to the Mechanic Shop Application!");
        System.out.println("This application helps manage work orders, billing, and interactions between mechanics, managers, and customers.");

        // Ask for user's name
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        // Ask for user's role
        System.out.print("Are you a mechanic, manager, bookkeeper, or customer? ");
        String role = scanner.nextLine();

        // Display personalized welcome message based on role
        switch (role.toLowerCase()) {
            case "mechanic":
                System.out.println("Welcome, " + name + "! You can now start working on work orders.");
                break;
            case "manager":
                System.out.println("Welcome, " + name + "! You can now manage work orders, billing, and employees.");
                break;
            case "bookkeeper":
                System.out.println("Welcome, " + name + "! You can now manage billing and financial records.");
                break;
            case "customer":
                System.out.println("Welcome, " + name + "! You can now view your work orders and invoices.");
                break;
            default:
                System.out.println("Invalid role entered. Please try again.");
        }
        }
    }
