<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<section class="content">
	<div class="box-header">
		<h3 class="box-title">게시판 상세보기</h3>
	</div>
<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label>제목</label> <input type="text" name='title'
					class="form-control" value="${board.title}" readonly="readonly"/>
			</div>
		<div class="form-group">
	<label>내용</label>
	<textarea class="form-control" name="content" rows="5"
		readonly="readonly" >${board.content}</textarea>
</div>

<div class="form-group">
	<label>작성자</label> 
	<input type="text" name="nickname" value="${board.nickname}" 
	class="form-control" readonly="readonly">			
</div>
</div>

<div class="box-footer">
	<button type="submit" class="btn btn-primary">수정하기 </button>
	<input type="button" onclick="javascript:window.location='${pageContext.request.contextPath}/board/list'" value="목록"/>
	<input type="button" onclick="javascript:window.location='${pageContext.request.contextPath}/board/write'" value="글쓰기"/>
</div>
</form>
</section>
<%@include file="../include/footer.jsp"%>
		