package prog5121poe;

public class Login {
    private Registration registration;

    public Login(Registration registration) {
        this.registration = registration;
    }

    // Checks that the username contains an underscore and is no more than 5 characters long
    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Checks password complexity: at least 8 characters, a capital letter, a number, and a special character
    public static boolean checkPasswordComplexity(String password) {
        boolean hasCapitalLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);

            if (Character.isUpperCase(character)) {
                hasCapitalLetter = true;
            } else if (Character.isDigit(character)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(character)) {
                hasSpecialCharacter = true;
            }
        }

        boolean isLongEnough = password.length() >= 8;
        return isLongEnough && hasCapitalLetter && hasNumber && hasSpecialCharacter;
    }

    // Checks that the cell phone number starts with a country code (e.g. +27)
    // followed by no more than 10 further digits.
    // Regex approach adapted from: https://www.baeldung.com/java-regex-validate-phone-numbers
    public static boolean checkCellPhoneNumber(String cellPhone) {
        String regex = "^\\+\\d{1,3}\\d{1,10}$";
        return cellPhone.matches(regex);
    }

    public boolean loginUser(String username, String password) {
        return username.equals(registration.getUsername())
                && password.equals(registration.getPassword());
    }

    public String returnLoginStatus(boolean loginSuccessful) {
        if (loginSuccessful) {
            return "Welcome " + registration.getFirstName() + ", "
                    + registration.getLastName() + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}