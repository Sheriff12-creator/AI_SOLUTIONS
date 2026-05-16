package dao;

import model.Service;
import util.DBConnection;

import java.sql.*;
import java.util.*;

public class ServiceDAO {

    public static List<Service> getAllServices() {

        List<Service> list = new ArrayList<>();

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

                s.setServiceName(
                        rs.getString("service_name")
                );

                s.setDescription(
                        rs.getString("description")
                );

                s.setIcon(
                        rs.getString("icon")
                );

                list.add(s);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
