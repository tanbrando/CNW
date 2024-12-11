<%@ page import="model.BEAN.Department" %>
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
	<div class="formBox">
        <h3 class="title">
            Cập nhật thông tin phòng ban
        </h3>
        <form method="post" action="">
        	<%
        		{ Department department = (Department) request.getAttribute("department");
        	%>
            <div class="inputGroup">
                <label for="IDPB">Mã phòng ban</label>
                <input type="text" id="IDPB" name="IDPB" readonly value="<%=department.getID() %>">
            </div>
            <div class="inputGroup">
                <label for="Tenphongban">Tên phòng ban</label>
                <input type="text" id="Tenphongban" name="Tenphongban" value="<%=department.getName() %>">
            </div>
            <div class="inputGroup">
                <label for="Mota">Mô tả</label>
                <textarea id="Mota" name="Mota"><%=department.getDetail() %></textarea>
            </div>
            <div  class="inputGroup--btn">
                <input type="submit" value="OK" id="submitBtn">
                <button type="reset">Reset</button>            
            </div>
            <% } %>
        </form>
    </div>
</body>
</html>