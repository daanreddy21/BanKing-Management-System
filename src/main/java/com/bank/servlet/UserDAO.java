package com.bank.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // 1️⃣ Create user (used when admin approves account request)
    public void createUser(UserDTO user)
            throws SQLException, ClassNotFoundException {

        String sql =
            "INSERT INTO users(account_id, username, password, role, balance) " +
            "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBconnection.getconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getAccountId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.setDouble(5, user.getBalance());

            ps.executeUpdate();
        }
    }

    // 2️⃣ Get current balance (VERY IMPORTANT)
    public double getBalance(String accountId)
            throws SQLException, ClassNotFoundException {

        String sql = "SELECT balance FROM users WHERE account_id=?";

        try (Connection con = DBconnection.getconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, accountId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble("balance");
            }
        }
        return 0;
    }

    // 3️⃣ Update balance (deposit / withdraw)
    public void updateBalance(String accountId, double amount)
            throws SQLException, ClassNotFoundException {

        String sql = "UPDATE users SET balance = balance + ? WHERE account_id=?";

        try (Connection con = DBconnection.getconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, amount);
            ps.setString(2, accountId);

            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new SQLException("Invalid account ID");
            }
        }
    }
}
