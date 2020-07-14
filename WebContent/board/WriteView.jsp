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
<script
	src="https://saengkowebepeulrikeisyeonmandeulgi-a7c0v89rds.disqus.com/embed.js"
	data-timestamp="1588036256890"></script>
<link rel="prefetch" as="style"
	href="https://c.disquscdn.com/next/embed/styles/lounge.9a11b91b20ca66d0cf6475e0f5c1ab1a.css">
<link rel="prefetch" as="script"
	href="https://c.disquscdn.com/next/embed/common.bundle.f9554506a08a1cc2b021f0dfc3f59ebb.js">
<link rel="prefetch" as="script"
	href="https://c.disquscdn.com/next/embed/lounge.bundle.2569b4785d87ab13c01fd14df7af10db.js">
<link rel="prefetch" as="script"
	href="https://disqus.com/next/config.js">
<script
	src="https://c.disquscdn.com/next/embed/alfalfalfa.0823c767a3bc925f628afd9bed26c958.js"
	async="" charset="UTF-8"></script>
<style>
.row {
	margin: 0 50px 0 50px;
	padding-bottom: 30px;
	border-bottom: 2px solid #e7e9ee;
}

article {
	margin: 50px 50px 0 50px;
}

.container {
	padding: 50px 0 50px 0;
}

.btn-primary {
	background-color: #3d3d3d !important;
	border-color: #3d3d3d !important;
	color: #fff !important;
}

.btn-primary:active, .btn-primary:focus, .btn-primary:hover {
	background-color: #4b4b4b !important;
	border-color: #4b4b4b !important
}

