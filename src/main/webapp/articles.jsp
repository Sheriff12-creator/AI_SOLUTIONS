<%--
  Created by IntelliJ IDEA.
  User: fcse22-008
  Date: 01/05/2026
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.ArticleDAO" %>
<%@ page import="model.Article" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>

    <title>Articles - AI-Solutions</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<section class="services-section">

    <div class="section-title">
        <h2>AI Insights & Articles</h2>
        <p>Latest intelligence, research and AI innovations</p>
    </div>

    <div class="services-grid">

        <%
            List<Article> articles =
                    ArticleDAO.getAllArticles();

            for(Article a : articles){
        %>

        <!-- ARTICLE CARD -->
        <%
            String url = a.getArticleUrl();

            if(url == null || url.trim().isEmpty()){
                url = "#";
            }
        %>

        <a href="<%= url %>" target="_blank" class="article-card">

            <div class="article-image">
                <img src="<%= a.getImageUrl() %>" />
            </div>

            <div class="article-body">

                <h3><%= a.getTitle() %></h3>

                <p class="article-author">
                    <%= a.getAuthor() %>
                </p>

                <p class="article-preview">
                    <%= a.getContent().length() > 140
                            ? a.getContent().substring(0,140) + "..."
                            : a.getContent()
                    %>
                </p>

                <small>
                    <%= a.getCreatedAt() %>
                </small>

            </div>

        </a>
        <% } %>

    </div>

</section>

<footer class="footer">

    <p>
        © 2026 AI-Solutions.
        All Rights Reserved.
    </p>

</footer>

</body>
</html>