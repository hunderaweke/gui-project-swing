package stg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class SignupPage extends JFrame {
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton signupButton;

    public SignupPage() {
        setTitle("Signup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to full screen

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(173, 216, 230)); // Set light blue background color
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());

        JLabel headerLabel = new JLabel("Online Shopping");
        headerLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE); // Set white text color

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        signupButton = new JButton("Signup");
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Establish database connection
                try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;")) {
                    // Prepare SQL statement
                    String sql = "INSERT INTO Customers (username, email, password) VALUES (?, ?, ?)";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, username);
                        statement.setString(2, email);
                        statement.setString(3, password);

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

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Add some spacing
        contentPane.add(headerLabel, gbc);

        gbc.gridy = 1;
        contentPane.add(usernameLabel, gbc);

        gbc.gridx = 1; // Use the next column
        contentPane.add(usernameField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0; // Reset to the first column
        contentPane.add(emailLabel, gbc);

        gbc.gridx = 1;
        contentPane.add(emailField, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        contentPane.add(passwordLabel, gbc);

        gbc.gridx = 1;
        contentPane.add(passwordField, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // Span across two columns
        contentPane.add(signupButton, gbc);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SignupPage signupPage = new SignupPage();
            signupPage.setVisible(true);
        });
    }
}