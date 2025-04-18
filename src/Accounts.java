import java.util.ArrayList;
import java.util.Scanner;

public class Accounts implements IBankAccount{

    //strings
    private String usernameGiven;
    private String passwordGiven;
    //Numerical variables
    private float balanceFloat = 0.0F;
    private String balanceString;
    private int indexOfAccount;
    //booleans
    private boolean isMainMenu = true;
    private boolean isCreateView = false;
    private boolean isLoginView= false;
    private boolean isUsersAccountView = false;
    private boolean isDepositeView = false;
    private boolean isWithdrawalView = false;

    private static Scanner scan = new Scanner(System.in);
    private boolean isValidLogin = false;
    private boolean isValidCreate = false;

    //Enums
    private AccountType accountType;

    private ArrayList<String> usernamesList = new ArrayList<>();
    private ArrayList<String> passwordsList  = new ArrayList<>();
    private ArrayList<AccountType> accountTypeList = new ArrayList<>();
    private ArrayList<Float> balanceList = new ArrayList<>();

    private Validator validator;
    public Accounts(){

        this.validator = new Validator(this);
    }
    //Login and Create Views
    public void LoginView() {

        System.out.println("=============");
        System.out.println("Login view");
        System.out.println("=============");
        while(isLoginView && !isMainMenu && !isCreateView && !isUsersAccountView) {
            String usernameEntered;
            String passwordEntered;
            System.out.println("""
                            If You Want To Go Back To Main Menu Enter '0'.
                            For any following prompts in this view.
                            """);

            System.out.println("Enter your username: ");
            usernameEntered = scan.nextLine();
            if (usernameEntered.equals("0")) {
                isMainMenu = true;
                isCreateView = false;
                isLoginView = false;
                isUsersAccountView= false;
                System.out.println("<--Going Back");
                break;
            }

            System.out.println("Enter your password: ");
            passwordEntered = scan.nextLine();
            if (passwordEntered.equals("0")) {
                isMainMenu = true;
                isCreateView = false;
                isLoginView = false;
                isUsersAccountView= false;
                System.out.println("<--Going Back");
                break;
            }
            isValidLogin = validateLogIntoAccount(usernameEntered, passwordEntered);
            if (isValidLogin) {
                System.out.println("Login Successful");
                System.out.println("--Logging You Into Your Account--");
                isMainMenu = false;
                isCreateView = false;
                isLoginView = false;
                isUsersAccountView = true;
                ViewUsersAccount(indexOfAccount, usernameEntered, accountTypeList.get(indexOfAccount), balanceList.get(indexOfAccount));
            }
            else{
                System.out.println("Login Failed, This Username and/or password either doesnt exist. Try again");

            }
        }

    }

