<%--
  Created by IntelliJ IDEA.
  User: fcse22-008
  Date: 01/05/2026
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page import="model.Project" %>

<!DOCTYPE html>
<html>
<head>

    <title>Projects & Case Studies</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<section class="projects-section">

    <div class="section-title">

        <h2>Past Projects & Case Studies</h2>

        <p>
            Real AI-powered enterprise solutions
            successfully delivered for clients.
        </p>

    </div>

    <div class="projects-grid">

        <%
            List<Project> projects =
                    (List<Project>) request.getAttribute("projects");

            if(projects != null && !projects.isEmpty()){

                for(Project p : projects){
        %>

        <div class="project-card">

            <!-- IMAGE -->

            <div class="project-image-wrapper">

                <img src="<%= p.getImageUrl() %>"
                     alt="Project Image">

            </div>

            <!-- CONTENT -->

            <div class="project-content">

                <div class="project-top">

                    <h3>
                        <%= p.getProjectName() %>
                    </h3>

                    <div class="project-rating">

                        &#9733;
                        <%= String.format("%.1f", p.getAvgRating()) %>

                    </div>

                </div>

                <p class="project-client">

                    Client:
                    <span>
                        <%= p.getClientName() %>
                    </span>

                </p>

                <p class="project-description">

                    <%= p.getDescription().length() > 140
                            ? p.getDescription().substring(0,140) + "..."
                            : p.getDescription()
                    %>

                </p>

                <div class="tech-stack">

                    <%
                        String[] techs =
                                p.getTechnologies().split(",");

                        for(String tech : techs){
                    %>

                    <span class="tech-badge">

                        <%= tech.trim() %>

                    </span>

                    <%
                        }
                    %>

                </div>

                <a href="project-details?id=<%= p.getId() %>"
                   class="project-btn">

                    View Case Study

                </a>

            </div>

        </div>

        <%
            }

        } else {
        %>

        <div class="empty-state">

            <h3>No Projects Found</h3>

            <p>
                Projects will appear here once added.
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