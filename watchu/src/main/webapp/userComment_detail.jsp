<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.user_name{
    font-size:14px;
    font-weight: bold;
}
.comments-list .media{
    border-bottom: 1px dotted #ccc;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<link rel="stylesheet" href="css.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin-main.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container text-center">
		<h2>코멘트</h2>
		<hr />
	</div>


	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-md-12 ">
				<div class="row">
					<div class="container">
						<div class="col-xs-6 col-md-6">
							<div class="container">
								<img src="resources/images/img3.png" width="50" height="50">&emsp;홍길동
								<span style="color: gray; font-size: 7px">13시간 전</span><br>
								<span style="font-weight: bold">가디언즈 오브 갤럭시</span> 
								<span style="color: gray; font-size: 8px"> 2018</span><br> 
								<span class="glyphicon glyphicon-star"></span> 
								<span class="glyphicon glyphicon-star"></span> 
								<span class="glyphicon glyphicon-star"></span> 
								<span class="glyphicon glyphicon-star"></span> 
								<span class="glyphicon glyphicon-star-empty"></span>
							</div>
						</div>

						<!-- 영화 사진 - 누르면 영화 상세 정보로 이동 -->
						<div class="col-xs-6 col-md-6 text-right">
							<a href="#"><img src="resources/images/gad.jpg" width="110" height="150"></a>
						</div>
					</div>
				</div>

				<div class="container">
					<div class="col-xs-12 col-md-12 text-left">
						<div class="container">
							<h5>리뷰가 쓰여지는 공간</h5>
						</div>
					</div>
				</div>
				<hr />

				<div class="container text-center">
					<a href="#"><span class="glyphicon glyphicon-thumbs-up "></span> 좋아요</a>&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;
					<span style="color: #d3d3d3"> | </span>&emsp;&emsp;&emsp; &emsp;&emsp;
					<a href="#"><span class="glyphicon glyphicon-comment "></span> 댓글</a>&emsp;&emsp;&emsp;&emsp;&emsp;
					<span style="color: #d3d3d3"> | </span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<a href="#"><span class="glyphicon glyphicon-share-alt "></span> 공유</a>
				</div><hr />
				
				
				
				<div class="container">
	                <div class="col-xs-12 col-md-12">
	                  <div class="page-header">
	                    <h1><small class="pull-right">45 comments</small> Comments </h1>
	                  </div> 
	                   <div class="comments-list">
	                       
	                       <div class="media">
	                           <p class="pull-right"><small>4 days ago</small></p>
	                            <a class="media-left" href="#">
	                              <img src="resources/images/img3.png" width="50" height="50">
	                            </a>
	                            <div class="media-body">
	                              <h4 class="media-heading user_name">홍길자</h4>잘보고가요~!
	                              <p><small><a href="#">좋아요 &emsp;<span class="glyphicon glyphicon-thumbs-up"> 11</span></a></small></p>
	                            </div>
	                       </div>
	                       <div class="media">
	                           <p class="pull-right"><small>5 days ago</small></p>
	                            <a class="media-left" href="#">
	                              <img src="resources/images/img3.png" width="50" height="50">
	                            </a>
	                            <div class="media-body">
	                              <h4 class="media-heading user_name">홍길순</h4>좋아용
	                              <p><small><a href="#">좋아요 &emsp;<span class="glyphicon glyphicon-thumbs-up"> 1</span></a></small></p>
	                            </div>
	                       </div>
                  		 </div>
               		 </div>
       			 </div>
			</div>
		</div>
	</div>
</body>
</html>