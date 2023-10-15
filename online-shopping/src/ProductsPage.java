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

            // Create GUI
            frame = new JFrame("Products");
            panel = new JPanel();
            panel.setLayout(new GridLayout(0, 4));
            int n = 6;
            // Add products to panel
            while (n > 0 && rs.next()) {
                // add button to each product with their product_id for later use
                Icon icon = new ImageIcon(new URL(rs.getString("image_url")));
                JLabel imageLabel = new JLabel(icon);

                JLabel nameLabel = new JLabel(rs.getString("product_name"));

                JLabel priceLabel = new JLabel(rs.getString("price"));
                // make the description to be wrapped in a new line
                JLabel descriptionLabel = new JLabel("<html><p>" + rs.getString("product_description") + "</p></html>");

                panel.add(imageLabel);
                panel.add(nameLabel);
                panel.add(priceLabel);
                panel.add(descriptionLabel);
                n--;
            }
            // Add panel to frame
            frame.add(panel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 1700);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ProductsPage();
    }

}
