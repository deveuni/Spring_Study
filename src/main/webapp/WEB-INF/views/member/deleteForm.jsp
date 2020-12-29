<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WEB-INF/views/member/deleteForm.jsp</h1>
	<h1>회원 탈퇴</h1>
	
	<fieldset>
		<form action="" method="post">
		ID : <input type="text" name="userid" value="${memVO.userid }" readonly><br>
		PW : <input type="password" name="userpw" value=""><br><br>
		
		<input type="submit" value="회원탈퇴">
		</form>
	</fieldset>


</body>
</html>