<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팔로잉폼</title>
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
				<!-- 임시목록 시작 -->
				
					<table style="border:1px solid black;">
						<tr>
							<th>이름</th>
						</tr>
						<c:forEach var="article" items="${list}">
							<tr>
								<td>${article.name}</td>
								
							</tr>
						</c:forEach>
					</table>
					<div class="align-center">${pagingHtml}</div>
				
				<!-- 임시목록 끝 -->
				<div class="panel panel-default">
                <div class="panel-heading">팔로잉목록</div>
                
                <ul class="list-group">
                    
                    <li class="list-group-item">
       					
                        <a href="#" class="following_profile_img"><img
												src="${pageContext.request.contextPath}/resources/images/default-profile.jpg"
												class="img-circle" id="following_profile_img" style="width:50px;height:50px;"></a> 
							
							
							<span class="name_span"><label class="name">홍길동</label></span>
							
							
							<div class="pull-right">
								<div class="" data-toggle="buttons">
									<label class="btn btn-success "> 
										<input type="radio" name="options" id="option5" checked>팔로잉
									</label> 
									<label class="btn btn-primary active"> 
										<input type="radio" name="options" id="option6" style="display: none;">팔로워
									</label>
								</div>
							</div>
						</li>
                    
                    <li class="list-group-item">
                        <a href="#" class="following_profile_img"><img
												src="${pageContext.request.contextPath}/resources/images/default-profile.jpg"
												class="img-circle" id="following_profile_img" style="width:50px;height:50px;"></a>
						<span class="name_span"><label class="name">홍길동</label></span>												
                        <div class="pull-right">
                          <div class="" data-toggle="buttons">
									<label class="btn btn-success "> 
										<input type="radio" name="options" id="option5" checked>팔로잉
									</label> 
									<label class="btn btn-primary active"> 
										<input type="radio" name="options" id="option6" style="display: none;">팔로워
									</label>
						 </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <a href="#" class="following_profile_img">
                        <img src="${pageContext.request.contextPath}/resources/images/default-profile.jpg" class="img-circle" id="following_profile_img" style="width:50px;height:50px;"></a>
						<span class="name_span">
						<label class="name">홍길동</label></span>
                        <div class="pull-right">
                            <div class="" data-toggle="buttons">
									<label class="btn btn-success "> 
										<input type="radio" name="options" id="option5" checked>팔로잉
									</label> 
									<label class="btn btn-primary active"> 
										<input type="radio" name="options" id="option6" style="display: none;">팔로워
									</label>
								</div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <a href="#" class="following_profile_img"><img
												src="${pageContext.request.contextPath}/resources/images/default-profile.jpg"
												class="img-circle" id="following_profile_img" style="width:50px;height:50px;"></a>
						<span class="name_span"><label class="name">홍길동</label></span>
                        <div class="pull-right">
                            <div class="" data-toggle="buttons">
									<label class="btn btn-success "> 
										<input type="radio" name="options" id="option5" checked>팔로잉
									</label> 
									<label class="btn btn-primary active"> 
										<input type="radio" name="options" id="option6" style="display: none;">팔로워
									</label>
								</div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <a href="#" class="following_profile_img"><img
												src="${pageContext.request.contextPath}/resources/images/default-profile.jpg"
												class="img-circle" id="following_profile_img" style="width:50px;height:50px;"></a>
						<span class="name_span"><label class="name">홍길동</label></span>
                        <div class="pull-right">
                            <div class="" data-toggle="buttons">
									<label class="btn btn-success "> 
										<input type="radio" name="options" id="option5" checked>팔로잉
									</label> 
									<label class="btn btn-primary active"> 
										<input type="radio" name="options" id="option6" style="display: none;">팔로워
									</label>
								</div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <a href="#" class="following_profile_img"><img
												src="${pageContext.request.contextPath}/resources/images/default-profile.jpg"
												class="img-circle" id="following_profile_img" style="width:50px;height:50px;"></a>
						<span class="name_span"><label class="name">홍길동</label></span>
                        <div class="pull-right">
                            <div class="" data-toggle="buttons">
									<label class="btn btn-success "> 
										<input type="radio" name="options" id="option5" checked>팔로잉
									</label> 
									<label class="btn btn-primary active"> 
										<input type="radio" name="options" id="option6" style="display: none;">팔로워
									</label>
								</div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>