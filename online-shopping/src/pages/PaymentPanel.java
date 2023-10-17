package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPanel extends JPanel {
    private JTextField amountTextField;
    private JTextField balanceTextField;
    private JTextField priceTextField;
    private JButton payButton;

    public PaymentPanel() {
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel amountLabel = new JLabel("Amount to Pay:");
        amountTextField = new JTextField(10);

        JLabel balanceLabel = new JLabel("Balance:");
        balanceTextField = new JTextField(10);
        balanceTextField.setEditable(false);

        JLabel priceLabel = new JLabel("Price:");
        priceTextField = new JTextField(10);

        payButton = new JButton("Pay");
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