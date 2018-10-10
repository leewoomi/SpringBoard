<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<section class="content">
	<!-- 회원가입 -->
	<form id="registerform" enctype="multipart/form-data" method="post"
		onsubmit="return check()">
		<p align="center">
		<table border="1" width="50%" height="80%" align='center'>
			<tr>
				<td colspan="3" align="center"><h2>회원 가입</h2></td>
					<tr>
				<td rowspan="5" align="center">						<p></p>
				<img id="img" width="100" height="100" border="1" /> <br />
				<br /> <input type='file' id="image" name="image" /><br /></td>
			</tr>

			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;이메일</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="email" name="email"
					id="email" size="30" maxlength=50 onblur="confirmId()"
					required="required" />
					<div id="emailDiv"></div>
				</td>
			</tr>
			
					<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;비밀번호</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="password" name="pw" id="pw"
					size="20" required="required" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;비밀번호 확인</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="password" id="pwconfirm" 
					size="20" required="required" />
				</td>
			</tr>
			<tr>
				<td width="17%" bgcolor="#f5f5f5"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;이름</font></td>
				<td>&nbsp;&nbsp;&nbsp; <input type="text" name="nickname"
size="20" pattern="([a-z, A-Z, 가-힣]){2,}" required="required"
					title="닉네임은 문자 2자 이상입니다." />
				</td>
			</tr>
					<tr>
				<td align="center" colspan="3">
					<p></p> <input type="submit" value="회원가입" class="btn btn-warning" />
					<input type="button" value="메인으로" class="btn btn-success"
	onclick="javascript:window.location='../'">
					<p></p>
				</td>
			</tr>
		</table>
	</form>
	<br />
	<br />
</section>
<%@include file="../include/footer.jsp"%>

<script>
	var filename = ''
	//change 이벤트가 발생하면 readURL 호출
	//change - 내용이 변경되면 호출되는 이벤트
	document.getElementById("image").addEventListener('change', function() {
		readURL(this);
	});
	//이미지파일을 선택했을 때 미리보기를 수행해주는 메소드
	function readURL(input) {
		if (input.files && input.files[0]) {
			filename = input.files[0].name;
			var ext = filename.substr(filename.length - 3, filename.length);
			var isCheck = false;
			if ((ext.toLowerCase() == "jpg" || ext.toLowerCase() == "gif" || 
				 ext.toLowerCase() == "png")) {
				isCheck = true;
			}
			if (isCheck == false) {
				alert("jpg나 gif, png 만 업로드가 가능합니다.");
				return;
			}
			var reader = new FileReader();

			reader.onload = function(e) {
				document.getElementById('img').src = e.target.result;
			}
			reader.readAsDataURL(input.files[0]);
		}
	};
	
	
	
	//아이디 중복검사 여부를 저장할 변수 
	//이 변수 값이 false면 중복 검사를 통과하지 못한 것.
	var idcheck= false;

	function confirmId() {
		var addr = "idcheck";
		//email 란의 값을 가져옴.
		var email = document.getElementById("email").value;
		//email 값을 가지고 중복 검사를 위한 ajax 요청 
		$.ajax({
			url : addr,
			data : {
				'email' : email
			},
			dataType : "json",
			
			success : function(data) {
				if (data.result == true) {
					document.getElementById("emailDiv").innerHTML = "사용 가능한 아이디입니다.";
					document.getElementById("emailDiv").style.color='blue';
					idcheck = true;
				} else {
					document.getElementById("emailDiv").innerHTML = "사용 불가능한 아이디입니다.";
					document.getElementById("emailDiv").style.color='red';
					idcheck=false
				}
			}
		});
	}

</script>


		