
// I did use AI to generate this commented field as a sort of documentation and explanation for the user. To save myself time. But the code is mine though, with some internet&Lecture notes help.
/** Documentation & Explanation For The Reader.
 * Represents a user with information required for account creation and management.
 * This record holds the user's details including username, password, account type, and balance.
 *
 * Fields:
 * - username: The username of the user. Used for unique identification during login or account creation.
 * - password: The password associated with the user's account. Ensures secure access.
 * - accountType: The type of account the user holds. Can be one of SAVINGS, BASIC, or BUSINESS.
 * - balance: The user's account balance. Represents the current monetary amount in the account.
 */
public record Users(String username,
                    String password,
                    AccountType accountType,
                    float balance)
{

}
