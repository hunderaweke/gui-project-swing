
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginPage {
    
    public static void main(String[] args) {
        var frame = new JFrame("Login");
        var panel = new JPanel();
        var userNameField = new JTextField(10);
        var passwordField = new JPasswordField(10);
        var userNameLabel = new JLabel("Enter Name: ");
        var passwordLabel = new JLabel("Enter Password");
        var button = new JButton("Login");
        panel.setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(userNameLabel, gbc);
        gbc.gridy = 1;
        panel.add(userNameField, gbc);
        userNameField.setPreferredSize(new Dimension(200, 30));
        userNameField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);
        gbc.gridy = 3;
        panel.add(passwordField, gbc);
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(button, gbc);
        frame.add(panel);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameField.getText();
                String password = passwordField.getText();
                var authenticated = Authenticator.authenticate(userName, password);
                if (authenticated) {
                    JOptionPane.showMessageDialog(frame, "Login Successful");
                    var userData = UserProfile.getUserData(userName);
                    frame.setVisible(false);
                    UserProfilePage.userProfilePage(userData);
                } else {
                    JOptionPane.showMessageDialog(frame, "Login Failed");
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.RED);
        frame.setSize(400, 700);
        frame.setVisible(true);
    }
}
