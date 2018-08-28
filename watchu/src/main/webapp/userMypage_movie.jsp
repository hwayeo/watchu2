<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<link rel="stylesheet" href="css.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin-main.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container-fluid">
		<div class="container text-center">
			<div class="col-xs-12 col-md-12">
				<h2>영화</h2>
				<hr>
			</div>
		</div>

		<div class="row container">
			<div class="col-xs-12 col-md-12">
				<div class="container row">
					<div class="col-xs-7 col-md-7">
						<span style="font-size: 30px">평가</span>&emsp;200<br> <br>
					</div>
					<div class="col-xs-1 col-md-4"></div>
					<div class="col-xs-4 col-md-1">
						<br>
						<button class="btn btn-md btn-primary active" type="button">더보기</button>
						<br> <br>
					</div>
				</div>

				<div class="col-xs-4 col-md-4">
					<img src="resources/images/gad.jpg" width="150" height="200"><br>
					<p>가디언즈 오브 갤럭시</p>
					<span style="color: #ffbf00">★4.5</span>
				</div>
				<div class="col-xs-4 col-md-4">
					<img src="resources/images/gad2.jpg" width="150" height="200"><br>
					<p>수어사이드 스쿼드</p>
					<span style="color: #ffbf00">★1.5</span>

				</div>
				<div class="col-xs-4 col-md-4">
					<img src="resources/images/gad3.jpg" width="150" height="200"><br>
					<p>앤트맨</p>
					<span style="color: #ffbf00">★5.0</span>
				</div>
			</div>
		</div>

		<div class="row container">
			<div class="col-xs-10 col-md-11">
				<hr>
				<h3>보고싶어요</h3>
			</div>
			<div class="col-xs-2 col-md-1">
				<hr>
				<h4>15</h4>
			</div>
		</div>

		<div class="row container">
			<div class="col-xs-10 col-md-11">
				<hr>
				<h3>보는중</h3>
			</div>
			<div class="col-xs-2 col-md-1">
				<hr>
				<h4>3</h4>
			</div>
		</div>
	</div>
</body>
</html>