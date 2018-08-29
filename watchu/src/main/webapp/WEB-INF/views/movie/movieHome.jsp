<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 최신 등록 영화 -->
<div class="row">
	<div class="home-text1">최신영화
	<a href="#" class="home-text2">모두보기</a></div>
	<div id = mlist></div>
</div>  


<!-- 추천 영화 태그1 -->
<div class="row">
	<div class="home-text1">추천영화1
	<a href="#" class="home-text2">모두보기</a></div>
	<div class="col-sm-6 col-md-3" id="main-category">
		<a href="#" class="thumbnail"><img src="${pageContext.request.contextPath}/resources/images/away.jpg"></a>
		<div class="sub-category">
			<h4>영화제목</h4>
		</div>
	</div>
</div>


<!-- 추천 영화 태그2 -->
<div class="row">
	<div class="home-text1">추천영화2
	<a href="#" class="home-text2">모두보기</a></div>
	<div class="col-sm-6 col-md-3" id="main-category">
		<a href="#" class="thumbnail"><img src="${pageContext.request.contextPath}/resources/images/best.jpg"></a>
		<div class="sub-category">
			<h4>영화제목</h4>
		</div>
	</div>
</div>