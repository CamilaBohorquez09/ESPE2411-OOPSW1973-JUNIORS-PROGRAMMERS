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
    public int customerId;
    public String customerName;
    private List<MenuItem> orderedItems;
    private String tableNumber;
    private Date orderDate;
    public SaleNote saleNote;

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
//        for (Map.Entry<String, Integer> entry : items.entrySet()) {
//            MenuItem item = MenuItem.getMenuItemById(getMenuItemIdByName(entry.getKey()));
//            if (item != null) {
//                for (int i = 0; i < entry.getValue(); i++) {
//                    this.orderedItems.add(item);
//                }
//            }
//        }
        this.tableNumber = "";
        this.orderDate = new Date();
        this.saleNote = null;
    }    
    

    
    private int getMenuItemIdByName(String name) {
//        for (MenuItem item : MenuItem.getMenuItems()) {
//            if (item.getName().equalsIgnoreCase(name)) {
//                return item.getId();
//            }
//        }
        return -1;
    }

    public Map<String, Integer> getItems() {
        Map<String, Integer> itemsMap = new HashMap<>();
        for (MenuItem item : getOrderedItems()) {
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
        for (MenuItem item : getOrderedItems()) {
            itemsDetails.append(item.getName()).append("\n");
        }
        return "Order{" +
                "orderId=" + getOrderId() +
                ", customerId=" + getCustomerId() +
                ", customerName='" + getCustomerName() + '\'' +
                ", orderedItems=\n" + itemsDetails +
                ", tableNumber='" + getTableNumber() + '\'' +
                ", orderDate=" + getOrderDate() +
                ", saleNote=" + getSaleNote() +
                '}';
    }
}