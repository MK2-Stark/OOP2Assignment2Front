import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Variables
        Accounts accounts = new Accounts();

        int mainOptionSelected;
        boolean isRunning = true;

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
