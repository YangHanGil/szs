<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>
</head>
<body>

<script type="text/javascript">
window.onload = function(){
	
	const msg = "<%=msg%>"
	if(msg!="null") alert("<%=msg%>"); 
	
}
</script>
<a href="/szs/login">로그인하기</a>
<a href="szs/signin">회원가입하기</a>
</body>
</html>