package pages;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import custom_components.CustomCardButton;
import custom_components.CustomProductPageLabel;
import pages.ModifyAmountDialog.ModifyAmountListener;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class ProductsPage extends JPanel {
    ProductsPage(int customer_id) {
        String url = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;";
        this.setPreferredSize(new Dimension(1210, 1600));
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
            this.setLayout(new GridLayout(0, 4, 10, 0));
            int n = 8;
            while (n > 0 && rs.next()) {
                var productCard = new JPanel(new GridLayout(3, 2, 0, 2));
                Icon icon = new ImageIcon(new URL(rs.getString("image_url")));
                var imageLabel = new JLabel(icon);
                int height = icon.getIconHeight();
                imageLabel.setPreferredSize(new Dimension(100, height));

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

                var productButton = new CustomCardButton("󰄒  Add to Cart");
                productButton.putClientProperty("productId", rs.getString("product_id"));
                productButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int quantity = 1;
                            ModifyAmountDialog dialog = new ModifyAmountDialog(null, quantity);
                            dialog.setModifyAmountListener(new ModifyAmountListener() {
                                @Override
                                public void onAmountModified(int modifiedAmount) {
                                    System.out.println(modifiedAmount);
                                }
                            });
                            dialog.setVisible(true);
                            int modifiedAmount = dialog.getModifiedAmount();
                            if (quantity <= 0) {
                                //
                            } else {
                                int productId = Integer
                                        .parseInt((String) productButton.getClientProperty("productId"));
                                addToCart(productId, url, modifiedAmount, customer_id);
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                });
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

    public static void addToCart(int productId, String url, int quantity, int customer_id) {
        try {
            Connection conn = DriverManager.getConnection(url);
            CallableStatement stmt = conn.prepareCall("{CALL AddCartItem(?, ?, ?, ?, ?)}");
            stmt.setInt(1, customer_id);
            stmt.setInt(2, productId);
            stmt.setInt(3, 1);
            stmt.setInt(4, quantity);
            stmt.setInt(5, 1);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        var frame = new JFrame("Online Shopping");
        frame.setContentPane(new ProductsPage(31));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}