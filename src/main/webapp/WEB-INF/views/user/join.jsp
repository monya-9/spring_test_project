<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<form action="/user/join" method="POST">
	<label>아이디:</label><input name="user_id" id="user_id" type="text" class="id" placeholder="아이디를 입력해주세요."> <br>
	<label>비밀번호:</label><input name="user_pw" id="user_pw" type="password" class="pw" placeholder="비밀번호를 입력해주세요."> <br>
	<label>이름:</label><input name="user_name" id="user_name" type="text" class="name" placeholder="이름을 입력해주세요."> <br>
      <label>생년월일</label><input name="user_birth" id="user_birth" type="date" class="birth" placeholder="생년월일" > <br>
	<label>이메일:</label><input name="user_email" id="user_email" type="email" class="email" placeholder="이메일을 입력해주세요."> <br>
	<label>권한:</label> <br>
	<label><input type='radio' name="user_class" id="user_class" value='관리자' />관리자</label>
  	<label><input type='radio' name="user_class" id="user_class" value='일반' />일반</label> <br>
	<label>성별:</label> <br>
	<label><input type='radio' name="user_gender" id="user_gender" value='여성' />여성</label>
  	<label><input type='radio' name="user_gender" id="user_gender" value='남성' />남성</label>
	
      <input type="hidden" name="actionType" value="join">
      <input type="submit" class="btn" value="회원가입"/>
</form>
	

</body>
</html>