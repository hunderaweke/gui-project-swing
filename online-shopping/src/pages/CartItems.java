package pages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import custom_components.CustomCardButton;
import custom_components.CustomTable;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class CartItems extends JPanel {
    private JButton removeItemButton;
    private JButton orderItemButton;
    String connectionUrl = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;";
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public CartItems() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(screenSize.width - 400, screenSize.height - 400));
        try (Connection con = DriverManager.getConnection(connectionUrl)) {
            // make a table for it pls
            var cartTable = new CustomTable();
            cartTable.setPreferredSize(new Dimension(1000, 900));
            var model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[] { "Item", "Product", "Price", "Quantity", "State" });
            removeItemButton = new CustomCardButton("󰵩  Remove Item");
            removeItemButton.setForeground(Color.WHITE);

            orderItemButton = new CustomCardButton("󱗪  Order Item");
            orderItemButton.setForeground(Color.WHITE);
            orderItemButton.setBackground(new Color(19, 126, 217));

            var getCartItemsQuery = "SELECT cart_id, product_id,quantity,is_active FROM Cart_Item;";
            var getProductQuery = "SELECT product_name, price FROM Product WHERE product_id = ?;";

            try {
                var statement = con.prepareStatement(getCartItemsQuery);
                var statement2 = con.prepareStatement(getProductQuery);
                var cartResultSet = statement.executeQuery();
                while (cartResultSet.next()) {
                    String cartID = cartResultSet.getString("cart_id");
                    var productID = cartResultSet.getString("product_id");
                    statement2.setString(1, productID);
                    var productResultSet = statement2.executeQuery();
                    productResultSet.next();
                    var quantity = cartResultSet.getString("quantity");
                    model.addRow(new Object[] { cartID, productID, productResultSet.getString("product_name"),
                            productResultSet.getString("price"), quantity, cartResultSet.getString("is_active") });

                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout());
            buttonPanel.add(removeItemButton);
            buttonPanel.add(orderItemButton);
            cartTable.setModel(model);
            add(new JScrollPane(cartTable), BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);
            removeItemButton.setBackground(new Color(19, 126, 217));
            removeItemButton.addActionListener(e -> {
                int row = (int) cartTable.getSelectedRow();
                if (row != -1) {
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

            orderItemButton.addActionListener(e -> {
                int[] rows = cartTable.getSelectedRows();
                if (rows.length == 0) {
                    System.out.println("No element selected");
                } else {
                    for (int row : rows) {
                        System.out.println(row);
                        var productId = Integer.parseInt((String) cartTable.getValueAt(row, 1));
                        try {
                            Connection conn = DriverManager.getConnection(this.connectionUrl);
                            PreparedStatement stmt = conn.prepareStatement(
                                    "Select product_name,price, catagory_id FROM Product WHERE product_id=?");
                            stmt.setInt(1, productId);
                            var productResultSet = stmt.executeQuery();
                            productResultSet.next();
                            var productName = productResultSet.getString("product_name");
                            var price = productResultSet.getString("price");
                            var catagoryId = productResultSet.getString("catagory_id");
                            stmt.close();
                            String[][] orderData;
                            orderData = new String[][] { { productName, price, catagoryId } };
                            var orderPage = new OrderPage(orderData);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        var frame = new JFrame("Online Shopping");
        frame.setContentPane(new CartItems());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}