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

<style>
.row {
	margin: 0 50px 0 50px;
}

.container {
	padding: 50px 0 50px;
}

.btn-primary {
    background-color: #3d3d3d!important;
    border-color: #3d3d3d!important;
    color: #fff!important;
}
.btn-primary:active, .btn-primary:focus, .btn-primary:hover {
	background-color:#4b4b4b !important;
	border-color: #4b4b4b !important
}
a{
color: #212529;
}
</style>

<title>게시판</title>
</head>
<body>

	<jsp:include page="/Note_Header.jsp" />

	<div class="container">
		<div class="row">
			<table class="table table-hover"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="post" items="${posts}">
						<tr>
							<td><a href='content.ho?no=${post.no}'>${post.no}</a></td>
							<td><a href='content.ho?no=${post.no}'> ${post.title} </a></td>
							<td>${post.id}</td>
							<td>${post.createdDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<a href='list.ho?page=${pageNum-1}'
					class="btn btn-success btn-arraw-left">◀</a> ${pageNum} <a
					href='list.ho?page=${pageNum+1}'
					class="btn btn-success btn-arraw-left">▶</a>

				<!-- 
		<a href='delete.ho?no=${post.no}&id=${post.id}'> [삭제] </a>
	 -->
				<a href='write.ho' class="btn btn-primary pull-right" style="float: right;
				">글쓰기</a>
			</div>
		</div>
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










