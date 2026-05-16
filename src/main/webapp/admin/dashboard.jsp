<%--
  Created by IntelliJ IDEA.
  User: fcse22-008
  Date: 01/05/2026
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="dao.InquiryDAO" %>
<%@ page import="model.Inquiry" %>
<%@ page import="java.util.List" %>

<%
    if(session.getAttribute("admin") == null){

        response.sendRedirect("login.jsp");

        return;
    }

    int total =
            InquiryDAO.getTotalInquiries();

    List<Inquiry> inquiries =
            InquiryDAO.getAllInquiries();
%>

<%
    if(session.getAttribute("admin") == null){
        response.sendRedirect("admin-login.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>

    <title>Admin Dashboard</title>

    <link rel="stylesheet"
          href="../css/style.css">

</head>

<body>

<section class="contact-section">

    <div class="section-title">

        <h2>AI-Solutions Dashboard</h2>

        <p>
            Welcome,
            <%= session.getAttribute("admin") %>
        </p>

    </div>

    <!-- ANALYTICS CARD -->

    <div class="services-grid">

        <div class="service-card">

            <h3>Total Inquiries</h3>

            <h1 style="
                font-size:60px;
                color:#00f7ff;
            ">
                <%= total %>
            </h1>

        </div>

    </div>

    <br><br><br>

    <!-- INQUIRY TABLE -->

    <div class="service-card">

        <h2 style="margin-bottom:30px;">
            Customer Inquiries
        </h2>

        <input type="text"
               id="searchInput"
               placeholder="Search inquiries..."
               style="
                width:100%;
                padding:15px;
                margin-bottom:20px;
                border-radius:10px;
                border:none;
               ">

        <div style="overflow-x:auto;">

            <table id="inquiryTable"
                   style="
                    width:100%;
                    border-collapse:collapse;
                    color:white;
                   ">

                <thead>

                <tr style="
                    background:#00f7ff;
                    color:black;
                ">

                    <th style="padding:15px;">Name</th>
                    <th>Email</th>
                    <th>Company</th>
                    <th>Country</th>
                    <th>Job Title</th>
                    <th>Details</th>
                    <th>Status</th>

                </tr>

                </thead>

                <tbody>

                <%
                    for(Inquiry i : inquiries){
                %>

                <tr>

                    <td style="padding:15px;">
                        <%= i.getFullName() %>
                    </td>

                    <td>
                        <%= i.getEmail() %>
                    </td>

                    <td>
                        <%= i.getCompanyName() %>
                    </td>

                    <td>
                        <%= i.getCountry() %>
                    </td>

                    <td>
                        <%= i.getJobTitle() %>
                    </td>

                    <td>
                        <%= i.getJobDetails() %>
                    </td>

                    <td>
                        <%= i.getStatus() %>
                    </td>

                </tr>

                <%
                    }
                %>

                </tbody>

            </table>

        </div>

    </div>

    <br><br>

    <a href="../logout">

        <button style="
            padding:15px 30px;
            background:#00f7ff;
            border:none;
            border-radius:10px;
            cursor:pointer;
            font-weight:bold;
        ">
            Logout
        </button>

    </a>

</section>

<script>

    const searchInput =
        document.getElementById("searchInput");

    searchInput.addEventListener("keyup", function(){

        const filter =
            searchInput.value.toLowerCase();

        const rows =
            document.querySelectorAll(
                "#inquiryTable tbody tr"
            );

        rows.forEach(row => {

            const text =
                row.innerText.toLowerCase();

            row.style.display =
                text.includes(filter)
                    ? ""
                    : "none";
        });
    });

</script>
<footer class="footer">

    <p>
        © 2026 AI-Solutions.
        All Rights Reserved.
    </p>

</footer>
</body>
</html>