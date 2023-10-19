package pages;

import javax.swing.*;

import custom_components.CustomHeader;
import custom_components.CustomLabel;

import java.awt.*;

public class UserProfilePage extends JPanel {
    public UserProfilePage(String[] userData) {
        var detailsPanel = new JPanel();
        var profileIcon = new CustomHeader.BigHeaders("");
        var name = new CustomLabel.UserNameLabel(userData[0] + " " + userData[1]);
        var email = new CustomLabel("Email: " + userData[3]);
        var userName = new CustomLabel("Username: " + userData[2]);
        var balance = new CustomLabel("Balance: " + userData[userData.length - 1]);
        // var phoneNumber = new CustomLabel(userData[4]);
        detailsPanel.setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST; // Align components to the top right corner
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding
        gbc.gridx = 0;
        gbc.gridy = 0;
        detailsPanel.add(name, gbc);
        gbc.gridy = 1;
        detailsPanel.add(userName, gbc);
        gbc.gridy = 2;
        detailsPanel.add(email, gbc);
        gbc.gridy = 3;
        detailsPanel.add(balance, gbc);
        this.add(profileIcon);
        this.add(detailsPanel);
    }
}