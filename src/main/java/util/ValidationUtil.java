package util;

public class ValidationUtil {

    // Validate that a string is not null or empty
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    // Validate that a string represents a valid number
    public static boolean isValidNumber(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Validate minimum balance is above a certain threshold
    public static boolean isMinimumBalanceValid(double balance, double minimumThreshold) {
        return balance >= minimumThreshold;
    }

}
