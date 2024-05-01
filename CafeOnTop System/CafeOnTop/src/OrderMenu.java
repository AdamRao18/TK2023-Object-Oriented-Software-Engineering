import javax.swing.*;

public class OrderMenu extends JFrame {
    private JComboBox<String> foodComboBox;
    private JComboBox<String> drinkComboBox;
    private JComboBox<String> tableComboBox;
    private JTextArea textArea;
    private JButton payButton;
    private OrderModel orderModel;

    public OrderMenu() {
        orderModel = new OrderModel();

        JPanel panel = new JPanel();
        setSize(450, 300);
        setTitle("Place Order");
        add(panel);

        panel.setLayout(null);

        JLabel foodLabel = new JLabel("Food:");
        foodLabel.setBounds(10, 20, 100, 25);
        panel.add(foodLabel);

        foodComboBox = new JComboBox<>(orderModel.getFoodItems());
        foodComboBox.setBounds(120, 20, 165, 25);
        panel.add(foodComboBox);

        JLabel drinkLabel = new JLabel("Beverage:");
        drinkLabel.setBounds(10, 50, 100, 25);
        panel.add(drinkLabel);

        drinkComboBox = new JComboBox<>(orderModel.getDrinkItems());
        drinkComboBox.setBounds(120, 50, 165, 25);
        panel.add(drinkComboBox);

        JLabel tableLabel = new JLabel("Table Number:");
        tableLabel.setBounds(10, 80, 100, 25);
        panel.add(tableLabel);

        tableComboBox = new JComboBox<>(orderModel.getTableNumbers());
        tableComboBox.setBounds(120, 80, 165, 25);
        panel.add(tableComboBox);

        JButton placeOrderButton = new JButton("Place Order");
        placeOrderButton.setBounds(10, 110, 220, 25);
        placeOrderButton.addActionListener(e -> {
            String selectedFood = (String) foodComboBox.getSelectedItem();
            String selectedDrink = (String) drinkComboBox.getSelectedItem();
            String selectedTable = (String) tableComboBox.getSelectedItem();
            orderModel.addOrder(selectedFood, selectedDrink, selectedTable);
            textArea.setText(orderModel.getOrderDetails());
        });
        panel.add(placeOrderButton);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 140, 420, 120);
        panel.add(scrollPane);

        payButton = new JButton("Proceed");
        payButton.setBounds(250, 110, 100, 25);
        payButton.addActionListener(e -> {
            String[] orderDetails = orderModel.getCurrentOrder();
            new DeliveryMenu(orderDetails[0], orderDetails[1], Double.parseDouble(orderDetails[2]), orderDetails[3]);
        });
        panel.add(payButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        OrderMenu order = new OrderMenu();
        order.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
