package com.bank.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/transactions")
public class TransactionHistoryServlet extends HttpServlet {

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
            TransactionDAO dao = new TransactionDAO();
            List<TransactionDTO> list = dao.getTransactions(accountId);

            req.setAttribute("transactions", list);

        } catch (Exception e) {
            throw new ServletException(e);
        }

        req.getRequestDispatcher("transactions.jsp")
           .forward(req, res);
    }
}
