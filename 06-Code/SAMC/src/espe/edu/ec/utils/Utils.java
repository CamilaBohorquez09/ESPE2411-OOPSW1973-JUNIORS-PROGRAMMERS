package espe.edu.ec.utils;

import java.util.Scanner;

public class Utils {
    
    public void validarOpcion(int choice) {
        while (choice < 1 || choice > 5) {
            System.out.println("Opcion no valida. Por favor, ingrese una opcion valida entre 1 y 5.");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Seleccione una opción: ");
            choice = Integer.parseInt(scanner.nextLine());
        }
    }
    
     public void validarOpcionMenu(int choice) {
        while (choice < 1 || choice >= 19) {
            System.out.println("Opcion no valida. Por favor, ingrese una opcion valida entre 1-19");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Seleccione una opcion: ");
            choice = Integer.parseInt(scanner.nextLine());
        }
    }

    
    public int validarEntero() {
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

   
    public String validarCadenaNoVacia() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (input.isEmpty()) {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("El campo no puede estar vacio. Por favor ingrese un valor.");
            }
        }
        return input;
    }

    
    public String validarEmail() {
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
    
    
    public int validarCantidad() {
        Scanner scanner = new Scanner(System.in);
        int cantidad = -1;
        while (cantidad <= 0) {
            try {
                cantidad = Integer.parseInt(scanner.nextLine());
                if (cantidad <= 0) {
                    System.out.println("La cantidad debe ser un número mayor que 0. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Dato inválido. Ingrese un número entero positivo.");
            }
        }
        return cantidad;
    }
    

 public String validarTelefono() {
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



public boolean esCedulaValida(String cedula) {
    int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
    int total = 0;
    int digitoVerificador;
    int ultimoDigito = Integer.parseInt(cedula.substring(9, 10)); // Último dígito (verificador)

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

