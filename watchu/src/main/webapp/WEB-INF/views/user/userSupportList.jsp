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
      <div class="tab-pane active text-center" id="support_list">
         <div class="col-md-12 col-xs-12 content-header">
            <!-- �˻� -->
            <p class="search-title">�˻� ���� </p>
            <select name="category">
               <option value="faq1">App ����</option>
               <option value="faq2">������ ����</option>
               <option value="faq3">1:1 ���</option>
            </select>
            
            <input type="text" style="width:110px">
            
            <input type="button" value="�˻�" class="btnSearch">
         </div>
         
         <p class="total">�� <span class="watchucolor">12</span>���� ��㳻���� �ֽ��ϴ�.</p>

         <!-- ��� ��� -->
         <table class="table table-hover table-condensed">
            <tr class="sup_title">
               <th class="col-md-1">��ȣ</th>
               <th class="col-md-2">���̵�</th>
               <th class="col-md-3">����</th>
               <th class="col-md-2">�з�</th>
               <th class="col-md-2">����</th>
               <th class="col-md-2">�����</th>
            </tr>
            
            <c:forEach var="contact" items="${list}">
            <tr class="sup_content" a onclick="location.href='userSupportView.do?contact_num=${contact.contact_num}'" style="cursor:pointer">
               <td>${contact.contact_num}</td>
               <td>${contact.id}</td>
               <td>����</td>
               <td>App ����</td>
               <td>
               	<c:if test="${contact.recotentable == 0}">
               		<a style="color:red">�亯���</a>
               	</c:if>
               	<c:if test="${contact.recotentable == 1}">
               		<a style="color:blue">�亯�Ϸ�</a>
               	</c:if>
               </td>
               <td>${contact.reg_date}</td>
            </tr>
            </c:forEach>
         </table>
      </div>
      
      <div class="etc text-center">
      	<c:if test="${!empty user_id}">
			<input type="button" class="btn btn-default" value="�۾���" onclick="location.href='userSupportWrite.do'">
		</c:if>
      </div>
   </div>
</div>