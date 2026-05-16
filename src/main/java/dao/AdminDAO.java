package dao;

import model.Admin;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

    public static Admin login(String username) {

        Admin admin = null;

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM admins WHERE username=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                admin = new Admin();

                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setEmail(rs.getString("email"));
                admin.setAuthToken(rs.getString("auth_token"));
                admin.setTokenExpiry(rs.getLong("token_expiry"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return admin;
    }

    public static void saveToken(int adminId,
                                 String token,
                                 long expiry) {

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "UPDATE admins SET auth_token=?, token_expiry=? WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, token);
            ps.setLong(2, expiry);
            ps.setInt(3, adminId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Admin getAdminByToken(String token) {

        Admin admin = null;

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "SELECT * FROM admins WHERE auth_token=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, token);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                admin = new Admin();

                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setEmail(rs.getString("email"));
                admin.setAuthToken(rs.getString("auth_token"));
                admin.setTokenExpiry(rs.getLong("token_expiry"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return admin;
    }

    public static void clearToken(int adminId) {

        try {

            Connection conn = DBConnection.getConnection();

            String sql =
                    "UPDATE admins " +
                            "SET auth_token=NULL, token_expiry=NULL " +
                            "WHERE id=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, adminId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}