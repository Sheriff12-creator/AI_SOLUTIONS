package dao;

import model.Event;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    public static List<Event> getAllEvents(){

        List<Event> list = new ArrayList<>();

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM events ORDER BY event_date ASC";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Event e = new Event();

                e.setId(rs.getInt("id"));
                e.setEventName(rs.getString("event_name"));
                e.setLocation(rs.getString("location"));
                e.setDescription(rs.getString("description"));
                e.setEventDate(rs.getString("event_date"));
                e.setImagePath(rs.getString("image_path"));

                list.add(e);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
