import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener {

    private JLabel titleLabel;
    private JButton makeOrderButton, reservationButton, feedbackButton;
    private MainMenuModel mainMenuModel;

    public MainMenu() {
        setTitle("Cafe on Top - Main Menu");
        mainMenuModel = new MainMenuModel();

        // Create the title label
        titleLabel = new JLabel("Cafe on Top");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Create the buttons
        makeOrderButton = new JButton("Let's Order");
        reservationButton = new JButton("Make a Reservation");
        feedbackButton = new JButton("Share Feedback");

        // Add action listeners
        makeOrderButton.addActionListener(this);
        reservationButton.addActionListener(this);
        feedbackButton.addActionListener(this);

        // Set layout to GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0; // Add vertical space
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding

        // Add title label
        add(titleLabel, gbc);

        // Increment y position for buttons
        gbc.gridy++;

        // Add buttons
        add(makeOrderButton, gbc);
        
        // Increment y position for feedback button
        gbc.gridy++;

        // Add buttons
        add(reservationButton, gbc);

        // Increment y position for feedback button
        gbc.gridy++;

        // Add feedback button
        add(feedbackButton, gbc);

        // Set frame properties
        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == makeOrderButton) {
            mainMenuModel.makeOrder();
        } else if (e.getSource() == reservationButton) {
            mainMenuModel.makeReservation();
        } else if (e.getSource() == feedbackButton) {
            mainMenuModel.shareFeedback();
        }
    }
}
