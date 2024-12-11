package espe.edu.ec.utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import espe.edu.ec.model.Bill;
import espe.edu.ec.model.MenuItem;
import espe.edu.ec.model.SaleNote;
import com.google.gson.Gson;
import espe.edu.ec.model.Customer;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class ManageFileJson {
    private final Gson gson;
    public ManageFileJson() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void saveBillToJson(Bill bill) {
        List<Bill> bills = new ArrayList<>();
        try (FileReader reader = new FileReader("bills.json")) {
            bills = gson.fromJson(reader, new TypeToken<List<Bill>>() {}.getType());
            if (bills == null) {
                bills = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo bills.json, se creara uno nuevo.");
        }
         boolean clienteExistente = bills.stream()
            .anyMatch(existingBill -> existingBill.getCustomer().getName().equals(bill.getCustomer().getName()));

        if (!clienteExistente) {
            bills.add(bill);
            try (FileWriter writer = new FileWriter("bills.json")) {
                gson.toJson(bills, writer);
                System.out.println("Factura guardada correctamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Ya existe una factura para este cliente.");
        }
    }


    public void saveSaleNoteToJson(SaleNote saleNote) {
        List<SaleNote> saleNotes = new ArrayList<>();

        try (FileReader reader = new FileReader("sale_notes.json")) {
            saleNotes = gson.fromJson(reader, new TypeToken<List<SaleNote>>() {}.getType());
            if (saleNotes == null) {
                saleNotes = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo sale_notes.json, se creara uno nuevo.");
        }

        boolean clienteExistente = saleNotes.stream()
            .anyMatch(existingSaleNote -> existingSaleNote.getCustomer().getName().equals(saleNote.getCustomer().getName()));

        if (!clienteExistente) {
            saleNotes.add(saleNote);
            try (FileWriter writer = new FileWriter("sale_notes.json")) {
                gson.toJson(saleNotes, writer);
                System.out.println("Nota de venta guardada correctamente.");
            } catch (IOException e) {
                System.out.println("Error al guardar la nota de venta en JSON: " + e.getMessage());
            }
        } else {
            System.out.println("Ya existe una nota de venta para este cliente.");
        }
    }
    public void saveCommentToJson(String comment) {
        try (FileWriter writer = new FileWriter("comments.json", true)) {
            String json = gson.toJson(comment);
            writer.write(json + "\n");
            System.out.println("Comentario guardado en el archivo comments.json.");
        } catch (IOException e) {
            System.out.println("Error al guardar el comentario en JSON: " + e.getMessage());
        }
    }
    public Customer getCustomerById(String idCard) {
    try (FileReader reader = new FileReader("bills.json")) {
        List<Bill> bills = gson.fromJson(reader, new TypeToken<List<Bill>>() {}.getType());
        if (bills != null) {
            for (Bill bill : bills) {
                if (bill.getCustomer().getIdCard().equals(idCard)) {
                    return bill.getCustomer();
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer el archivo bills.json: " + e.getMessage());
    }
    return null;
}

    public Map<String, Integer> getOrderByCustomer(String idCard) {
        try (FileReader reader = new FileReader("bills.json")) {
            List<Bill> bills = gson.fromJson(reader, new TypeToken<List<Bill>>() {}.getType());
            if (bills != null) {
                for (Bill bill : bills) {
                    if (bill.getCustomer().getIdCard().equals(idCard)) {
                            return bill.getOrder();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo bills.json: " + e.getMessage());
        }
        return new HashMap<>();
    }
    public SaleNote getSalesNoteByCustomer(String idCard) {
        try (FileReader reader = new FileReader("sale_notes.json")) {
            List<SaleNote> saleNotes = gson.fromJson(reader, new TypeToken<List<SaleNote>>() {}.getType());
            if (saleNotes != null) {
                for (SaleNote saleNote : saleNotes) {
                    if (saleNote.getCustomer().getIdCard().equals(idCard)) {
                        return saleNote;
                    }
                }
            }
        }catch (IOException e) {
            System.out.println("Error al leer el archivo sale_notes.json: " + e.getMessage());
        }
        return null;
    }
    public void saveQuantitiesToJson() {
    List<Map<String, Object>> quantities = new ArrayList<>();
    for (MenuItem item : MenuItem.getMenuItems()) {
        Map<String, Object> itemData = new HashMap<>();
        itemData.put("id", item.getId());
        itemData.put("name", item.getName());
        itemData.put("quantity", item.getInventory());
        quantities.add(itemData);
    }
    try (FileWriter writer = new FileWriter("quantity.json")) {
        gson.toJson(quantities, writer);
        System.out.println("Inventario guardado correctamente en quantity.json.");
    }   catch (IOException e) {
        System.out.println("Error al guardar quantity.json: " + e.getMessage());
        }
    }
    public void loadQuantitiesFromJson() {
    try (FileReader reader = new FileReader("quantity.json")) {
        List<Map<String, Object>> quantities = gson.fromJson(reader, new TypeToken<List<Map<String, Object>>>() {}.getType());
        if (quantities != null) {
            for (Map<String, Object> itemData : quantities) {
                int id = ((Double) itemData.get("id")).intValue();
                int quantity = ((Double) itemData.get("quantity")).intValue();
                MenuItem item = MenuItem.getMenuItemById(id);
                if (item != null) {
                    item.reduceInventory(item.getInventory() - quantity);
                }
            }
        }
        System.out.println("Inventario cargado desde quantity.json.");
        }   catch (IOException e) {
        System.out.println("Error al cargar quantity.json: " + e.getMessage());
        }
    }
    
}