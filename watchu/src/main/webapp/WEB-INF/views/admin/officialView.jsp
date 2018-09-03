<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="detail">
	<h2>관계자 상세 정보</h2>
	<ul>
		<li>관계자 코드: ${official.off_num}</li>
		<hr size="1" width="100%">
		<li>구분: ${official.jobs}</li>
		<li>이름: ${official.name}</li>
		<li>필모그래피: ${official.filmograp}</li>
	</ul>
</div>