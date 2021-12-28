<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<script src="http://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
<script type="text/javascript" src="http://localhost:8080/js/common.js"></script>
<script type="text/javascript">

	
	function signin(){
		$('#F_EMAIL').val($('#F_EMAIL').val());
		if (!Common.isEmail($.trim($("#F_EMAIL").val()))) {
			alert('이메일을 입력하여 주시기 바랍니다.');
			return false;
		}if($('#F_EMAIL').val().match(Common.emlPattern) == null){
			alert('이메일 유형이 옳지 않습니다. 예)example@example.com');
			$('#F_EMAIL').val('');
			return false;
		}
		var formdata = {
			'F_EMAIL' : $('#F_EMAIL').val()
		}
		Common.call("http://localhost:8080/sign/signin", formdata, function(data){
			if (!data) {
				alert('등록 불가능한 아이디입니다.');
				EmailChk = false;
				return false;
			} else {
				alert('등록 가능한 아이디입니다.');
				EmailChk = true;
			}
		}, false);
	}
</script>

<form action="" method="post" enctype="multipart/form-data" onsubmit="return selectUserFemail()">
    <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />

    <div>
    	<input type="email" id="userId" name="userId" size="100" placeholder="아이디">
    </div>
    <div>
    	<input type="password" id="password" name="password" size="100" placeholder="비밀번호">
    </div>
    <div>
    	<input type="text" id="name" name="name" size="20" placeholder="이름">
    </div>
    <div>
    	<input type="password" id="fRegNo" name="fRegNo" size="6" placeholder="앞번호"> - <input type="password" id="lRegNo" name="lRegNo" size="7" placeholder="뒷번호">
    </div>
    <input type="submit" value="완료">
    
</form>

</body>
</html>