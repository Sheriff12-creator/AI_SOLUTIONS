<%--
  Created by IntelliJ IDEA.
  User: fcse22-008
  Date: 12/05/2026
  Time: 01:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.Project" %>
<%@ page import="java.util.List" %>

<%
  Project p =
          (Project) request.getAttribute("project");

  List<String> reviews =
          (List<String>) request.getAttribute("reviews");
%>

<!DOCTYPE html>
<html>
<head>

  <title>Project Details</title>

  <link rel="stylesheet" href="css/style.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<section class="projects-section">

  <div class="project-details-container">

    <img src="<%= p.getImageUrl() %>"
         class="details-image">

    <h1>
      <%= p.getProjectName() %>
    </h1>

    <p>
      Client:
      <%= p.getClientName() %>
    </p>

    <p>
      <%= p.getDescription() %>
    </p>

    <p>
      Technologies:
      <%= p.getTechnologies() %>
    </p>

    <div class="project-rating">

      &#9733;
      <%= String.format("%.1f",
              p.getAvgRating()) %>

    </div>

    <hr>

    <h2>Submit Review</h2>

    <form action="submit-project-review"
          method="post"
          class="review-form">

      <input type="hidden"
             name="projectId"
             value="<%= p.getId() %>">

      <input type="text"
             name="reviewerName"
             placeholder="Your Name"
             required>

      <select name="rating" required>

        <option value="5">5 Stars</option>
        <option value="4">4 Stars</option>
        <option value="3">3 Stars</option>
        <option value="2">2 Stars</option>
        <option value="1">1 Star</option>

      </select>

      <textarea name="reviewText"
                placeholder="Write review..."
                required></textarea>

      <button type="submit"
              class="primary-btn">

        Submit Review

      </button>

    </form>

    <hr>

    <h2>Client Reviews</h2>

    <%
      for(String r : reviews){
    %>

    <div class="review-box">

      <%= r %>

    </div>

    <%
      }
    %>

  </div>

</section>

</body>
</html>