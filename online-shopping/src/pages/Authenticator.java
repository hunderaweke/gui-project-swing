package pages;

import java.security.MessageDigest;
import java.sql.*;

public class Authenticator {
    public static boolean authenticate(String userName, String password) {
        try {
            var connectionUrl = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;";
            var con = DriverManager.getConnection(connectionUrl);
            var getPasswordQuery = "SELECT username,customer_password FROM Customer WHERE username = ?";
            var statement = con.prepareStatement(getPasswordQuery);
            statement.setString(1, userName);
            var resultSet = statement.executeQuery();
            resultSet.next();
            var passwordFromDB = resultSet.getBytes("customer_password");
            try {
                var md = MessageDigest.getInstance("SHA-256");
                md.update(password.getBytes());
                byte[] hashedPassword = md.digest();
                if (MessageDigest.isEqual(hashedPassword, passwordFromDB)) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Error");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
