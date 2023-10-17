package pages;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import custom_components.CustomCardButton;
import custom_components.CustomProductPageLabel;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class ProductsPage extends JPanel {
    ProductsPage() {
        // Database connection code
        String url = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;";
        this.setPreferredSize(new Dimension(1210, 1600));
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
            this.setLayout(new GridLayout(0, 4, 10, 0));
            int n = 7;
            while (n > 0 && rs.next()) {
                var productCard = new JPanel(new GridLayout(3, 2, 0, 2));
                Icon icon = new ImageIcon(new URL(rs.getString("image_url")));
                var imageLabel = new JLabel(icon);
                int height = icon.getIconHeight();
                imageLabel.setPreferredSize(new Dimension(100, height));
                var productButton = new CustomCardButton("󰄒  Add to Cart");
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
                var nameLabel = new CustomProductPageLabel.NameLabel(
                        "<html><h2 style='font-size: 14px; font-weight: bold;'>" + rs.getString("product_name")
                                + "</h2></html>");
                var priceLabel = new CustomProductPageLabel.PriceLabel(
                        rs.getString("price"));
                var descriptionLabel = new CustomProductPageLabel.DescriptionLabel(
                        "<html><p style='font-size: 12px; font-weight: light;'>" + rs.getString("product_description")
                                + "</p></html>");
                descriptionLabel.setPreferredSize(new Dimension(280, 60));
                nameLabel.setPreferredSize(new Dimension(280, 50));
                priceLabel.setPreferredSize(new Dimension(280, 60));
                secondaryPanel.setBackground(Color.WHITE);
                productCard.setBorder(new EmptyBorder(0, 10, 0, 10));
                nameLabel.setBorder(new EmptyBorder(0, 13, 0, 13));
                descriptionLabel.setBorder(new EmptyBorder(0, 13, 0, 13));

                priceLabel.setBorder(new EmptyBorder(0, 13, 0, 13));

                secondaryPanel.add(nameLabel);
                secondaryPanel.add(descriptionLabel);
                secondaryPanel.add(priceLabel);
                secondaryPanel.add(productButton);
                productCard.add(imageLabel);
                productCard.add(secondaryPanel);

                this.add(productCard);
                n--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addToCart(int productId, String url) {
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
        var frame = new JFrame("Online Shopping");
        frame.setContentPane(new ProductsPage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}