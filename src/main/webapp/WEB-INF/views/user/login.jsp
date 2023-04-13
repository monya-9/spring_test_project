<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<form action="/user/login" method="POST">                                                                           
	      <h2>로그인</h2>
	      <div class="textForm">
	        <input name="user_id" type="text" class="id" placeholder="아이디">
	        </input>
	      </div>
	      <div class="textForm">
	        <input name="user_pw" type="password" class="pw" placeholder="비밀번호">
	      </div>
	      <input type="hidden" name="actionType" value="login">
	      <input type="submit" class="btn" value="로그인"/>
	    </form>
</body>
</html>