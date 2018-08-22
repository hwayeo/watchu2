<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<nav class="navbar">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex2">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar custom-icon"></span>
				<span class="icon-bar custom-icon"></span>
				<span class="icon-bar custom-icon"></span>
			</button>		
			<a href="#" class="navbar-brand" id="brand_text"><b>WATCHA</b></a>
		</div>
		<div class="collapse navbar-collapse">
				<div class="form-group search-form">
				<div class="input-group input-group-lg">
						<span class="input-group-addon"><span class="glyphicon glyphicon-search"></span></span>
						<input type="text" class="form-control" placeholder="영화 제목,배우,감독을 검색해보세요.">
				</div>
				</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">영화</a></li>
			<c:if test="${empty user_id}">
				<li><a href="#">로그인</a></li>
				<li><a href="#">회원가입</a></li>
			</c:if>
			<c:if test="${!empty user_id}">
				<img src="${pageContext.request.contextPath}/resources/images/default-profile.jpg" class="img-responsive img-circle" id="profile_img">
			</c:if>
			</ul>
		</div><!-- .navbar-collapse -->
	</nav>