import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FeedbackView {
    private JFrame frame;
    private JComboBox<String> busIdComboBox;
    private JTextField nameField;
    private JTextField emailField;
    private JComboBox<Integer> starScaleComboBox;
    private JTextArea feedbackArea;
    private JButton submitButton;
    private JTextArea feedbackListArea;
    private List<Feedback> feedbackList;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JLabel lblNewLabel;

    public FeedbackView(List<Bus> buses) {
        frame = new JFrame("Feedback Form");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(new GridLayout(6, 2, 5, 5));

        JLabel label = new JLabel("Bus ID:");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 16));
        mainPanel.add(label);
        busIdComboBox = new JComboBox<>();
        for (Bus bus : buses) {
            busIdComboBox.addItem(bus.getBusNumber());
        }
        mainPanel.add(busIdComboBox);

        JLabel label_1 = new JLabel("Name:");
        label_1.setForeground(Color.WHITE);
        label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        mainPanel.add(label_1);
        nameField = new JTextField(20);
        mainPanel.add(nameField);

        JLabel label_2 = new JLabel("Email:");
        label_2.setForeground(Color.WHITE);
        label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
        mainPanel.add(label_2);
        emailField = new JTextField(20);
        mainPanel.add(emailField);

        JLabel label_3 = new JLabel("Star Scale (1-5):");
        label_3.setForeground(Color.WHITE);
        label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
        mainPanel.add(label_3);
        starScaleComboBox = new JComboBox<>();
        for (int i = 1; i <= 5; i++) {
            starScaleComboBox.addItem(i);
        }
        mainPanel.add(starScaleComboBox);

        JLabel label_4 = new JLabel("Feedback:");
        label_4.setForeground(Color.WHITE);
        label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
        mainPanel.add(label_4);
        feedbackArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        mainPanel.add(scrollPane);

        submitButton = new JButton("Submit");
        mainPanel.add(submitButton);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        feedbackListArea = new JTextArea(7, 40);
        feedbackListArea.setFont(new Font("Monospaced", Font.BOLD, 15));
        feedbackListArea.setEditable(false);
        JScrollPane listScrollPane = new JScrollPane(feedbackListArea);
        frame.getContentPane().add(BorderLayout.SOUTH, listScrollPane);
        
        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        
        lblNewLabel = new JLabel("Feedback Section");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(lblNewLabel);
        
        panel_1 = new JPanel();
        panel_1.setBackground(Color.BLACK);
        frame.getContentPane().add(panel_1, BorderLayout.WEST);
        
        panel_2 = new JPanel();
        panel_2.setBackground(Color.BLACK);
        frame.getContentPane().add(panel_2, BorderLayout.EAST);

        feedbackList = new ArrayList<>();
    }

    public void createAndShowGUI() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(e -> {
            // Check if any field is empty
            if (getName().isEmpty() || getEmail().isEmpty() || getFeedback().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                listener.actionPerformed(e); // Proceed with submitting feedback
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }

    public String getSelectedBusId() {
        return busIdComboBox.getSelectedItem().toString();
    }

    public String getName() {
        return nameField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public int getStarScale() {
        return (int) starScaleComboBox.getSelectedItem();
    }

    public String getFeedback() {
        return feedbackArea.getText();
    }

    public void addFeedbackToList(Feedback feedback) {
        feedbackList.add(feedback);
        updateFeedbackListArea();
    }

    private void updateFeedbackListArea() {
        feedbackListArea.setText("");
        for (Feedback feedback : feedbackList) {
            feedbackListArea.append("Bus ID: " + feedback.getBusId() + "\n");
            feedbackListArea.append("Name: " + feedback.getName() + "\n");
            feedbackListArea.append("Email: " + feedback.getEmail() + "\n");
            feedbackListArea.append("Star Scale: " + feedback.getStarScale() + "\n");
            feedbackListArea.append("Feedback: " + feedback.getFeedback() + "\n\n");
        }
    }

    public void clearFields() {
        nameField.setText("");
        emailField.setText("");
        feedbackArea.setText("");
    }
}
