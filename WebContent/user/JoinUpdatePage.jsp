<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/custom.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.js"></script>
<title>JoinUpdatePage</title>
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
.btn-primary.active{
	background-color: #636e72 !important;
}
</style>

</head>
<body>
	<jsp:include page="/Note_Header.jsp" />

	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px; margin:50px 0 50px 0;">
				<form method="post" action="update.do">
					<h3 style="text-align: center;">회원정보 수정</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="회원번호"
							name="no" maxlength="20" value='${user.no}' readonly>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디"
							name="id" maxlength="20" value='${user.id}'>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="비밀번호"
							name="password" maxlength="20" value='${user.password}'>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="이름"
							name="name" maxlength="20" value='${user.name}'>
					</div>
					<div class="form-group" style="text-align: center;">
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-primary active"> <input
								type="radio" name="gender" autocomplete="off" value='남자'
								checked>남자
							</label> <label class="btn btn-primary"> <input type="radio"
								name="gender" autocomplete="off" value='여자' checked>여자
							</label>
						</div>
					</div>
					<div class="form-group">
						<input type="email" class="form-control" placeholder="이메일"
							name="email" maxlength="20" value='${user.email}'>
					</div>
					<input type="submit" class="btn btn-primary form-control"
						value="저장" style="margin-bottom: 15px">
					<input type="submit" class="btn btn-primary form-control"
						value="취소" onclick='location.href="main.do"'>
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








