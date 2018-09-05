<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/support.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/support.js"></script>
<div id="main-content">
<div class="container">
   <h2 class="title">������</h2>
   <p class="subTitle">Watchu�� �������Դϴ�.</p>

   <div class="content-body">
      <div class="tab-pane active text-center" id="support_list">
         <div class="col-md-12 col-xs-12 content-header">
            <!-- �˻� -->
	        <form action="userSupportList.do" id="search_form" method="get">
				<ul class="search">
					<li style="none">
						<p class="search-title">�˻� ���� </p>
	            <select name="keyfield">
	               <option value="title">����</option>
					<option value="id">ID</option>
					<option value="content">����</option>
					<option value="all">��ü</option>
	            </select>
					<input type="text" name="keyword" id="keyword" style="width:110px">
					<input type="submit" value="�˻�" class="btnSearch">
				</ul>
			</form>
         </div>
         
         <p class="total">�� <span class="watchucolor">${contact.count}</span>���� ��㳻���� �ֽ��ϴ�.</p>

         <!-- ��� ��� -->
        <c:if test="${count == 0}">
			<div class="align-center">��ϵ� �Խù��� �����ϴ�.</div>
		</c:if>
		<c:if test="${count > 0}">
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
               <td>${contact.title}</td>
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
         </c:if>
      </div>
      <div class="etc text-center">
		<input type="button" class="btn btn-default" value="�۾���" onclick="location.href='userSupportWrite.do'">
      </div>
   </div>
</div>
</div>