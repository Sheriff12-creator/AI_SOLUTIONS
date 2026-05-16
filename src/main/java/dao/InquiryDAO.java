package dao;

import model.Inquiry;
import util.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InquiryDAO {

    public static boolean saveInquiry(Inquiry i) {

        boolean result = false;

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO inquiries " +
                    "(full_name, email, phone,\n" +
                    "company_name, country,\n" +
                    "job_title, job_details,\n" +
                    "created_at) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, NOW())";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, i.getFullName());
            ps.setString(2, i.getEmail());
            ps.setString(3, i.getPhone());
            ps.setString(4, i.getCompanyName());
            ps.setString(5, i.getCountry());
            ps.setString(6, i.getJobTitle());
            ps.setString(7, i.getJobDetails());


            result = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static int getTotalInquiries() {

        int total = 0;

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "SELECT COUNT(*) FROM inquiries";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                total = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }

    public static List<Inquiry> getAllInquiries() {

        List<Inquiry> list = new ArrayList<>();

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "SELECT * FROM inquiries ORDER BY id DESC";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Inquiry i = new Inquiry();

                i.setFullName(
                        rs.getString("full_name")
                );

                i.setEmail(
                        rs.getString("email")
                );

                i.setPhone(
                        rs.getString("phone")
                );

                i.setCompanyName(
                        rs.getString("company_name")
                );

                i.setCountry(
                        rs.getString("country")
                );

                i.setJobTitle(
                        rs.getString("job_title")
                );

                i.setJobDetails(
                        rs.getString("job_details")
                );

                i.setStatus(
                        rs.getString("status")
                );

                list.add(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}