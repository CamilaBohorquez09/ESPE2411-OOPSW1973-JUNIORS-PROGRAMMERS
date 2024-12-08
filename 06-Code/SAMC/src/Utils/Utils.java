package Utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static boolean validarSoloLetras(String input) {
        return input.matches("[a-zA-ZnN]+");
    }

    public static boolean validarCedula(String cedula) {
        if (cedula.length() != 10) {
            return false;
        }
        return cedula.matches("\\d{10}");
    }

    public static boolean validarCorreo(String correo) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    public static int validarOpcion(int min, int max, Scanner scanner) {
        int opcion;
        while (true) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion >= min && opcion <= max) {
                    return opcion;
                } else {
                    System.out.println("Opcion fuera de rango. Ingrese una opcion valida entre " + min + " y " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un numero valido.");
            }
        }
    }

    public static boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{9}");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        if (validarSoloLetras(nombre)) {
            System.out.println("Nombre valido.");
        } else {
            System.out.println("Nombre no valido. Solo se permiten letras.");
        }

        System.out.print("Ingrese su cedula (10 digitos): ");
        String cedula = scanner.nextLine();
        if (validarCedula(cedula)) {
            System.out.println("Cedula valida.");
        } else {
            System.out.println("Cedula no valida. Debe tener 10 digitos.");
        }

        System.out.print("Ingrese su correo electronico: ");
        String correo = scanner.nextLine();
        if (validarCorreo(correo)) {
            System.out.println("Correo valido.");
        } else {
            System.out.println("Correo no valido.");
        }

        System.out.print("Ingrese su telefono (9 digitos): ");
        String telefono = scanner.nextLine();
        if (validarTelefono(telefono)) {
            System.out.println("Telefono valido.");
        } else {
            System.out.println("Telefono no valido. Debe tener 9 digitos.");
        }

        System.out.print("Seleccione una opcion entre 1 y 5: ");
        int opcion = validarOpcion(1, 5, scanner);
        System.out.println("Opcion seleccionada: " + opcion);
    }
}

