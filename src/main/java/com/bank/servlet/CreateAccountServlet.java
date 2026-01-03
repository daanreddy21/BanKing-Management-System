package com.bank.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createAccount")
public class CreateAccountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int reqId = Integer.parseInt(req.getParameter("reqId"));

        try (Connection con = DBconnection.getconnection()) {

            // 1️⃣ Fetch account request
            String fetchSql =
                "SELECT name, aadhaar, deposit FROM account_request WHERE id=?";
            PreparedStatement ps1 = con.prepareStatement(fetchSql);
            ps1.setInt(1, reqId);
            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) {
                res.sendRedirect("adminDash");
                return;
            }

            String name = rs.getString("name");
            String aadhaar = rs.getString("aadhaar");
            double deposit = rs.getDouble("deposit");

            // 2️⃣ Penalty logic
            double penalty = (deposit < 1000) ? 10 : 0;
            double finalBalance = deposit - penalty;

            // 3️⃣ Generate credentials
            String accountId = "LCB" + System.currentTimeMillis();
            String password = aadhaar;

            // 4️⃣ Create user using DAO
            UserDTO user = new UserDTO();
            user.setAccountId(accountId);
            user.setUsername(name);     // maps to users.username
            user.setPassword(password);
            user.setRole("USER");
            user.setBalance(finalBalance);

            UserDAO userDAO = new UserDAO();
            userDAO.createUser(user);

            // 5️⃣ Update request status
            String updateSql =
                "UPDATE account_request SET status='APPROVED' WHERE id=?";
            PreparedStatement ps3 = con.prepareStatement(updateSql);
            ps3.setInt(1, reqId);
            ps3.executeUpdate();

            // 6️⃣ Redirect back to admin dashboard (SERVLET)
            res.sendRedirect("adminDash");

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Account creation failed", e);
        }
    }
}
