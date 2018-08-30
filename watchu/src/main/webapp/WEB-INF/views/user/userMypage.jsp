<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/setup.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mypage.js"></script>
    
<div class="container">
   <div class="row">
      <div class="col-xs-12 col-md-12 bn">   
         <div class="col-xs-12 col-md-12 grid">
            <div class="col-xs-8 col-md-10">
            </div>
            <div class="col-xs-4 col-md-2 user_icon">
               <a href="follow.do" class="glyphicon glyphicon-user"></a>&emsp;
               <a href="setup.do" class="glyphicon glyphicon-cog" data-toggle="modal" data-target="#myModal2"></a>
            </div>
         </div>
         
         <div class="col-xs-7 col-md-5 text-center">
            <a href="#" class="profile_img"> 
				<c:if test="${empty user.profile_img}">
					<img src="${pageContext.request.contextPath}/resources/images/default-profile.jpg" class="img-circle" id="profile_img" style="width: 50px; height: 50px;">
				</c:if> 
				<c:if test="${!empty user.profile_img}">
					<img src="${pageContext.request.contextPath}/main/imageView.do?id=${user.id}" width="50" height="50" class="img-circle"> 
				</c:if>
			</a>
            <h2> ${user.name}</h2>
            <div>
               <ul class="wcPc-Arrange">
                  <li>
                     <div>
                        <a href="#">Following&emsp;</a>
                        <a href="#">885&emsp;</a>
                     </div>
                  </li>
                  <li>
                     <div>
                        <a href="#">Followers&emsp;</a>
                        <a href="#">1.810&emsp;</a>
                     </div>
                  </li>
               </ul>
            </div>
         </div>
         <div class="col-md-4"></div>
         <div class="col-xs-5 col-md-1"><br>
            <button class="btn btn-md btn-primary active" type="button" onclick="location.href='updateUser.do'">프로필 수정</button>
         </div><br><br>
      </div>
      
      <div class="col-xs-12 col-md-12 bn"> 
      <div class="container" style="border:1px solid gray"><br><br>
            <div class="col-xs-7 col-md-7 text-center">
               <span class="wc-StatLabel2 wcPc-block"><a onclick="location.href='userMypage_movie.do'">영화</a></span> 234<br>
               <span class="wc-StatLabel wcPc-block"><a onclick="location.href='userWish.do'">보고싶어요</a></span> 12
            </div>
            <div class="col-xs-5 col-md-5">
               <span class="wc-StatLabel wcPc-block"><a onclick="location.href='userComment.do'">코멘트</a></span> 11<br>
               <span class="wc-StatLabel wcPc-block"><a onclick="location.href='userLikeComment.do'">좋아요</a></span> 120<br><br><br>
            </div>
      </div>
      </div>
      <br><br>
   
   <div class="col-xs-12 col-md-12 sec_header text-center">
         <div class="col-xs-8 col-md-5 left">
            <h2>최고의 작품</h2>
         </div>
      </div>
         
      <div class="col-xs-12 col-md-12"> 
         <c:if test="col-xs">
            <div class="col-xs-4 col-md-4">
            <img src="${pageContext.request.contextPath}/resources/images/gad.jpg" width="50" height="50"><br>
            <p>가디언즈 오브 갤럭시</p>
            </div>
            <div class="col-xs-4 col-md-4">
               <img src="${pageContext.request.contextPath}/resources/images/gad2.jpg" width="80" height="130"><br>
               <p>수어사이드 스쿼드</p>
            </div>
            <div class="col-xs-4 col-md-4">
               <img src="${pageContext.request.contextPath}/resources/images/gad3.jpg" width="80" height="130"><br>
               <p>앤트맨</p>
            </div> 
         </c:if>

         <div class="col-xs-12 col-md-12">
            <div class="col-xs-4 col-md-4 text-center">
               <img src="${pageContext.request.contextPath}/resources/images/gad.jpg" width="130" height="180"><br>
               <p>가디언즈 오브 갤럭시</p>
            </div>
            <div class="col-xs-4 col-md-4 text-center">
               <img src="${pageContext.request.contextPath}/resources/images/gad2.jpg" width="130" height="180"><br>
               <p>수어사이드 스쿼드</p>
            </div>
            <div class="col-xs-4 col-md-4 text-center">
               <img src="${pageContext.request.contextPath}/resources/images/gad3.jpg" width="130" height="180"><br>
               <p>앤트맨</p>
            </div>
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

                  <li class="list-group-item">
                     <div class="">
                        <a href="updateUser.do"><label>내 설정</label></a>
                     </div>
                  </li>

                  <li class="list-group-item"></li>


                  <li class="list-group-item">

                     <div class="">
                        <a href="#"><label>공지사항</label></a>
                     </div>
                  </li>


                  <li class="list-group-item">
                     <div class="">
                        <a href="#"><label>고객센터</label></a>
                     </div>

                  </li>

                  <li class="list-group-item"></li>

                  <li class="list-group-item">
                     <div class="">
                        <a href="logout.do"><label>로그아웃</label></a>
                     </div>

                  </li>

                  <li class="list-group-item">
                     <div class="">
                        <a href="deleteUser.do"><label>회원탈퇴</label></a>
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