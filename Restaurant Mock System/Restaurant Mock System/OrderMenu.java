import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OrderMenu extends JFrame implements ActionListener {
    private JComboBox<String> foodComboBox;
    private JComboBox<String> drinkComboBox;
    private JComboBox<String> tableComboBox;
    private JTextArea textArea;
    private JButton viewOrder;
    private String selectedFood;
    private String selectedDrink;
    private String selectedTable;

    public OrderMenu() {
        JPanel panel = new JPanel();
        setSize(450, 300);
        setTitle("Place Order");
        add(panel);

        panel.setLayout(null);

        JLabel foodLabel = new JLabel("Food:");
        foodLabel.setBounds(10, 20, 100, 25);
        panel.add(foodLabel);

        String[] foodItems = {"Nasi Ayam (RM 5.00)", "Nasi Lemak (RM 5.00)", "Pasta (RM 10.00)", "Burger (RM 15.00)"};
        foodComboBox = new JComboBox<>(foodItems);
        foodComboBox.setBounds(120, 20, 165, 25);
        panel.add(foodComboBox);

        JLabel drinkLabel = new JLabel("Beverage:");
        drinkLabel.setBounds(10, 50, 100, 25);
        panel.add(drinkLabel);

        String[] drinkItems = {"Plain Water (RM 2.00)", "Ice Milo (RM 4.00)", "Juice (RM 8.00)", "Coffee (RM 8.00)"};
        drinkComboBox = new JComboBox<>(drinkItems);
        drinkComboBox.setBounds(120, 50, 165, 25);
        panel.add(drinkComboBox);

        JLabel tableLabel = new JLabel("Table Number:");
        tableLabel.setBounds(10, 80, 100, 25);
        panel.add(tableLabel);

        String[] tableNumberList = {"001", "002", "003", "004", "005"};
        tableComboBox = new JComboBox<>(tableNumberList);
        tableComboBox.setBounds(120, 80, 165, 25);
        panel.add(tableComboBox);

        JButton placeOrderButton = new JButton("Place Order");
        placeOrderButton.setBounds(10, 110, 100, 25);
        placeOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedFood = (String) foodComboBox.getSelectedItem();
                selectedDrink = (String) drinkComboBox.getSelectedItem();
                selectedTable = (String) tableComboBox.getSelectedItem();

            }
        });
        panel.add(placeOrderButton);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 140, 420, 120);
        panel.add(scrollPane);

        viewOrder = new JButton("View Order");
        viewOrder.setBounds(160, 110, 220, 25);
        viewOrder.addActionListener(this);
        panel.add(viewOrder);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewOrder) {
            textArea.append("Order Details:\nFood: " + selectedFood + "\nBeverage: " + selectedDrink +
                    "\nTable Number: " + selectedTable + "\n");
        }
    }

    public static void main(String[] args) {
        OrderMenu order = new OrderMenu();
        order.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


