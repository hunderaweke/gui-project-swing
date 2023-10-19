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
    private CustomInputField totalPriceLabel;

    public OrderPage(ArrayList<ArrayList<String>> orderData) {
        this.orderData = orderData;
        getContentPane().setBackground(new Color(1, 73, 124));
        calculatePriceSum();
        initComponents();
        setVisible(true);
    }

    private void calculatePriceSum() {
        for (ArrayList<String> product : orderData) {
            priceSum += Integer.parseInt(product.get(2));
        }
    }

    private void initComponents() {
        setLayout(null);

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
        orderButton.setBounds(10, 90, 80, 30);
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOrder();
            }
        });
        add(orderButton);
        setSize(new Dimension(500, 200));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void performOrder() {
        JOptionPane.showMessageDialog(null, "Order placed successfully");
        dispose();
    }

}