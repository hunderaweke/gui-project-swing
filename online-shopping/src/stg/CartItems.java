package stg;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;

public class CartItems extends JPanel {
    private JButton removeItemButton;
    String connectionUrl = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;";

    public CartItems() {
        setLayout(new BorderLayout());
        try (Connection con = DriverManager.getConnection(this.connectionUrl)) {
            // make a table for it pls
            var cartTable = new JTable();
            var model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[] { "Item", "Price" });
            removeItemButton = new JButton("Remove Item");
            var getCartItemsQuery = "SELECT cart_id, product_id FROM Cart_Item;";
            var getProductQuery = "SELECT product_name, price FROM Product WHERE product_id = ?;";

            try {

                var statement = con.prepareStatement(getCartItemsQuery);
                var statement2 = con.prepareStatement(getProductQuery);
                var cartResultSet = statement.executeQuery();
                while (cartResultSet.next()) {
                    String productID = cartResultSet.getString("product_id");
                    statement2.setString(1, productID);
                    var productResultSet = statement2.executeQuery();
                    productResultSet.next();
                    model.addRow(new Object[] { productID, productResultSet.getString("product_name"),
                            productResultSet.getString("price") });
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout());
            buttonPanel.add(removeItemButton);
            cartTable.setModel(model);
            add(new JScrollPane(cartTable), BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);
            removeItemButton.addActionListener(e -> {
                int row = (int) cartTable.getSelectedRow();
                if (row != -1) {
                    // Get product id from selected row
                    var productId = Integer.parseInt((String) cartTable.getValueAt(row, 0));
                    try {
                        Connection conn = DriverManager.getConnection(this.connectionUrl);
                        PreparedStatement stmt = conn.prepareStatement("DELETE FROM Cart_Item WHERE product_id = ?");
                        stmt.setInt(1, productId);
                        stmt.executeUpdate();
                        model.removeRow(row);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}