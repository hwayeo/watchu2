<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="text-right">
	<div class="header-menu hidden-xs">
		<c:if test="${empty user_id}">
			<a href="${pageContext.request.contextPath}/movie/movieHome.do" class="btn header-item">영화목록</a>
			<a href="${pageContext.request.contextPath}/user/login.do" class="btn header-item">로그인</a>
			<a href="${pageContext.request.contextPath}/user/write.do" class="btn header-item">회원가입</a>
		</c:if>
		<c:if test="${!empty user_id}">
		<div class="dropdown">
			<a href="" class="dropdown-toggle" id="mainMenu" data-toggle="dropdown" aria-expanded="true">
			<c:if test="${empty profile}">
				<img src="${pageContext.request.contextPath}/resources/images/default-profile.jpg" width="35" height="35" class="img-circle">
			</c:if>
			<c:if test="${!empty profile}">
				<img src="imageView.do?id=${user_id}" width="35" height="35" class="img-circle">
			</c:if>
			</a> 
			<ul class="dropdown-menu dropdown-menu-right" role="menu" aria-labelledby="mainMenu">
   				<li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/movie/movieHome.do">영화목록</a></li>
    			<li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/user/userMypage.do">마이페이지</a></li>
    			<li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/user/logout.do">로그아웃</a></li>
  			</ul>
		</div>
		</c:if>
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
