<%@ page import="java.util.ArrayList, model.BEAN.Department" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
	<title>Cập nhật phòng ban</title>
</head>
<body>
	<jsp:include page="/partials/navbar.jsp"/>
	<table width="100%" class="table">
        <caption>Dữ liệu bảng Phòng ban</caption>
        <tr class="">
            <th>IDPB</th>
            <th>Tên Phòng Ban</th>
            <th>Mô tả</th>
            <th>Thao tác</th>
        </tr>
		<% 
			ArrayList<Department> departmentList = (ArrayList<Department>) request.getAttribute("departmentList");
			for(int i = 0; i < departmentList.size() ; i++) {
				Department department = departmentList.get(i);
		%>
            <tr>
            	<td><%= department.getID() %></td>
            	<td><%= department.getName() %></td>
            	<td><%= department.getDetail() %></td>
            	<td><a href="${pageContext.request.contextPath}/Department/edit?id=<%= department.getID() %>">Cập nhật</a></td>
            </tr>
         <% } %>
    </table>
</body>
</html>