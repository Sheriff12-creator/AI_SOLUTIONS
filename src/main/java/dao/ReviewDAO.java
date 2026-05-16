package dao;

import model.Review;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    public static boolean saveReview(Review review) {

        boolean result = false;

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO reviews " +
                            "(full_name, company_name, review_text, rating) " +
                            "VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, review.getFullName());

            ps.setString(2, review.getCompanyName());

            ps.setString(3, review.getReviewText());

            ps.setInt(4, review.getRating());

            result =
                    ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<Review> getAllReviews() {

        List<Review> list =
                new ArrayList<>();

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM reviews ORDER BY id DESC";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Review r =
                        new Review();

                r.setFullName(
                        rs.getString("full_name")
                );

                r.setCompanyName(
                        rs.getString("company_name")
                );


                r.setReviewText(
                        rs.getString("review_text")
                );

                r.setRating(
                        rs.getInt("rating")
                );

                r.setCreatedAt(
                        rs.getString("created_at")
                );

                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
