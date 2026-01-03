package com.bank.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRequestDAO {

    // 1️⃣ Save user request (with deposit)
    public void saveRequest(AccountRequestDTO dto)
            throws SQLException, ClassNotFoundException {

        String sql =
            "INSERT INTO account_request(name,aadhaar,phone,address,deposit,status) " +
            "VALUES(?,?,?,?,?,?)";

        try (Connection con = DBconnection.getconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dto.getName());
            ps.setString(2, dto.getAadhaar());
            ps.setString(3, dto.getPhone());
            ps.setString(4, dto.getAddress());
            ps.setDouble(5, dto.getDeposit());
            ps.setString(6, dto.getStatus());

            ps.executeUpdate();
        }
    }

    // 2️⃣ Get ONLY pending requests
    public List<AccountRequestDTO> getPendingRequests()
            throws SQLException, ClassNotFoundException {

        List<AccountRequestDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM account_request WHERE status='PENDING'";

        try (Connection con = DBconnection.getconnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AccountRequestDTO dto = new AccountRequestDTO();
                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
                dto.setAadhaar(rs.getString("aadhaar"));
                dto.setPhone(rs.getString("phone"));
                dto.setAddress(rs.getString("address"));
                dto.setDeposit(rs.getDouble("deposit"));
                dto.setStatus(rs.getString("status"));
                list.add(dto);
            }
        }
        return list;
    }

    // 3️⃣ Get ALL requests (pending + approved)
    public List<AccountRequestDTO> getAllRequests()
            throws SQLException, ClassNotFoundException {

        List<AccountRequestDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM account_request ORDER BY id DESC";

        try (Connection con = DBconnection.getconnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AccountRequestDTO dto = new AccountRequestDTO();
                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
                dto.setAadhaar(rs.getString("aadhaar"));
                dto.setPhone(rs.getString("phone"));
                dto.setAddress(rs.getString("address"));
                dto.setDeposit(rs.getDouble("deposit"));
                dto.setStatus(rs.getString("status"));
                list.add(dto);
            }
        }
        return list;
    }

    // 4️⃣ Approve request
    public void approveRequest(int id)
            throws SQLException, ClassNotFoundException {

        String sql = "UPDATE account_request SET status='APPROVED' WHERE id=?";

        try (Connection con = DBconnection.getconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    public void rejectRequest(int id, String reason)
            throws SQLException, ClassNotFoundException {

        String sql =
            "UPDATE account_request SET status='REJECTED', rejection_reason=? WHERE id=?";

        try (Connection con = DBconnection.getconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, reason);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

}
