package espe.edu.ec.model;
/**
 * Clase que representa un método de pago: Transferencia o Efectivo.
 */
public class MethodsOfPayment {
    private int idPaymentMethod;
    private String paymentType; 
    private float amount;
    private boolean isPaymentCompleted;
    
    
    @Override
    public String toString() {
        return "PaymentMethod{" +
                "idPaymentMethod=" + idPaymentMethod +
                ", paymentType='" + paymentType + '\'' +
                ", amount=" + amount +
                ", isPaymentCompleted=" + isPaymentCompleted +
                '}';
    }

    public MethodsOfPayment(Bill bill, SaleNote salenote) {
    }

    public MethodsOfPayment(int idPaymentMethod, String paymentType, float amount, boolean isPaymentCompleted) {
        this.idPaymentMethod = idPaymentMethod;
        this.paymentType = paymentType;
        this.amount = amount;
        this.isPaymentCompleted = isPaymentCompleted;
    }
    public int getIdPaymentMethod(Order order) {
        return idPaymentMethod;
    }

    public void setIdPaymentMethod(int idPaymentMethod) {
        this.idPaymentMethod = idPaymentMethod;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isPaymentCompleted() {
        return isPaymentCompleted;
    }

    public void setPaymentCompleted(boolean isPaymentCompleted) {
        this.isPaymentCompleted = isPaymentCompleted;
    }

    public void completePayment() {
        if (!isPaymentCompleted) {
            this.isPaymentCompleted = true;
            System.out.println("El pago ha sido completado.");
        } else {
            System.out.println("El pago ya estaba completado.");
        }
    }

    public void cancelPayment() {
        if (!isPaymentCompleted) {
            System.out.println("El pago ha sido cancelado.");
        } else {
            System.out.println("No se puede cancelar un pago ya completado.");
        }
    }

    public String getPaymentStatus() {
        return isPaymentCompleted ? "Pago completado" : "Pago pendiente";
    }
}
