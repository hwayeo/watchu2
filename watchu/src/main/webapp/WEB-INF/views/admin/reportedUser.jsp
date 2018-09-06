<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  	
<div class="admin-main">
	<div class="tab-pane" id="reported_user">
		<h2>회원 신고 내역</h2>
		<br>
		<div class="content-header">
			<!-- 검색 -->
			<form id="user_search" method="get" class="search">
			<select name="keyfield">
				<option value="id">ID</option>
				<option value="report_content">내용</option>
			</select>
			<input type="text" name="keyword" id="keyword"> 
			<input type="submit" value="검색">
			</form>
			
			<!-- 처리여부 -->
			<input type="radio" name="status" value="all" checked> 전체 <input
				type="radio" name="status" value="incomplete"> 미처리<br>
			<Br> 
		</div>

		<div class="content-body">
			<!-- 회원 신고 내역 -->
			<table class="table table-hover table-condensed">
				<c:if test="${count == 0}">
							<div class="align-center">글없음</div>
				</c:if>
				<c:if test="${count > 0}">
					<tr>
							<th class="col-md-2">번호</th>
							<th class="col-md-6">신고내용</th>
							<th class="4">작성자</th>
							<th class="4">처리상태</th>
					</tr>
                    <c:forEach var="report" items="${list}">
						<tr>
							<td><a href='detailReport.do?num=${report.report_num}'>${report.report_num}</a></td>
							<td>${report.report_content}</td>
							<td>${report.id }</td>
							<td>완료/미완료</td>
						</tr>
                    </c:forEach>
                </c:if>
			</table>
			<br>

			<!-- 페이지버튼 -->
			<div align="center">${pagingHtml}</div>
			<!-- <nav align="center">
				<ul class="pagination pagination-sm">
					<li class="disabled"><a href="#" aria-label="Previous"><span
							aria-hidden="true">&laquo;</span></a></li>
					<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
				</ul>
			</nav> -->
			<br>
		</div>
	</div>
</div>