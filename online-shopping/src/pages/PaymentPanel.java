package pages;

import javax.swing.*;

import custom_components.CustomButton;
import custom_components.CustomCardButton;
import custom_components.CustomInputField;
import custom_components.CustomLabel;
import custom_components.SideBarButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPanel extends JPanel {
    private CustomCardButton payButton;

    public PaymentPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        payButton = new CustomCardButton("  Pay");
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Payment Successful");
            }
        });
        add(payButton, gbc);
    }
}