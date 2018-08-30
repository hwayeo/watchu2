<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천친구폼</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/follow.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin-main.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
    <div class="row">
     <div class="col-md-8 col-md-offset-4">
     		<!-- 검색폼 시작 -->
  			<form class="navbar-form" role="search" id="search_form" action="" method="get" >
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search" name="keyword" id="keyword">
                    <div class="input-group-btn">
                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                    </div>
                </div>
            </form>
            <!-- 검색폼 끝 -->
            
				<div class="panel panel-default">
                <div class="panel-heading">추천친구 목록</div>
                
                <ul class="list-group">
                    
                    <c:forEach var="article" items="${list}">
                    <!-- 관리자제외 -->
                    <c:if test="${article.auth==1}">
						<li class="list-group-item">
						<a href="#" class="following_profile_img"> 
							<c:if test="${empty article.profile_img}">
								<img src="${pageContext.request.contextPath}/resources/images/default-profile.jpg"
											class="img-circle" id="following_profile_img"
											style="width: 50px; height: 50px;">
							</c:if> 
							<c:if test="${!empty article.profile_img}">
								<img src="${pageContext.request.contextPath}/main/imageView.do?id=${article.id}" width="50" height="50" class="img-circle">
							</c:if>
						</a> 
						<span class="name_span"><label class="name">${article.name}</label></span>

								<div class="pull-right">
									<div class="" data-toggle="buttons">
										<label class="btn btn-primary"> 
										<input type="radio" name="following" id="follow" checked>팔로우
										</label> 
										<label class="btn btn-success active"> 
										<input type="radio" name="follower" id="following" style="display: none;">팔로잉
										</label>
									</div>
								</div></li>
						</c:if>
						</c:forEach>
                    
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>