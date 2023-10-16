import javax.swing.*;
import java.awt.*;
import java.sql.*;

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
        // a function for getting the cart items from data base and appending to the
        // cart list
        var getCartItemsQuery = "SELECT * FROM Cart_Item;";

        try {
            var connectionUrl = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;";
            var con = DriverManager.getConnection(connectionUrl);
            var statement = con.prepareStatement(getCartItemsQuery);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cartListModel.addElement(resultSet.getString("product_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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

}