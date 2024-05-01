import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView {
    private JFrame frame;
    private JButton bookingBusButton;
    private JButton ticketViewButton;
    private JButton userFeedbackButton;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_4;
    private JButton UserButton;

    public MainMenuView() {
        frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(395, 337);

        GridLayout gl_panel = new GridLayout(3, 1);
        gl_panel.setVgap(5);
        gl_panel.setHgap(5);
        JPanel panel = new JPanel(gl_panel);
        panel.setForeground(Color.WHITE);
        panel.setBackground(Color.BLACK);

        bookingBusButton = new JButton("Booking Bus");
        bookingBusButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(bookingBusButton);

        ticketViewButton = new JButton("Ticket View");
        ticketViewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(ticketViewButton);

        userFeedbackButton = new JButton("User Feedback");
        userFeedbackButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(userFeedbackButton);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        
        panel_1 = new JPanel();
        panel_1.setForeground(Color.WHITE);
        panel_1.setBackground(Color.BLACK);
        frame.getContentPane().add(panel_1, BorderLayout.NORTH);
        
                JLabel titleLabel = new JLabel("Welcome To Booking Bus System", SwingConstants.CENTER);
                titleLabel.setForeground(Color.WHITE);
                titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
                panel_1.add(titleLabel);
        
        panel_2 = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
        flowLayout_2.setVgap(9);
        panel_2.setForeground(Color.WHITE);
        panel_2.setBackground(Color.BLACK);
        frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
        
        UserButton = new JButton("User Menu");
        panel_2.add(UserButton);
        
        panel_3 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
        flowLayout_1.setHgap(9);
        panel_3.setForeground(Color.WHITE);
        panel_3.setBackground(Color.BLACK);
        frame.getContentPane().add(panel_3, BorderLayout.WEST);
        
        panel_4 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
        flowLayout.setHgap(9);
        flowLayout.setVgap(8);
        panel_4.setForeground(Color.WHITE);
        panel_4.setBackground(Color.BLACK);
        frame.getContentPane().add(panel_4, BorderLayout.EAST);
    }

    public void createAndShowGUI() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    public void addBookingBusButtonListener(ActionListener listener) {
        bookingBusButton.addActionListener(listener);
    }

    public void addTicketViewButtonListener(ActionListener listener) {
        ticketViewButton.addActionListener(listener);
    }

    public void addUserFeedbackButtonListener(ActionListener listener) {
        userFeedbackButton.addActionListener(listener);
    }
    
    public void addUserButtonListener(ActionListener listener) {
        UserButton.addActionListener(listener);
    }

    public JFrame getFrame() {
        return frame;
    }
}
