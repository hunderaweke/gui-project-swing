package pages;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import custom_components.CustomCardButton;
import custom_components.CustomInputField;
import custom_components.CustomLabel;
import custom_components.CustomSignUpLabel;

public class OrderPage extends JDialog {
    private ArrayList<ArrayList<String>> orderData;
    private int priceSum = 0;
    private int numberOfProducts = 0;
    private CustomInputField totalPriceLabel;

    public OrderPage(ArrayList<ArrayList<String>> orderData) {
        this.orderData = orderData;
        getContentPane().setBackground(new Color(1, 73, 124));
        calculatePriceSum();
        calculateProducts();
        initComponents();
        setVisible(true);
    }

    private void calculateProducts() {
        for (ArrayList<String> product : orderData) {
            numberOfProducts += Integer.parseInt(product.get(product.size() - 1));
        }
    }

    private void calculatePriceSum() {
        for (ArrayList<String> product : orderData) {
            priceSum += Integer.parseInt(product.get(2));
        }
    }

    private void initComponents() {
        setLayout(null);
        CustomSignUpLabel noOfProducts = new CustomSignUpLabel("No of products");
        noOfProducts.setBounds(10, 90, 200, 30);
        add(noOfProducts);
        CustomInputField noOfProductsText = new CustomInputField(Integer.toString(numberOfProducts));
        noOfProductsText.setBounds(150, 90, 150, 30);
        noOfProductsText.setEditable(false);
        add(noOfProductsText);
        CustomSignUpLabel title = new CustomSignUpLabel("Order Detail");
        title.setBounds(10, 10, 200, 30);
        add(title);

        CustomLabel totalPriceText = new CustomSignUpLabel("Total Price:");
        totalPriceText.setBounds(10, 50, 200, 30);
        add(totalPriceText);

        totalPriceLabel = new CustomInputField(Integer.toString(priceSum));
        totalPriceLabel.setEditable(false);
        totalPriceLabel.setBounds(150, 50, 150, 30);
        add(totalPriceLabel);

        CustomCardButton orderButton = new CustomCardButton("Order");
        orderButton.setBounds(10, 120, 80, 30);
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOrder();
            }
        });
        add(orderButton);
        setSize(new Dimension(500, 250));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void performOrder() {
        JOptionPane.showMessageDialog(null, "Order placed successfully");
        dispose();
    }

}