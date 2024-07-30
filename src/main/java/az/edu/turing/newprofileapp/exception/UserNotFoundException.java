package az.edu.turing.newprofileapp.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String userNotFound){super("User not found");}
}