import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class ProductsPage {

    JFrame frame;
    JPanel panel;

    public ProductsPage() {

        // Database connection code
        String url = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
            frame = new JFrame("Products");
            panel = new JPanel();
            panel.setLayout(new GridLayout(0, 7, 20, 0));
            int n = 7;
            while (n > 0 && rs.next()) {
                var productCard = new JPanel(new GridLayout(5, 1, 0, 2));
                Icon icon = new ImageIcon(new URL(rs.getString("image_url")));
                var imageLabel = new JLabel(icon);
                int height = icon.getIconHeight();
                imageLabel.setPreferredSize(new Dimension(100, height));
                var productButton = new JButton("Add to Cart");
                productButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Add the product to the cart
                        try {
                            addToCart(rs.getInt("product_id"), url);
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                var secondaryPanel = new JPanel();
                var nameLabel = new JLabel(rs.getString("product_name"));
                var priceLabel = new JLabel("<html><h1 style=' color: rgb(19, 126, 217); font-weight: bold;'>"
                        + rs.getString("price") + "</h1></html>");
                var descriptionLabel = new JLabel(
                    "<html><p style='font-size: 12px; font-weight: bold;'>" + rs.getString("product_description")
                                + "</p></html>");
                secondaryPanel.add(nameLabel);
                secondaryPanel.add(priceLabel);
                secondaryPanel.add(productButton);
                productCard.add(imageLabel);
                productCard.add(descriptionLabel);
                productCard.add(secondaryPanel);
                panel.add(productCard);
                n--;
            }
            // Add panel to frame
            frame.add(panel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 700);
        frame.setVisible(true);
    }

    public void addToCart(int productId, String url) {
        try {
            // Create database connection
            Connection conn = DriverManager.getConnection(url);

            // Call stored procedure to add product to cart
            CallableStatement stmt = conn.prepareCall("{CALL AddCartItem(?, ?, ?, ?, ?)}");
            stmt.setInt(1, 1);
            stmt.setInt(2, productId);
            stmt.setInt(3, 1);
            stmt.setInt(4, 1);
            stmt.setInt(5, 1);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ProductsPage();
    }

}
