package prog5121poe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testCheckUserName() {
        // Username is correctly formatted: contains an underscore and is no more than five characters long
        assertTrue(Login.checkUserName("kyl_1"));

        // Username is incorrectly formatted: no underscore, too long
        assertFalse(Login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        // Password meets complexity requirements
        assertTrue(Login.checkPasswordComplexity("Ch&&sec@ke99!"));

        // Password does not meet complexity requirements
        assertFalse(Login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumber() {
        // Cell phone number is correctly formatted
        assertTrue(Login.checkCellPhoneNumber("+27838968976"));

        // Cell phone number is incorrectly formatted
        assertFalse(Login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testLoginUser() {
        Registration registration = new Registration();
        registration.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

        Login login = new Login(registration);

        // Login successful: matching username and password
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));

        // Login failed: wrong password
        assertFalse(login.loginUser("kyl_1", "wrongPassword1!"));
    }

    @Test
    public void testReturnLoginStatus() {
        Registration registration = new Registration();
        registration.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

        Login login = new Login(registration);

        boolean successfulLogin = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Welcome Kyle, Smith it is great to see you again.", login.returnLoginStatus(successfulLogin));

        boolean failedLogin = login.loginUser("kyl_1", "wrongPassword1!");
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(failedLogin));
    }
}