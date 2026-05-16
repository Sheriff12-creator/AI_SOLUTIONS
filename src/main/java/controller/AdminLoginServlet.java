package controller;

import dao.AdminDAO;
import model.Admin;
import util.EmailUtil;
import util.PasswordUtil;
import util.TokenUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/admin-login")
public class AdminLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        Admin admin =
                AdminDAO.login(username);

        if(admin != null &&
                PasswordUtil.verifyPassword(
                        password,
                        admin.getPassword()
                )) {

            String token =
                    TokenUtil.generateToken(admin.getId());

            String[] parts = token.split("\\.");

            long expiry =
                    Long.parseLong(parts[2]);

            AdminDAO.saveToken(
                    admin.getId(),
                    token,
                    expiry
            );

            EmailUtil.sendToken(
                    admin.getEmail(),
                    token
            );

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "pendingAdmin",
                    admin.getUsername()
            );

            response.sendRedirect(
                    "admin/verify-token.jsp"
            );

        } else {

            response.sendRedirect(
                    "admin/login.jsp?error=true"
            );
        }
    }
}