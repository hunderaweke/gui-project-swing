package pages;

import javax.swing.*;
import custom_components.CustomCardButton;
import custom_components.CustomInputField;
import custom_components.CustomSignUpLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyAmountDialog extends JDialog {
    private CustomInputField amountTextField;
    private CustomCardButton saveButton;
    private CustomCardButton cancelButton;
    private int modifiedAmount;
    private ModifyAmountListener listener;

    public ModifyAmountDialog(Frame owner, int currentAmount) {
        super(owner, "Modify Amount", true);
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(1, 73, 124));
        amountTextField = new CustomInputField(String.valueOf(currentAmount));
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        contentPanel.add(new CustomSignUpLabel("Enter Amount: "), gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        contentPanel.add(amountTextField, gbc);
        setPreferredSize(new Dimension(500, 300));
        saveButton = new CustomCardButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int modifiedAmount = Integer.parseInt(amountTextField.getText());
                    ModifyAmountDialog.this.modifiedAmount = modifiedAmount;
                    dispose(); // Close the dialog
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ModifyAmountDialog.this, "Invalid amount", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelButton = new CustomCardButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifiedAmount = currentAmount; // Revert to the original amount
                dispose();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(10, 6, 0, 6);
        buttonPanel.add(saveButton, gbc);
        buttonPanel.setBackground(new Color(1, 73, 124));
        gbc.gridx = 1;
        buttonPanel.add(cancelButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPanel.add(buttonPanel, gbc);
        setContentPane(contentPanel);
        pack();
        setLocationRelativeTo(owner);
        setResizable(false);
    }

    public int getModifiedAmount() {
        return modifiedAmount;
    }

    public void setModifyAmountListener(ModifyAmountListener listener) {
        this.listener = listener;
    }

    public interface ModifyAmountListener {
        void onAmountModified(int modifiedAmount);
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (!visible) {
            if (listener != null) {
                listener.onAmountModified(modifiedAmount);
            }
        }
    }
}