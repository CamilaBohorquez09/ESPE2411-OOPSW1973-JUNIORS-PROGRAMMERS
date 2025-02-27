package ec.edu.espe.samc.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TextBoxValidation {
    /**
     * Validates that no input field is empty.
     * @param parent The JFrame to center the error message on
     * @param fields Varargs of JTextField or JPasswordField to validate
     * @return true if all fields are filled, false otherwise
     */
    public static boolean validateFields(JFrame parent, JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(parent, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    /**
     * Overloaded method to handle JPasswordFields.
     * @param parent The JFrame to center the error message on
     * @param passwordFields Varargs of JPasswordField to validate
     * @return true if all password fields are filled, false otherwise
     */
    public static boolean validateFields(JFrame parent, JPasswordField... passwordFields) {
        for (JPasswordField passwordField : passwordFields) {
            if (new String(passwordField.getPassword()).trim().isEmpty()) {
                JOptionPane.showMessageDialog(parent, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
}