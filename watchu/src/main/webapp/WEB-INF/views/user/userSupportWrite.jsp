<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/support.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/support.js"></script>
<div id="main-content">
<div class="container">
   <h2 class="title">������</h2>
   <p class="subTitle">Watchu�� �������Դϴ�.</p>
<div class="container">
<table class="table table-bordered">
    <thead>
        <caption> �۾��� </caption>
    </thead>
    <tbody>
        <form:form commandName="contactCommand" action="userSupportWrite.do" id="register_form" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${user_id}">
		<form:errors element="div" cssClass="error-color"/>	
            <tr>
                <th>���� </th>
                <td><input type="text" placeholder="������ �Է��ϼ���. " name="title" class="form-control"/></td>
            </tr>
            <tr>
                <th>���� </th>
				<form:errors path="content" cssClass="error-color"/>
                <td><textarea cols="10" rows="15" placeholder="������ �Է��ϼ���. " name="content" class="form-control"></textarea></td>
            </tr>
            <tr>
                <th>÷������ </th>
                <td><input type="file" placeholder="������ �����ϼ���. " name="upload" id="upload"/></td>
            </tr>
            <tr>
                <td colspan="2" class="text-center">
                    <input type="submit" class="btn btn-default" value="���">
                    <input type="button" class="btn btn-default" value="���" onclick="location.href='userSupportList.do'"/>
                </td>
            </tr>
        </form:form>
    </tbody>
</table>
</div>
</div></div>