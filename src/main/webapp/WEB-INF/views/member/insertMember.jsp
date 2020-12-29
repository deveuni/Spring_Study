<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WEB-INF/views/member/insertMember.jsp</h1>
	<h1>views의 폴더명은 컨트롤러의 모듈명과 동일</h1>
	<h1> 회원가입 페이지 </h1>
	
	<!-- input 태그안의 name은 membervo에서의 객체의 이름과 동일하게 함. -->
	<fieldset>
		<legend>ITWILL 회원가입</legend>
		<form action="/member/insert" method="post">
			ID : <input type="text" name="userid"><br>
			PW : <input type="password" name="userpw"><br>
			NAME : <input type="text" name="username"><br>
			EMAIL : <input type="text" name="useremail"><br>
		
			<input type="submit" value="회원가입">
		</form>
	</fieldset>	

</body>
</html>