import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// I did use AI to generate this commented field as a sort of documentation and explanation for the user. To save myself time. But the code is mine though, with some internet&Lecture notes help.
//I figured they would be a nice little "nice to have" touch/addition to include for the reader.
/** Documentation & Explanation For The Reader.
 * The Main class serves as the entry point for the Simple Banking App program.
 * It provides a console-based interface for users to interact with the application,
 * allowing them to log in, create accounts, or quit the program. The class also
 * displays the current date and time upon startup using Java's Date/Time API.
 *
 * Main program functionalities:
 * - Display the main menu with options to log in, create an account, or exit the program.
 * - Handle user input to navigate between different features of the application.
 * - Manage the current application state through the Accounts object.
 *
 * Application Context:
 * - This application uses local data structures for storing account information.
 * - The application does not support data persistence; all data is reset upon restarting.
 *
 * The program leverages features such as `Scanner` for user input and `switch` statements
 * for option handling. The main loop (`while`) ensures the application continues running
 * until the user chooses to exit.
 */

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Variables
        Accounts accounts = new Accounts();

        int mainOptionSelected;
        boolean isRunning = true;

        //Using Date/Time API for getting current date and time
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Current Date: " + currentDate.format(dateFormatter));
        System.out.println("Current Time: " + currentTime.format(timeFormatter));

        while (isRunning) {

            if(accounts.getMainBool() && !accounts.getCreateViewBool() && !accounts.getLoginViewBool() && !accounts.getAccountViewBool()) {
                System.out.println("-Welcome To Simple Banking App-:");
                //Entry message prints
                System.out.println("=============");
                System.out.println("Main Menu");
                System.out.println("=============");
                System.out.println("""
                        Note *Create account first if you haven't before logging in.
                        Also Create an account when you have restarted the program.
                        There is no persistent data or database, data is all stored in local data structures in this program*""");

                System.out.println("[1] -Log In-");
                System.out.println("[2] -Create Account-");
                System.out.println("[3] -Quit Program-");
                //prompt user input
                System.out.print("Please select available Main Menu option: ");

                mainOptionSelected = scanner.nextInt();
                scanner.nextLine();

                String action = switch (mainOptionSelected) {
                    //lOGIN OPTION
                    //AS A USER I WANT TO BE ABLE TO LOG INTO MY EXISTING BANK ACCOUNT
                    case 1 -> {
                        System.out.println("Option 1 Selected");
                        accounts.setMainBool(false);
                        accounts.setCreateViewBool(false);
                        accounts.setLoginViewBool(true);
                        accounts.setAccountViewBool(false);
                        accounts.LoginView();
                        yield "Login view";
                    }
                    //CREATE ACCOUNT OPTION
                    //AS A USER I WANT TO BE ABLE TO CREATE A BANK ACCOUNT
                    case 2 -> {
                        System.out.println("Option 2 Selected");
                        accounts.setMainBool(false);
                        accounts.setCreateViewBool(true);
                        accounts.setLoginViewBool(false);
                        accounts.setAccountViewBool(false);
                        accounts.createView();
                        yield "Create View";
                    }
                    case 3 -> {
                        System.out.println("Option 3 Selected: Quitting");
                        System.exit(0);
                        yield "Quitting"; // Yielding a value to indicate action
                    }
                    default -> {
                        System.out.println("That option does not exist here. Try again");
                        yield "Invalid Option"; // Yielding a value for invalid option
                    }
                };
            }
        }
    }
}
