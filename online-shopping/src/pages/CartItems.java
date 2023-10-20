package pages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import custom_components.CustomCardButton;
import custom_components.CustomTable;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class CartItems extends JPanel {
    private JButton removeItemButton;
    private JButton orderItemButton;
    String connectionUrl = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;";
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public CartItems(String userName) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(screenSize.width - 330, screenSize.height - 230));
        try (Connection con = DriverManager.getConnection(connectionUrl)) {
            var cartTable = new CustomTable();
            cartTable.setPreferredSize(new Dimension(1000, 900));
            var model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[] { "Item", "Product", "Price", "Quantity", "State" });
            removeItemButton = new CustomCardButton("󰵩  Remove Item");
            removeItemButton.setForeground(Color.WHITE);

            orderItemButton = new CustomCardButton("󱗪  Order Item");
            orderItemButton.setForeground(Color.WHITE);
            orderItemButton.setBackground(new Color(19, 126, 217));

            var getCartItemsQuery = "SELECT cart_id, product_id,quantity,is_active FROM Cart_Item WHERE customer_id = ?;";
            var getProductQuery = "SELECT product_name, price FROM Product WHERE product_id = ?;";
            var getCustomerIdQuery = "SELECT customer_id FROM Customer WHERE username = ?;";
            var getCustomerIdStatement = con.prepareStatement(getCustomerIdQuery);
            getCustomerIdStatement.setString(1, userName);
            var getCustomerIdResultSet = getCustomerIdStatement.executeQuery();
            getCustomerIdResultSet.next();
            var customerId = getCustomerIdResultSet.getString("customer_id");
            try {
                var statement = con.prepareStatement(getCartItemsQuery);
                statement.setString(1, customerId);
                var statement2 = con.prepareStatement(getProductQuery);
                var cartResultSet = statement.executeQuery();
                while (cartResultSet.next()) {
                    var productID = cartResultSet.getString("product_id");
                    statement2.setString(1, productID);
                    var productResultSet = statement2.executeQuery();
                    productResultSet.next();
                    var quantity = cartResultSet.getString("quantity");
                    model.addRow(new Object[] { productID, productResultSet.getString("product_name"),
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
                ArrayList<ArrayList<String>> orderData = new ArrayList<>();
                if (rows.length == 0) {
                    System.out.println("No element selected");
                } else {
                    for (int row : rows) {
                        String productId = (String) cartTable.getValueAt(row, 0);
                        var quantity = Integer.parseInt((String) cartTable.getValueAt(row, 3));
                        try {
                            Connection conn = DriverManager.getConnection(this.connectionUrl);
                            PreparedStatement stmt = conn.prepareStatement(
                                    "Select product_name,price, catagory_id FROM Product WHERE product_id=?");
                            stmt.setString(1, productId);
                            var productResultSet = stmt.executeQuery();
                            productResultSet.next();
                            var productName = productResultSet.getString("product_name");
                            var price = Integer.parseInt(productResultSet.getString("price"));
                            price = price * quantity;
                            stmt.close();
                            ArrayList<String> elements = new ArrayList<>();
                            elements.add(productId);
                            elements.add(productName);
                            elements.add("" + price + "");
                            elements.add("" + quantity + "");
                            elements.add("" + customerId + "");
                            orderData.add(elements);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                    var orderPage = new OrderPage(orderData);
                    orderPage.setVisible(true);
                }
            });

        } catch (

        SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        var frame = new JFrame("Online Shopping");
        frame.setContentPane(new CartItems("hundera"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}