package az.edu.turing.newprofileapp.exception;


public class ProfileAlreadyExistsException extends RuntimeException {
    public ProfileAlreadyExistsException(String username) {
        super("User with username " + username + " already exists.");
    }
}
