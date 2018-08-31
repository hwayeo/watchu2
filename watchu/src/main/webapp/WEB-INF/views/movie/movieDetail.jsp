<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/movie-detail.css">	
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/watchu-view.css">	
<div id="main-page">
	<div id="main_banner">
		<div id="img-test">
		</div> 
	</div>
</div>
<div class="container-fluid">
	<!-- 상단부분 시작 -->
	<div class="row">
		<%-- <!-- 상단 포스터 이미지 -->
		<div class="col-md-12" id="poster">
			<a href="#" class=""><img src="${pageContext.request.contextPath}/resources/images/img4.jpg" class="img-responsive center-block hidden-xs" id="image"></a>
			<a href="#" class="hidden-md hidden-lg hidden-sm thumbnail"><img src="#" class="center-block visible-xs"></a>
		</div>
		<!-- 상단 포스터 이미지 끝 --> --%>
		
		<!-- 영화 기본정보 pc 화면 -->
	<div class="col-sm-12 col-md-12 col-xs-12 hidden-xs">
		 <div class="col-sm-6 col-md-6 col-xs-6" id="poster3">
			<div class="hidden-xs"><img src="#" id="image2"></div> 
		</div>
	
	<div class="col-sm-6 col-md-6 col-xs-6" id="poster2">
		 <h3><b>어벤져스:인피니티워</b></h3>
		 	<p>2018.sf.미국</p>
		 		<hr width="90%" align="left">	
					<p>평점★4.5</p>
				<hr width="90%" align="left">
			<button type="button" style="width: 250px;" 
			 class="btn btn-primary btn-default btn-danger">보고싶어요</button>
		</div>
	</div>
		<!-- 영화 기본정보 pc화면 끝 -->
		
		<!-- 영화 기본정보 모바일 화면 -->
		<div class="col-sm-12 col-md-12-xs-12 hidden-md hidden-lg hidden-sm" style="text-align:center"> 
		<h3>어벤져스:인피니티워</h3>
		 	<p>2018.sf.미국</p>
		 		<hr width="90%" align="left">	
					<p>평점★4.5</p>
				<hr width="90%" align="left">
		<button type="button" style="width: 200px;" 
		class="btn btn-primary btn-default btn-danger">보고싶어요</button>
		<hr width="90%" align="left">
		<div class="visible-xs">
				<a href="#"><button type="button" style="width: 200px;" 
			 class="btn btn-primary btn-default btn-info">코멘트 남기기</button></a>
		</div>
	</div>
	<!-- 영화 기본정보 모바일 화면 끝-->
	</div>
</div>
	<!-- 상단 부분 끝 -->
	
	<!-- 상세정보 시작 -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-xs-12" id="middle">
				<!-- 코멘트 -->
				<div class="comment hidden-xs">대단한 작품이군요 회원님의 코멘트를 남겨주세요
					<a href="#"><button 
						class="btn btn-primary btn-default btn-info">코멘트 남기기
					</button></a>
				</div>
				<!-- 코멘트 끝 -->
				
				<!-- pc상세정보 -->
				<div class="hidden-xs" id="box">
				<div>
					<h4><b>내 예상 별점</b></h4>
				<br>
				</div>

				<div>
					<h5>본 친구</h5>
				</div>
				<hr>

				<div>
					<h5>선호하는 감독</h5>
				</div>
				<hr>

				<div>
					<h5>선호하는 배우</h5>
				</div>
				<hr>

				<div>
					<h5>재밌게 본 비슷한 작품</h5>
				</div>
				<hr>

				<div>
					<h5>선호하는 태그</h5>
				</div>
				<hr>

				<div>
					<h4><b>기본정보</b></h4>
				</div>
				
				<div>내용</div>
				<hr>
				<div>
					<h4><b>출연제작</b></h4>
				</div>
				<hr>

				<div>
					<h4><b>별점 그래프</b></h4>
				</div>
				<hr>

				<div>
					<h4><b>본 친구</b></h4>
				</div>
				<hr>

				<div>
					<h4><b>코멘트</b></h4>
				</div>
				
				<div id="comment-box">
					<div class="division1">
						<h4><span>아이디</span></h4>
					</div>
				<div class="division2">
						<h4><span>아이디</span></h4>
					</div>
				</div>
				
				<hr>

				<div>
					<h4><b>비슷한 작품</b></h4>
					<a href="#"><img src="#" id="image3"></a>
					<a href="#"><img src="#" id="image3"></a>
					<a href="#"><img src="#" id="image3"></a>
					<a href="#"><img src="#" id="image3"></a>
					<a href="#"><img src="#" id="image3"></a>
					<a href="#"><img src="#" id="image3"></a>
					<a href="#"><img src="#" id="image3"></a>
					<a href="#"><img src="#" id="image3"></a>
				</div>
			</div>	
				<!-- pc상세정보 끝 -->
				
				<!-- 모바일 상세정보 시작-->
				<div class="col-sm-12 col-md-12 col-xs-12 hidden-md hidden-lg hidden-sm" id="box2">
				<div>
					<h4><b>내 예상 별점</b></h4>
				<br>
				</div>

				<div>
					<h5>본 친구</h5>
				</div>
				<hr>

				<div>
					<h5>선호하는 감독</h5>
				</div>
				<hr>

				<div>
					<h5>선호하는 배우</h5>
				</div>
				<hr>

				<div>
					<h5>재밌게 본 비슷한 작품</h5>
				</div>
				<hr>

				<div>
					<h5>선호하는 태그</h5>
				</div>
				<hr>

				<div>
					<h4><b>기본정보</b></h4>
				</div>
				
				<div>내용</div>
				<hr>
				<div>
					<h4><b>출연제작</b></h4>
				</div>
				<hr>

				<div>
					<h4><b>별점 그래프</b></h4>
				</div>
				<hr>

				<div>
					<h4><b>본 친구</b></h4>
				</div>
				<hr>

				<div>
					<h4><b>코멘트</b>  </h4>
				</div>
				
				<div class="jumbotron division3">
					<h4><span>아이디</span></h4>
				</div>
				<hr>
				
				<div class="row">
				<h4><b>비슷한 작품</b></h4>
					<div class="col-xs-4">
					<a href="#"><img src="${pageContext.request.contextPath}/resources/images/img1.jpg" id="image4"></a>
					</div>
					<div class="col-xs-4">
					<a href="#"><img src="${pageContext.request.contextPath}/resources/images/img1.jpg" id="image4"></a>
					</div>
					<div class="col-xs-4">
					<a href="#"><img src="${pageContext.request.contextPath}/resources/images/img1.jpg" id="image4"></a>
					</div>
				</div>
				<!-- 모바일 상세정보 끝-->
			</div>
		</div>
	</div>
</div>
	<!-- 상세정보 끝 -->
<input type="hidden" value="${movie.movie_num}">