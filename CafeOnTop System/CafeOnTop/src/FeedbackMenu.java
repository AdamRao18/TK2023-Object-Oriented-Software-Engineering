import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FeedbackMenu extends JFrame implements ActionListener {
    private JLabel titleLabel, feedbackLabel, nameLabel, emailLabel, ratingLabel;
    private JTextField nameField, emailField;
    private JTextArea feedbackTextArea;
    private JButton submitButton;
    private FeedbackModel feedbackModel;
    private JComboBox<Integer> ratingComboBox; 

    public FeedbackMenu() {
        setTitle("Cafe on Top - Feedback System");
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        titleLabel = new JLabel("Cafe on Top", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        ratingLabel = new JLabel("Rating:");
        Integer[] ratings = {1, 2, 3, 4, 5};
        ratingComboBox = new JComboBox<>(ratings);

        feedbackLabel = new JLabel("Please share your feedback:");
        feedbackTextArea = new JTextArea(10, 40);
        submitButton = new JButton("Submit Feedback");
        submitButton.addActionListener(this);

        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(titleLabel, constraints);

        constraints.gridy = 1;
        add(nameLabel, constraints);
        constraints.gridy = 2;
        add(nameField, constraints);

        constraints.gridy = 3;
        add(emailLabel, constraints);
        constraints.gridy = 4;
        add(emailField, constraints);

        constraints.gridy = 5;
        add(ratingLabel, constraints);
        constraints.gridy = 6;
        add(ratingComboBox, constraints);

        constraints.fill = GridBagConstraints.BOTH; // Fill for text area
        constraints.gridy = 7;
        add(feedbackLabel, constraints);
        constraints.gridy = 8;
        add(feedbackTextArea, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 9;
        add(submitButton, constraints);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        feedbackModel = new FeedbackModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            int rating = (int) ratingComboBox.getSelectedItem();
            String feedback = feedbackTextArea.getText();

            feedbackModel.submitFeedback(name, email, rating, feedback);
            JOptionPane.showMessageDialog(this, "Thank you for your feedback, " + name + "!");

            nameField.setText("");
            emailField.setText("");
            ratingComboBox.setSelectedItem(1); // Set default rating to 1
            feedbackTextArea.setText("");
        }
    }

    public static void main(String[] args) {
        new FeedbackMenu();
    }
}
