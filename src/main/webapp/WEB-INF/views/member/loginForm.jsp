<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WEB-INF/views/member/loginForm.jsp</h1>
	<h1>로그인</h1>
	
	<fieldset>
	  <legend> ITWILL 로그인 </legend>
	  <!-- action="" 속성값이 없을 경우 자기자신 페이지 호출
	  		/member/login(post) 
	   -->
		<form action="" method="post">
			아이디 : <input type="text" name="userid"><br>		
			비밀번호 : <input type="password" name="userpw"><br>
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onclick="location.href='/member/insert'">
		</form>
	</fieldset>

</body>
</html>