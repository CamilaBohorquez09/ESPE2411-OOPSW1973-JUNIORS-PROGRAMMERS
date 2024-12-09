package espe.edu.ec.model;

public class SaleNote {

    public static void printSaleNote(MenuItem item, int quantity) {
        double total = item.getPrice() * quantity; 
        System.out.println("******** NOTA DE VENTA ********");
        System.out.println("Articulo: " + item.getName());
        System.out.println("Descripcion: " + item.getDescription());
        System.out.println("Cantidad: " + quantity);
        System.out.println("Precio Unitario: $" + item.getPrice());
        System.out.println("Total: $" + total);
        System.out.println("******************************");
    }
}

