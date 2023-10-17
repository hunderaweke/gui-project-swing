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
        var email = new CustomLabel(userData[2]);
        var userName = new CustomLabel(userData[3]);
        var phoneNumber = new CustomLabel(userData[userData.length - 1]);
        detailsPanel.setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHEAST; // Align components to the top right corner
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding
        gbc.gridx = 0;
        gbc.gridy = 0;
        detailsPanel.add(name, gbc);
        gbc.gridy = 1;
        detailsPanel.add(userName, gbc);
        gbc.gridy = 2;
        detailsPanel.add(email, gbc);
        gbc.gridy = 3;
        detailsPanel.add(phoneNumber, gbc);
        this.add(profileIcon);
        this.add(detailsPanel);
    }
}