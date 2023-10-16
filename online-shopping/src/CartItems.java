import javax.swing.*;
import java.awt.*;

public class CartItems extends JPanel {
    private DefaultListModel<String> cartListModel;
    private JList<String> cartList;
    private JButton addItemButton;
    private JButton removeItemButton;

    public CartItems() {
        setLayout(new BorderLayout());

        cartListModel = new DefaultListModel<>();
        cartList = new JList<>(cartListModel);
        addItemButton = new JButton("Add Item");
        removeItemButton = new JButton("Remove Item");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addItemButton);
        buttonPanel.add(removeItemButton);

        add(new JScrollPane(cartList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addItemButton.addActionListener(e -> {
            String item = JOptionPane.showInputDialog("Enter item name:");
            if (item != null && !item.isEmpty()) {
                cartListModel.addElement(item);
            }
        });

        removeItemButton.addActionListener(e -> {
            int selectedIndex = cartList.getSelectedIndex();
            if (selectedIndex != -1) {
                cartListModel.removeElementAt(selectedIndex);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cart Items");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.getContentPane().add(new CartItems());
            frame.setVisible(true);
        });
    }
}