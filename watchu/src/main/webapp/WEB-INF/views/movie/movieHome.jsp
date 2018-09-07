<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default" id="navline">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-movie">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a href="#" class="navbar-brand">영화메뉴</a>
	</div>
	<div class="collapse navbar-collapse navbar-movie">
		<ul class="nav navbar-nav">
			<li><a href="movieHome.do">홈</a></li>
			<li><a href="movieList.do">카테고리</a></li>
			<li><a href="movieEva.do">평가하기</a></li>
		</ul>
	</div>
</nav>


<!-- 최신 등록 영화 -->
<div class="row">
	<div class="home-text1">최신영화
	<a href="movieList.do" class="home-text2">모두보기</a></div>
	<div class="mlist"></div>
</div>  


<!-- 추천 영화 태그1 -->
<div class="row">
	<div class="home-text1">미국영화
	<a href="movieList.do?keyfield=country&keyword=미국" class="home-text2">미쿸보귀</a></div>
	<div class="mlist2"></div>
</div>


<!-- 추천 영화 태그2 -->
<div class="row">
	<div class="home-text1">한국영화
	<a href="movieList.do?keyfield=country&keyword=한국" class="home-text2">한쿸보기</a></div>
	<div class="mlist3"></div>
</div>

<c:forEach var="ml" items="${list}">
	<input type="hidden" id="movie_num" name="movie_num" value="${ml.movie_num}">
</c:forEach>