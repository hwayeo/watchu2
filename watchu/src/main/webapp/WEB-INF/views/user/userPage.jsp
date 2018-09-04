<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/setup.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mypage.js"></script>
<div id="main-content">
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12 col-md-12"><br><br>
			<div class="col-xs-12 col-md-12">
				<div class="col-xs-8 col-md-10">
				</div>
				<div class="col-xs-4 col-md-2">
					<a href="setup.do" class="glyphicon glyphicon-cog" data-toggle="modal" data-target="#myModal2"></a>
				</div><hr/>
			</div>
			
			<div class="col-xs-7 col-md-6 text-center">
				<a href="#" class="following_profile_img"> 
					<c:if test="${empty anotheruser.profile_img}">
							<img src="${pageContext.request.contextPath}/resources/images/default-profile.jpg"
											class="img-circle" id="following_profile_img"
											style="width: 50px; height: 50px;">
					</c:if> 
					<c:if test="${!empty anotheruser.profile_img}">
							<img src="${pageContext.request.contextPath}/main/imageView.do?id=${anotheruser.id}" width="70" height="70" class="img-circle">
					</c:if>
				</a> 
				<p style="font-size:22px"> ${anotheruser.name}</p>
				<div>
					<ul class="wcPc-Arrange">
						<li class="wcPc-ArrangeSizeFit" style="list-style:none;">
								<a href="myfollowing.do?id=${anotheruser.id}">Following&emsp;</a>
								<a href="myfollowing.do?id=${anotheruser.id}">${list.size()}</a>
						</li>
						<li class="wcPc-ArrangeSizeFit" style="list-style:none;">
								<a href="myfollower.do?id=${anotheruser.id}">Followers&emsp;</a>
								<a href="myfollower.do?id=${anotheruser.id}">${list2.size()}</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-2"></div>
			
		</div>
		
		
		<!-- 겟방식으로 id 넘기는걸로 고쳐야댐 시작-->
		<div class="col-xs-12 col-md-12"> 
		<div class="container" style="border:1px solid gray"><br>
				<div class="col-xs-7 col-md-7 text-center">
					<span class="wc-StatLabel2 wcPc-block"><a onclick="location.href='userMypage_movie.do'">영화</a></span> 234<br>
					<span class="wc-StatLabel wcPc-block"><a onclick="location.href='userWish.do'">보고싶어요</a></span> 12
					
				</div>
				<div class="col-xs-5 col-md-5">
					<span class="wc-StatLabel wcPc-block"><a onclick="location.href='userComment.do'">코멘트</a></span> 11<br>
					<span class="wc-StatLabel wcPc-block"><a onclick="location.href='userLikeComment.do'">좋아요</a></span> 120<br><br>
				</div>
		</div>
		</div>
		<br><br><hr>
		<!-- 겟방식으로 id 넘기는걸로 고쳐야댐 끝-->
		
	<div class="col-xs-12 col-md-12 text-center"> 
			<div class="col-xs-7 col-md-6"><br>
				<p style="font-size:22px">최고의 작품</p><br>
			</div>
			<div class="col-xs-1 col-md-2"></div>
			
		</div>
			
		<div class="col-xs-12 col-md-12 text-center"> 
			
			<div class="col-md-3"></div>
			<div class="col-xs-4 col-md-2">
				<img class="image" src="${pageContext.request.contextPath}/resources/images/gad.jpg" ><br>
				<p>가디언즈 오브 갤럭시</p>
			</div>
			<div class="col-xs-4 col-md-2">
				<img class="image" src="${pageContext.request.contextPath}/resources/images/gad2.jpg" ><br>
				<p>수어사이드 스쿼드</p>
			</div>
			<div class="col-xs-4 col-md-2">
				<img class="image" src="${pageContext.request.contextPath}/resources/images/gad3.jpg" ><br>
				<p>앤트맨</p>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</div>


<!-- 톱니바퀴 누르면 나오는 모달 -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">설정</h4>
				</div>
				<div class="modal-body">
					<form class="pb-modalreglog-form-reg">
					<!--     여기부터 넣어라 -->
					<ul class="list-group">

						<li class="list-group-item"></li>

						<li class="list-group-item">
							<div class="">
								<a href="#"><label>BLOCK</label></a>
							</div>

						</li>

					</ul>

					<!--     여기까지다 -->
					</form>
				</div>
				<div class="modal-footer text-center">Watchu♥</div>
			</div>
		</div>
	</div>
</div>   