package com.bank.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminDash")
public class AdminDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String status = req.getParameter("status"); // PENDING / COMPLETED / ALL
        List<AccountRequestDTO> list = new ArrayList<>();

        try (Connection con = DBconnection.getconnection()) {

            String sql;

            if ("PENDING".equals(status)) {
                sql = "SELECT * FROM account_request WHERE status='PENDING'";
            } 
            else if ("COMPLETED".equals(status)) {
                sql = "SELECT * FROM account_request WHERE status IN ('APPROVED','REJECTED')";
            } 
            else {
                sql = "SELECT * FROM account_request";
            }

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AccountRequestDTO dto = new AccountRequestDTO();
                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
                dto.setAadhaar(rs.getString("aadhaar"));
                dto.setPhone(rs.getString("phone"));
                dto.setAddress(rs.getString("address"));
                dto.setDeposit(rs.getDouble("deposit"));
                dto.setStatus(rs.getString("status"));
                dto.setRejectionReason(rs.getString("rejection_reason"));

                list.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("requests", list);
        req.setAttribute("filter", status);
        req.getRequestDispatcher("adminDash.jsp").forward(req, res);
    }
}
