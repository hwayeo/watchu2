<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="text-right">
	<div class="header-menu hidden-xs">
		<a href="${pageContext.request.contextPath}/movie/movieHome.do" class="btn header-item">영화목록</a>
		<a href="#" class="btn header-item">로그인</a>
		<a href="${pageContext.request.contextPath}/user/write.do" class="btn header-item">회원가입</a>
	</div>
</div>
	<div class="form-group search-form">
		<div class="input-group input-group-lg">
      		<input type="text" class="form-control" placeholder="작품 제목,배우,감독 검색">
      		<span class="input-group-btn">
        		<button class="btn btn-default" type="button"><span id="search-icon" class="glyphicon glyphicon-search"></span></button>
      		</span>
      	</div>
	</div>
