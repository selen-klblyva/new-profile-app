package az.edu.turing.newprofileapp.exception;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(Long id) {
        super("User with id " + id + " not found");
    }
}
