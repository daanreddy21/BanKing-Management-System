package com.bank.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null) {
            res.sendRedirect("Login.jsp");
            return;
        }

        String accountId = (String) session.getAttribute("accountId");
        String sessionPassword = (String) session.getAttribute("password");
        String inputPassword = req.getParameter("password");

        if (!sessionPassword.equals(inputPassword)) {
            res.sendRedirect("withdraw.jsp?error=InvalidPassword");
            return;
        }

        double amount = Double.parseDouble(req.getParameter("amount"));

        try {
            UserDAO dao = new UserDAO();
            dao.updateBalance(accountId, -amount); // DEBIT

            // refresh balance
            double newBalance = dao.getBalance(accountId);
            session.setAttribute("balance", newBalance);

            res.sendRedirect("UserDash.jsp");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
