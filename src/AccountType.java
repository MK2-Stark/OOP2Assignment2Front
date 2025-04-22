// I did use AI to generate this commented field as a sort of documentation and explanation for the user. To save myself time. But the code is mine though, with some internet&Lecture notes help.
/** Documentation & Explanation For The Reader:
 *
 * Represents the type of account a user can have in the system.
 *
 * Each account type determines the specific set of functionalities,
 * services, or policies applicable to the user's account.
 *
 * Types of accounts:
 * - SAVINGS: Typically used for saving money with an interest rate.
 * - BASIC: A standard account for general purposes.
 * - BUSINESS: An account tailored for business-related transactions or activities.
 *
 * This enum is primarily used in scenarios like account creation,
 * authorization validation, and managing user accounts in the system.
 */
public enum AccountType {
    SAVINGS,
    BASIC,
    BUSINESS
}