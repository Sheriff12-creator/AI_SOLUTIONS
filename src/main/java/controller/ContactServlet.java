package controller;

import dao.InquiryDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Inquiry;
import java.io.IOException;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Inquiry i = new Inquiry();

        i.setFullName(request.getParameter("fullName"));
        i.setEmail(request.getParameter("email"));
        i.setPhone(request.getParameter("phone"));
        i.setCompanyName(request.getParameter("companyName"));
        i.setCountry(request.getParameter("country"));
        i.setJobTitle(request.getParameter("jobTitle"));
        i.setJobDetails(request.getParameter("jobDetails"));

        boolean success = InquiryDAO.saveInquiry(i);

        if (success) {
            response.sendRedirect("contact.jsp?success=true");
        } else {
            response.sendRedirect("contact.jsp?error=true");
        }
    }
}