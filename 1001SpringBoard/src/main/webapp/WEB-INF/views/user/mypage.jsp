<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<section class="content">
	<!--My Page -->
	<h2 align="center">마이 페이지</h2>
	<div align="center">
		<table>
			<tr>
				<td rowspan="2"><p>
						<img id="img" width="100" height="100" border="1"
							src="../userimage/${user.image}" />
					</p>
					<p align="right"><input type="button"  value="변경"/></p>
					</td>
				<td>
					<p>닉네임 : ${user.nickname}</p>

				</td>
			</tr>
			<tr>
				<td>
					<p>이메일 : ${user.email}</p>
				</td>
			</tr>
		</table>
	</div>
	<br /> <br />
</section>
<%@include file="../include/footer.jsp"%>



