package espe.edu.ec.utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
    public static boolean validateOnlyLetters(String input) {
        return input.matches("[a-zA-ZnN]+");
    }

    public static boolean validateIDCard(String idCard) {
        if (idCard.length() != 10) {
            return false;
        }
        return idCard.matches("\\d{10}");
    }

    public static boolean validateEmail(String correo) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    public static int validateOption(int min, int max, Scanner scanner) {
        int option;
        while (true) {
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option >= min && option <= max) {
                    return option;
                } else {
                    System.out.println("Opcion fuera de rango. Ingrese una opcion valida entre " + min + " y " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un numero valido.");
            }
        }
    }

    public static boolean validatePhone(String telefono) {
        return telefono.matches("\\d{10}");
    }
    
    public void validateOption(int choice) {
        while (choice < 1 || choice > 5) {
            System.out.println("Opcion no valida. Por favor, ingrese una opcion valida entre 1 y 5.");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Seleccione una opcion: ");
            choice = Integer.parseInt(scanner.nextLine());
        }
    }
    
     public void validateMenuOption(int choice) {
        while (choice < 1 || choice >= 19) {
            System.out.println("Opcion no valida. Por favor, ingrese una opcion valida entre 1-19");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Seleccione una opcion: ");
            choice = Integer.parseInt(scanner.nextLine());
        }
    }

    
    public int validateInt() {
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        boolean isValid = false;
        while (!isValid) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Dato invalido. Por favor, ingrese un numero entero.");
            }
        }
        return number;
    }

   
    public String validateNonNullString() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (input.isEmpty()) {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("El campo no puede estar vacio. Por favor ingrese el dato solicitado.");
            }
        }
        return input;
    }

    
    public String validateEmail() {
        Scanner scanner = new Scanner(System.in);
        String email = "";
        while (true) {
            email = scanner.nextLine();
            if (email.contains("@") && email.contains(".")) {
                break;
            } else {
                System.out.println("Correo invalido. Ingrese un correo electronico valido.");
            }
        }
        return email;
    }
    
    
    public int validateQuantity() {
        Scanner scanner = new Scanner(System.in);
        int cantidad = -1;
        while (cantidad <= 0) {
            try {
                cantidad = Integer.parseInt(scanner.nextLine());
                if (cantidad <= 0) {
                    System.out.println("La cantidad debe ser un numero mayor que 0. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Dato inválido. Ingrese un número entero positivo.");
            }
        }
        return cantidad;
    }
    

 public String validatePhone() {
        Scanner scanner = new Scanner(System.in);
        String phone;
        while (true) {
            phone = scanner.nextLine();
            if (phone.matches("\\d{10}")) {  
                return phone;
            } else {
                System.out.println("Numero de telefono invalido .Ingrese nuevamente");
            }
        }
    }



public boolean isValidIDCard(String cedula) {
    int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
    int total = 0;
    int digitoVerificador;
    int ultimoDigito = Integer.parseInt(cedula.substring(9, 10));

    for (int i = 0; i < 9; i++) {
        total += Integer.parseInt(String.valueOf(cedula.charAt(i))) * coeficientes[i];
    }

  
    int modulo = total % 10;
    if (modulo == 0) {
        digitoVerificador = 0;
    } else {
        digitoVerificador = 10 - modulo;
    }

  
    return digitoVerificador == ultimoDigito;
}



}

