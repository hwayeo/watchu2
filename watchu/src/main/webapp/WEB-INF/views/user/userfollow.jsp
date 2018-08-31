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


<script type="text/javascript">
/* 나중에 폴더로 옮길거임! */
$(document).ready(function(){
	
	$('.follow').click(function(){
		
		var follow_id = $(this).attr('data-id');
		var user_id = $('#user_id').val();
		alert("user_id =" +user_id);
		alert("follow_id =" +follow_id);
		
		$.ajax({
			url:'following.do',
			type:'post',
			data:{follow_id:follow_id,user_id:user_id},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'success'){
					alert(follow_id + '입니당' );
					
					/* $(this).attr('class','unfollow').show();
					$(this).attr('class','follow').hide(); */
				}else{
					
				}			
			},
			error:function(){
				alert('네트워크 오류 발생');
			}
		});
	});
	
 
	$('#unfollow').click(function(){
		
	});
});
</script>
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
                
                <input type="hidden" id="user_id" name="user_id" value="${user.id}">
                
                <ul class="list-group">
                    <c:forEach var="article" items="${list}">
                    <!-- 본인,관리자제외 -->
                    <c:if test="${article.auth==1 && article.id != user.id }">
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

								<%-- <c:if test="${article.id != user.follow }"user.follow split으로 쪼개서 리스트넣고 불러옴>
									<div class="pull-right">
										<!-- <div class="" data-toggle="buttons"> -->
											<input type="button" class="btn btn-primary follow" data-id="${article.id}" name="follow" value="팔로우" style="display: none;">
											<input type="button" class="btn btn-success active unfollow" name="unfollow" value="팔로잉">
										<!-- </div> -->
									</div>
								</c:if> --%>
								<%-- <c:if test="${article.id == user.follow }"> --%>
									<div class="pull-right">
										<!-- <div class="" data-toggle="buttons"> -->
											<input type="button" class="btn btn-primary follow" data-id="${article.id}" name="follow" value="팔로우" >
											<input type="button" class="btn btn-success active unfollow" data-id="${article.id}" name="unfollow" value="팔로잉" style="display: none;">
										<!-- </div> -->
									</div>
								<%-- </c:if> --%>
								
								
						</li>
						</c:if>
						</c:forEach>
                    
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>

