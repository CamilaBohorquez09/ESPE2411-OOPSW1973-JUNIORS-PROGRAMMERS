package espe.edu.ec.controller;

import espe.edu.ec.model.Cashier;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase para manejar operaciones relacionadas con archivos CSV.
 */
public class ManageFileCsv {
    private static final String FILE_NAME = "customers.csv";

    public void saveToCsv(Cashier cashier) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.append(String.valueOf(cashier.getDniCustomer())).append(",");
            writer.append(cashier.getNameCustomer()).append(",");
            writer.append(cashier.getAddressOfCustomer()).append(",");
            writer.append(cashier.getEmailOfCustomer()).append(",");
            writer.append(cashier.getPhoneOfCustomer()).append("\n");
            System.out.println("Datos guardados en el archivo CSV.");
        } catch (IOException e) {
            System.out.println("Error al guardar en CSV: " + e.getMessage());
        }
    }
}