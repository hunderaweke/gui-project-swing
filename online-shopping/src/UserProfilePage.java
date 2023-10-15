
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfilePage {
    public static void userProfilePage(String[] userData) {
        var frame = new JFrame("User Profile");
        var panel = new JPanel();
        var firstName = new JLabel(userData[0]);
        var lastName = new JLabel(userData[1]);
        var email = new JLabel(userData[2]);
        var userName = new JLabel(userData[3]);
        var phoneNumber = new JLabel(userData[userData.length - 1]);
        var buyAProductButton = new JButton("Buy A Product");
        panel.setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(firstName, gbc);
        gbc.gridy = 1;
        panel.add(lastName, gbc);
        gbc.gridy = 2;
        gbc.gridx = 1;
        panel.add(buyAProductButton, gbc);
        gbc.gridx = 0;
        panel.add(userName, gbc);
        gbc.gridy = 3;
        panel.add(email, gbc);
        gbc.gridy = 4;
        panel.add(phoneNumber, gbc);
        buyAProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ShowItemsPage.showItemsPage();
            }
        });
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.RED);
        frame.setSize(400, 700);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        var userData = UserProfile.getUserData("hundera");
        userProfilePage(userData);
    }
}
