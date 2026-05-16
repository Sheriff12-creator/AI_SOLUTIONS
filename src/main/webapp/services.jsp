<%--
  Created by IntelliJ IDEA.
  User: fcse22-008
  Date: 01/05/2026
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page import="model.Service" %>

<!DOCTYPE html>
<html>
<head>

    <title>Services - AI-Solutions</title>

    <link rel="stylesheet" href="css/style.css">

    <!-- FONT AWESOME -->

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<section class="services-section">

    <div class="section-title">

        <h2>AI Services</h2>

        <p>
            Intelligent business solutions powered by AI.
        </p>

    </div>

    <div class="services-grid">

        <%
            List<Service> services =
                    (List<Service>) request.getAttribute("services");

            if(services != null && !services.isEmpty()){

                for(Service s : services){
        %>

        <div class="service-card">

            <div class="service-icon">

                <i class="fa-solid fa-<%= s.getIcon() %>"></i>

            </div>

            <h3>

                <%= s.getServiceName() %>

            </h3>

            <p>

                <%= s.getDescription() %>

            </p>

        </div>

        <%
            }

        } else {
        %>

        <div class="empty-state">

            <h3>No Services Found</h3>

            <p>
                Services will appear here once added.
            </p>

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