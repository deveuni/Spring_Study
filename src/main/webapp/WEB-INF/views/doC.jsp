<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/WEB-INF/views/doC.jsp</h1>
	
	<!-- 
	둘다 사용 가능하지만 
	페이지 안정성을 위해서 el표현식쓰기 - 데이터가 null 일 때 빈공백으로 출력(컴파일 에러X)
								   request는 에러나면 nullpointexception이 뜸 
	-->
	<h2> 전달 데이터 : <%=request.getParameter("msg") %> </h2>
	<!-- 주소에 바로 msg파라미터에 저장되므로 정보 가져감 -->
	<h2> 전달 데이터(el) : ${msg }</h2>
	<!-- el표현식은 컨트롤러에 거쳐서 전달되므로 컨트롤러에 저장된 msg1에 저장된 파라미터만 불러올 수 있음. -->
	

</body>
</html>