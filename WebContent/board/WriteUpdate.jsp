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
<style>
.row {
	margin: 0 50px 0 50px;
}

.container {
	padding: 50px 0 50px 0;
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
th, td{
border: 2px solid #ddd;
}
</style>
<title>게시판</title>
</head>
<body>
	<!-- 
	<h1>회원 등록</h1>
	<form action='write.ho' method='post'>
		제목: <input type='text' name='title'><br>
		내용: <input type='text' name='content'><br>
		<input type='submit' value='submit'>
		<input type='reset' value='취소'>
	</form>
 -->
	<jsp:include page="/Note_Header.jsp" />
	<div class="container">
		<div class="row">
			<form method="post" action="update.ho?up=${view.id}&no=${view.no}">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>

											<tr style="background-color: #eeeeee;">
						<td style="width:80px;">작성자</td>
						<td>${view.id}</td>	
						<td style="width: 80px">작성일자</td>
						<td colspan="6">${view.createdDate}</td>							
					</tr>
					</thead>
					<tbody>
						<tr>
						<td colspan="6"><input type="text" class="form-control" placeholder="글 제목" name="title" maxlength="50" value="${view.title}"></td>
						</tr>
						<tr>
							<td colspan="6"><textarea class="form-control" placeholder="글 내용"
									name="content" maxlength="2048" style="height: 350px;">${view.content}</textarea>
							</td>
						</tr>
					</tbody>
				</table>
				<a href="<%=request.getContextPath()%>/board/list.ho?page=1" class="btn btn-primary">목록</a>
				
				<input type="submit" class="btn btn-primary pull-right" value="수정"
					style="margin-left: 10px"> 
			</form>
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