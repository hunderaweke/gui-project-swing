package pages;

import java.sql.*;

public class UserProfile {
    public static String[] getUserData(String userName) {
        try {
            var connectionUrl = "jdbc:sqlserver://localhost:1433;Database=Online_shopping;user=hundera;password=55969362;encrypt=true;trustServerCertificate=true;";
            var con = DriverManager.getConnection(connectionUrl);
            var getUserDataQuery = "SELECT customer_id,username,first_name,last_name,email,phone_number FROM Customer WHERE username = ?;";
            var getuserBalanceQuery = "SELECT AMOUNT FROM balance WHERE customer_id=?;";
            var statement = con.prepareStatement(getUserDataQuery);
            statement.setString(1, userName);
            var resultSet = statement.executeQuery();
            resultSet.next();

            var userId = resultSet.getString("customer_id");
            var balanceStmnt = con.prepareStatement(getuserBalanceQuery);
            balanceStmnt.setString(1, "31");
            var balanceSet = balanceStmnt.executeQuery();
            balanceSet.next();
            var userData = new String[] { resultSet.getString("first_name"), resultSet.getString("last_name"),
                    resultSet.getString("username"),
                    resultSet.getString("email"), resultSet.getString("phone_number"), balanceSet.getString("AMOUNT") };
            return userData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return new String[] {};
    };
}