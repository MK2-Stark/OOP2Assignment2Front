public sealed class Account permits BasicAccount, SavingsAccount, BusinessAccount {

    protected final String accountNumber;

    public Account (String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
}
