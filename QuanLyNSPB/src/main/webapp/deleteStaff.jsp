<%@ page import="java.util.ArrayList, model.BEAN.Staff" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
	<title>Xóa nhân viên</title>
</head>
<body>
	<jsp:include page="/partials/navbar.jsp"/>
	<table width="100%" class="table">
        <caption>Dữ liệu bảng Nhân viên</caption>
        <tr class="">
            <th>IDNV</th>
            <th>Họ tên</th>
            <th>Địa chỉ</th>
            <th>Thao tác</th>
        </tr>
		<% 
			ArrayList<Staff> staffList = (ArrayList<Staff>) request.getAttribute("staffList");
			for(int i = 0; i < staffList.size() ; i++) {
				Staff staff = staffList.get(i);
		%>
            <tr>
            	<td><%= staff.getID() %></td>
            	<td><%= staff.getName() %></td>
            	<td><%= staff.getAddress() %></td>
            	<td><a href="${pageContext.request.contextPath}/Staff/delete?id=<%= staff.getID() %>">Xóa</a></td>
            </tr>
         <% } %>
    </table>
</body>
</html>