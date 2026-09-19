package prog5121poe;
 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
 

public class LoginTest {
 
    // ===================== assertEquals tests =====================
 
    @Test
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login(null);
        login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!");
 
        String result = login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!");
 
        assertEquals("Welcome Kyle, Smith it is great to see you.", result);
    }
 
    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login(null);
 
        String result = login.registerUser("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99!");
 
        assertEquals("Username is not correctly formatted; please ensure that your "
                + "username contains an underscore and is no more than five characters "
                + "in length.", result);
    }
 
    @Test
    public void testPasswordMeetsComplexityRequirements() {
        Login login = new Login(null);
 
        String result = login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!");
 
        assertEquals("Password successfully captured.", result);
    }
 
    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        Login login = new Login(null);
 
        String result = login.registerUser("Kyle", "Smith", "kyl_1", "password");
 
        assertEquals("Password is not correctly formatted; please ensure that the "
                + "password contains at least eight characters, a capital letter, "
                + "a number, and a special character.", result);
    }
 
    @Test
    public void testCellPhoneNumberCorrectlyFormatted() {
        Login login = new Login(null);
        login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!");
 
        String result = login.captureCellPhoneNumber("+27838968976");
 
        assertEquals("Cell number successfully captured.", result);
    }
 
    @Test
    public void testCellPhoneNumberIncorrectlyFormatted() {
        Login login = new Login(null);
        login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!");
 
        String result = login.captureCellPhoneNumber("08966553");
 
        assertEquals("Cell number is incorrectly formatted or does not contain an "
                + "international code; please correct the number and try again.", result);
    }
 
    // ===================== assertTrue / assertFalse tests =====================
 
    @Test
    public void testLoginSuccessful() {
        Login login = new Login(null);
        login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!");
 
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
 
    @Test
    public void testLoginFailed() {
        Login login = new Login(null);
        login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!");
 
        assertFalse(login.loginUser("kyl_1", "WrongPassword1!"));
    }
 
    @Test
    public void testUsernameFormatIsCorrect() {
        Login login = new Login(null);
 
        assertTrue(login.checkUserName("kyl_1"));
    }
 
    @Test
    public void testUsernameFormatIsIncorrect() {
        Login login = new Login(null);
 
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }
 
    @Test
    public void testPasswordComplexityIsMet() {
        Login login = new Login(null);
 
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
 
    @Test
    public void testPasswordComplexityIsNotMet() {
        Login login = new Login(null);
 
        assertFalse(login.checkPasswordComplexity("password"));
    }
 
    @Test
    public void testCellPhoneNumberFormatIsCorrect() {
        Login login = new Login(null);
 
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }
 
    @Test
    public void testCellPhoneNumberFormatIsIncorrect() {
        Login login = new Login(null);
 
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
}