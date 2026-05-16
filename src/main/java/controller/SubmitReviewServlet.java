package controller;

import dao.ReviewDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Review;

import java.io.IOException;

public class SubmitReviewServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String fullName =
                request.getParameter("fullName");

        String companyName =
                request.getParameter("companyName");


        String reviewText =
                request.getParameter("reviewText");

        int rating =
                Integer.parseInt(
                        request.getParameter("rating")
                );

        Review review = new Review();

        review.setFullName(fullName);
        review.setCompanyName(companyName);
        review.setReviewText(reviewText);
        review.setRating(rating);

        boolean success =
                ReviewDAO.saveReview(review);

        if(success){

            response.sendRedirect(
                    "reviews.jsp?success=1"
            );

        } else {

            response.sendRedirect(
                    "submit-review.jsp?error=1"
            );
        }
    }
}
