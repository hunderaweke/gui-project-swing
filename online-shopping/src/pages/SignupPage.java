package pages;

import javax.swing.*;

import custom_components.CustomButtonHoverEffect;
import custom_components.CustomCardButton;
import custom_components.CustomHeader;
import custom_components.CustomInputField;
import custom_components.CustomSignUpLabel;
import custom_components.CustomPasswordField;
import custom_components.SideBarButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupPage extends JFrame {
    public CustomInputField usernameField;
    public CustomInputField firstNameField;
    public CustomInputField lastNameField;
    public CustomInputField phoneNumberField;
    public CustomInputField ageField;
    public CustomInputField emailField;
    public CustomPasswordField passwordField;
    public CustomPasswordField confirmPasswordField;
    public JButton signupButton;

    public SignupPage() {
        setTitle("Signup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(990, 800));
        setLocationRelativeTo(null);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(1, 73, 124));
        add(contentPane);
        contentPane.setLayout(new GridBagLayout());
        JPanel signuPanel = new JPanel();
        signuPanel.setBackground(new Color(19, 126, 217));
        JLabel headerLabel = new CustomHeader("Online Shopping  ");
        headerLabel.setForeground(Color.WHITE);
        var firstNameLabel = new CustomSignUpLabel("First name:");
        firstNameField = new CustomInputField();
        var lastNameLabel = new CustomSignUpLabel("Last name:");
        lastNameField = new CustomInputField();
        var alreadyHaveAccount = new CustomSignUpLabel("Already Have an Account");
        var toLoginButton = new CustomCardButton("󰍂  Login");
        var phoneLabel = new CustomSignUpLabel("Phone Number:");
        phoneNumberField = new CustomInputField();
        var ageLabel = new CustomSignUpLabel("Age:");
        ageField = new CustomInputField();
        CustomSignUpLabel usernameLabel = new CustomSignUpLabel("Username:");
        usernameField = new CustomInputField();
        CustomSignUpLabel emailLabel = new CustomSignUpLabel("Email:");
        emailField = new CustomInputField();
        CustomSignUpLabel passwordLabel = new CustomSignUpLabel("Password:");
        passwordField = new CustomPasswordField();
        CustomSignUpLabel confirmPasswordLabel = new CustomSignUpLabel("Confirm Password:");
        confirmPasswordField = new CustomPasswordField();
        signupButton = new SideBarButton("  Signup");
        signupButton.setFont(signupButton.getFont().deriveFont(Font.BOLD, 18));
        signupButton.setPreferredSize(new Dimension(250, 40));
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = usernameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String age = ageField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String phoneNumber = phoneNumberField.getText();
                String confirmPassword = new String(confirmPasswordField.getPassword());

                // Establish database connection
                try (Connection connection = DriverManager.getConnection(
                        "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;")) {
                    // Prepare SQL statement
                    String sql = "insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values (?, ?, ?, ?, ?, ?,  HASHBYTES('SHA2_256', ?));";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, firstName);
                        statement.setString(2, lastName);
                        statement.setString(3, email);
                        statement.setString(4, phoneNumber);
                        statement.setString(5, age);
                        statement.setString(6, userName);
                        statement.setString(7, password);
                        statement.setString(8, confirmPassword);

                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "Signup successful!");
                        }
                        setVisible(false);
                        new MainFrame("Online Shopping", userName);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        toLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new LoginPage();
            }
        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 4, 0, 10);
        gbc.anchor = GridBagConstraints.WEST;
        signupButton.addMouseListener(new CustomButtonHoverEffect());
        signuPanel.setLayout(new GridBagLayout());
        signuPanel.setBackground(new Color(1, 73, 124));
        gbc.gridx = 0;
        gbc.gridy = 0;
        signuPanel.add(firstNameLabel, gbc);
        gbc.gridy = 1;
        signuPanel.add(firstNameField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        signuPanel.add(lastNameLabel, gbc);
        gbc.gridy = 1;
        signuPanel.add(lastNameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        signuPanel.add(phoneLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        signuPanel.add(phoneNumberField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        signuPanel.add(ageLabel, gbc);
        gbc.gridy += 1;
        signuPanel.add(ageField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        signuPanel.add(usernameLabel, gbc);
        gbc.gridy += 1;
        signuPanel.add(usernameField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        signuPanel.add(passwordLabel, gbc);
        gbc.gridy += 1;
        signuPanel.add(passwordField, gbc);
        gbc.gridx = 0;
        gbc.gridy += 1;
        signuPanel.add(emailLabel, gbc);
        gbc.gridy += 1;
        signuPanel.add(emailField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        signuPanel.add(confirmPasswordLabel, gbc);
        gbc.gridy += 1;
        signuPanel.add(confirmPasswordField, gbc);
        gbc.gridx = 0;
        gbc.gridy += 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 4, 0, 10);
        gbc.gridwidth = 2;
        signuPanel.add(signupButton, gbc);

        gbc.gridx = 0;
        gbc.gridy += 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        signuPanel.add(alreadyHaveAccount, gbc);

        gbc.gridx = 0;
        gbc.gridy += 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        signuPanel.add(toLoginButton, gbc);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;

        contentPane.add(headerLabel, gbc);

        signuPanel.setPreferredSize(new Dimension(500, 1000));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(signuPanel, gbc);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SignupPage();
    }
}