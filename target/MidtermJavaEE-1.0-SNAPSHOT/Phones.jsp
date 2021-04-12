<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop</title>
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/heroic-features.css" rel="stylesheet">

</head>
<body>
<!-- Navigation -->
<%@ include file="/navbar.jsp" %>
<jsp:useBean id = "phone" class="PhonesDAO"/>
<%
    List list=new ArrayList<>();
    phone.
%>
<!-- Page Content -->
<div class="container">

    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
        <h1 class="display-3">Welcome to Shop!</h1>
        <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, ipsam, eligendi, in quo sunt possimus non incidunt odit vero aliquid similique quaerat nam nobis illo aspernatur vitae fugiat numquam repellat.</p>
        <a href="#" class="btn btn-primary btn-lg">Call to action!</a>
    </header>

    <!-- Page Features -->
    <div class="row text-center">
        <%while(rs.next()){%>
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src=<%= rs.getString("imglink")%> alt="">
                <div class="card-body">
                    <h4 class="card-title"><%= rs.getString("name")%></h4>
                    <p class="card-text"><%= rs.getString("price")%> tg</p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">Buy</a>
                </div>
            </div>
        </div>
<%}

%>
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://consumer-img.huawei.com/content/dam/huawei-cbg-site/common/mkt/list-image/phones/p30-pro/P30Pro_skyblue.png" alt="">
                <div class="card-body">
                    <h4 class="card-title">Huawei P 30</h4>
                    <p class="card-text">240 990 tg</p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">Buy</a>
                </div>
            </div>
        </div>


    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<%@ include file="/footer.jsp" %>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
