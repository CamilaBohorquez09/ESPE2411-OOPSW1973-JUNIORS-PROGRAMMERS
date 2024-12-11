package espe.edu.ec.utils;

import java.util.Scanner;

public class AdminPermissions {
    private String encryptedPassword;

    public AdminPermissions() {
        this.encryptedPassword = "cfokp123";
    }

    private String encryptPassword(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char newChar = (char) ((c - base + 2) % 26 + base);
                encrypted.append(newChar);
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    public boolean validatePassword(String inputPassword) {
        String encryptedInput = encryptPassword(inputPassword);
        return encryptedInput.equals(encryptedPassword);
    }
}
