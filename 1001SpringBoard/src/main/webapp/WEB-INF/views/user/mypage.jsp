<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<section class="content">
	<!-- 회원 정보 페이지 -->
	<form id="mypageform" enctype="multipart/form-data" method="post">
		<p align="center">
		<table border="1" width="50%" height="80%" align='center'>
			<tr>
				<td colspan="3" align="center"><h2>마이페이지</h2></td>
			<tr>
				<td rowspan="5" align="center">
					<p></p> <br />
				<img id="img" width="100" height="100" border="1"
					src="../userimage/${user.image}" /> <br />
				<br />
				</td>
			</tr>

			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;이메일</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="email" name="email"
					id="email" size="30" maxlength=50 readonly="readonly"
					value="${user.email}" />
					<div id="emailDiv"></div>
				</td>
			</tr>

			<tr>
				<td bgcolor="#f5f5f5"></td>
				<td></td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"></td>
				<td></td>
			</tr>
			<tr>
				<td width="17%" bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;닉네임</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="text" name="nickname"
					size="20"  readonly="readonly"
					value="${user.nickname}" />
				</td>
			</tr>
			<tr>
				<td align="center" colspan="3">
					<p></p> <input type="submit" value="수정" class="btn btn-warning" />
					<input type="button" value="메인으로" class="btn btn-success"
					onclick="javascript:window.location='../'">
					<p></p>
				</td>
			</tr>
		</table>
	</form>
	<br /> <br />
</section>
<%@include file="../include/footer.jsp"%>

