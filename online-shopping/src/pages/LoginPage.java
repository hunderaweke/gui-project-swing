package pages;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import custom_components.CustomButton;
import custom_components.CustomCardButton;
import custom_components.CustomInputField;
import custom_components.CustomSignUpLabel;
import custom_components.CustomPasswordField;

public class LoginPage extends JFrame {
    public LoginPage() {
        var panel = new JPanel();
        var userNameField = new CustomInputField();
        var passwordField = new CustomPasswordField();
        var userNameLabel = new CustomSignUpLabel("  Enter Username: ");
        var passwordLabel = new CustomSignUpLabel("󰌾  Enter Password");
        var dontHaveAccountLabel = new CustomSignUpLabel("Don't Have Account");
        var loginButton = new CustomButton("󰍂  Login");
        var toSignUpButton = new CustomCardButton(" Sign Up");
        // var toAdminPage = new CustomCardButton("Admin Page");
        loginButton.setBackground(new Color(143, 196, 212));
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
        panel.add(loginButton, gbc);
        gbc.gridy = 5;
        gbc.insets = new Insets(20, 0, 0, 0);
        panel.add(dontHaveAccountLabel, gbc);
        gbc.gridy = 6;
        panel.add(toSignUpButton, gbc);
        gbc.gridy = 7;
        // panel.add(toAdminPage, gbc);
        add(panel);
        panel.setBackground(new Color(1, 73, 124));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameField.getText();
                String password = passwordField.getText();
                var authenticated = Authenticator.authenticate(userName, password);
                if (authenticated) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    setVisible(false);
                    new MainFrame("Online Shopping", userName);
                } else {
                    JOptionPane.showMessageDialog(null, "Login Failed");
                }
            }
        });
        toSignUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new SignupPage();
            }
        });
        // toAdminPage.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // setVisible(false);
        // new AdminMainFrame("Online Shopping");
        // }
        // });
    }

    public static void main(String[] args) {
        new LoginPage();
    }

}
