package prog5121poe;
 
import java.util.Scanner;


 //This the public class 


public class Main {
 
    
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login(null);
 
        // Registration section
        
        System.out.println("QUICKCHAT REGISTRATION");
        
      //Asking for first name
 
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        
        //Asking to enter last name
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        //Asking to enter username 
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        //Asking to enter password
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        //Asking for South African cellphone number 
        System.out.print("Enter your South African cell phone number: ");
        String cellphone = scanner.nextLine();
 
  //Registration results being displayed here 
        
        System.out.println("REGISTRATION RESULTS");
       
        
 
        System.out.println(login.checkUserNameMessage(username));
        System.out.println(login.checkPasswordMessage(password));
        System.out.println(login.checkCellPhoneMessage(cellphone));
 
        String registerResult = login.registerUser(firstName, lastName, username, password, cellphone);
        System.out.println(registerResult);
 
        //Login section
        if (registerResult.equals("User successfully registered.")) {
 
            
            
            System.out.println("LOGIN");
           
           
 
            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();
 
            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();
 
            String loginStatus = login.returnLoginStatus(loginUsername, loginPassword);
            System.out.println(loginStatus);
        }
 
        scanner.close();
    }
}
 

