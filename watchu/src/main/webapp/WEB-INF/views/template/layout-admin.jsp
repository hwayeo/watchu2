<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<meta charset="UTF-8">
<title><tiles:getAsString name="title"></tiles:getAsString></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin-main.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="main_header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div id="admin">
	<div id="main_menu">
		<tiles:insertAttribute name="menu"/>
	</div>
	<div id="main_body">
		<tiles:insertAttribute name="body"/>
	</div>
	</div>
	<div id="main_footer">
		<tiles:insertAttribute name="footer"/>
	</div>
</body>
</html>






