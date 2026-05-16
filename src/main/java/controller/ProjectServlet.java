package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Project;
import util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/projects")
public class ProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Project> projectList = new ArrayList<>();

        try {

            Connection conn = DBConnection.getConnection();

            String sql = """
            SELECT p.*,
            AVG(pr.rating) AS avg_rating
            FROM projects p
            LEFT JOIN project_reviews pr
            ON p.id = pr.project_id
            GROUP BY p.id
            """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Project p = new Project();

                p.setId(rs.getInt("id"));
                p.setProjectName(rs.getString("project_name"));
                p.setClientName(rs.getString("client_name"));
                p.setDescription(rs.getString("description"));
                p.setTechnologies(rs.getString("technologies"));
                p.setRating(rs.getInt("rating"));
                p.setImageUrl(rs.getString("image_url"));
                p.setAvgRating(rs.getDouble("avg_rating"));

                projectList.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("projects", projectList);

        request.getRequestDispatcher("projects.jsp")
                .forward(request, response);
    }
}