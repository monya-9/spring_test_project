<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.example.spring.test.model.userDTO"%>
    <% userDTO user = (userDTO)request.getAttribute("user"); %>
    <% String user_id = request.getParameter("user_id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
</head>
<body>
	<form action="/user/modifyController" method="GET">                                                                           
      <h2>회원 정보 수정</h2>
      <div class="textForm">
        <input type="text" name="user_id" size="30" value="<%=user.getUser_id()%>" readonly>
      </div>
      <div class="textForm">
        <input name="user_pw" id="user_pw" type="password" class="pw" placeholder="비밀번호" value="<%=user.getUser_pw()%>">
      </div>
      <div class="eheck_font" id="pw_check"></div>
      
       <!-- <div class="textForm">
        <input name="user_pw2" id="user_pw2" type="password" class="pw" placeholder="비밀번호 확인">
      </div>
      <div class="eheck_font" id="pw2_check"></div> -->
      
      <div class="textForm">
        <input name="user_name" id="user_name" type="text" class="name" placeholder="이름" value="<%=user.getUser_name()%>">
      </div>
      <div class="eheck_font" id="name_check"></div>
      
      <div class="textForm">
        <input name="user_birth" type="text" class="cellphoneNo" placeholder="생년월일" value="<%=user.getUser_birth()%>">
      </div>
      
       <div class="textForm">
        <input name="user_email" id="user_email" type="email" class="email" placeholder="이메일" value="<%=user.getUser_email()%>">
      </div>
      <div class="eheck_font" id="email_check"></div>
      
      <div class="textForm">
        <input name="user_class" id="user_class" type="text" class="cellphoneNo" placeholder="권한" value="<%=user.getUser_class()%>">
      </div>
      
      <div class="textForm">
        <input name="user_gender" id="user_gender" type="text" class="cellphoneNo" placeholder="성별" value="<%=user.getUser_gender()%>">
      </div>
        <div class="eheck_font" id="phone_check"></div>
      
      <input type="submit" class="btn" value="수정"/>
    </form>
</body>
</html>