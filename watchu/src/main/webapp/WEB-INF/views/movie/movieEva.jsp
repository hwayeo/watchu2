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

<!-- 모바일 환경 -->
<select class="visible-xs visible-sm form-control">
  <option selected>모든 장르</option>
  <option>드라마</option>
  <option>판타지</option>
  <option>재난</option>
  <option>공포</option>
  <option>로맨스</option>
  <option>모험</option>
  <option>스릴러</option>
  <option>다큐멘터리</option>
  <option>코미디</option>
  <option>가족</option>
  <option>미스터리</option>
  <option>애니메이션</option>
  <option>범죄</option>
  <option>뮤지컬</option>
  <option>SF</option>
  <option>액션</option>
  <option>히어로</option>
</select>
<select class="visible-xs visible-sm form-control">
  <option selected>모든 국가</option>
  <option>한국</option>
  <option>미국</option>
  <option>일본</option>
  <option>중국</option>
  <option>독일</option>
  <option>대만</option>
  <option>인도</option>
  <option>영국</option>
  <option>프랑스</option>
  <option>이탈리아</option>
  <option>캐나다</option>
  <option>스페인</option>
</select>
<select class="visible-xs visible-sm form-control"> 
  <option selected>최신 순</option>
  <option>추천 순</option>
  <option>별점 순</option>
</select>
<!-- 웹환경 -->
<select id="rate-menu" class="hidden-xs hidden-sm">
  <option selected>모든 장르</option>
  <option>드라마</option>
  <option>판타지</option>
  <option>재난</option>
  <option>공포</option>
  <option>로맨스</option>
  <option>모험</option>
  <option>스릴러</option>
  <option>다큐멘터리</option>
  <option>코미디</option>
  <option>가족</option>
  <option>미스터리</option>
  <option>애니메이션</option>
  <option>범죄</option>
  <option>뮤지컬</option>
  <option>SF</option>
  <option>액션</option>
  <option>히어로</option>
</select>
<select id="rate-menu" class="hidden-xs hidden-sm">
  <option selected>모든 국가</option>
  <option>한국</option>
  <option>미국</option>
  <option>일본</option>
  <option>중국</option>
  <option>독일</option>
  <option>대만</option>
  <option>인도</option>
  <option>영국</option>
  <option>프랑스</option>
  <option>이탈리아</option>
  <option>캐나다</option>
  <option>스페인</option>
</select>
<select id="rate-menu" class="hidden-xs hidden-sm category-right"> 
  <option selected>최신 순</option>
  <option>추천 순</option>
  <option>별점 순</option>
</select>

<div class="row">
	<!-- <div class="mlist4"></div> -->
	<c:forEach var="ml" items="${list}">
	<div class="col-sm-6 col-md-3 col-xs-6" id="main-category">
		<div class="thumbnail"><img src="${pageContext.request.contextPath}/resources/images/img4.jpg"></div>
		<div class="sub-category caption"> 
			<p class="ptitle">${ml.title}</p>	
			<p class="pgeren">★★★★☆</p>
		</div>
	</div>
	</c:forEach>
</div>