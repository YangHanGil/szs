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

	const msg = "<%=msg%>";
	if(msg != "null"){
		alert(msg);
	}

	let EmailChk = false;
	$(function(){
		$('#selectUserFemail').click(function() {
			selectUserFemail();
			alert("dsds");
		});
	});
	
	function selectUserFemail(){
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
		Common.call("http://localhost:8080/regist/selectUserFemail", formdata, function(data){
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

<form action="/regist/insertUser" method="post" enctype="multipart/form-data" onsubmit="return selectUserFemail()">
    <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />

    <div>
    	<input type="email" id="F_EMAIL" name="F_EMAIL" size="100" placeholder="이메일"> <button type="button" onclick="selectUserFemail()"> 아이디중복체크</button>
    </div>
    <div>
    	<input type="password" id="F_PASS" name="F_PASS" size="100" placeholder="비밀번호">
    </div>
    <div>
    	<input type="text" id="F_NAME" name="F_NAME" size="20" placeholder="이름">
    </div>
    <div>
    	<input type="text" id="F_NICKNAME" name="F_NICKNAME" size="30" placeholder="별명(20자 이내)">
    </div>
    <div>
    	<input type="text" id="F_HP" name="F_HP" size="20" placeholder="전화번호">
    </div>
    <div>
    	<span> 성별 : </span>
		<input type="radio" name="F_GENDER" value="M"> <label> 남자</label>
		<input type="radio" name="F_GENDER" value="F"> <label> 여자</label>?
    </div>
    <input type="submit" value="완료">
    
</form>

</body>
</html>