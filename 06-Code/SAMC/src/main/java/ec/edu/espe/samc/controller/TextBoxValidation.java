package ec.edu.espe.samc.controller;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TextBoxValidation {

    /**
     * Validates that no input field is empty.
     * @param fields Varargs of JTextField or JPasswordField to validate
     * @return true if all fields are filled, false otherwise
     */
    public static boolean validateFields(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    /**
     * Overloaded method to handle JPasswordFields.
     * @param passwordFields Varargs of JPasswordField to validate
     * @return true if all password fields are filled, false otherwise
     */
    public static boolean validateFields(JPasswordField... passwordFields) {
        for (JPasswordField passwordField : passwordFields) {
            if (new String(passwordField.getPassword()).trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
}