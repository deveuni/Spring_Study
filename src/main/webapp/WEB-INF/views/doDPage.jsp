<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>WEB-INF/views/doDPage.jsp</h1>
	
	<h2> 컨트롤러에서 전달된 객체 정보 </h2>
	<h2> 상품명 : ${vo.name }</h2>
	<h2> 가격 : ${vo.price}</h2>
	
	<hr>
	<h2> 상품명 : ${productVO.name }</h2>
	<h2> 가격 : ${productVO.price}</h2>
	

</body>
</html>