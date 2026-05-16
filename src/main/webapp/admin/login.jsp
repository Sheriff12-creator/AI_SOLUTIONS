<%--
  Created by IntelliJ IDEA.
  User: fcse22-008
  Date: 01/05/2026
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<!DOCTYPE html>

<html>

<head>

    <title>
        Secure Admin Login - AI-Solutions
    </title>

    <link rel="stylesheet"
          href="../css/style.css">

</head>

<body>

<jsp:include page="/navbar.jsp"/>

<section class="services-section">

    <div class="section-title">

        <h2>
            Secure Authentication Portal
        </h2>

        <p>
            Restricted administrative access
            for authorised AI-Solutions personnel.
        </p>

    </div>

    <div class="admin-login-container">

        <div class="login-security-badge">

            🔒 Enterprise Protected Access

        </div>

        <form action="../admin-login"
              method="post"
              class="review-form">

            <input type="text"
                   name="username"
                   placeholder="Administrator Username"
                   required>

            <input type="password"
                   name="password"
                   placeholder="Secure Password"
                   required>

            <button type="submit"
                    class="primary-btn">

                Continue Authentication

            </button>

        </form>

        <div class="login-footer-text">

            AI-Solutions Security System
            • Token Protected
            • Role Verified

        </div>

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