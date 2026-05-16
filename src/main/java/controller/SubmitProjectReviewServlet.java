package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/submit-project-review")
public class SubmitProjectReviewServlet
        extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int projectId =
                    Integer.parseInt(
                            request.getParameter("projectId")
                    );

            String reviewerName =
                    request.getParameter("reviewerName");

            int rating =
                    Integer.parseInt(
                            request.getParameter("rating")
                    );

            String reviewText =
                    request.getParameter("reviewText");

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO project_reviews " +
                            "(project_id, reviewer_name, rating, review_text) " +
                            "VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, projectId);
            ps.setString(2, reviewerName);
            ps.setInt(3, rating);
            ps.setString(4, reviewText);

            ps.executeUpdate();

            response.sendRedirect("projects");

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
