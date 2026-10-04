import java.util.Scanner;
import java.lang.String;

public class Main {

    public static String month = "";
    public static int year = 9999;
    public static Scanner keyboard = new Scanner(System.in);

    public static Month mainMonth;

    public static void main(String[] args) {
        introduction();
        mainMonth = new Month(month, year);

        boolean loop = true;
        while (loop) {
            int choiceNum = calculatorPrompts();
            switch (choiceNum) {
                case 1: // Add a day 
                    addDay();
                    break;
                case 2: // Delete a day
                    deleteDay();
                    break;
                case 3: // Overview 
                    overviewMonth();
                    break;
                case 4: // Total mileage
                    totalMileage();
                    break;
                case 5: // Export
                    exportFile();
                    break;
                default: // Exit
                    loop = false;
                    System.out.println("\nThank you for visiting my Mileage Calculator.\n");
                    break;
            }
        }
        keyboard.close();
    }

    private static void introduction() {
        boolean is_month_valid = false;
        boolean is_year_valid = false;

        System.out.println("\nWelcome to the...");
        System.out.println(" __  __ _ _                          ____      _            _       _");
        System.out.println("|  \\/  (_) | ___  __ _  __ _  ___   / ___|__ _| | ___ _   _| | __ _| |_ ___  _ __");
        System.out.println("| |\\/| | | |/ _ \\/ _` |/ _` |/ _ \\ | |   / _` | |/ __| | | | |/ _` | __/ _ \\| '__|");
        System.out.println("| |  | | | |  __/ (_| | (_| |  __/ | |__| (_| | | (__| |_| | | (_| | || (_) | |");
        System.out.println("|_|  |_|_|_|\\___|\\__,_|\\__, |\\___|  \\____\\__,_|_|\\___|\\__,_|_|\\__,_|\\__\\___/|_|");
        System.out.println("                       |___/");

        
        while (!is_month_valid) {
            System.out.print("> For what month? ");
            String inputMonth = keyboard.next().toLowerCase();
            switch (inputMonth) {
                case "january":
                case "february":
                case "march":
                case "april":
                case "may":
                case "june":
                case "july":
                case "august":
                case "september":
                case "october":
                case "november":
                case "december":
                    validMonth(inputMonth);
                    is_month_valid = true;
                    break;
                default:
                    System.out.println("> Invalid month name entered!");
            }
        }

        while (!is_year_valid) {
            System.out.print("> For what year? ");
            int inputYear = keyboard.nextInt();
            if (2000 > year || year < 3000) { System.out.println("> Invalid year entered!"); }
            else {
                System.out.printf("> You have selected the year of %d\n", inputYear);
                year = inputYear;
                is_year_valid = true;
            }
        }
    }

    private static void validMonth(String monthName) {
        System.out.printf("\n> You have selected the month of %s!\n", monthName);
        month = monthName;
    }

    // This will present different prompts of what the audience may want 
    private static int calculatorPrompts() {
        // Display the options
        System.out.println(" __  __ _ _                          ____      _            _       _");
        System.out.println("|  \\/  (_) | ___  __ _  __ _  ___   / ___|__ _| | ___ _   _| | __ _| |_ ___  _ __");
        System.out.println("| |\\/| | | |/ _ \\/ _` |/ _` |/ _ \\ | |   / _` | |/ __| | | | |/ _` | __/ _ \\| '__|");
        System.out.println("| |  | | | |  __/ (_| | (_| |  __/ | |__| (_| | | (__| |_| | | (_| | || (_) | |");
        System.out.println("|_|  |_|_|_|\\___|\\__,_|\\__, |\\___|  \\____\\__,_|_|\\___|\\__,_|_|\\__,_|\\__\\___/|_|");
        System.out.println("                       |___/");
        System.out.println("\nChoose 1: Add a day");
        System.out.println("Choose 2: Delete a day");
        System.out.println("Choose 3: Overview the month");
        System.out.println("Choose 4: Show the total mileage");
        System.out.println("Choose 5: Export the file into an excel sheet");
        System.out.println("Any to EXIT.\n");
        System.out.print("Choose an option > ");

        // Read the user's input and clean up
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        return choice;
    }

    private static void addDay() {  // Case 1: Add a day
        System.out.println("================================");

        // Start with adding a date

        String date = "";
        do {
            System.out.print("> What is the date: ");
            date = keyboard.nextLine();
        } while (date.isEmpty());
        Day newDay = new Day(date);

        // Add the stops

        boolean done = false;
        do {
            System.out.println("\n> Type 4983 for Penelope store.");
            System.out.println("> Type 5340 for Jennifer store.");
            System.out.println("> Type 7646 for Spencer store.");
            System.out.println("> Type 2074 for Emily store.");
            System.out.println("> Type 3736 for Tara store.");
            System.out.println("> Type bank for Bank.");

            System.out.print("> What is your stop? ");
            String stop = keyboard.next();
            done = newDay.addPlace(stop);
        } while (!done);

        mainMonth.addDayToMonth(newDay);

        System.out.println("================================");
    }

    private static void deleteDay() {  // Case 2
        System.out.println("Delete a day");
    }

    private static void overviewMonth() {  // Case 3
        System.out.println(mainMonth.toString());
    }

    private static void totalMileage() {  // Case 4
        System.out.println("Show the total mileage");
    }

    private static void exportFile() {  // Case 5
        System.out.println("Export the file into an excel sheet");
    }
}