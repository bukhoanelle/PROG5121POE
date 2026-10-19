package prog5121poe;

import java.util.Scanner;

//Public class evaluation 

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

        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter a username: ");
        String username = input.nextLine();

        System.out.print("Enter a password: ");
        String password = input.nextLine();

        System.out.print("Enter your cell phone number (+27): ");
        String cellPhone = input.nextLine();

        String registrationMessage = registration.registerUser(firstName, lastName, username, password, cellPhone);
        System.out.println(registrationMessage);

        //Checking if registration succeeds
        if (registrationMessage.contains("Username successfully captured.")
                && registrationMessage.contains("Password successfully captured.")
                && registrationMessage.contains("Cell number successfully captured.")) {
            registeredSuccessfully = true;
        }

        // Login section - only offered if registration succeeded
        if (registeredSuccessfully) {
            System.out.println("\n Login ");

            System.out.print("Enter your username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter your password: ");
            String loginPassword = input.nextLine();

            boolean loginSuccessful = login.loginUser(loginUsername, loginPassword);
            System.out.println(login.returnLoginStatus(loginSuccessful));

        } else {
            System.out.println("\nRegistration was not successful, so login cannot proceed.");
        }

        input.close();
    }
}
}
 

