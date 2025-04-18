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

                switch (mainOptionSelected) {
                    //lOGIN OPTION
                    case 1:
                        System.out.println("Option 1 Selected");

                        //isMainMenu = false;
                        accounts.setMainBool(false);
                        //isCreateView = false;
                        accounts.setCreateViewBool(false);
                        //isLoginView= true;
                        accounts.setLoginViewBool(true);
                        accounts.setAccountViewBool(false);
                        accounts.LoginView();


                        break;
                    //CREATE ACCOUNT OPTION
                    case 2:
                        System.out.println("Option 2 Selected");

                        accounts.setMainBool(false);
                        //isCreateView = false;
                        accounts.setCreateViewBool(true);
                        //isLoginView= true;
                        accounts.setLoginViewBool(false);
                        accounts.setAccountViewBool(false);
                        accounts.createView();
                        break;

                    //QUIT OPTION
                    case 3:
                        System.out.println("Option 3 Selected: Quitting");
                        //quit program
                        System.exit(0);
                        break;
                    default:
                        System.out.println("That option does not exist here. try again");
                }
            }
        }
    }


//    private static void LoginView() {
//
//        System.out.println("=============");
//        System.out.println("Login view");
//        System.out.println("=============");
//        while(isLoginView && !isMainMenu && !isCreateView) {
//            String usernameEntered;
//            String passwordEntered;
//            System.out.println("""
//                            If You Want To Go Back To Main Menu Enter '0'.
//                            For any following prompts in this view.
//                            """);
//
//            System.out.println("Enter your username: ");
//            usernameEntered = scanner.nextLine();
//            if (usernameEntered.equals("0")) {
//                isMainMenu = true;
//                isCreateView = false;
//                isLoginView = false;
//                System.out.println("<--Going Back");
//                break;
//            }
//
//            System.out.println("Enter your password: ");
//            passwordEntered = scanner.nextLine();
//            if (passwordEntered.equals("0")) {
//                isMainMenu = true;
//                isCreateView = false;
//                isLoginView = false;
//                System.out.println("<--Going Back");
//                break;
//            }
//        }
//    }
//
//    private static void CreateView() {
//        System.out.println("=============");
//        System.out.println("Create Account View");
//        System.out.println("=============");
//
//        while(isCreateView && !isLoginView && !isMainMenu) {
//            String usernameEntered;
//            String passwordEntered;
//            System.out.println("""
//                            If You Want To Go Back To Main Menu Enter '0'.
//                            For any following prompts in this view.
//                            """);
//
//            System.out.println("Enter your username: ");
//            usernameEntered = scanner.nextLine();
//            if (usernameEntered.equals("0")) {
//                isMainMenu = false;
//                isCreateView = true;
//                isLoginView = false;
//                System.out.println("<--Going Back");
//                break;
//
//            }
//            System.out.println("Enter your password: ");
//            passwordEntered = scanner.nextLine();
//            if (passwordEntered.equals("0")) {
//                isMainMenu = false;
//                isCreateView = true;
//                isLoginView = false;
//                System.out.println("<--Going Back");
//                break;
//            }
//
//
//        }
//    }

}
