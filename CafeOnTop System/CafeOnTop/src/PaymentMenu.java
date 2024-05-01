import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentMenu extends JFrame {
    private JComboBox<String> tableComboBox;
    private JComboBox<String> paymentComboBox;
    private JTextArea textArea;
    private PaymentModel paymentModel;

    public PaymentMenu(double totalCost) {
        paymentModel = new PaymentModel(totalCost);

        JPanel panel = new JPanel();
        setSize(450, 300);
        setTitle("Payment");
        add(panel);

        panel.setLayout(null);

        JLabel tableLabel = new JLabel("Table Number:");
        tableLabel.setBounds(10, 20, 100, 25);
        panel.add(tableLabel);

        String[] tableItems = {"001"};
        tableComboBox = new JComboBox<>(tableItems);
        tableComboBox.setBounds(120, 20, 165, 25);
        panel.add(tableComboBox);

        JLabel paymentLabel = new JLabel("Payment Type:");
        paymentLabel.setBounds(10, 50, 100, 25);
        panel.add(paymentLabel);

        String[] paymentItems = {"Card", "Cash", "Online Banking", "QR"};
        paymentComboBox = new JComboBox<>(paymentItems);
        paymentComboBox.setBounds(120, 50, 165, 25);
        panel.add(paymentComboBox);

        JLabel totalLabel = new JLabel("Total: RM " + totalCost + "0");
        totalLabel.setBounds(10, 80, 200, 25);
        panel.add(totalLabel);

        JButton confirmButton = new JButton("Confirm & Pay");
        confirmButton.setBounds(100, 110, 220, 25);
        confirmButton.addActionListener(e -> {
            String selectedTable = (String) tableComboBox.getSelectedItem();
            String selectedPayment = (String) paymentComboBox.getSelectedItem();
            paymentModel.addPaymentDetails(selectedTable, selectedPayment);
            textArea.setText(paymentModel.getPaymentDetails());
            JOptionPane.showMessageDialog(this, "Payment Successful!");
        });
        panel.add(confirmButton);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 140, 420, 120);
        panel.add(scrollPane);

        setVisible(true);
    }
}
