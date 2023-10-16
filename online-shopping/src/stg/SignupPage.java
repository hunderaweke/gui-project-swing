package stg;

import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import stg.LoginPage.ButtonHoverEffect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.EventObject;
=======
import java.sql.*;
>>>>>>> 1974a8e283ce6bee22f93e60379be6ac68ea1032

public class SignupPage extends JFrame {
    public JTextField usernameField;
    public JTextField firstNameField;
    public JTextField lastNameField;
    public JTextField phoneNumberField;
    public JTextField ageField;
    public JTextField emailField;
    public JPasswordField passwordField;
    public JButton signupButton;

    public SignupPage() {
        setTitle("Signup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to full screen

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(19, 126, 217)); // Set light blue background color
        add(contentPane);
        contentPane.setLayout(new GridBagLayout());

        JLabel headerLabel = new JLabel("Online Shopping");
        headerLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 42));
        headerLabel.setForeground(Color.WHITE); // Set white text color
        var firstNameLabel  = new JLabel("First name");
        firstNameField = new JTextField(20);
        firstNameField.setPreferredSize(new Dimension(250, 30));
        var lastNameLabel  = new JLabel("Last name");
        lastNameField = new JTextField(20);
        lastNameField.setPreferredSize(new Dimension(250, 30));

        var phoneLabel =  new JLabel("Phone Number");
        phoneNumberField = new JTextField(20);
        phoneNumberField.setPreferredSize(new Dimension(250, 30));
        var ageLabel =  new JLabel("Age");
        ageField = new JTextField(10);
        ageField.setPreferredSize(new Dimension(250, 30));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        usernameField.setPreferredSize(new Dimension(250, 30));
      

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(250, 30));

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(250, 30));

        
        
        firstNameLabel.setFont(firstNameLabel.getFont().deriveFont(Font.BOLD, 18)); 
        lastNameLabel.setFont(lastNameLabel.getFont().deriveFont(Font.BOLD, 18)); 
        phoneLabel.setFont(phoneLabel.getFont().deriveFont(Font.BOLD, 18)); 
        ageLabel.setFont(ageLabel.getFont().deriveFont(Font.BOLD, 18)); 
        usernameLabel.setFont(usernameLabel.getFont().deriveFont(Font.BOLD, 18)); 
        emailLabel.setFont(emailLabel.getFont().deriveFont(Font.BOLD, 18));
        passwordLabel.setFont(passwordLabel.getFont().deriveFont(Font.BOLD, 18));


        signupButton = new JButton("Signup");
        signupButton.setBackground(new Color(143, 196, 212));
        signupButton.setForeground(Color.BLACK);
        signupButton.setFont(signupButton.getFont().deriveFont(Font.BOLD, 18));
        signupButton.setPreferredSize(new Dimension(100, 40));
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String age = ageField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String phoneNumber = phoneNumberField.getText();
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
                        statement.setString(6, username);
                        statement.setString(7, password);


                        // Execute the SQL statement
                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "Signup successful!");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        signupButton.addMouseListener(new ButtonHoverEffect());
         class ButtonHoverEffect extends MouseAdapter {
        private Color originalBackground;

        
        public void mouseEntered(MouseEvent e) {
            JButton button = (JButton) ((EventObject) e).getSource();
            originalBackground = button.getBackground();
            button.setBackground(new Color(205, 234, 226));
        }

    
        public void mouseExited(MouseEvent e) {
            JButton button = (JButton) ((EventObject) e).getSource();
            button.setBackground(originalBackground);
        }
    }


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(headerLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPane.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPane.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
               contentPane.add(lastNameLabel, gbc);
       
               gbc.gridx = 1;
               gbc.gridy = 2;
               contentPane.add(lastNameField, gbc);
       
               gbc.gridx = 0;
               gbc.gridy = 3;
               contentPane.add(phoneLabel, gbc);
       
               gbc.gridx = 1;
               gbc.gridy = 3;
               contentPane.add(phoneNumberField, gbc);
       
               gbc.gridx = 0;
               gbc.gridy = 4;
               contentPane.add(ageLabel, gbc);
       
               gbc.gridx = 1;
               gbc.gridy = 4;
               contentPane.add(ageField, gbc);
       
               gbc.gridx = 0;
               gbc.gridy = 5;
               contentPane.add(usernameLabel, gbc);
       
               gbc.gridx = 1;
               gbc.gridy = 5;
               contentPane.add(usernameField, gbc);
       
               gbc.gridx = 0;
               gbc.gridy = 6;
               contentPane.add(emailLabel, gbc);
       
               gbc.gridx = 1;
               gbc.gridy = 6;
               contentPane.add(emailField, gbc);
       
               gbc.gridx = 0;
               gbc.gridy = 7;
               contentPane.add(passwordLabel, gbc);
       
               gbc.gridx = 1;
               gbc.gridy = 7;
               contentPane.add(passwordField, gbc);
       
               gbc.gridx = 0;
               gbc.gridy = 8;
               gbc.gridwidth = 2;
               contentPane.add(signupButton, gbc);
       
               setVisible(true);
           }
       
           public static void main(String[] args) {
               SwingUtilities.invokeLater(SignupPage::new);
           }
       }