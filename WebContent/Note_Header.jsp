<%-- 메뉴 추가 --%>
<%@page import="spms.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Stylish Portfolio - Start Bootstrap Template</title>

<!-- Bootstrap Core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<link href="vendor/simple-line-icons/css/simple-line-icons.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="css/stylish-portfolio.min.css" rel="stylesheet">


<style>
#sidebar-wrapper {
background: #3d3d3d;
}

</style>

<body id="page-top">

	<!-- Navigation -->
	<a class="menu-toggle rounded" href="#"> <i class="fas fa-bars"
		style="line-height: 50px;"></i>
	</a>
	<nav id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<li class="sidebar-brand"><a class="js-scroll-trigger"
				href="../user/MainPage.jsp">Board</a></li>
			<li class="sidebar-nav-item"><a class="js-scroll-trigger"
				href="../user/MainPage.jsp">Home</a></li>
			<li class="sidebar-nav-item"><a class="js-scroll-trigger"
				href="<%=request.getContextPath()%>/board/list.ho?page=1">Board</a></li>
			<li class="sidebar-nav-item"><a class="js-scroll-trigger"
				href="../user/check.ho">Attendance Check</a></li>
			<c:if
				test="${empty sessionScope.user or 
              empty sessionScope.user.id}">
				<li class="sidebar-nav-item"><a class="js-scroll-trigger"
					href="<%=request.getContextPath()%>/user/login.do">Login</a></li>
				<li class="sidebar-nav-item"><a class="js-scroll-trigger"
					href="<%=request.getContextPath()%>/user/join.do">Sign Up</a></li>
			</c:if>
			<c:if
				test="${!empty sessionScope.user and 
              !empty sessionScope.user.id}">
				<li class="sidebar-nav-item"><a class="js-scroll-trigger"
					href="<%=request.getContextPath()%>/user/logout.do">Logout</a></li>
				<li class="sidebar-nav-item"><a class="js-scroll-trigger"
					href='../user/mypage.do?no=${user.no}'>My Page</a></li>
				<li class="sidebar-nav-item"><a class="js-scroll-trigger"
					href='../user/update.do?no=${user.no}'>Edit Member</a></li>
			</c:if>
		</ul>
	</nav>


	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/stylish-portfolio.min.js"></script>
</body>
