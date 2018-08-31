<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/support.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/support.js"></script>

<div class="container">
   <h2 class="title">고객센터</h2>
   <p class="subTitle">Watchu의 고객센터입니다.</p>

   <div class="content-body">
      <div class="tab-pane active" id="support_list">
         <div class="col-md-12 col-xs-12 content-header">
            <!-- 검색 -->
            <p class="search-title">검색 구분 </p>
            <select name="category">
               <option value="faq1">App 오류</option>
               <option value="faq2">콘텐츠 오류</option>
               <option value="faq3">1:1 상담</option>
            </select>
            
            <input type="text">
            
            <input type="button" value="검색" class="btnSearch">
         </div>
         
         <p class="total">총 <span class="watchucolor">12</span>건의 상담내역이 있습니다.</p>

         <!-- 상담 목록 -->
         <table class="table table-hover table-condensed">
            <tr class="sup_title">
               <th class="col-md-2">번호</th>
               <th class="col-md-2">제목</th>
               <th class="col-md-2">분류</th>
               <th class="col-md-2">상태</th>
               <th class="col-md-2">등록일</th>
            </tr>
            
            <tr class="sup_content">
               <td>1</td>
               <td><a href="#">제목</a></td>
               <td>App 오류</td>
               <td>답변대기</td>
               <td>2018.8.31</td>
            </tr>
         </table>
      </div>
      
      <div class="etc">
         <div class="col-md-12">
            
         </div>
      </div>
   </div>
</div>