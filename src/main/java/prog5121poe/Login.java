package prog5121poe;
 
import java.util.regex.Pattern;
 
//This is Login.jav

public class Login {
 
    private Registration registration;
 
    public Login(Registration registration) {
        this.registration = registration;
    }
 
    //The boolean validation
    
    public boolean checkUserName(String username) {
        if (username == null) {
            return false;
        }
        return username.contains("_") && username.length() <= 5;
    }
 //Checking the password complexity
    
    public boolean checkPasswordComplexity(String password) {
        if (password == null) {
            return false;
        }
 
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
                // Anything that isn't a letter or digit counts as "special".
                hasSpecialCharacter = true;
            }
        }
 
        return password.length() >= 8 && hasCapitalLetter && hasNumber && hasSpecialCharacter;
    }
 
    //checking cellPhone number if it has South African code (+27)
    public boolean checkCellPhoneNumber(String cellphone) {
        if (cellphone == null) {
            return false;
        }
        // South African international format: +27 followed by exactly 9 digits.
        String southAfricanCellphoneRegex = "^\\+27\\d{9}$";
        return Pattern.matches(southAfricanCellphoneRegex, cellphone);
    }
 
    //This can also be used to print the registration results
    public String checkUserNameMessage(String username) {
        if (checkUserName(username)) {
            return "Username successfully captured.";
        }
        return "Username is not correctly formatted; please ensure that your username "
                + "contains an underscore and is no more than"
                + " five characters in length.";
    }
 //checking for password
    
    public String checkPasswordMessage(String password) {
        if (checkPasswordComplexity(password)) {
            return "Password successfully captured.";
            //Returning the password 
        }
        return "Password is not correctly formatted; please ensure that the password "
                + "contains at least eight characters,"
                + " a capital letter, "
                + "a number, and "
                + "a special character.";
    }
 
    public String checkCellPhoneMessage(String cellphone) {
        if (checkCellPhoneNumber(cellphone)) {
            return "Cell number successfully captured.";
        }
        return "Cell number is incorrectly formatted or does not contain an international code; please correct "
                + "the number and try again.";
    }
 
    //This the validation of the registration
    
    public String registerUser(
            String firstName,
            String lastName, 
            String username,
            String password,
            String cellphone) {
        boolean usernameValid = checkUserName(username);
        boolean passwordValid = checkPasswordComplexity(password);
        boolean cellphoneValid = checkCellPhoneNumber(cellphone);
 
        if (usernameValid && passwordValid && cellphoneValid) {
            this.registration = new Registration(firstName, lastName, username, password, cellphone);
            return "User successfully registered.";
        }
 
        return "User registration failed. Please correct the details above and try again.";
    }
 
    // Verification that the given username and password do match
    
    public boolean loginUser(String loginUsername, String loginPassword) {
        if (registration == null) {
            return false;
        }
        return registration.getUsername().equals(loginUsername)
                && registration.getPassword().equals(loginPassword);
    }
 
    /**
     * Returns the appropriate login status message.
     */
    public String returnLoginStatus(String loginUsername, String loginPassword) {
        if (loginUser(loginUsername, loginPassword)) {
            return "Welcome " + registration.getFirstName() + ", " + registration.getLastName() + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
}
 


