package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Project;
import util.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/project-details")
public class ProjectDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int projectId =
                Integer.parseInt(
                        request.getParameter("id")
                );

        Project project = null;

        List<String> reviews =
                new ArrayList<>();

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "SELECT p.*, " +
                            "COALESCE(AVG(pr.rating),0) AS avg_rating " +
                            "FROM projects p " +
                            "LEFT JOIN project_reviews pr " +
                            "ON p.id = pr.project_id " +
                            "WHERE p.id=? " +
                            "GROUP BY p.id";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, projectId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()){

                project = new Project();

                project.setId(
                        rs.getInt("id")
                );

                project.setProjectName(
                        rs.getString("project_name")
                );

                project.setClientName(
                        rs.getString("client_name")
                );

                project.setDescription(
                        rs.getString("description")
                );

                project.setTechnologies(
                        rs.getString("technologies")
                );

                project.setImageUrl(
                        rs.getString("image_url")
                );

                project.setAvgRating(
                        rs.getDouble("avg_rating")
                );
            }

            String reviewSql =
                    "SELECT * FROM project_reviews " +
                            "WHERE project_id=? " +
                            "ORDER BY created_at DESC";

            PreparedStatement reviewPs =
                    conn.prepareStatement(reviewSql);

            reviewPs.setInt(1, projectId);

            ResultSet reviewRs =
                    reviewPs.executeQuery();

            while(reviewRs.next()){

                reviews.add(
                        reviewRs.getString("reviewer_name")
                                + " | "
                                + reviewRs.getInt("rating")
                                + "★ | "
                                + reviewRs.getString("review_text")
                );
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        request.setAttribute("project", project);

        request.setAttribute("reviews", reviews);

        request.getRequestDispatcher(
                "project-details.jsp"
        ).forward(request, response);
    }
}
