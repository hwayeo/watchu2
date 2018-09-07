<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/movieEva.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/movieEva.js"></script>

<nav class="navbar navbar-default" id="navline">
   <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-movie">
         <span class="icon-bar"></span> 
         <span class="icon-bar"></span> 
         <span class="icon-bar"></span>
      </button>
      
      <a href="#" class="navbar-brand">영화메뉴</a>
   </div>
   
   <div class="collapse navbar-collapse navbar-movie">
      <ul class="nav navbar-nav">
         <li><a href="movieHome.do">홈</a></li>
         <li><a href="movieList.do">카테고리</a></li>
         <li><a href="movieEva.do">평가하기</a></li>
      </ul>
   </div> 
</nav>

<!-- 모바일 환경 -->
<select class="visible-xs visible-sm form-control">
  <option selected>모든 장르</option>
  <option>드라마</option>
  <option>판타지</option>
  <option>재난</option>
  <option>공포</option>
  <option>로맨스</option>
  <option>모험</option>
  <option>스릴러</option>
  <option>다큐멘터리</option>
  <option>코미디</option>
  <option>가족</option>
  <option>미스터리</option>
  <option>애니메이션</option>
  <option>범죄</option>
  <option>뮤지컬</option>
  <option>SF</option>
  <option>액션</option>
  <option>히어로</option>
</select>
<select id="keyfield" name="keyfield" class="visible-xs visible-sm form-control">
  <option selected>모든 국가</option>
  <option>한국</option>
  <option>미국</option>
  <option>일본</option>
  <option>중국</option>
  <option>독일</option>
  <option>대만</option>
  <option>인도</option>
  <option>영국</option>
  <option>프랑스</option>
  <option>이탈리아</option>
  <option>캐나다</option>
  <option>스페인</option>
</select>
<select class="visible-xs visible-sm form-control"> 
  <option selected>최신 순</option>
  <option>추천 순</option>
  <option>별점 순</option>
</select>
<!-- 웹환경 -->
<select  class="hidden-xs hidden-sm rate-menu">
  <option selected>모든 장르</option>
  <option>드라마</option>
  <option>판타지</option>
  <option>재난</option>
  <option>공포</option>
  <option>로맨스</option>
  <option>모험</option>
  <option>스릴러</option>
  <option>다큐멘터리</option>
  <option>코미디</option>
  <option>가족</option>
  <option>미스터리</option>
  <option>애니메이션</option>
  <option>범죄</option>
  <option>뮤지컬</option>
  <option>SF</option>
  <option>액션</option>
  <option>히어로</option>
</select>
<select id="evafield" name="keyfield" class="hidden-xs hidden-sm rate-menu">
  <option value="" selected>모든 국가</option>
  <option value="한국">한국</option>
  <option value="미국">미국</option>
  <option>일본</option>
  <option>중국</option>
  <option>독일</option>
  <option>대만</option>
  <option>인도</option>
  <option>영국</option>
  <option>프랑스</option>
  <option>이탈리아</option>
  <option>캐나다</option>
  <option>스페인</option>
</select>
<select  class="hidden-xs hidden-sm rate-menu category-right"> 
  <option selected>최신 순</option>
  <option>추천 순</option>
  <option>별점 순</option>
</select>
<input type="hidden" id="user_id" value="${user_id}">
<div class="row">
	<div id="elist"></div>
   <%-- <c:forEach var="ml" items="${list}">
  <div class="col-sm-6 col-md-3 col-xs-6" id="main-category">
      <div class="thumbnail">
         <img src="${pageContext.request.contextPath}/resources/images/img4.jpg" class="mimg">
         <div class="overlay">
            <div class="list-contents">
               <p class="subtitle">${ml.title}</p>
               <p class="year">연도 추가해주세요</p>
               <div class="starRating" data-num="${ml.movie_num}" data-id="${user_id}">
                  <fieldset class="rating">
                      <input type="radio" id="star5" name="rating" value="5" />
                      <label class = "full" for="star5" title="Awesome - 5 stars"></label>              
                      <input type="radio" id="star4half" name="rating" value="4.5" />
                      <label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>           
                      <input type="radio" id="star4" name="rating" value="4" />
                      <label class = "full" for="star4" title="Pretty good - 4 stars"></label>              
                      <input type="radio" id="star3half" name="rating" value="3.5" />
                      <label class="half" for="star3half" title="better than good - 3.5 stars"></label>  
                      <input type="radio" id="star3" name="rating" value="3" />
                      <label class = "full" for="star3" title="Good - 3 stars"></label>
                      <input type="radio" id="star2half" name="rating" value="2.5" />
                      <label class="half" for="star2half" title="so so - 2.5 stars"></label>  
                      <input type="radio" id="star2" name="rating" value="2" />
                      <label class = "full" for="star2" title="not bad - 2 stars"></label>
                      <input type="radio" id="star1half" name="rating" value="1.5" />
                      <label class="half" for="star1half" title="bad - 1.5 stars"></label>
                      <input type="radio" id="star1" name="rating" value="1" />
                      <label class = "full" for="star1" title="so bad - 1 star"></label>
                      <input type="radio" id="starhalf" name="rating" value="0.5" />
                      <label class="half" for="starhalf" title="Worst - 0.5 stars"></label>
                  </fieldset>
               </div>
            </div>
         </div>
      </div> 
   </div>
   </c:forEach> --%>
   <%-- <div class="sub-category caption">
         <p class="ptitle">${ml.title}</p>
   </div> --%>
</div>