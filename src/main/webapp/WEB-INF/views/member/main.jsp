<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WEB-INF/views/member/main.jsp</h1>
	<h1>메인페이지</h1>
	
	<%
		String id = (String)session.getAttribute("id");
	
	if(id == null){
		// 로그인 페이지로 이동
		response.sendRedirect("/member/login");
	}
		
	%>
	
	<h2>ID(JSP) : <%=id %></h2>
	<h2>ID(EL) : ${id }</h2>

	<input type="button" value="로그아웃" onclick="location.href='/member/logout'">


	<hr>
	<h2> 사용자 이름 : ${mvo.username}</h2>
	<h2> 사용자 이메일 : ${mvo.useremail}</h2>
	
	<hr>
	<h2> <a href="/member/info">회원정보 확인</a> </h2>
	<h2> <a href="/member/update">회원정보 수정</a> </h2>
	<h2> <a href="/member/delete"> 회원정보 삭제 </a></h2>
	
	
	<%
		if(id != null || id.equals("admin")){
	%>
	
	<h2> <a href="/member/list">회원정보 리스트</a> </h2>

	<%
		}
	%>


</body>
</html>