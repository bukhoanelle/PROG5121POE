package prog5121poe;

public class Registration {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellphone;

    public Registration() {
    }

    public String registerUser(String firstName, String lastName, String username, String password, String cellPhone) {
        if (!Login.checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!Login.checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!Login.checkCellPhoneNumber(cellPhone)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellphone = cellPhone;

        return "Username successfully captured. Password successfully captured. Cell number successfully captured.";
    }

    void setUsername(String username) {
        this.username = username;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void setCellPhone(String cellPhone) {
        this.cellphone = cellPhone;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }
}