<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String user_id = request.getParameter("user_id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>testMain</h1>
					<%
							  if( session.isNew()){
								 session.setAttribute("loginState", "logout");
								 session.setAttribute("userid", null);
								 session.setAttribute("userpw", null);
							  }
							
	
								if( session.getAttribute("loginState").equals("login")){
									
							%>

									<a href="/user/showmodifyController?user_id=<%=session.getAttribute("userid")%>" class="flex-c-m trans-04 p-lr-25">
										<%=session.getAttribute("userid")%>님
									</a>

									<a href="/user/logout" class="flex-c-m trans-04 p-lr-25">
										로그아웃
									</a>
									
									<a href="/user/list" class="flex-c-m trans-04 p-lr-25">
										회원목록
									</a>
							<%
								  } else{
							%>  
							
									<a href="login" class="flex-c-m trans-04 p-lr-25">
										로그인
									</a>

									<a href="join" class="flex-c-m trans-04 p-lr-25">
										회원가입
									</a>
								<%
								 }
								%>
</body>
</html>