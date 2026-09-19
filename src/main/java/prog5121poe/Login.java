/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121poe;

/**
 *
 * @author Student
 */
public class Login {
    private Registration registration;

    public Login(Registration registration){
        this.registration = registration;
    } 
    public boolean  checkUserName(String username){
        return username.contains("_")&& username.length()<=5;
    }
      //Checking password complexity
    public boolean checkPasswordComplexity(String password){
     boolean ithasCapitalletter = false; 
     boolean hasNumber = false;
     boolean hasSpecialCharacter = false;
     for (int i = 0; i < password.length(); i++){
        char character = password.charAt(i);
        
        if (character.isUpperCase(character)){
            boolean hasCapitalLetter = true;
        }
        
     }
    }
    
   
    
}
