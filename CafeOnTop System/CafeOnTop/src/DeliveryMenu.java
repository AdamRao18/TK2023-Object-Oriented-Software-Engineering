import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeliveryMenu extends JFrame {
    private JTextArea detailsArea;
    private JButton confirmButton, addButton;
    private JTextField nameField, addressField, phoneField;
    private DeliveryModel deliveryModel;

    public DeliveryMenu(String food, String drink, double totalCost, String tableNumber) {
        deliveryModel = new DeliveryModel();

        JPanel panel = new JPanel();
        setSize(400, 500);
        setTitle("Delivery");
        add(panel);

        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        nameLabel.setBounds(10, 10, 100, 25);
        nameField.setBounds(120, 10, 200, 25);
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField();
        addressLabel.setBounds(10, 40, 100, 25);
        addressField.setBounds(120, 40, 200, 25);
        panel.add(addressLabel);
        panel.add(addressField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();
        phoneLabel.setBounds(10, 70, 100, 25);
        phoneField.setBounds(120, 70, 200, 25);
        panel.add(phoneLabel);
        panel.add(phoneField);

        JLabel foodLabel = new JLabel("Food: " + food);
        foodLabel.setBounds(10, 100, 300, 25);
        panel.add(foodLabel);

        JLabel drinkLabel = new JLabel("Beverage: " + drink);
        drinkLabel.setBounds(10, 130, 300, 25);
        panel.add(drinkLabel);

        addButton = new JButton("Add");
        addButton.setBounds(10, 160, 100, 25);
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            deliveryModel.addDeliveryDetails(name, address, phone, food, drink, totalCost, tableNumber);
            detailsArea.setText(deliveryModel.getDeliveryDetails());
        });
        panel.add(addButton);
        
        confirmButton = new JButton("Confirm Delivery");
        confirmButton.setBounds(200, 160, 150, 25);
        confirmButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Delivery confirmed for Table " + tableNumber);
            dispose();
            new PaymentMenu(totalCost);
        });
        panel.add(confirmButton);

        setVisible(true);

        JLabel deliveryLabel = new JLabel("Delivery Details:");
        deliveryLabel.setBounds(10, 190, 100, 25);
        panel.add(deliveryLabel);

        detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(detailsArea);
        scrollPane.setBounds(10, 220, 360, 200);
        panel.add(scrollPane);
        
    }
}
