<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>

<title>로그인</title>
</head>
<body>

<script src="http://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
<script type="text/javascript" src="http://localhost:8080/js/common.js"></script>
<script type="text/javascript">
window.onload = function(){
	
	const msg = "<%=msg%>"
	if(msg!="null") alert("<%=msg%>"); 
	
}

function login(){

	var parameter = $('meta[name="_csrf_parameter"]').attr('content')
	var header = $("meta[name='_csrf_header']").attr("content");
	var token = $("meta[name='_csrf']").attr("content");
	
// 	var formdata = $("form[name=loginForm]").serialize() ;
	var formdata = {
			"userId" : $("#userId").val(),
			"password" : $("#password").val()
	}
	console.dir(formdata)
	
	
	Common.call("${pageContext.request.contextPath}/szs/login/do", formdata, function(data){
		console.log(data);
	}, false, header, token);
}
</script>

<h1>로그인</h1>
<hr>
<form name="loginForm" method="post" enctype="multipart/form-data" >
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
	<input type="text" id="userId" name="userId" placeholder="아이디">
	<input type="password" id="password" name="password" placeholder="비밀번호">
	<button type="button" onclick="login()">로그인</button>
	
	<a href="/szs/signin">회원가입하기</a>
</form>

</body>
</html>