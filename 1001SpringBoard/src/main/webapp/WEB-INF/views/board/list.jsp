<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!-- jstl 사용을 위한 설정  -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#boardSearch {
	text-align: center;
	padding-top: 5%;
	margin-top: 5%;
}

#boardSearch input {
	border: 1px solid gray;
	border-radius: 10px 10px 10px 10px;
}

#boardDiv {
	text-align: center;
	margin-top: 5%;
	margin-bottom: 5%;
}

table {
	width: 80%;
	height: 40%;
	margin-left: 10%;
	margin-right: 10%;
	margin-left: 10%;
}

.boardlist tr th {
	text-align: center;
	border-bottom: 1px solid black;
	border-top: 1px solid black;
	padding: 10px;
	margin: 10px;
}

.boardlist tr .bno {
	text-align: center;
	padding: 10px;
	margin: 10px;
	width: 5%;
}

.boardlist tr .nickname {
	text-align: center;
	padding: 10px;
	margin: 10px;
	width: 10%;
}

.boardlist tr .title {
	text-align: center;
	padding: 10px;
	margin: 10px;
	width: 40%;
}

.boardlist tr #tdTitle {
	text-align: left;
}

.boardlist tr .dispdate {
	text-align: center;
	padding: 10px;
	margin: 10px;
	width: 10%;
}

.boardlist tr .readcnt {
	text-align: center;
	padding: 10px;
	margin: 10px;
	width: 5%;
}
</style>
<section class="content">

	<!--<p>${list}</p>-->

	<!-- 검색 -->
	
	<div>
		<form action="" method="get">
			<div id="boardSearch">
				<input type="search" size="100" name="search" id="search" /> <input
					type="submit">
			</div>
		</form>
	</div>
	
	
	<!-- 게시판 리스트 테이블 -->
	<div id="boardDiv">
		<table class="boardlist">
			<tr>
				<th class="bno">글 번호</th>
				<th class="nickname">작성자</th>
				<th class="title">글 제목</th>
				<th class="dispdate">작성일</th>
				<th class="readcnt">조회수</th>
			</tr>
		</table>
		<c:forEach var="list" items="${list}">
			<table class="boardlist">
				<tr>
					<td class="bno">${list.bno}</td>
					<td class="nickname">${list.nickname}</td>
					<td class="title" id="tdTitle"><a
						href="detail?bno=${list.bno}">${list.title}</a></td>
					<td class="dispdate">${list.dispdate}</td>
					<td class="readcnt">${list.readcnt}</td>
				</tr>
			</table>
		</c:forEach>
	</div>
</section>
<%@include file="../include/footer.jsp"%>