<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 외부 CSS 연결 --><!-- JSP,CSS,IMG -->
	<!-- <link href="/resources/CSS/member.css" rel="stylesheet" type="text/css">
	<link href="./resources/CSS/member.css" rel="stylesheet" type="text/css"> -->
	<link href="${pageContext.request.contextPath }/resources/CSS/member.css" rel="stylesheet" type="text/css">

	<style type="text/css">
		/* h3{
			color: blue;		
		} */
	</style>


</head>
<body>

	<h1>WEB-INF/views/member/info.jsp</h1>
	
	<h1> 회원 정보 확인 </h1>
	
	${memVO }
	
	<h3> 아이디 : ${memVO.userid } </h3>
	<h3> 이름 : ${memVO.username }</h3>
	<h3> 비밀번호 : ${memVO.userpw }</h3>
	<h3> 이메일 : ${memVO.useremail }</h3>
	<h3> 가입일 : ${memVO.regdate }</h3>
	<h3> 정보수정 : ${memVO.updatedate }</h3>
	
	<a href="/member/main"> 메인페이지로 이동 </a>

</body>
</html>