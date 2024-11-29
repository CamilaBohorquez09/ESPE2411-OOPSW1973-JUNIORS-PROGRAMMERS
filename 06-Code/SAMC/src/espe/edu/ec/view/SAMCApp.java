package espe.edu.ec.view;

import espe.edu.ec.controller.ManageFileCsv;
import espe.edu.ec.controller.ManageFileJson;
import espe.edu.ec.model.Cashier;
import espe.edu.ec.model.Bill;

import java.util.Scanner;

/**
 * Clase principal para ingresar datos del cliente y generar una factura.
 */
public class SAMCApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cashier cashier = new Cashier();
        ManageFileCsv manageFileCsv = new ManageFileCsv();
        ManageFileJson manageFileJson = new ManageFileJson();

        System.out.print("Enter DNI: ");
        cashier.setDniCustomer(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Enter Name: ");
        cashier.setNameCustomer(scanner.nextLine());

        System.out.print("Enter Address: ");
        cashier.setAddressOfCustomer(scanner.nextLine());

        System.out.print("Enter Email: ");
        cashier.setEmailOfCustomer(scanner.nextLine());

        System.out.print("Enter Phone Number: ");
        cashier.setPhoneOfCustomer(scanner.nextLine());

        Bill bill = new Bill(cashier);

        manageFileCsv.saveToCsv(cashier);
        manageFileJson.saveToJson(cashier);

        System.out.println("Factura Generada:");
        System.out.println(bill);
    }
}
