
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.net.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ShowItemsPage {

    static DefaultTableModel model = new DefaultTableModel();

    public static void showItemsPage() {
        try {
            var connectionUrl = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;";
            var con = DriverManager.getConnection(connectionUrl);
            var showItemsQuery = "SELECT * FROM Product";
            var statement = con.prepareStatement(showItemsQuery);
            var resultSet = statement.executeQuery();
            var frame = new JFrame("Products");
            var panel = new JPanel();
            var productsTable = new JTable();
            Object[] columnNames = new Object[] { "Image", "Product Name", "Price", "Quantity", "Description" };
            model.setColumnIdentifiers(columnNames);
            var gridPanel = new GridLayout(0, 1);
            var gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            panel.setLayout(gridPanel);
            productsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            // set the rows to auto resize
            productsTable.setRowHeight(100);
            // make the description to be wrapped in a new line
            productsTable.setBackground(Color.CYAN);
            productsTable.setShowGrid(false);
            productsTable.setShowHorizontalLines(false);
            productsTable.setShowVerticalLines(false);
            productsTable.setIntercellSpacing(new Dimension(0, 0));
            productsTable.setCellSelectionEnabled(false);
            productsTable.setRowSelectionAllowed(false);
            productsTable.setColumnSelectionAllowed(false);
            productsTable.setFocusable(false);
            productsTable.setOpaque(false);
            // for (var i = 0; i <= 7; i++) {
            resultSet.next();
            Icon icon = new ImageIcon(new URL(resultSet.getString("image_url")));
            var productName = resultSet.getString("product_name");
            var productPrice = resultSet.getString("price");
            var productQuantity = resultSet.getString("quantity");
            var productDescription = resultSet.getString("product_description");
            Object[][] data = new Object[][] { { icon, productName, productPrice,
                    productQuantity,
                    productDescription } };
            model.addRow(data);
            BufferedImage image = ImageIO.read(new URL(resultSet.getString("image_url")));
            int height = image.getHeight();
            productsTable.setRowHeight(height);
            // }
            productsTable.setModel(model);
            panel.setBackground(Color.RED);
            panel.add(new JScrollPane(productsTable));
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.repaint();
            frame.setSize(1400, 1700);
            frame.setVisible(true);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
