
// I did use AI to generate this commented field as a sort of documentation and explanation for the user. To save myself time. But the code is mine though, with some internet&Lecture notes help.
/** Documentation & Explanation For The Reader.
 * The IBankAccount interface defines the core functionality for managing basic
 * operations of a bank account. It provides methods for depositing and withdrawing
 * money from an account.
 *
 * Implementing classes are expected to provide specific logic for these operations,
 * including maintaining the account state based on the deposit and withdrawal actions.
 */
interface IBankAccount {

    void DepositMoney(int index, float amount);
    void WithdrawMoney(int index, float amount);


}
