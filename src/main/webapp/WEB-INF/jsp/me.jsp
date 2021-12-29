<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>개인정보</title>
</head>
<body>
<script type="text/javascript">
window.onload = function(){
	
	const msg = "<%=msg%>"
	if(msg!="null") alert("<%=msg%>"); 
	
}
</script>

	szs 로그인함

</body>
</html>