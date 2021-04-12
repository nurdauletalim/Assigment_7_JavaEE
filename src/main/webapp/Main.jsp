<%@ page import="java.util.List" %>
<%@ page import="model.Posts" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>PhoneStore</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <% List<?> posts = (List<?>) request.getSession().getAttribute("posts");%>
    <%! Posts p; %>
</head>

<body id="page-top">

<%@ include file="/navbar.jsp" %>
<header class="bg-primary text-white">
    <div class="container text-center">
        <h1>Welcome to Online Phone Store</h1>
    </div>
</header>

<section id="about">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <%
                    for (Object obj : posts) {
                        p = (Posts) obj;
                %>
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title"><%=p.getTopic()%></h5>
                        <p class="card-text"><%=p.getText()%></p>
                        <p class="card-text"><small class="text-muted"><%=p.getLike()%></small></p>
                        <p class="card-text"><small class="text-muted"><%=p.getDislike()%></small></p>
                    </div>
                </div>
                <%}%>

            </div>
        </div>
    </div>
</section>


<!-- Footer -->
<%@ include file="/footer.jsp" %>


<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom JavaScript for this theme -->
<script src="js/scrolling-nav.js"></script>

</body>
</html>
