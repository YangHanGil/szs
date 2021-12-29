<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
	<meta id="_csrf" name="_csrf" th:content="${_csrf.token}"/>
	<meta id="_csrf_header" name="_csrf_header" th:content="${_csrf.headerName}"/>

	<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<script src="http://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
<script type="text/javascript" src="http://localhost:8080/js/common.js"></script>
<script type="text/javascript">


	window.onload = function(){
		
		const msg = "<%=msg%>"
		if(msg!="null") alert("<%=msg%>"); 
		
	}
</script>

<form name="signForm" action="/sign/signup" method="post" enctype="multipart/form-data" onsubmit="">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
	<div>
		<input type="email" id="userId" name="userId" size="100" placeholder="아이디(이메일)">
	</div>
	<div>
		<input type="password" id="password" name="password" size="100" placeholder="비밀번호">
	</div>
	<div>
		<input type="text" id="name" name="name" size="20" placeholder="이름" value="홍길동">
	</div>
	<div>
		<input type="password" id="fRegNo" name="fRegNo" maxlength="6" placeholder="앞번호" value="860824"> 
		- 
		<input type="password" id="lRegNo" name="lRegNo" maxlength="7" placeholder="뒷번호" value="1655068">
	</div>
	<input type="submit" value="완료" >
    
</form>

</body>
</html>