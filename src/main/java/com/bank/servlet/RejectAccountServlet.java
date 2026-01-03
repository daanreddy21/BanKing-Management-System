package com.bank.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/rejectAccount")
public class RejectAccountServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int reqId = Integer.parseInt(req.getParameter("reqId"));
        String reason = req.getParameter("reason");

        try {
            AccountRequestDAO dao = new AccountRequestDAO();
            dao.rejectRequest(reqId, reason);

            res.sendRedirect("adminDash");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
