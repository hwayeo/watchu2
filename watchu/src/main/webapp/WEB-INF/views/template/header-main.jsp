<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="text-right">
	<div class="header-menu hidden-xs">
		<a href="${pageContext.request.contextPath}/movie/list.do" class="btn header-item">영화목록</a>
		<a href="#" class="btn header-item" data-toggle="modal" data-target="#loginModal">로그인</a>
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

	<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <div class="text-center">
	        <h3 class="modal-title" id="myModalLabel"><b>로그인</b></h3>
        </div>
      </div>
      <div class="modal-body">	
      	<form:form commandName="command" action="login.do">
	      	<div class="text-center">
		      	<form:input path="id"/>
		      	<form:password path="passwd"/>
		      	<input type="submit" value="로그인">
		        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
      		</div>
      	</form:form>
      </div>
    </div>
  </div>
</div>