package espe.edu.ec.model;

import java.util.List;

/**
 * Clase que representa un contador para cálculos contables.
 */
public class Counter{
    /**
     * Método para calcular el subtotal de una lista de elementos del menú.
     *
     * @param menuItems Lista de ítems del menú.
     * @return El subtotal calculado.
     */
    public float calculateSubtotal(List<MenuItem> menuItems) {
        // Implementación futura
        return 0.0f;
    }

    /**
     * Método para calcular el impuesto basado en el subtotal.
     *
     * @param subtotal Subtotal de los ítems del menú.
     * @param taxRate Tasa de impuesto (por ejemplo, 0.12 para 12%).
     * @return El impuesto calculado.
     */
    public float calculateTax(float subtotal, float taxRate) {
        // Implementación futura
        return 0.0f;
    }

    /**
     * Método para calcular el total basado en el subtotal y el impuesto.
     *
     * @param subtotal Subtotal de los ítems del menú.
     * @param tax Impuesto calculado.
     * @return El monto total.
     */
    public float calculateTotal(float subtotal, float tax) {
        // Implementación futura
        return 0.0f;
    }

    /**
     * Método para calcular el total de una nota de venta.
     *
     * @param saleNote La nota de venta.
     * @return El total calculado para la nota de venta.
     */
    public float calculateSaleNoteTotal(SaleNote saleNote) {
        // Implementación futura
        return 0.0f;
    }

    /**
     * Método para calcular los totales acumulados de múltiples notas de venta.
     *
     * @param saleNotes Lista de notas de venta.
     * @return El total acumulado.
     */
    public float calculateTotalForAllSaleNotes(List<SaleNote> saleNotes) {
        // Implementación futura
        return 0.0f;
    }

    /**
     * Método para calcular el total de ítems vendidos en todas las notas.
     *
     * @param saleNotes Lista de notas de venta.
     * @return El número total de ítems vendidos.
     */
    public int calculateTotalItemsSold(List<SaleNote> saleNotes) {
        // Implementación futura
        return 0;
    }
}