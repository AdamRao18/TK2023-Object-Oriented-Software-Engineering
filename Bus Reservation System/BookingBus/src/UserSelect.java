import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class UserSelect extends JFrame {

    private UserSelectListener userSelectListener;

    public interface UserSelectListener {
        void onCustomerSelected();
        void onStaffSelected();
    }

    public void addUserSelectListener(UserSelectListener listener) {
        this.userSelectListener = listener;
    }

    public UserSelect() {
        super("User Selection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(406, 185);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);

        JButton customerButton = new JButton("Customer");
        customerButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        JButton staffButton = new JButton("Staff");
        staffButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userSelectListener != null) {
                    userSelectListener.onCustomerSelected();
                }
            }
        });

        staffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userSelectListener != null) {
                    userSelectListener.onStaffSelected();
                }
            }
        });
        panel.setLayout(new GridLayout(0, 2, 10, 10));

        panel.add(customerButton);
        panel.add(staffButton);

        getContentPane().add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.BLACK);
        getContentPane().add(panel_1, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("Welcome To Bus Reservation System");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel_1.add(lblNewLabel);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.BLACK);
        getContentPane().add(panel_2, BorderLayout.SOUTH);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.BLACK);
        getContentPane().add(panel_3, BorderLayout.WEST);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(Color.BLACK);
        getContentPane().add(panel_4, BorderLayout.EAST);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
