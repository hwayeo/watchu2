<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="admin-main">
	<div class="tab-pane" id="reported_user">
		<h2>회원 신고 내역</h2>
		<br>
		<div class="content-header">
			<!-- 처리여부 -->
			<input type="radio" name="status" value="all" checked> 전체 <input
				type="radio" name="status" value="incomplete"> 미처리<br>
			<Br> 
			<!-- 검색 -->
			<form action="user.do" id="user_search" method="get" class="search">
			<select name="keyfield">
				<option value="name">ID</option>
				<option value="id">신고내용</option>
			</select>
			<input type="text" name="keyword" id="keyword"> 
			<input type="submit" value="검색">
			</form>
		</div>

		<div class="content-body">
			<!-- 회원 신고 내역 -->
			<table class="table table-hover table-condensed">
				<tr>
					<th class="col-md-2">번호</th>
					<th class="col-md-8">글 제목</th>
					<th class="">작성자</th>
				</tr>
				<c:forEach var="user" items="${user_list}">
				<tr>
					<%-- <td onclick="location.href='userDetail.do?id=${user.id}'" style="cursor:pointer;">${user.id}</td>
					<td onclick="location.href='userDetail.do?id=${user.id}'" style="cursor:pointer;">${user.name}</td>
					<td>${user.phone}</td>
					<td>${user.email}</td>
					<td>${user.reg_date}</td>
					<td><input type="checkbox" name="checked"></td> --%>
				</tr>
				</c:forEach>
			</table>
			<br>

			<!-- 페이지버튼 -->
			<div align="center">${pagingHtml}</div>
		
			<br>
		</div>
	</div>
</div>