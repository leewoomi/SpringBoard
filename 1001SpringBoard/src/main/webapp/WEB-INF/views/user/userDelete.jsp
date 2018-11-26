<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<style>
#userDeleteCheck {
	text-align: center;
	margin: 5%;
	margin-left:20%;
	padding: 5%;
	background-color: #CCCCCC;
	width: 40%;
	height: 30%;
}

.yesorno {
	padding: 2%;
	margin: 2%;
	width: 20%;
}
</style>

<section class="content">



	<form accept-charset="UTF-8" role="form" action="userDelete"
		method="post">

		<div id="userDeleteCheck">
			<h2>회원 탈퇴</h2>
			<hr />

			<h3>탈퇴하시려면 비밀번호를 입력해주세요.</h3>

			<div style='color: red'>${msg}</div>
			<div class="form-group">
				<label for="username-email">이메일</label> <input type="email"
					name="email" id="email" value="${user.email}" readonly="readonly"
					placeholder="이메일을 입력하세요" class="form-control" />
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label> <input type="password" name="password"
					id="password" required="required" placeholder="비밀번호를 입력하세요" class="form-control" />
			</div>

			<input type="submit" class="yesorno" value="탈퇴하기" onclick="yes()" /> <input
				type="button" class="yesorno" value="메인으로"
				onclick="window.location.href='../'" />

		</div>
	</form>


</section>
<%@include file="../include/footer.jsp"%>
<script>
	function yes() {
		alert("안녕히가세요.");
	}
</script>

