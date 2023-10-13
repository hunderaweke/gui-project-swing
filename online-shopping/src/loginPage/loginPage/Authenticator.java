package loginPage;

import java.sql.*;

public class Authenticator {
    protected static boolean authenticate(String userName, String password) {
        try {
            var connectionUrl = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=<username>;password=<password>;encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;";
            var con = DriverManager.getConnection(connectionUrl);
            var query = "SELECT username,customer_password FROM Customer";
            var statement = con.createStatement();
            var resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                var passwordFromDatabase = resultSet.getString(2);
                System.out.println(passwordFromDatabase);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

}
