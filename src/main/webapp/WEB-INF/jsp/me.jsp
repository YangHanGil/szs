<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��������</title>
</head>
<body>
<script type="text/javascript">
window.onload = function(){
	
	const msg = "<%=msg%>"
	if(msg!="null") alert("<%=msg%>"); 
	
}
</script>

	szs �α�����

</body>
</html>