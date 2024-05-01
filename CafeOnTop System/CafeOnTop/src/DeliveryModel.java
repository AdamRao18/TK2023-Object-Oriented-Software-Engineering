public class DeliveryModel {
    private String deliveryDetails;

    public void addDeliveryDetails(String name, String address, String phone, String food, String drink, double totalCost, String tableNumber) {
        deliveryDetails = "Delivery Details:\nName: " + name + "\nAddress: " + address + "\nPhone Number: RM " + phone +
                "\nFood: " + food + "\nBeverage: " + drink + "\nTotal: " + totalCost + "\nTable Number: " + tableNumber;
    }

    public String getDeliveryDetails() {
        return deliveryDetails;
    }
}
