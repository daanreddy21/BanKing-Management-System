package com.bank.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/userDash")
public class UserDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("accountId") == null) {
            res.sendRedirect("Login.jsp");
            return;
        }

        String accountId = (String) session.getAttribute("accountId");

        try {
            UserDAO userDAO = new UserDAO();
            double balance = userDAO.getBalance(accountId);

            TransactionDAO txnDAO = new TransactionDAO();
            List<TransactionDTO> txns = txnDAO.getTransactions(accountId);

            session.setAttribute("balance", balance);
            req.setAttribute("transactions", txns);

        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("UserDash.jsp").forward(req, res);
    }
}
