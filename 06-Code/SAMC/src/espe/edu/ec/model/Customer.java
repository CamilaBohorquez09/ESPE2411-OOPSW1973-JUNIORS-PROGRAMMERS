package espe.edu.ec.model;

import espe.edu.ec.utils.Validations;

import java.util.Scanner;

public class Customer {
    private String name;
    private String idCard;
    private String email;
    private String address;
    private String phoneNumber;

    public Customer(String name, String idCard, String email, String address, String phoneNumber) {
        this.name = name;
        this.idCard = idCard;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static Customer createCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del cliente: ");
        String name = scanner.nextLine();

        String idCard = null;
        while (idCard == null) {
            System.out.print("Ingrese la cédula del cliente (10 dígitos): ");
            String inputIdCard = scanner.nextLine();
            if (Validations.validateIDCard(inputIdCard)) {
                idCard = inputIdCard;
            } else {
                System.out.println("Cédula inválida. Debe tener 10 dígitos.");
            }
        }

        String email = null;
        while (email == null) {
            System.out.print("Ingrese el correo del cliente: ");
            String inputEmail = scanner.nextLine();
            if (Validations.validateEmail(inputEmail)) {
                email = inputEmail;
            } else {
                System.out.println("Correo electrónico inválido.");
            }
        }

        System.out.print("Ingrese la dirección del cliente: ");
        String address = scanner.nextLine();

        String phoneNumber = null;
        while (phoneNumber == null) {
            System.out.print("Ingrese el número de teléfono del cliente (10 dígitos): ");
            String inputPhoneNumber = scanner.nextLine();
            if (Validations.validatePhone(inputPhoneNumber)) {
                phoneNumber = inputPhoneNumber;
            } else {
                System.out.println("Número de teléfono inválido. Debe tener 10 dígitos.");
            }
        }

        return new Customer(name, idCard, email, address, phoneNumber);
    }

    public String getName() {
        return name;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