    public void createView() {
        System.out.println("=============");
        System.out.println("Create Account View");
        System.out.println("=============");

        while(isCreateView && !isLoginView && !isMainMenu && !isUsersAccountView) {
            String usernameEntered;
            String passwordEntered;
            int accTypeSelected;
            System.out.println("""
                            If You Want To Go Back To Main Menu Enter '0'.
                            For any following prompts in this view.
                            """);

            System.out.println("Enter your username: ");
            usernameEntered = scan.nextLine();
            if (usernameEntered.equals("0")) {
                isMainMenu = true;
                isCreateView = false;
                isLoginView = false;
                isUsersAccountView = false;
                System.out.println("<--Going Back");
                break;

            }
            System.out.println("Enter your password: ");
            passwordEntered = scan.nextLine();
            if (passwordEntered.equals("0")) {
                isMainMenu = true;
                isCreateView = false;
                isLoginView = false;
                isUsersAccountView = false;
                System.out.println("<--Going Back");
                break;
            }
            System.out.println("[1] -SAVINGS-");
            System.out.println("[2] -BASIC-");
            System.out.println("[3] -BUSINESS-");
            System.out.println("Please Select What Type Of Account You Would Like to Create From Available Options: ");
            accTypeSelected = scan.nextInt();
            scan.nextLine();
            //successful creation
            switch (accTypeSelected) {
                case 1:
                    System.out.println("SAVINGS ACCOUNT TYPE SELECTED");
                    accountType = AccountType.SAVINGS;
                    //call create account here
                    System.out.println("VALIDATING ACCOUNT....");
                    isValidCreate = validator.createValidator(usernameEntered, passwordEntered, accountType);
                    if(isValidCreate){
                        System.out.println("--CREATE ACCOUNT IS VALID--");
                        //since it is valid, Add the username, password and account type to their respective arraylist.
                        usernamesList.add(usernameEntered);
                        passwordsList.add(passwordEntered);
                        accountTypeList.add(accountType);
                        balanceList.add(0.0F);

                        System.out.println("Accounts usernames arraylist: "+ usernamesList);
                        System.out.println("Accounts passwords arraylist: "+ passwordsList);
                        System.out.println("Accounts account type arraylist: "+ accountTypeList);

                        isMainMenu = true;
                        isCreateView = false;
                        isLoginView = false;
                        isUsersAccountView = false;
                    }
                    else{
                        System.out.println("--CREATE ACCOUNT IS INVALID--");
                        System.out.println("--Try Creating Again--");
                        break;
                    }
                    break;

                case 2:
                    System.out.println("BASIC ACCOUNT TYPE SELECTED");
                    accountType = AccountType.BASIC;
                    //call create account here
                    System.out.println("VALIDATING ACCOUNT....");
                    isValidCreate = validator.createValidator(usernameEntered, passwordEntered, accountType);
                    if(isValidCreate){
                        System.out.println("--CREATE ACCOUNT IS VALID--");
                        //since it is valid, Add the username, password and account type to their respective arraylist.
                        usernamesList.add(usernameEntered);
                        passwordsList.add(passwordEntered);
                        accountTypeList.add(accountType);
                        balanceList.add(0.0F);

                        System.out.println("Accounts usernames arraylist: "+ usernamesList);
                        System.out.println("Accounts passwords arraylist: "+ passwordsList);
                        System.out.println("Accounts account type arraylist: "+ accountTypeList);


                        isMainMenu = true;
                        isCreateView = false;
                        isLoginView = false;
                        isUsersAccountView = false;
                    }
                    else{
                        System.out.println("--CREATE ACCOUNT IS INVALID--");
                        System.out.println("--Try Creating Again--");
                        break;
                    }
                    break;
                case 3:
                    System.out.println("BUSINESS ACCOUNT TYPE SELECTED");
                    accountType = AccountType.BUSINESS;
                    //call create account here
                    System.out.println("VALIDATING ACCOUNT....");
                    isValidCreate = validator.createValidator(usernameEntered, passwordEntered, accountType);
                    if(isValidCreate){
                        System.out.println("--CREATE ACCOUNT IS VALID--");
                        //since it is valid, Add the username, password and account type to their respective arraylist.
                        usernamesList.add(usernameEntered);
                        passwordsList.add(passwordEntered);
                        accountTypeList.add(accountType);
                        balanceList.add(0.0F);


                        System.out.println("Accounts usernames arraylist: "+ usernamesList);
                        System.out.println("Accounts passwords arraylist: "+ passwordsList);
                        System.out.println("Accounts account type arraylist: "+ accountTypeList);


                        isMainMenu = true;
                        isCreateView = false;
                        isLoginView = false;
                        isUsersAccountView = false;
                    }
                    else{
                        System.out.println("--CREATE ACCOUNT IS INVALID--");
                        System.out.println("--Try Creating Again--");
                        break;
                    }
                    break;

                default:
                    System.out.println("That option does not exist. Select one that does. Lets try this again");
            }
        }
    }

    private Boolean validateLogIntoAccount(String usrname, String passwrd)
    {
        boolean usernameMatches = false;
        boolean passwordMatches = false;
        int ia = 0;
        if(usernamesList != null && passwordsList != null) {
            if (!usernamesList.isEmpty() && !passwordsList.isEmpty()) {
                for(int i = 0; i < usernamesList.size(); i++){
                    if(usernamesList.get(i).equals(usrname)){
                        usernameMatches = true;
                        ia = i;

                    }

                }
                for(int i =0; i < passwordsList.size(); i++){
                    if(passwordsList.get(i).equals(passwrd)){
                        passwordMatches = true;
                        ia = i;
                    }
                }
                indexOfAccount = ia;
                accountType = accountTypeList.get(indexOfAccount);
                balanceFloat = balanceList.get(indexOfAccount);
            }
        }
        if(usernameMatches && passwordMatches) {
            return true;

        }
        else{
            return false;
        }

    }

