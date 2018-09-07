<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypagemovie.css">
	<div class="container-fluid">
		<div class="container text-center">
			<div class="col-xs-12 col-md-12">
				<h2>영화</h2>
				<hr>
			</div>
		</div>

		<div class="container text-center">
			<div class="col-xs-12 col-md-12">
				<div class="container row">
					<div class="col-xs-7 col-md-7">
						<p style="font-size:22px" class="text-left">평가&emsp;<span style="font-size:13px">200</span></p><br> <br>
					</div>
					<div class="col-xs-1 col-md-4"></div>
					<div class="col-xs-4 col-md-1">
						<br>
						<button class="btn btn-md btn-primary active" type="button" onclick="location.href='userMypage_movielist.do'">더보기</button>
						<br> <br>
					</div>
				</div>

				<div class="col-xs-4 col-md-3">
					<img class="image" src="${pageContext.request.contextPath}/resources/images/gad.jpg"><br>
					<p>가디언즈 오브 갤럭시</p>
					<span style="color: #ffbf00">★4.5</span>
				</div>
				<div class="col-xs-4 col-md-3">
					<img class="image" src="${pageContext.request.contextPath}/resources/images/gad2.jpg"><br>
					<p>수어사이드 스쿼드</p>
					<span style="color: #ffbf00">★1.5</span>

				</div>
				<div class="col-xs-4 col-md-3">
					<img class="image" src="${pageContext.request.contextPath}/resources/images/gad3.jpg"><br>
					<p>앤트맨</p>
					<span style="color: #ffbf00">★5.0</span>
				</div>
				<div class="col-xs-4 col-md-3">
					<img class="image" src="${pageContext.request.contextPath}/resources/images/gad.jpg"><br>
					<p>가디언즈 오브 갤럭시</p>
					<span style="color: #ffbf00">★4.5</span>
				</div>
				
			</div>
		</div>
	</div>
