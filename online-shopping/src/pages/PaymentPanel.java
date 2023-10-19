package pages;

import javax.swing.*;

import custom_components.CustomButton;
import custom_components.CustomInputField;
import custom_components.CustomLabel;
import custom_components.SideBarButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPanel extends JPanel {
    private CustomInputField amountTextField;
    private CustomInputField priceTextField;
    private CustomButton payButton;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public PaymentPanel() {
        setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 0);
        setPreferredSize(new Dimension(screenSize.width - 400, screenSize.height - 450));
        setBackground(new Color(1, 73, 124));
        JLabel amountLabel = new CustomLabel("Amount to Pay:");
        amountTextField = new CustomInputField();
        JLabel priceLabel = new CustomLabel("Price:");
        priceTextField = new CustomInputField();
        payButton = new SideBarButton("Pay");
        payButton.setPreferredSize(new Dimension(200, 40));
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer.parseInt(amountTextField.getText());
                    JOptionPane.showMessageDialog(null, "Payment Successful");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Payment Failed");
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(amountLabel, gbc);
        gbc.gridy = 1;
        add(amountTextField, gbc);
        gbc.gridy = 2;
        add(priceLabel, gbc);
        gbc.gridy = 3;
        add(priceTextField, gbc);
        gbc.gridy = 4;
        add(payButton, gbc);
    }
}