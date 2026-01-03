package com.bank.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    public UserDTO validateAndGetUser(String accountId, String password, String role)
            throws Exception {

        String sql =
            "SELECT account_id, username, password, role, balance " +
            "FROM users WHERE account_id=? AND password=? AND role=?";

        try (Connection con = DBconnection.getconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, accountId);
            ps.setString(2, password);
            ps.setString(3, role);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UserDTO user = new UserDTO();
                user.setAccountId(rs.getString("account_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setBalance(rs.getDouble("balance"));
                return user;
            }
        }
        return null;
    }
}
