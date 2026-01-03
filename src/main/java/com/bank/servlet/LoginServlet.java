package com.bank.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String accountId = req.getParameter("accountId");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        try {
            LoginDAO dao = new LoginDAO();
            UserDTO user = dao.validateAndGetUser(accountId, password, role);

            if (user != null) {
                HttpSession session = req.getSession(true);

                session.setAttribute("accountId", user.getAccountId());
                session.setAttribute("username", user.getUsername());
                session.setAttribute("role", user.getRole());
                session.setAttribute("balance", user.getBalance());
                session.setAttribute("password", user.getPassword());

                if ("ADMIN".equals(user.getRole())) {
                    res.sendRedirect("adminDash");
                } else {
                    res.sendRedirect("UserDash.jsp");
                }
            } else {
                req.setAttribute("error", "Invalid Account ID / Password / Role");
                req.getRequestDispatcher("Login.jsp").forward(req, res);
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
