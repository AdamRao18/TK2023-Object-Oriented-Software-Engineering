public class PaymentModel {
    private String paymentDetails;
    private double totalCost;

    public PaymentModel(double totalCost) {
        this.totalCost = totalCost;
    }

    public void addPaymentDetails(String tableNumber, String paymentType) {
        paymentDetails = "Payment Details:\nTable Number: " + tableNumber + "\nPayment Type: " + paymentType + "\nTotal: RM " + totalCost;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }
}
