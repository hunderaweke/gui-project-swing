package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import custom_components.CustomButton;
import custom_components.CustomInputField;

public class AddProductsPage extends JPanel {

    public AddProductsPage() {
        var addButton = new CustomButton("Add product");
        var productName = new CustomInputField();
        var productPrice = new CustomInputField();
        var imageUrl = new CustomInputField();
        var productDescription = new CustomInputField();
        var categoryId = 1;
        var submitButton = new CustomButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = productName.getText();
                String price = productPrice.getText();
                String description = productDescription.getText();
                String image = imageUrl.getText();
                int category = categoryId;
                String quantity = ""; // Add code to get the quantity input from the user

                InsertProduct(name, price, description, category, image, quantity);
                JOptionPane.showMessageDialog(null, "Product added successfully!"); // Show notification
            }
        });

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 0, 0);
        add(addButton, gbc);
        gbc.gridy = 1;
        add(productName, gbc);
        gbc.gridy = 2;
        add(productPrice, gbc);
        gbc.gridy = 3;
        add(imageUrl, gbc);
        gbc.gridy = 4;
        add(productDescription, gbc);
        gbc.gridy = 5;
        add(submitButton, gbc);
    }
    public void InsertProduct(String productName, String price, String description, int categoryId, String imageUrl,
            String quantity) {
        var connectionUrl = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;";
        try (var con = DriverManager.getConnection(connectionUrl)) {
            var insertProductQuery = "{CALL InsertProduct(?, ?, ?, ?, ?,?)}";
            PreparedStatement stmt = con.prepareStatement(insertProductQuery);
            stmt.setString(1, productName);
            stmt.setString(2, price);
            stmt.setString(3, description);
            stmt.setInt(4, categoryId);
            stmt.setString(5, imageUrl);
            stmt.setString(6, quantity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}