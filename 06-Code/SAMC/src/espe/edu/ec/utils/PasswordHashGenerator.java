package espe.edu.ec.utils;

public class PasswordHashGenerator {

    public static String generateHashedPassword(String password) {
        return PasswordUtils.hashPassword(password);
    }
}


