<%--
  Created by IntelliJ IDEA.
  User: fcse22-008
  Date: 01/05/2026
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.EventDAO" %>
<%@ page import="model.Event" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>

    <title>Events - AI-Solutions</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<section class="services-section">

    <div class="section-title">
        <h2>Upcoming Events</h2>
    </div>

    <div class="services-grid">

        <%
            List<Event> events =
                    EventDAO.getAllEvents();

            for(Event e : events){
        %>

        <div class="service-card">

            <img src="<%= e.getImagePath() %>"
                 style="width:100%;
                        border-radius:10px;
                        margin-bottom:15px;">

            <h3><%= e.getEventName() %></h3>

            <p>
                <%= e.getLocation() %>
            </p>

            <p>
                <%= e.getDescription() %>
            </p>

            <p style="color:#00f7ff;">
                Date: <%= e.getEventDate() %>
            </p>

        </div>

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
