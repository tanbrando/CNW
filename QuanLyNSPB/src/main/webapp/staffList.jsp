<%@ page import="java.util.ArrayList, model.BEAN.Staff" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
	<title>Danh sách nhân viên</title>
</head>
<body>
	<jsp:include page="/partials/navbar.jsp"/>
	<table width="100%" class="table">
        <caption>Dữ liệu bảng Nhân viên</caption>
        <tr class="">
            <th>IDNV</th>
            <th>Họ tên</th>
            <th>IDPB</th>
            <th>Địa chỉ</th>
        </tr>
		<% 
			ArrayList<Staff> staffList = (ArrayList<Staff>) request.getAttribute("staffList");
			for(int i = 0; i < staffList.size() ; i++) {
				Staff staff = staffList.get(i);
		%>
            <tr>
            	<td><%= staff.getID() %></td>
            	<td><%= staff.getName() %></td>
            	<td><%= staff.getDepartmentID() %></td>
            	<td><%= staff.getAddress() %></td>
            </tr>
         <% } %>
    </table>
</body>
</html>