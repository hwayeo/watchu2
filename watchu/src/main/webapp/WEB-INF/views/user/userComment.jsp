<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setup.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="container text-center">
		<h2>코멘트</h2><hr/>
	</div>
<div class="tab-content container">
	<div id="home" class="tab-pane fade in active">
		<div class="nav-collapse">
				<ul class="nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><b class="caret"></b>&nbsp;작성 순</a>
						<ul class="dropdown-menu">
							<li class="dropdown-header">작성 순</li>
							<li><a href="#">나의 별점 높은 순</a></li>
							<li><a href="#">나의 별점 낮은 순</a></li>
							<li><a href="#">평균 별점 순</a></li>
							<li><a href="#">신작 순</a></li>
						</ul></li>
				</ul><hr>
		</div> 
		
	<div class="container">
		<div class="well"> 
			<div class="media">
				<div class="media-body">
					<div class="container">
						<a onclick="location.href='userMypage.do'" class="profile_img"> 
							<c:if test="${empty user.profile_img}">
								<img src="${pageContext.request.contextPath}/resources/images/default-profile.jpg" class="img-circle" id="profile_img" style="width: 50px; height: 50px;"> ${user.name}
							</c:if> 
							<c:if test="${!empty user.profile_img}">
								<img src="${pageContext.request.contextPath}/main/imageView.do?id=${user.id}" width="50" height="50" class="img-circle"> ${user.name}
							</c:if>
						</a>	
						<p align="right"> 
							<li>
								<span class="glyphicon glyphicon-star"></span> 
								<span class="glyphicon glyphicon-star"></span> 
								<span class="glyphicon glyphicon-star"></span> 
								<span class="glyphicon glyphicon-star"></span> 
								<span class="glyphicon glyphicon-star-empty"></span>
							</li>
					</div><hr/>
					<div class="container" onclick="location.href='userComment_detail.do'" style="cursor:pointer;">  
						<a class="pull-left" href="#"> 
							<img class="media-object" src="resources/images/gad.jpg" width="170" height="250">
						</a>
						<h2 class="media-heading">&emsp;가디언즈 오브 갤럭시</h2>
						<p> &emsp; &emsp;2014</p>
						<h4>&emsp;&emsp;We are groot!</h4> 
						<br><br><br><br><br><br>
						<ul class="list-inline list-unstyled">
							&emsp;<li><span><i class="glyphicon glyphicon-calendar"></i> ${user.reg_date} </span></li>
							<li>|</li>
							<span><i class="glyphicon glyphicon-thumbs-up"></i> 12likes</span>
							<li>|</li>
							<span><i class="glyphicon glyphicon-comment"></i> 2comments</span>
							<li>|</li>
						</ul>
					</div>
				</div><hr/>
				<a href="#">좋아요</a>&emsp;
				<a href="userCommentWrite.do" data-toggle="modal" data-target="#CommentWrite">댓글</a>&emsp;
				
				<a href="#">공유</a>
				<a href="#" style="text-align:right"><span class="glyphicon glyphicon-option-horizontal"></span></a>
			</div>
		</div>
	</div><br>
	
	<!-- 댓글 쓰기 모달창 -->
	<div class="modal fade" id="CommentWrite" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span> 
					</button>
					<h2 class="modal-title text-center" id="myModalLabel">댓글 쓰기</h2>
				</div>
				<div class="modal-body">
					<form class="pb-modalreglog-form-reg">
						<div class="">
							<textarea placeholder="코멘트에 댓글을 남겨보세요" style="outline: none; margin: 0px; width: 270px; height: 349px;"></textarea>
						</div>
						<button class="btn btn-md btn-primary active" type="submit">전송</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div></div>