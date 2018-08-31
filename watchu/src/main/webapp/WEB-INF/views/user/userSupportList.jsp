<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/support.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/support.js"></script>

<div class="container">
   <h2 class="title">������</h2>
   <p class="subTitle">Watchu�� �������Դϴ�.</p>

   <div class="content-body">
      <div class="tab-pane active" id="support_list">
         <div class="col-md-12 col-xs-12 content-header">
            <!-- �˻� -->
            <p class="search-title">�˻� ���� </p>
            <select name="category">
               <option value="faq1">App ����</option>
               <option value="faq2">������ ����</option>
               <option value="faq3">1:1 ���</option>
            </select>
            
            <input type="text">
            
            <input type="button" value="�˻�" class="btnSearch">
         </div>
         
         <p class="total">�� <span class="watchucolor">12</span>���� ��㳻���� �ֽ��ϴ�.</p>

         <!-- ��� ��� -->
         <table class="table table-hover table-condensed">
            <tr class="sup_title">
               <th class="col-md-2">��ȣ</th>
               <th class="col-md-2">���̵�</th>
               <th class="col-md-2">����</th>
               <th class="col-md-2">�з�</th>
               <th class="col-md-2">����</th>
               <th class="col-md-2">�����</th>
            </tr>
            
            <c:forEach var="contact" items="${list}">
            <tr class="sup_content">
               <td>${contact.contact_num}</td>
               <td>${contact.id}</td>
               <td><a onclick="location.href='userSupportView.do'">����</a></td>
               <td>App ����</td>
               <td>�亯���</td>
               <td>${contact.reg_date}</td>
            </tr>
            </c:forEach>
         </table>
      </div>
      
      <div class="etc">
         <div class="col-md-12">
            
         </div>
      </div>
   </div>
</div>