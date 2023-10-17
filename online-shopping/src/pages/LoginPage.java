package pages;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import custom.CustomButton;
import custom.CustomInputField;
import custom.CustomLabel;
import custom.CustomPasswordField;

public class LoginPage {

    public static void main(String[] args) {
        var frame = new JFrame("Online Shopping");
        var panel = new JPanel();
        var userNameField = new CustomInputField();
        var passwordField = new CustomPasswordField();
        var userNameLabel = new CustomLabel("Enter Username: ");
        var passwordLabel = new CustomLabel("Enter Password");
        var button = new CustomButton("Login");
        button.setBackground(new Color(143, 196, 212));
        panel.setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(userNameLabel, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        panel.add(userNameField, gbc);
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
        panel.add(passwordLabel, gbc);
        gbc.gridy = 3;
        panel.add(passwordField, gbc);
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 0, 0);
        panel.add(button, gbc);
        frame.add(panel);
        panel.setBackground(new Color(19, 126, 217));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameField.getText();
                String password = passwordField.getText();
                var authenticated = Authenticator.authenticate(userName, password);
                if (authenticated) {
                    JOptionPane.showMessageDialog(frame, "Login Successful");
                    frame.setVisible(false);
                    new MainFrame("Online Shopping", userName);
                } else {
                    JOptionPane.showMessageDialog(frame, "Login Failed");
                }
            }
        });
    }

}