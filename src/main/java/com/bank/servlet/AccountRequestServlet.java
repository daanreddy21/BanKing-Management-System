package com.bank.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/requestAccount")
public class AccountRequestServlet extends HttpServlet {

protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

    String name = req.getParameter("name");
    String aadhaar = req.getParameter("aadhaar");
    String phone = req.getParameter("phone");
    String address = req.getParameter("address");
    double deposit = Double.parseDouble(req.getParameter("deposit"));

    try {
        Connection con = DBconnection.getconnection();
        PreparedStatement ps = con.prepareStatement(
          "INSERT INTO account_request(name,aadhaar,phone,address,deposit,status) VALUES(?,?,?,?,?,?)"
        );
        ps.setString(1, name);
        ps.setString(2, aadhaar);
        ps.setString(3, phone);
        ps.setString(4, address);
        ps.setDouble(5, deposit);
        ps.setString(6, "PENDING");

        ps.executeUpdate();
        res.sendRedirect("requestSuccess.jsp");

    } catch (Exception e) {
        e.printStackTrace();
    }
}


}

