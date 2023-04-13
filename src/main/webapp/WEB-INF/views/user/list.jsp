<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.example.spring.test.model.userDTO"%>
     <% userDTO user; %>
	<%
		ArrayList<userDTO> userList;
		userList = (ArrayList<userDTO>)request.getAttribute("userList");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="p-t-100">
	<div>
		<h2>상품 정보(관리자)</h2>
		<hr>
		<br>
			<table border="1">
		      <thead>
		         <tr>
		            <th>아이디</th>
		            <th>비밀번호</th>
		            <th>이름</th>
		            <th>생년월일</th>
		            <th>이메일</th>
		            <th>권한</th>
		            <th>성별</th>
		            <th>삭제</th>
		         </tr>
		      </thead>
		      <tbody>
		      <%
				   for(int i=0; i<userList.size(); i++) {
					   user = userList.get(i);
				%>
		       <tr>
		         <td><%=user.getUser_id()%></td>
		         <td><%=user.getUser_pw()%></td>
		         <td><%=user.getUser_name()%></td>
		         <td><%=user.getUser_birth()%></td>
		         <td><%=user.getUser_email()%></td>
		         <td><%=user.getUser_class()%></td>
		         <td><%=user.getUser_gender()%></td>
		         <%-- <td><a href="./productController.pc?actionType=productInquiry&product_no=<%=product.getProduct_no()%>">수정</a></td> --%>
		         <td><a href="/user/delete?user_id=<%=user.getUser_id()%>">삭제</a></td>
		      </tr>
		      <%
				   }
				%>
		      </tbody>
	      </table>
	</div>
</section>
<br>
</body>
</html>