th, td {
	border: 2px solid #ddd;
}
</style>
<title>게시판</title>
</head>
<body id="page-top">

	<jsp:include page="/Note_Header.jsp" />
	<!-- 
	<div class="container">
		<div class="row">
			<form method="post" action="update.ho?no=${view.no }">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee;">[${view.createdDate}]
								작성자: </th>
						</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2">${view.id}</td>								
					</tr>
					</thead>
					<tbody>
						<tr>
							<td>${view.title }</td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용"
									name="content" maxlength="2048" style="height: 350px;"
									readonly="">${view.content }</textarea></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary pull-right" value="수정"
					style="margin-left: 10px;"> <a
					href='delete.ho?no=${view.no}&id=${view.id}'
					class="btn btn-primary pull-right">삭제</a>
			</form>
	</div>
	
	<article>
		<div id="disqus_thread">
			<iframe id="dsq-app9466" name="dsq-app9466" allowtransparency="true"
				frameborder="0" scrolling="no" tabindex="0" title="Disqus"
				width="100%"
				src="https://disqus.com/embed/comments/?base=default&amp;f=saengkowebepeulrikeisyeonmandeulgi-a7c0v89rds&amp;t_u=http%3A%2F%2Flocalhost%3A8080%2FTPJ_NoteWeb_20200421_hg%2Fboard%2FWriteView.jsp&amp;t_d=%EA%B2%8C%EC%8B%9C%ED%8C%90&amp;t_t=%EA%B2%8C%EC%8B%9C%ED%8C%90&amp;s_o=default#version=206d8ff2f80c3ca0938577332c03b31a"
				style="width: 1px !important; min-width: 100% !important; border: none !important; overflow: hidden !important; height: 478px !important;"
				horizontalscrolling="no" verticalscrolling="no"></iframe>
			<iframe id="indicator-north" name="indicator-north"
				allowtransparency="true" frameborder="0" scrolling="no" tabindex="0"
				title="Disqus"
				style="width: 830px !important; border: none !important; overflow: hidden !important; top: 0px !important; min-width: 830px !important; max-width: 830px !important; position: fixed !important; z-index: 2147483646 !important; height: 0px !important; min-height: 0px !important; max-height: 0px !important; display: none !important;"></iframe>
			<iframe id="indicator-south" name="indicator-south"
				allowtransparency="true" frameborder="0" scrolling="no" tabindex="0"
				title="Disqus"
				style="width: 830px !important; border: none !important; overflow: hidden !important; bottom: 0px !important; min-width: 830px !important; max-width: 830px !important; position: fixed !important; z-index: 2147483646 !important; height: 0px !important; min-height: 0px !important; max-height: 0px !important; display: none !important;"></iframe>
		</div>
		<script>
						/**
						 *  RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
						 *  LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables*/
						/*
						 var disqus_config = function () {
						 this.page.url = PAGE_URL;  // Replace PAGE_URL with your page's canonical URL variable
						 this.page.identifier = PAGE_IDENTIFIER; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
						 };
						 */
						(function() {
							var d = document, s = d.createElement('script');
							s.src = 'https://saengkowebepeulrikeisyeonmandeulgi-a7c0v89rds.disqus.com/embed.js';
							s.setAttribute('data-timestamp', +new Date());
							(d.head || d.body).appendChild(s);
						})();
					</script>
		<noscript>Please enable JavaScript to view the &lt;a
			href="https://disqus.com/?ref_noscript"&gt;comments powered by
			Disqus.&lt;/a&gt;</noscript>
	</article>
	
	</div>
 -->
	<div class="container">
		<div class="row">
			<form method="post" action="update.ho?no=${view.no}">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="6"
								style="background-color: #eeeeee; text-align: center;">게시판
								글 보기</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td style="width: 80px">글 제목</td>
							<td colspan="4">${view.title}</td>
						</tr>
						<tr>
							<td>작성자</td>
							<td>${view.id}</td>
							<td style="width: 80px">작성일자</td>
							<td colspan="4">${view.createdDate}</td>
						</tr>
						<tr>
							<td>내용</td>
							<td colspan="4" style="min-height: 200px; text-align: left;">${view.content }</td>
						</tr>
					</tbody>
				</table>
				<a href="<%=request.getContextPath()%>/board/list.ho?page=1"
					class="btn btn-primary">목록</a> <a
					href='delete.ho?no=${view.no}&id=${view.id}'
					class="btn btn-primary pull-right" style="margin-left: 10px;">삭제</a>
				<input type="submit" class="btn btn-primary pull-right" value="수정">
			</form>
		</div>

		<article>
			<div id="disqus_thread">
				<iframe id="dsq-app9466" name="dsq-app9466" allowtransparency="true"
					frameborder="0" scrolling="no" tabindex="0" title="Disqus"
					width="100%"
					src="https://disqus.com/embed/comments/?base=default&amp;f=saengkowebepeulrikeisyeonmandeulgi-a7c0v89rds&amp;t_u=http%3A%2F%2Flocalhost%3A8080%2FTPJ_NoteWeb_20200421_hg%2Fboard%2FWriteView.jsp&amp;t_d=%EA%B2%8C%EC%8B%9C%ED%8C%90&amp;t_t=%EA%B2%8C%EC%8B%9C%ED%8C%90&amp;s_o=default#version=206d8ff2f80c3ca0938577332c03b31a"
					style="width: 1px !important; min-width: 100% !important; border: none !important; overflow: hidden !important; height: 478px !important;"
					horizontalscrolling="no" verticalscrolling="no"></iframe>
				<iframe id="indicator-north" name="indicator-north"
					allowtransparency="true" frameborder="0" scrolling="no"
					tabindex="0" title="Disqus"
					style="width: 830px !important; border: none !important; overflow: hidden !important; top: 0px !important; min-width: 830px !important; max-width: 830px !important; position: fixed !important; z-index: 2147483646 !important; height: 0px !important; min-height: 0px !important; max-height: 0px !important; display: none !important;"></iframe>
				<iframe id="indicator-south" name="indicator-south"
					allowtransparency="true" frameborder="0" scrolling="no"
					tabindex="0" title="Disqus"
					style="width: 830px !important; border: none !important; overflow: hidden !important; bottom: 0px !important; min-width: 830px !important; max-width: 830px !important; position: fixed !important; z-index: 2147483646 !important; height: 0px !important; min-height: 0px !important; max-height: 0px !important; display: none !important;"></iframe>
			</div>
			<script>
				/**
				 *  RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
				 *  LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables*/
				/*
				 var disqus_config = function () {
				 this.page.url = PAGE_URL;  // Replace PAGE_URL with your page's canonical URL variable
				 this.page.identifier = PAGE_IDENTIFIER; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
				 };
				 */
				(function() {
					var d = document, s = d.createElement('script');
					s.src = 'https://saengkowebepeulrikeisyeonmandeulgi-a7c0v89rds.disqus.com/embed.js';
					s.setAttribute('data-timestamp', +new Date());
					(d.head || d.body).appendChild(s);
				})();
			</script>
			<noscript>Please enable JavaScript to view the &lt;a
				href="https://disqus.com/?ref_noscript"&gt;comments powered by
				Disqus.&lt;/a&gt;</noscript>
		</article>

	</div>





	<iframe id="dsq-app9469" name="dsq-app9469" allowtransparency="true"
		frameborder="0" scrolling="no" tabindex="0" title="Disqus"
		width="100%"
		src="https://disqus.com/home/preload/?utm_source=disqus_embed"
		style="width: 1px !important; min-width: 100% !important; border: none !important; overflow: hidden !important; height: 100% !important; position: fixed !important; top: 0px !important; right: 0px !important; left: auto !important; bottom: auto !important; z-index: 2147483647 !important; display: none !important;">
	</iframe>

	<jsp:include page="/Note_Tail.jsp" />

	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="../js/stylish-portfolio.min.js"></script>

</body>
</html>