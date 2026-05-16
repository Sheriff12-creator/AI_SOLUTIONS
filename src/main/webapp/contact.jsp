<%--
  Created by IntelliJ IDEA.
  User: fcse22-008
  Date: 01/05/2026
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Us - AI-Solutions</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<jsp:include page="navbar.jsp"/>

<section class="services-section">

    <div class="section-title">

        <h2>Let's Build Something Intelligent</h2>

        <p>
            Tell us about your project requirements
            and our AI engineering team will
            contact you with tailored solutions.
        </p>

    </div>

    <div class="contact-container">

        <form action="contact"
              method="post"
              class="review-form">

            <input type="text"
                   name="fullName"
                   placeholder="Full Name"
                   required>

            <input type="email"
                   name="email"
                   placeholder="Email Address"
                   required>

            <input type="text"
                   name="phone"
                   placeholder="Phone Number"
                   required>

            <input type="text"
                   name="companyName"
                   placeholder="Company Name"
                   required>

            <input type="text"
                   name="country"
                   placeholder="Country"
                   required>

            <input type="text"
                   name="jobTitle"
                   placeholder="Job Title"
                   required>

            <textarea name="jobDetails"
                      placeholder="Describe your AI project requirements..."
                      required></textarea>

            <button type="submit"
                    class="primary-btn">

                Submit Inquiry

            </button>

        </form>

    </div>

</section>

<%
    if(request.getParameter("success") != null){
%>

<div class="success-toast"
     id="toast">

    Inquiry submitted successfully.

</div>

<script>

    setTimeout(() => {

        document.getElementById("toast")
            .style.display = "none";

    }, 3000);

</script>

<%
    }
%>

<footer class="footer">

    <p>
        © 2026 AI-Solutions.
        All Rights Reserved.
    </p>

</footer>

</body>
</html>
