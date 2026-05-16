package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Service;
import util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/services")
public class ServiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Service> services = new ArrayList<>();

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM services";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()){

                Service s = new Service();

                s.setId(rs.getInt("id"));
                s.setServiceName(rs.getString("service_name"));
                s.setDescription(rs.getString("description"));
                s.setIcon(rs.getString("icon"));

                services.add(s);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        request.setAttribute("services", services);

        request.getRequestDispatcher("services.jsp")
                .forward(request, response);
    }
}