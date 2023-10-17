package pages;

import javax.swing.*;

import custom.CustomButton;
import custom.CustomInputField;
import custom.CustomLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPanel extends JPanel {
    private CustomInputField amountTextField;
    private CustomInputField balanceTextField;
    private CustomInputField priceTextField;
    private CustomButton payButton;

    public PaymentPanel() {
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel amountLabel = new CustomLabel("Amount to Pay:");
        amountTextField = new CustomInputField();

        JLabel balanceLabel = new CustomLabel("Balance:");
        balanceTextField = new CustomInputField();
        balanceTextField.setEditable(false);

        JLabel priceLabel = new CustomLabel("Price:");
        priceTextField = new CustomInputField();

        payButton = new CustomButton("Pay");
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountTextField.getText());
                double price = Double.parseDouble(priceTextField.getText());
                double balance = amount - price;
                balanceTextField.setText(String.format("%.2f", balance));
            }
        });

        add(amountLabel);
        add(amountTextField);
        add(balanceLabel);
        add(balanceTextField);
        add(priceLabel);
        add(priceTextField);
        add(new JLabel()); // Empty label for spacing
        add(payButton);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Payment Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        PaymentPanel paymentPanel = new PaymentPanel();
        frame.add(paymentPanel);

        frame.setVisible(true);
    }
}