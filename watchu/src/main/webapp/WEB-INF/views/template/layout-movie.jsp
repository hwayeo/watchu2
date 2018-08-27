<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title"></tiles:getAsString></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/movie-list.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/watchu-main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<tiles:insertAttribute name="header"/>
<div class="container">
	<tiles:insertAttribute name="menu"/>
	<hr>
	<tiles:insertAttribute name="movieHome"/> 
</div>
	<tiles:insertAttribute name="footer"/>
</body>
</html>