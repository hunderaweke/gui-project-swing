package stg;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage {

    public static void main(String[] args) {
        var frame = new JFrame("Online Shopping");
        var panel = new JPanel();
        var userNameField = new JTextField(10);
        userNameField.setBackground(new Color(192, 192, 192));
        userNameField.setForeground(Color.black);
        Font font = new Font("Times New Roman", Font.BOLD, 16);
        userNameField.setFont(font);

        var passwordField = new JPasswordField(10);
        var userNameLabel = new JLabel("Enter Name: ");
        var passwordLabel = new JLabel("Enter Password");
        passwordField.setBackground(new Color(192, 192, 192));
        passwordField.setFont(font);

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
        userNameField.setPreferredSize(new Dimension(200, 30));
        userNameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);
        gbc.gridy = 3;
        panel.add(passwordField, gbc);
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 0, 0);
        panel.add(button, gbc);
        frame.add(panel);
        panel.setBackground(new Color(19, 126, 217));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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