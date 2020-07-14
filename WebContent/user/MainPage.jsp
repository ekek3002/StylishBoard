<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Stylish Board</title>

<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<link href="../vendor/simple-line-icons/css/simple-line-icons.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/stylish-portfolio.min.css" rel="stylesheet">
<style>
.btn-primary {
    background-color: #3d3d3d!important;
    border-color: #3d3d3d!important;
    color: #fff!important;
}
.btn-primary:active, .btn-primary:focus, .btn-primary:hover {
	background-color:#4b4b4b !important;
	border-color: #4b4b4b !important
}
</style>
<title>MainPage</title>
</head>
<body>
	<jsp:include page="/Note_Header.jsp"/>

  <!-- Header -->
  <header class="masthead d-flex" style="background-image: url(../img/3.jpg)">
    <div class="container text-center my-auto">
      <h1 class="mb-1">Stylish Board</h1>
      <h3 class="mb-5">
        <!--  <em>A Free Bootstrap Theme by Start Bootstrap</em>-->
      </h3>
      <a class="btn btn-primary btn-xl js-scroll-trigger" href="<%=request.getContextPath()%>/board/list.ho?page=1">More</a>
    </div>
    <div class="overlay"></div>
  </header>
	
	<jsp:include page="/Note_Tail.jsp"/>
		<!-- Bootstrap core JavaScript -->
	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="../js/stylish-portfolio.min.js"></script>
</body>
</html>