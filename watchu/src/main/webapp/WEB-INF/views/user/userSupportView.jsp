<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/contact.reply.js"></script>
<div class="page-main-style">
	<%-- <h2>${contact.title}</h2> --%>
	<ul>
		<li>번호 : ${contact.contact_num}</li>
		<li>작성자 : ${contact.id}</li>
		<li>등록일 : ${contact.reg_date}</li>
		<c:if test="${!empty contact.filename}">
			<li>첨부파일 : <a href="file.do?num=${contact.contact_num}">${contact.filename}</a></li>
		</c:if>
	</ul>
	<hr size="1" width="100%">
	<c:if test="${fn:endsWith(contact.filename,'.jpg') || 
	              fn:endsWith(contact.filename,'.JPG') ||
	              fn:endsWith(contact.filename,'.gif') ||
	              fn:endsWith(contact.filename,'.GIF') ||
	              fn:endsWith(contact.filename,'.png') ||
	              fn:endsWith(contact.filename,'.PNG')}">
	<div class="align-center">
		<img src="imageView.do?contact_num=${contact.contact_num}" style="max-width:500px">
	</div>	
	</c:if>
	<p>
		${contact.content}
	</p>
	<hr size="1" width="100%">
	<div class="align-right">
		<c:if test="${!empty user_id && user_id == contact.id}">
		<input type="button" value="수정" onclick="location.href='userSupportUpdate.do?contact_num=${contact.contact_num}'">	
		<input type="button" value="삭제"  onclick="location.href='userSupportDelete.do?contact_num=${contact.contact_num}'">	  
		</c:if>
		<input type="button" value="목록" onclick="location.href='userSupportList.do'">	  
	</div>
	
	<!-- 목록 출력 -->
	<div id="output"></div>
	<div class="paging-button" style="display:none;">
		<input type="button" value="다음글 보기">
	</div>
	<div id="loading" style="display:none;">
		<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif">
	</div> 
	
</div>
