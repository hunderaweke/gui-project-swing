package pages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import custom_components.CustomCardButton;
import custom_components.CustomTable;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class OrdersPage extends JPanel {
    private JButton removeItemButton;
    private JButton orderItemButton;
    String connectionUrl = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;";
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public OrdersPage(String userName) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(screenSize.width - 330, screenSize.height - 230));
        try (Connection con = DriverManager.getConnection(connectionUrl)) {
            var cartTable = new CustomTable();
            cartTable.setPreferredSize(new Dimension(1000, 900));
            var model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[] { "Price", "Quantity" });

            orderItemButton = new CustomCardButton("Pay");
            orderItemButton.setForeground(Color.WHITE);
            orderItemButton.setBackground(new Color(19, 126, 217));

            var getOrdersQuery = "SELECT quantity,total_price FROM Orders WHERE customer_id = ?;";
            var getCustomerIdQuery = "SELECT customer_id FROM Customer WHERE username = ?;";
            var getCustomerIdStatement = con.prepareStatement(getCustomerIdQuery);
            getCustomerIdStatement.setString(1, userName);
            var getCustomerIdResultSet = getCustomerIdStatement.executeQuery();
            getCustomerIdResultSet.next();
            var customerId = getCustomerIdResultSet.getString("customer_id");
            try {
                var statement = con.prepareStatement(getOrdersQuery);
                statement.setString(1, customerId);
                var cartResultSet = statement.executeQuery();
                while (cartResultSet.next()) {
                    var quantity = cartResultSet.getString("quantity");
                    model.addRow(new Object[] {
                            cartResultSet.getString("total_price"), quantity });
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout());
            buttonPanel.add(orderItemButton);
            cartTable.setModel(model);
            add(new JScrollPane(cartTable), BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);

            orderItemButton.addActionListener(e -> {
                int row = cartTable.getSelectedRow();

                if (row != -1) {
                    var price = Integer.parseInt((String) cartTable.getValueAt(row, 0));
                    var quantity = Integer.parseInt((String) cartTable.getValueAt(row, 1));
                    JOptionPane.showMessageDialog(null, "Price: " + price + "\nQuantity: " + quantity);
                    var getuserBalanceQuery = "SELECT AMOUNT FROM balance WHERE customer_id=?;";
                    try (Connection connec = DriverManager.getConnection(connectionUrl)) {
                        var balanceStmnt = connec.prepareStatement(getuserBalanceQuery);
                        balanceStmnt.setString(1, customerId);
                        var balanceSet = balanceStmnt.executeQuery();
                        balanceSet.next();
                        var balance = balanceSet.getString("AMOUNT");
                        var newBalance = Integer.parseInt(balance) - price * quantity;
                        Connection conn = DriverManager.getConnection(this.connectionUrl);
                        PreparedStatement stmt = conn
                                .prepareStatement("UPDATE balance SET AMOUNT = ? WHERE customer_id = ?");
                        stmt.setInt(1, newBalance);
                        stmt.setString(2, customerId);
                        stmt.executeUpdate();
                        stmt.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
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
