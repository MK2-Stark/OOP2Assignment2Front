
// I did use AI to generate this commented field as a sort of documentation and explanation for the user. To save myself time. But the code is mine though, with some internet&Lecture notes help.
/** Documentation & Explanation For The Reader.
 * Interface representing a validator for user account credentials and types.
 * This interface is designed to validate input details like username, password,
 * and account type before proceeding with any account-related operations.
 */
public interface IValidator {

    boolean createValidator(String username, String password, AccountType acType);
}
