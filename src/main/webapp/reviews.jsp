<%--
  Created by IntelliJ IDEA.
  User: fcse22-008
  Date: 01/05/2026
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.ReviewDAO" %>
<%@ page import="model.Review" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>

    <title>Projects - AI-Solutions</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<section class="services-section">

    <div class="section-title">

        <h2>Client Reviews</h2>

    </div>

    <div class="services-grid">

        <%
            List<Review> reviews =
                    ReviewDAO.getAllReviews();

            for(Review r : reviews){
        %>

        <div class="service-card">

            <h3>
                <%= r.getFullName() %>
            </h3>

            <p>
                <b>
                    <%= r.getCompanyName() %>
                </b>
            </p>

            <p>
                <%= r.getReviewText() %>
            </p>

            <p style="color:#00f7ff;">

                Rating:

                <%
                    for(int i=0;i<r.getRating();i++){
                %>
                ★
                <%
                    }
                %>

            </p>

            <small>
                <%= r.getCreatedAt() %>
            </small>

        </div>

        <%
            }
        %>

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