package espe.edu.ec.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordUtils {

    // Método para hashear una contraseña
    public static String hashPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    // Método para validar la contraseña ingresada contra el hash almacenado
    public static boolean validatePassword(String enteredPassword, String storedHash) {
        BCrypt.Result result = BCrypt.verifyer().verify(enteredPassword.toCharArray(), storedHash);
        return result.verified;
    }
}
