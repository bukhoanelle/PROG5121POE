package prog5121poe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationTest {

    @Test
    public void testRegisterUser_UsernameIncorrectlyFormatted() {
        Registration registration = new Registration();
        String result = registration.registerUser("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }

    @Test
    public void testRegisterUser_PasswordDoesNotMeetComplexity() {
        Registration registration = new Registration();
        String result = registration.registerUser("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testRegisterUser_CellPhoneIncorrectlyFormatted() {
        Registration registration = new Registration();
        String result = registration.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertEquals("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.", result);
    }

    @Test
    public void testRegisterUser_AllFieldsValid() {
        Registration registration = new Registration();
        String result = registration.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username successfully captured. Password successfully captured. Cell number successfully captured.", result);
    }
}