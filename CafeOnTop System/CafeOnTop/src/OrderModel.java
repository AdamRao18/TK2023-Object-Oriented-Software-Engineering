public class OrderModel {
    private final double[] foodPrice = {5.00, 5.00, 10.00, 15.00};
    private final double[] drinkPrice = {2.00, 4.00, 8.00, 8.00};
    private final String[] foodItems = {"Nasi Ayam (RM 5.00)", "Nasi Lemak (RM 5.00)", "Pasta (RM 10.00)", "Burger (RM 15.00)"};
    private final String[] drinkItems = {"Plain Water (RM 2.00)", "Ice Milo (RM 4.00)", "Juice (RM 8.00)", "Coffee (RM 8.00)"};
    private final String[] tableNumberList = {"001", "002", "003", "004", "005"};
    private String selectedFood;
    private String selectedDrink;
    private String selectedTable;
    private double totalCost;

    public String[] getFoodItems() {
        return foodItems;
    }

    public String[] getDrinkItems() {
        return drinkItems;
    }

    public String[] getTableNumbers() {
        return tableNumberList;
    }

    public void addOrder(String food, String drink, String table) {
        selectedFood = food;
        selectedDrink = drink;
        selectedTable = table;
        int foodIndex = getIndex(foodItems, food);
        int drinkIndex = getIndex(drinkItems, drink);
        totalCost = foodPrice[foodIndex] + drinkPrice[drinkIndex];
    }

    public String getOrderDetails() {
        return "Order Details:\nFood: " + selectedFood + "\nBeverage: " + selectedDrink + "\nTotal: RM " + totalCost +
                "\nTable Number: " + selectedTable;
    }

    public String[] getCurrentOrder() {
        return new String[]{selectedFood, selectedDrink, String.valueOf(totalCost), selectedTable};
    }

    private int getIndex(String[] array, String item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
}
