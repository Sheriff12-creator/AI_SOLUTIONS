<%--
  Created by IntelliJ IDEA.
  User: fcse22-008
  Date: 08/05/2026
  Time: 00:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>

    <title>Rate Us - AI-Solutions</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<section class="services-section">

    <div class="section-title">

        <h2>Share Your Experience</h2>

        <p>
            Your feedback helps us improve our
            AI-powered digital solutions and
            continue delivering exceptional innovation.
        </p>

    </div>

    <div class="review-container">

        <form action="SubmitReviewServlet"
              method="post"
              class="review-form">

            <input type="text"
                   name="fullName"
                   placeholder="Full Name"
                   required>

            <input type="text"
                   name="companyName"
                   placeholder="Company Name"
                   required>

            <textarea name="reviewText"
                      placeholder="Write your review..."
                      required></textarea>

            <label class="rating-label">
                Select Rating
            </label>

            <select name="rating" required>

                <option value="5">
                    ★★★★★ Excellent
                </option>

                <option value="4">
                    ★★★★☆ Very Good
                </option>

                <option value="3">
                    ★★★☆☆ Good
                </option>

                <option value="2">
                    ★★☆☆☆ Fair
                </option>

                <option value="1">
                    ★☆☆☆☆ Poor
                </option>

            </select>

            <button type="submit"
                    class="primary-btn">

                Submit Review

            </button>

        </form>

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