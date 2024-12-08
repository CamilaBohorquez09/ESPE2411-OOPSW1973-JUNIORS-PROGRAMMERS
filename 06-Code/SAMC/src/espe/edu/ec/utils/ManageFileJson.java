package espe.edu.ec.utils;

import espe.edu.ec.model.Bill;
import espe.edu.ec.model.SaleNote;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

public class ManageFileJson {

    public void saveBillToJson(Bill bill) {
        try (FileWriter writer = new FileWriter("bill.json")) {
            Gson gson = new Gson();
            gson.toJson(bill, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar la factura en JSON.");
        }
    }

    public void saveSaleNoteToJson(SaleNote saleNote) {
        try (FileWriter writer = new FileWriter("saleNote.json")) {
            Gson gson = new Gson();
            gson.toJson(saleNote, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar la nota de venta en JSON.");
        }
    }
}