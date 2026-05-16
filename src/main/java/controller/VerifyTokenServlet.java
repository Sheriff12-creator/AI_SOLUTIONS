package controller;

import dao.AdminDAO;
import model.Admin;
import util.TokenUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/verify-token")
public class VerifyTokenServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String token =
                request.getParameter("token");

        boolean valid =
                TokenUtil.validateToken(token);

        if(!valid) {

            response.sendRedirect(
                    "admin/verify-token.jsp?invalid=true"
            );

            return;
        }

        Admin admin =
                AdminDAO.getAdminByToken(token);

        if(admin == null) {

            response.sendRedirect(
                    "admin/verify-token.jsp?invalid=true"
            );

            return;
        }

        long expiry =
                admin.getTokenExpiry();

        if(System.currentTimeMillis() > expiry) {

            response.sendRedirect(
                    "admin/verify-token.jsp?expired=true"
            );

            return;
        }

        HttpSession session =
                request.getSession();

        session.setAttribute(
                "admin",
                admin.getUsername()
        );

        session.setMaxInactiveInterval(900);

        AdminDAO.clearToken(admin.getId());
        response.sendRedirect(
                "admin/dashboard.jsp"
        );
    }
}