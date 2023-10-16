import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfilePage {
    public static void userProfilePage(String[] userData) {
        var frame = new JFrame("User Profile");
        frame.setLayout(new BorderLayout());
        var navigationPanel = new JPanel();
        var buttonProductPage = new JButton("Products");
        var buttonUserProfilePage = new JButton("Profile"); 
        navigationPanel.add(buttonProductPage);
        navigationPanel.add(buttonUserProfilePage );
        frame.add(navigationPanel,BorderLayout.WEST);
        var profilePanel = new JPanel();
        var name = new JLabel("<html><h1>" + userData[0] + " " + userData[1] + "</h1></html>");
        var email = new JLabel(userData[2]);
        var userName = new JLabel(userData[3]);
        var phoneNumber = new JLabel(userData[userData.length - 1]);
        profilePanel.setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHEAST; // Align components to the top right corner
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding
        gbc.gridx = 1;
        gbc.gridy = 0;
        profilePanel.add(name, gbc);
        gbc.gridy = 1;
        profilePanel.add(userName, gbc);
        gbc.gridy = 2;
        profilePanel.add(email, gbc);
        gbc.gridy = 3;
        profilePanel.add(phoneNumber, gbc);
        frame.add(profilePanel);

        buttonUserProfilePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // productPanel.setVisible(false);
                profilePanel.setVisible(true);
                frame.add(profilePanel);
            }
        });
        buttonProductPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var productPanel = ProductsPage.productsPage();
                profilePanel.setVisible(false);
                frame.add(productPanel);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to fullscreen
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        var userData = UserProfile.getUserData("hundera");
        userProfilePage(userData);
    }
}