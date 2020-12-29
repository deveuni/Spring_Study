<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WEB-INF/views/member/memberlist.jsp</h1>
	
	<table border="1">
     <tr>
       <td>아이디</td>
       <td>비밀번호</td>
       <td>이름</td>
       <td>이메일</td>
       <td>가입일자</td>
       <td>정보수정일</td>       
     </tr>
     
     <c:forEach var="mlist" items="${memberList }">
     	<tr>
		  <td>${mlist.userid }</td>     	
		  <td>${mlist.userpw }</td>     	
		  <td>${mlist.username }</td>     	
		  <td>${mlist.useremail }</td>     	
		  <td>${mlist.regdate }</td>     	
		  <td>${mlist.updatedate }</td>     	
     	</tr>
     </c:forEach>
    
    
    </table>
    
    <h2> <a href="/member/main">main 페이지</a></h2>
	

</body>
</html>