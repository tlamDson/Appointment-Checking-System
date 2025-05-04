import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for the appointment management system
 */
public class AppointmentDemo {
    private ArrayList<Appointment> appointments;
    private Scanner scanner;

    /**
     * Constructor initializes the appointment list with sample appointments
     */
    public AppointmentDemo() { 
        appointments = new ArrayList<>();
        // Add some sample appointments
        appointments.add(new OneTimeAppointment("Dentist", 2015, 11, 1));
        appointments.add(new DailyAppointment("Blood Pressure Check"));
        appointments.add(new MonthlyAppointment("Visit to grandma", 1));
        appointments.add(new OneTimeAppointment("Code writing", 2025, 4, 25));
        appointments.add(new OneTimeAppointment("Team meeting", 2015, 6, 13));
        appointments.add(new DailyAppointment("Leetcode"));
        appointments.add(new MonthlyAppointment("Hanging out with friends", 15));
        appointments.add(new OneTimeAppointment("Submit part A code for COMP132 Lab", 2025, 4, 27));
        appointments.add(new MonthlyAppointment("Practice Front-end Dev", 5));
        
        scanner = new Scanner(System.in);
    }
    
    /**
     * Main method to run the appointment application
     */
    public static void main(String[] args) {
        AppointmentDemo demo = new AppointmentDemo();
        demo.run();
    }
    
    /**
     * Main application loop
     */
    public void run() {
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getIntInput("Select an option: ");
            
            switch (choice) {
                case 1:
                    checkAppointment();
                    break;
                case 2:
                    addAppointment();
                    break;
                case 3:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
    
    /**
     * Display the main menu options
     */
    private void displayMenu() {
        System.out.println("\n===== Appointment Management System =====");
        System.out.println("1. Check appointments for a date");
        System.out.println("2. Add a new appointment");
        System.out.println("3. Exit");
    }
    
    /**
     * Get integer input from user with error handling
     */
    private int getIntInput(String prompt) {
        int input = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
        
        return input;
    }
    
    /**
     * Check for appointments on a specific date
     */
    private void checkAppointment() {
        System.out.print("Enter a date (year month day): ");
        String input = scanner.nextLine();
        
        try {
            String[] parts = input.trim().split("\\s+");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Please enter exactly three numbers (year month day).");
            }
            
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            
            if (month < 1 || month > 12 || day < 1 || day > 31 || year < 0) {
                throw new IllegalArgumentException("Invalid date values.");
            }
            
            boolean found = false;
            System.out.printf("\nYou have the following appointments on %d/%d/%d:\n", month, day, year);
            
            for (Appointment appt : appointments) {
                if (appt.occursOn(year, month, day)) {
                    System.out.println("- " + appt.getDescription());
                    found = true;
                }
            }
            
            if (!found) {
                System.out.println("No appointments found for this date.");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numbers for year, month, and day.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Add a new appointment to the system
     */
    private void addAppointment() {
        System.out.println("\n----- Add New Appointment -----");
        System.out.print("Enter appointment description: ");
        String description = scanner.nextLine();
        
        System.out.println("\nSelect appointment type:");
        System.out.println("1. One-time appointment");
        System.out.println("2. Daily appointment");
        System.out.println("3. Monthly appointment");
        
        int choice = getIntInput("Enter your choice: ");
        
        try {
            switch (choice) {
                case 1:
                    addOneTimeAppointment(description);
                    break;
                case 2:
                    appointments.add(new DailyAppointment(description));
                    System.out.println("Daily appointment added successfully!");
                    break;
                case 3:
                    addMonthlyAppointment(description);
                    break;
                default:
                    System.out.println("Invalid appointment type. Appointment not added.");
            }
        } catch (Exception e) {
            System.out.println("Error adding appointment: " + e.getMessage());
        }
    }
    
    /**
     * Add a one-time appointment
     */
    private void addOneTimeAppointment(String description) {
        System.out.println("\nEnter date for one-time appointment:");
        int year = getIntInput("Year: ");
        int month = getIntInput("Month (1-12): ");
        int day = getIntInput("Day (1-31): ");
        
        if (month < 1 || month > 12 || day < 1 || day > 31 || year < 0) {
            throw new IllegalArgumentException("Invalid date values.");
        }
        
        appointments.add(new OneTimeAppointment(description, year, month, day));
        System.out.println("One-time appointment added successfully!");
    }
    
    /**
     * Add a monthly appointment
     */
    private void addMonthlyAppointment(String description) {
        int day = getIntInput("Enter day of month (1-31): ");
        
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day must be between 1 and 31.");
        }
        
        appointments.add(new MonthlyAppointment(description, day));
        System.out.println("Monthly appointment added successfully!");
    }
}


