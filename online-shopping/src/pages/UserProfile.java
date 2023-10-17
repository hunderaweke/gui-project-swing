package pages;

import java.sql.*;

public class UserProfile {
    public static String[] getUserData(String userName) {
        try {
            var connectionUrl = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;";
            var con = DriverManager.getConnection(connectionUrl);
            var getUserDataQuery = "SELECT username,first_name,last_name,email,phone_number FROM Customer WHERE username = ?;";
            var statement = con.prepareStatement(getUserDataQuery);
            statement.setString(1, userName);
            var resultSet = statement.executeQuery();
            resultSet.next();
            var userData = new String[] { resultSet.getString("first_name"), resultSet.getString("last_name"),
                    resultSet.getString("email"), resultSet.getString("phone_number") };
            return userData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return new String[] {};
    };
}
