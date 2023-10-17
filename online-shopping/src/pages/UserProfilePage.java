package pages;

import javax.swing.*;

import custom.CustomLabel;

import java.awt.*;

public class UserProfilePage extends JPanel {
    public UserProfilePage(String[] userData) {
        var name = new CustomLabel.UserNameLabel("<html><h1>" + userData[0] + " " + userData[1] + "</h1></html>");
        var email = new JLabel(userData[2]);
        var userName = new JLabel(userData[3]);
        var phoneNumber = new JLabel(userData[userData.length - 1]);
        this.setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHEAST; // Align components to the top right corner
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(name, gbc);
        gbc.gridy = 1;
        this.add(userName, gbc);
        gbc.gridy = 2;
        this.add(email, gbc);
        gbc.gridy = 3;
        this.add(phoneNumber, gbc);
    }
}