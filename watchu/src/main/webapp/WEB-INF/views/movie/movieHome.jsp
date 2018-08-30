<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 최신 등록 영화 -->
<div class="row">
	<div class="home-text1">최신영화
	<a href="movieDetail.do?movie_num=${list.movie_num}" class="home-text2">모두보기</a></div>
	<div class="mlist"></div>
</div>  


<!-- 추천 영화 태그1 -->
<div class="row">
	<div class="home-text1">추천영화1
	<a href="movieDetail.do?movie_num=${list.movie_num}" class="home-text2">모두보기</a></div>
	<div class="mlist2"></div>
</div>


<!-- 추천 영화 태그2 -->
<div class="row">
	<div class="home-text1">추천영화2
	<a href="movieDetail.do?movie_num=${list.movie_num}" class="home-text2">모두보기</a></div>
	<div class="mlist3"></div>
</div>