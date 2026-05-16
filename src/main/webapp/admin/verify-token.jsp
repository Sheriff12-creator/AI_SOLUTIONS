<%--
  Created by IntelliJ IDEA.
  User: fcse22-008
  Date: 02/05/2026
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<!DOCTYPE html>

<html>

<head>

    <title>
        Verify Authentication Token
    </title>

    <link rel="stylesheet"
          href="../css/style.css">

</head>

<body>

<jsp:include page="../navbar.jsp"/>

<section class="services-section">

    <div class="section-title">

        <h2>
            Multi-Factor Authentication
        </h2>

        <p>
            Enter the secure verification token
            sent to your registered email address.
        </p>

    </div>

    <div class="token-container">

        <div class="token-badge">

            🛡 Secure Token Verification

        </div>

        <form action="../verify-token"
              method="post"
              class="review-form">

            <input type="text"
                   name="token"
                   placeholder="Paste authentication token here"
                   class="token-input"
                   autocomplete="off"
                   spellcheck="false"
                   required>

            <button type="submit"
                    class="primary-btn">

                Verify Authentication

            </button>

        </form>

        <div class="token-timer"
             id="tokenTimer">

            Token expires in:
            02:00

        </div>

    </div>

</section>

<script>

    let timeLeft = 120;

    const timer =
        setInterval(() => {

            let minutes =
                Math.floor(timeLeft / 60);

            let seconds =
                timeLeft % 60;

            if(seconds < 10){
                seconds = "0" + seconds;
            }

            document.getElementById(
                "tokenTimer"
            ).innerHTML =

                "Token expires in: "
                + minutes
                + ":"
                + seconds;

            timeLeft--;

            if(timeLeft < 0){

                clearInterval(timer);

                document.getElementById(
                    "tokenTimer"
                ).innerHTML =

                    "Authentication token expired.";

            }

        }, 1000);

</script>

<footer class="footer">

    <p>
        © 2026 AI-Solutions.
        All Rights Reserved.
    </p>

</footer>

</body>

</html>