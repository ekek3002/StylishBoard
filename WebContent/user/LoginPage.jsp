<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/stylish-portfolio.min.css" rel="stylesheet">

<link rel="stylesheet" href="../css/bootstrap.css">

<!-- Custom Fonts -->
<link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<link href="../vendor/simple-line-icons/css/simple-line-icons.css"
	rel="stylesheet">
<style>
.btn-primary {
	background-color: #3d3d3d !important;
	border-color: #3d3d3d !important;
	color: #fff !important;
}

.btn-primary:active, .btn-primary:focus, .btn-primary:hover {
	background-color: #4b4b4b !important;
	border-color: #4b4b4b !important
}
</style>
<title>LoginPage</title>
</head>
<body>
	<jsp:include page="/Note_Header.jsp" />

	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px; margin:50px 0 50px 0;">
				<form method="post" action="login.do">
					<h3 style="text-align: center;">로그인 화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디"
							name="id" maxlength="20">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호"
							name="password" maxlength="20">
					</div>
					<input type="submit" class="btn btn-primary form-control"
						value="로그인">	
					<input type="button" class="btn btn-primary form-control"
						value="회원가입" onclick='location.href="join.do";' style="margin-top: 15px">
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>

	<jsp:include page="/Note_Tail.jsp" />
	
		<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="../js/stylish-portfolio.min.js"></script>
	
</body>
</html>








