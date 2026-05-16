package dao;

import model.Article;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {

    public static List<Article> getAllArticles() {

        List<Article> list = new ArrayList<>();

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM articles ORDER BY id DESC";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Article a = new Article();

                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setAuthor(rs.getString("author"));
                a.setImageUrl(rs.getString("image_url"));
                a.setArticleUrl(rs.getString("article_url"));
                a.setContent(rs.getString("content"));
                a.setCreatedAt(rs.getString("created_at"));

                list.add(a);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
}