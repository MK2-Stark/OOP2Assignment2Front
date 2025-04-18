public sealed class Account permits CheckingAccount, SavingsAccount {

    protected final String accountNumber;

    public Account (String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
}