    private void ViewUsersAccount(int index, String username, AccountType accType, Float accBalanceFl){
        System.out.println("=============");
        System.out.println("Logged Into Bank Account View");
        System.out.println("=============");
        accountType = accType;
        System.out.println("Account Username: " + username);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: " + accBalanceFl);
        System.out.println("-------------");

        while(isUsersAccountView && !isCreateView && !isLoginView && !isMainMenu){
            int actionSelected;
            System.out.println("New Account Balance: " + balanceList.get(index));


            System.out.println("What do you want to do?");
            System.out.println("[1] Deposit Money");
            System.out.println("[2] Withdraw Money");
            System.out.println("[3] Log Out & Go To Main Menu");

            actionSelected = scan.nextInt();
            scan.nextLine();

            switch(actionSelected){
                case 1:
                    System.out.println("You selected [1] Deposit Money");
                    System.out.println("Enter Amount To Deposit (Float Value): ");
                    float depositAmount = scan.nextFloat();
                    scan.nextLine();
                    float newBalance = balanceList.get(index) + depositAmount;
                    DepositMoney(index, newBalance);
                    break;

                case 2:
                    System.out.println("You selected [2] Withdraw Money");
                    System.out.println("Enter Amount To Withdraw (Float Value): ");
                    float withdrawAmount = scan.nextFloat();
                    scan.nextLine();
                    float newBalance2 = balanceList.get(index) - withdrawAmount;
                    WithdrawMoney(index, newBalance2);
                    break;

                case 3:
                    System.out.println("You selected [3] Log Out & Quit");
                    System.out.println("LOGGING OUT AND QUITTING BACK TO MAIN MENU");
                    isMainMenu = true;
                    isCreateView = false;
                    isLoginView = false;
                    isUsersAccountView = false;
                    //quit
                    break;

                default:
                    System.out.println("That option does not exist. Select a valid option!");
            }



        }
    }

    @Override
    public void DepositMoney(int index,float amount)
    {
        balanceList.set(index, amount);
        System.out.println("New Account Balance: " + amount);
        System.out.println("Successfully Deposited");
    }

    @Override
    public void WithdrawMoney(int index, float amount) {
        balanceList.set(index, amount);
        System.out.println("New Account Balance: " + amount);
        System.out.println("Successfully Withdrawn");
    }


    //Encapsulation down here
    public Boolean getMainBool(){
        return isMainMenu;
    }

    public void setMainBool(boolean mainBool){
        this.isMainMenu = mainBool;
    }

    public Boolean getLoginViewBool(){
        return isLoginView;
    }

    public void setLoginViewBool(boolean loginViewBool){
        this.isLoginView = loginViewBool;
    }

    public Boolean getCreateViewBool(){
        return isCreateView;
    }

    public void setCreateViewBool(boolean createViewBool){
        this.isCreateView = createViewBool;
    }

    public Boolean getAccountViewBool(){
        return isUsersAccountView;
    }

    public void setAccountViewBool(boolean accountViewBool){
        this.isUsersAccountView = accountViewBool;
    }

    //isUsersAccountView
    public String getUsernameGiven() {
        return usernameGiven;
    }

    public void setUsernameGiven(String usernameGiven) {
        this.usernameGiven = usernameGiven;
    }

    public String getPasswordGiven() {
        return passwordGiven;
    }
    public void setPasswordGiven(String passwordGiven) {
        this.passwordGiven = passwordGiven;
    }

    public ArrayList<String> getUsernamesList() {
        return usernamesList;
    }
    public ArrayList<String> getPasswordsList() {
        return passwordsList;
    }
    public ArrayList<AccountType> getAccountTypeList() {
        return accountTypeList;
    }

    public boolean isDepositeView() {
        return isDepositeView;
    }

    public void setDepositeView(boolean depositeView) {
        isDepositeView = depositeView;
    }

    public boolean isWithdrawalView() {
        return isWithdrawalView;
    }

    public void setWithdrawalView(boolean withdrawalView) {
        isWithdrawalView = withdrawalView;
    }

    public float getBalanceFloat() {
        return balanceFloat;
    }

    public void setBalanceFloat(float balanceFloat) {
        this.balanceFloat = balanceFloat;
    }


    //accountTypeList

}
