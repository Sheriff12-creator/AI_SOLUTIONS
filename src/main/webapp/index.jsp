<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>AI-Solutions</title>

    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

    <link href="https://unpkg.com/aos@2.3.4/dist/aos.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.12"></script>
</head>

<body>

<!-- LOADER -->
<div id="loader">
    <div class="spinner"></div>
</div>

<!-- NAVBAR -->
<nav class="navbar">
    <div class="logo">AI-Solutions</div>

    <ul class="nav-links">
        <li><a href="index.jsp">Home</a></li>
        <li><a href="about.jsp">About</a></li>
        <li><a href="services.jsp">Services</a></li>
        <li><a href="projects.jsp">Projects</a></li>
        <li><a href="articles.jsp">Articles</a></li>
        <li><a href="events.jsp">Events</a></li>
        <li><a href="contact.jsp">Contact</a></li>
    </ul>
</nav>

<!-- HERO -->
<section class="hero">

    <div class="hero-content">

        <h1>
            Transforming Business Through
            <span id="typing"></span>
        </h1>

        <p>
            AI-Solutions builds secure, scalable and intelligent AI systems
            that accelerate digital transformation across industries.
        </p>

        <a href="/ai-solutions/services"
           class="primary-btn">

            Explore Solutions

        </a>

    </div>

</section>

<!-- STATS -->
<section class="stats-section">

    <div class="dashboard-stats">

        <div class="stat-card">
            <h2 class="counter" data-target="120">0</h2>
            <p>Projects Completed</p>
        </div>

        <div class="stat-card">
            <h2 class="counter" data-target="45">0</h2>
            <p>Enterprise Clients</p>
        </div>

        <div class="stat-card">
            <h2 class="counter" data-target="99">0</h2>
            <p>AI Accuracy %</p>
        </div>

        <div class="stat-card">
            <h2 class="counter" data-target="24">0</h2>
            <p>Countries Reached</p>
        </div>

    </div>

</section>

<!-- SERVICES -->
<section class="services-section">

    <div class="section-title" data-aos="fade-up">
        <h2>Our AI Services</h2>
        <p>Next-generation intelligent enterprise solutions.</p>
    </div>

    <div class="services-grid">

        <div class="service-card" data-aos="fade-up">
            <h3>AI Assistants</h3>
            <p>Smart conversational automation systems.</p>
        </div>

        <div class="service-card" data-aos="fade-up" data-aos-delay="100">
            <h3>Predictive Analytics</h3>
            <p>Data-driven decision intelligence platforms.</p>
        </div>

        <div class="service-card" data-aos="fade-up" data-aos-delay="200">
            <h3>Automation Systems</h3>
            <p>Workflow optimisation and automation tools.</p>
        </div>

    </div>

</section>


<!-- RATE BUTTON -->
<a href="submit-review.jsp" class="rate-us-btn">
    ★ Rate Us
</a>

<!-- FOOTER -->
<footer class="footer">
    <p>© 2026 AI-Solutions. All Rights Reserved.</p>
</footer>

<!-- SCRIPTS -->
<script src="https://unpkg.com/aos@2.3.4/dist/aos.js"></script>

<script>
    AOS.init({
        duration: 1000,
        once: true
    });
</script>

<script>
    new Typed('#typing', {
        strings: ['AI Automation.', 'Predictive Systems.', 'Digital Transformation.'],
        typeSpeed: 60,
        backSpeed: 40,
        loop: true
    });
</script>

<script>
    const counters = document.querySelectorAll(".counter");

    counters.forEach(counter => {
        counter.innerText = "0";

        const update = () => {
            const target = +counter.getAttribute("data-target");
            const current = +counter.innerText;
            const increment = target / 100;

            if (current < target) {
                counter.innerText = Math.ceil(current + increment);
                setTimeout(update, 20);
            } else {
                counter.innerText = target;
            }
        };

        update();
    });
</script>

<script>
    window.addEventListener("load", () => {
        document.getElementById("loader").style.display = "none";
    });
</script>

</body>
</html>