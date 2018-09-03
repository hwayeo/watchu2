<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/contact.reply.js"></script>
<div class="page-main-style container">
	<table width="700" style="font-size:16px">
		<tr>
			<th>제목</th>
			<td></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${contact.id}</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${contact.reg_date}</td>
		</tr>
		<tr>	
			<th>첨부파일</th>
			<td>
				<c:if test="${!empty contact.filename}">
					<a href="file.do?num=${contact.contact_num}">${contact.filename}</a>
				</c:if>
			</td>
		</tr>
	</table>
	<hr size="1" width="100%">
	
	<table>
		<th width="250">내용</th>
		<td>
			<c:if test="${fn:endsWith(contact.filename,'.jpg') || 
			              fn:endsWith(contact.filename,'.JPG') ||
			              fn:endsWith(contact.filename,'.gif') ||
			              fn:endsWith(contact.filename,'.GIF') ||
			              fn:endsWith(contact.filename,'.png') ||
			              fn:endsWith(contact.filename,'.PNG')}">
			<img src="imageView.do?contact_num=${contact.contact_num}" style="max-width:300px">
			</c:if>
			<p><br>
				${contact.content}
			</p>
		</td>
	</table>		
	<hr size="1" width="100%">
	<div class="align-right text-center">
		<c:if test="${!empty user_id && user_id == contact.id}">
			<input type="button" class="btn btn-default" value="수정" onclick="location.href='userSupportUpdate.do?contact_num=${contact.contact_num}'">	
			<input type="button" class="btn btn-default" value="삭제"  onclick="location.href='userSupportDelete.do?contact_num=${contact.contact_num}'">	  
			<input type="button" class="btn btn-default" value="목록" onclick="location.href='userSupportList.do'"/>
		</c:if>
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

