package prog5121poe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Registration registration = new Registration();
        Login login = new Login(registration);

        // keep track of whether registration succeeded, so we don't
        // let the user try to log in before they've registered
        boolean registeredSuccessfully = false;

        // Registration section
        System.out.println(" Registration ");
        //Asking for username
        System.out.print("Enter a username: ");
        String username = input.nextLine();
        //Asking to enter password
        System.out.print("Enter a password: ");
        String password = input.nextLine();
        //Asking to enter cell phone number 
        System.out.print("Enter your cell phone number (with country code, e.g. +27...): ");
        String cellPhone = input.nextLine();

        String registrationMessage = registration.registerUser(username, password, cellPhone);
        System.out.println(registrationMessage);

        // check if registration actually succeeded by testing the
        // conditions again - if all pass, registration went through
        if (registrationMessage.contains("Username successfully captured.")
                && registrationMessage.contains("Password successfully captured.")
                && registrationMessage.contains("Cell phone number successfully added.")) {
            registeredSuccessfully = true;
        }

        // Login section - only offered if registration succeeded
        if (registeredSuccessfully) {
            System.out.println("\n Login ");

            System.out.print("Enter your username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter your password: ");
            String loginPassword = input.nextLine();

            login.loginUser(loginUsername, loginPassword);
            System.out.println(login.returnLoginStatus(loginUsername));

        } else {
            System.out.println("\nRegistration was not successful, so login cannot proceed.");
        }
    }
}