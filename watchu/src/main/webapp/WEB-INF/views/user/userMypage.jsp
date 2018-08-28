<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<div class="container-fluid">
	<div class="row">
	<div>
		<div class="col-xs-12 col-md-12"><br><br>
			<div class="col-xs-12 col-md-12">
			<div class="col-xs-9 col-md-9">
				<img class="rounded-circle" src="${pageContext.request.contextPath}/resources/images/img3.png" width="100" height="100">
				
				<!-- 확인해야 함 -->
				${profile_img} 
				
			<hr></div>
			<div class="col-xs-1 col-md-1">
				<a href="#" class="glyphicon glyphicon-user"></a> 
			</div>
			<div class="col-xs-1 col-md-1">
				<a href="톱니바퀴" class="glyphicon glyphicon-cog"></a>
			</div>
			</div>
			
				<div class="col-xs-8 col-md-8">
					<h2 class="text-left"> ${user.name}</h2>
				<div>
				<ul class="wcPc-Arrange">
				<li class="wcPc-ArrangeSizeFit">
				<a href="https://watcha.com/ko-KR" title="885 Following">
					<span class="wcPc-StatLabel wcPc-block">Following</span>&emsp;
					<span class="wcPc-StatValue text-center">885</span>
				</a>
				</li>
				<li class="wcPc-ArrangeSizeFit">
				<a href="https://watcha.com/ko-KR" title="1.810 Followers">
					<span class="wcPc-StatLabel wcPc-block">Followers</span>
					<span class="wcPc-StatValue text-center">1.810</span><br><br>
				</a>
				</li>
				</ul>
				</div>
				</div>
				
				<div class="col-xs-4 col-md-4"><br>
					<button class="btn btn-md btn-primary active" type="button" onclick="location.href='updateUser.do'">프로필 수정</button>
				</div><hr><br><br>
		</div>
		
		<div class="col-xs-12 col-md-12"> 
		<div class="container" style="border:1px solid gray"><br><br>
				<div class="col-xs-7 col-md-7 text-center">
					<span class="wc-StatLabel2 wcPc-block"><a href="#">영화</a></span> 234<br>
					<span class="wc-StatLabel wcPc-block"><a href="#">보고싶어요</a></span> 12
					
				</div>
				<div class="col-xs-5 col-md-5">
					<span class="wc-StatLabel wcPc-block"><a href="#">코멘트</a></span> 11<br>
					<span class="wc-StatLabel wcPc-block"><a href="#">좋아요</a></span> 120<br><br><br>
				</div>
		</div>
		</div>
		<br><br><hr>
	
	<div class="col-xs-12 col-md-12"> 
		<div class="container row">
			<div class="col-xs-7 col-md-7"><br>
				<h2>최고의 작품</h2>
			</div>
			<div class="col-xs-1 col-md-4">
			</div>
			<div class="col-xs-4 col-md-1"><br><br>
				<button class="btn btn-md btn-primary active" type="button">취향 분석</button>
			</div>
		</div>
	</div>
	</div>
	
	<div class="row container"><br>
	<div class="col-xs-12 col-md-12"> 
		<div class="col-xs-4 col-md-4">
			<img src="${pageContext.request.contextPath}/resources/images/gad.jpg" width="150" height="200"><br>
			<p>가디언즈 오브 갤럭시</p>
		</div>
		<div class="col-xs-4 col-md-4">
			<img src="${pageContext.request.contextPath}/resources/images/gad2.jpg" width="150" height="200"><br>
			<p>수어사이드 스쿼드</p>
		</div>
		<div class="col-xs-4 col-md-4">
			<img src="${pageContext.request.contextPath}/resources/images/gad3.jpg" width="150" height="200"><br>
			<p>앤트맨</p>
		</div>
	</div>
	</div>
</div>
</div>