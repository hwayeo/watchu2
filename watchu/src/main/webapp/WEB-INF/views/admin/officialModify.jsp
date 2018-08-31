<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- 관계자 상세&수정 -->
<div class="modify-form">
	<h3>관계자 상세/수정</h3>
	<form:form commadnName="command" action="officialModify.do" id="official_modify" enctype="multipart/form-data">
	<form:hidden path="off_num"/>
	<form:hidden path="upload"/>
	<form:errors element="div" cssClass="error-color"/>
	</form:form>
	<ul>
		<li>
			<label for="name">이름</label>
			<form:input path="name"/>
			<form:errors path="name" cssClass="error-color"/>
		</li>
	</ul>
</div>