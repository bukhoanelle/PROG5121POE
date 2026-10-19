# PROG5121 POE - Part 1

This is my Part 1 submission for PROG5121. It is a Java console app where a user registers and then logs in. I built it in NetBeans using Maven.

## What it does

- Asks for first name, last name, username, password and cell phone number
- Checks the username: it needs an underscore and must be 5 characters or less
- Checks the password: at least 8 characters, with a capital letter, a number and a special character
- Checks the cell phone number: it needs an international code like +27
- If registration works, it asks the user to log in and prints a welcome message

## Files

- Login.java - the checks and the login methods
- Registration.java - keeps the user's details and has the registerUser method
- Main.java - runs the program in the console
- LoginTest.java and RegistrationTest.java - JUnit tests

## How to run it

Open the project in NetBeans and run Main.java. To run the tests, right-click the project and click Test.

## Test data I used

- Username: kyl_1
- Password: Ch&&sec@ke99!
- Cell phone: +27838968976

The cell phone regex is from https://www.baeldung.com/java-regex-validate-phone-numbers

Cell phone regex adapted from https://www.baeldung.com/java-regex-validate-phone-numbers
