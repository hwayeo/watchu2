<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="container text-center">
		<h2>코멘트</h2><hr/>
	</div>
		<div class="nav-collapse">
			<ul class="nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><b class="caret"></b>&nbsp;작성 순</a>
					<ul class="dropdown-menu">
						<li class="dropdown-header">작성 순</li>
						<li><a href="#">나의 별점 높은 순</a></li>
						<li><a href="#">나의 별점 낮은 순</a></li>
						<li><a href="#">평균 별점 순</a></li>
						<li><a href="#">신작 순</a></li>
					</ul></li>
			</ul>
		</div><hr/>
	<div class="container">
		<div class="well" onclick="location.href='userComment_detail.do'" style="cursor:pointer;"> 
			<div class="media">
				<div class="media-body">
					<div class="container">
						<a class="pull-left" href="#"> 
							<img src="resources/images/img3.png" width="40" height="40">&emsp;홍길동
						</a>
						<p align="right"> 
							<li>
								<span class="glyphicon glyphicon-star"></span> 
								<span class="glyphicon glyphicon-star"></span> 
								<span class="glyphicon glyphicon-star"></span> 
								<span class="glyphicon glyphicon-star"></span> 
								<span class="glyphicon glyphicon-star-empty"></span>
							</li>
						</p>
					</div><hr/>
					<div class="container">  
						<a class="pull-left" href="#"> 
							<img class="media-object" src="resources/images/gad.jpg" width="170" height="250">
						</a>
						<h2 class="media-heading">&emsp;가디언즈 오브 갤럭시</h2>
						<p> &emsp; &emsp;2014</p>
						<h4>&emsp;&emsp;We are groot!</h4> 
						<br><br><br><br><br><br>
						<ul class="list-inline list-unstyled">
							&emsp;<li><span><i class="glyphicon glyphicon-calendar"></i> 2days, 8 hours </span></li>
							<li>|</li>
							<span><i class="glyphicon glyphicon-thumbs-up"></i> 12likes</span>
							<li>|</li>
							<span><i class="glyphicon glyphicon-comment"></i> 2comments</span>
							<li>|</li>
						</ul>
					</div>
				</div><hr/>
				<a href="#">좋아요</a>&emsp;
				<a href="#">댓글</a>&emsp;
				<a href="#">공유</a>
				<a href="#" style="text-align:right"><span class="glyphicon glyphicon-option-horizontal"></span></a>
			</div>
		</div>
	</div><br>