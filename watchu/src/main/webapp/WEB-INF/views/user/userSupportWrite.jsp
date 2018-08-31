<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/support.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/support.js"></script>

<div class="container">
   <h2 class="title">������</h2>
   <p class="subTitle">Watchu�� �������Դϴ�.</p>

	<h1>�۾���</h1>
	<form:form commandName="contactCommand" action="write.do" id="register_form" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${user_id}">
		<form:errors element="div" cssClass="error-color"/>	
		<ul>
			<li>
				<label for="content">����</label>
				<form:textarea path="content"/>
				<form:errors path="content" cssClass="error-color"/>
			</li>
			<li>
				<label for="upload">���Ͼ��ε�</label>
				<input type="file" name="upload" id="upload"/>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="����">
			<input type="button" value="���" onclick="location.href='userSupportList.do'">
		</div>
	</form:form>

</div>