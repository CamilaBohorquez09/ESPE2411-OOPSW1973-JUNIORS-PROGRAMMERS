package espe.edu.ec.model;
import espe.edu.ec.utils.ManageFileJson;
import espe.edu.ec.utils.Validations;
import static espe.edu.ec.utils.Validations.validateEmail;
import static espe.edu.ec.utils.Validations.validateIDCard;
import static espe.edu.ec.utils.Validations.validatePhone;
import espe.edu.ec.utils.exceptions.InvalidIDCardException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Order {
    private Map<String, Integer> items;
    private int orderId;
    private int customerId;
    private String customerName;
    private List<MenuItem> orderedItems;
    private String tableNumber;
    private Date orderDate;
    private SaleNote saleNote;

public Order() {
        this.items = new HashMap<>();
        this.orderedItems = new ArrayList<>();
        this.orderDate = new Date();
    }

    public Order(Map<String, Integer> items) {
        this.items = items;
        this.orderId = 0;
        this.customerId = 0;
        this.customerName = "";
        this.orderedItems = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            MenuItem item = MenuItem.getMenuItemById(getMenuItemIdByName(entry.getKey()));
            if (item != null) {
                for (int i = 0; i < entry.getValue(); i++) {
                    this.orderedItems.add(item);
                }
            }
        }
        this.tableNumber = "";
        this.orderDate = new Date();
        this.saleNote = null;
    }    
    
    public void placeOrder(Scanner scanner, Validations validations, ManageFileJson manageFileJson) {
        
        System.out.print("Ingrese su nombre: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese su cedula: ");
        String idCard;
        boolean isValid = false;

        do {
        idCard = scanner.nextLine();
        try {
        if (!validateIDCard(idCard)) {
            throw new InvalidIDCardException("Cedula no valida.");
        }
        isValid = true;
        } catch (InvalidIDCardException e) {
        System.out.println(e.getMessage());
        System.out.print("Por favor, reingrese su cedula: ");
        }
        } while (!isValid);


        System.out.print("Ingrese su correo electronico: ");
        String email = scanner.nextLine();
        if (validateEmail(email)) {
        } else {
            System.out.println("Correo no valido.");
        }

        System.out.print("Ingrese su direccion: ");
        String address = validations.validateNonNullString();

        System.out.print("Ingrese su telefono : ");
        String phone = scanner.nextLine();
        if (validatePhone(phone)) {
        } else {
            System.out.println("Telefono no valido. Debe tener 10 digitos.");
        }

        Customer customer = new Customer(name, idCard, email, address, phone);
        Map<String, Integer> order = new HashMap<>();

        System.out.println("Seleccione los platos (ingrese '0' para terminar): ");
        MenuItem.displayMenu();

        while (true) {
            System.out.print("Ingrese el ID del plato (ingrese '0' para terminar): ");
            int itemId = validations.validateInt();
            if (itemId == 0) break;

            System.out.print("Ingrese la cantidad: ");
            int quantity = validations.validateInt();

            MenuItem item = MenuItem.getMenuItemById(itemId);
            if (item != null) {
                if (item.getInventory() >= quantity) {
                    order.put(item.getName(), quantity);
                    item.reduceInventory(quantity);
                } else {
                    System.out.println("No hay suficiente inventario para " + item.getName());
                }
            } else {
                System.out.println("Plato no encontrado.");
            }
        }

        float total = new Counter().calculateTotal(order);
        SaleNote saleNote = new SaleNote(customer, order, total);

        manageFileJson.saveSaleNoteToJson(saleNote);

        Bill bill = new Bill(customer, order, total);
        
        manageFileJson.saveSaleNoteToJson(saleNote);
        manageFileJson.saveBillToJson(bill);
        manageFileJson.saveQuantitiesToJson();

        System.out.println("Pedido realizado con exito.");
    }
    private int getMenuItemIdByName(String name) {
        for (MenuItem item : MenuItem.getMenuItems()) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item.getId();
            }
        }
        return -1;
    }

    public float calculateOrderTotal() {
        float total = 0.0f;
        for (MenuItem item : orderedItems) {
            total += item.getPrice();
        }
        return total;
    }

    public Map<String, Integer> getItems() {
        Map<String, Integer> itemsMap = new HashMap<>();
        for (MenuItem item : orderedItems) {
            itemsMap.put(item.getName(), 1);
        }
        return itemsMap;
    }
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<MenuItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<MenuItem> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public SaleNote getSaleNote() {
        return saleNote;
    }

    public void setSaleNote(SaleNote saleNote) {
        this.saleNote = saleNote;
    }

    @Override
    public String toString() {
        StringBuilder itemsDetails = new StringBuilder();
        for (MenuItem item : orderedItems) {
            itemsDetails.append(item.getName()).append("\n");
        }
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", orderedItems=\n" + itemsDetails +
                ", tableNumber='" + tableNumber + '\'' +
                ", orderDate=" + orderDate +
                ", saleNote=" + saleNote +
                '}';
    }
}