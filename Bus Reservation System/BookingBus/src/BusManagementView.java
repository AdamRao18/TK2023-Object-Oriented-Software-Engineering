// BusManagementView class
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.List;

public class BusManagementView {
    private JFrame frame;
    private JList<String> busList;
    private DefaultListModel<String> listModel;

    /**
     * @wbp.parser.entryPoint
     */
    public BusManagementView() {
        // Set the Nimbus Look and Feel for a modern appearance
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        frame = new JFrame("Bus Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        busList = new JList<>(listModel);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(busList), BorderLayout.CENTER);

        JButton addButton = new JButton("Add Bus");
        addButton.setBackground(new Color(0, 128, 255));
        addButton.addActionListener(e -> new AddBusWindow());

        JButton editButton = new JButton("Edit Bus");
        editButton.setBackground(new Color(0, 128, 255));
        editButton.addActionListener(e -> {
            if (MainController.getInstance().hasBuses()) {
                int selectedIndex = busList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Bus selectedBus = MainController.getInstance().getBus(selectedIndex);
                    new EditBusWindow(selectedBus);
                } else {
                    JOptionPane.showMessageDialog(frame, "Select a bus to edit.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "No buses available. Add a bus first.");
            }
        });

        JButton deleteButton = new JButton("Delete Bus");
        deleteButton.setBackground(new Color(255, 0, 0));
        deleteButton.addActionListener(e -> {
            if (MainController.getInstance().hasBuses()) {
                int selectedIndex = busList.getSelectedIndex();
                if (selectedIndex != -1) {
                    int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this bus?",
                            "Confirm Delete", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        MainController.getInstance().deleteBus(selectedIndex);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Select a bus to delete.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "No buses available. Add a bus first.");
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(0, 0, 0));
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton backButton = new JButton("USER MENU");
        backButton.setBackground(Color.GREEN);
        backButton.setForeground(Color.BLACK);

        // Create an instance of the BackButtonListener and add it to the backButton
        backButton.addActionListener(new BackButtonListener());

        buttonPanel.add(backButton);
        
        
        frame.getContentPane().add(panel);
    }

    public void updateBusList(List<Bus> buses) {
        listModel.clear();
        for (Bus bus : buses) {
            listModel.addElement(
                    "<html><b>Bus Number:</b> " + bus.getBusNumber() +
                            "<br><b>Driver:</b> " + bus.getDriverName() +
                            "<br><b>Co-Driver:</b> " + bus.getCoDriverName() +
                            "<br><b>Origin:</b> " + bus.getOrigin() +
                            "<br><b>Direction:</b> " + bus.getDirection() +
                            "<br><b>Departure Date:</b> " + bus.getDepartureDate() +
                            "<br><b>Departure Time:</b> " + bus.getTimeOfDeparture() +
                            "<br><b>ETA:</b> " + bus.getEta() +
                            "<br><b>Passengers:</b> " + bus.getTotalPassengers() +
                            "<br><b>Company:</b> " + bus.getBusCompany() + "</html>"
            );
        }
    }

    public void show() {
        frame.setVisible(true);
    }
    
    private class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Call the MainController method to show the UserSelect
            MainController.getInstance().showUserSelectView();
            // Close the BusManagementView frame
            frame.dispose();
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BusManagementView().show();
        });
    }
}