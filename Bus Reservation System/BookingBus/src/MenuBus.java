import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuBus {
    private JFrame frame;
    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;

    public MenuBus() {
        frame = new JFrame("Bus Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(463, 313);

        GridLayout gl_panel = new GridLayout(4, 1, 10, 10);
        JPanel panel = new JPanel(gl_panel);
        panel.setForeground(Color.WHITE);
        panel.setBackground(Color.BLACK);

        JLabel titleLabel = new JLabel("BUS MANAGEMENT SYSTEM", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        panel.add(titleLabel);

        addButton = new JButton("Add Bus");
        addButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        addButton.setBackground(new Color(0, 128, 255));
        addButton.setForeground(new Color(0, 0, 0));
        panel.add(addButton);

        deleteButton = new JButton("Delete Bus");
        deleteButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        deleteButton.setBackground(new Color(0, 128, 255));
        deleteButton.setForeground(new Color(0, 0, 0));
        panel.add(deleteButton);

        editButton = new JButton("Edit Bus");
        editButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        editButton.setBackground(new Color(0, 128, 255));
        editButton.setForeground(new Color(0, 0, 0));
        panel.add(editButton);

        frame.getContentPane().add(BorderLayout.CENTER, panel);

        frame.setLocationRelativeTo(null);
    }

    public void createAndShowGUI() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void addEditButtonListener(ActionListener listener) {
        editButton.addActionListener(listener);
    }

    public JFrame getFrame() {
        return frame;
    }
}
