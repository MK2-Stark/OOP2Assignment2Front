import java.util.ArrayList;

public class Validator implements IValidator {

    private Accounts valAccounds;
    private ArrayList<String> usernamesExisting;
    private ArrayList<String> passwordsExisting;
    public Validator(Accounts valAccounds) {
        this.valAccounds = valAccounds;
    }


    @Override
    public boolean createValidator(String username, String password, AccountType acType) {
        clearUsernamesArrayList();
        clearPasswordsArrayList();
        //fillUsernamesArrayList();
        //fillPasswordsArrayList();
        try{
            //check if this username doesn't already exist.
            if(usernamesExisting.contains(username)) {
                System.out.println("Invalid username or password, This username already exists.");
                return false;
            }

            if(!checkIfOnlyLettersAndNumbers(username) || !checkIfOnlyLettersAndNumbers(password)){
                System.out.println("Invalid username or password, Must ONLY contain LETTERS AND NUMBERS.");
                return false;
            }
            System.out.println("Username and password are VALID. Success.");
            return true;
        } catch(NullPointerException e){
            System.out.println("NullPointerException Error: " + e.getMessage());
            System.out.println("NullPointerException Error: Username and/or password might be null");
            return false;
        } catch(Exception e){
            System.out.println("Exception Error: " + e.getMessage());
            return false;
        }

    }

    private boolean checkIfOnlyLettersAndNumbers(String stringToCheck){
        //check if the username and or passord only have numbers and letters in them.
        return stringToCheck != null && stringToCheck.matches("^[a-zA-Z0-9]+$");
    }

    public void clearUsernamesArrayList(){
        if(usernamesExisting != null){
            if(!usernamesExisting.isEmpty()){
                usernamesExisting.clear();
                usernamesExisting = null;
                System.out.println("Cleared the arraylist");
            }
        }
        this.usernamesExisting = new ArrayList<>(valAccounds.getUsernamesList());
        System.out.println("Refilled usernames arraylist: "+usernamesExisting);
    }

    public void clearPasswordsArrayList(){
        if(passwordsExisting != null){
            if(!passwordsExisting.isEmpty()){
                passwordsExisting.clear();
                passwordsExisting = null;
                System.out.println("Cleared the arraylist");
            }
        }
        this.passwordsExisting = new ArrayList<>(valAccounds.getPasswordsList());
        System.out.println("Refilled usernames arraylist: "+passwordsExisting);
    }

}
