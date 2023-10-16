package stg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import custom.CustomInputField;
import custom.CustomPasswordField;

public class LoginPage {

    public static void main(String[] args) {
        var frame = new JFrame("Online Shopping");
        var panel = new JPanel();
        var userNameField = new CustomInputField();

        // font supreme from fonts directoryFont font;\
        var passwordField = new CustomPasswordField();
        var userNameLabel = new JLabel("Enter Name: ");
        var passwordLabel = new JLabel("Enter Password");

        var button = new JButton("Login");
        button.setBackground(new Color(143, 196, 212));
        panel.setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(userNameLabel, gbc);
        gbc.gridy = 1;
        panel.add(userNameField, gbc);
        gbc.gridy = 2;
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
        // make the frame to appear at the middle of the screen
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);


        button.addMouseListener(new ButtonHoverEffect());
        userNameField.addMouseListener(new TextFieldHoverEffect());
        passwordField.addMouseListener(new TextFieldHoverEffect());

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

    // Custom MouseListener implementation for button hover effect
    static class ButtonHoverEffect extends MouseAdapter {
        private Color originalBackground;

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            originalBackground = button.getBackground();
            button.setBackground(new Color(205, 234, 226));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            button.setBackground(originalBackground);
        }
    }

    // Custom MouseListener implementation for text field hover effect
    static class TextFieldHoverEffect extends MouseAdapter {
        private Color originalBackground;

        @Override
        public void mouseEntered(MouseEvent e) {
            JTextField textField = (JTextField) e.getSource();
            originalBackground = textField.getBackground();
            textField.setBackground(Color.WHITE);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JTextField textField = (JTextField) e.getSource();
            textField.setBackground(originalBackground);
        }
    }
}