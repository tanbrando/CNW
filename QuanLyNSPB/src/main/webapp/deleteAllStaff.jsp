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
            	<td><input type='checkbox' class='checkbox' id = "<%=staff.getID() %>"></td>
            </tr>
         <% } %>  	
       	<tr><td colspan="4"><button onclick='deleteItem()'>Xóa tất cả</button></td></tr>
    </table>
    <script>
         function deleteItem() {
             var checkboxes = document.getElementsByClassName("checkbox");
             var url = "deleteAll?"
             for (var i = 0; i < checkboxes.length; i++) {
                 if (checkboxes[i].checked) {
                     var id = checkboxes[i].id;
                     url += "idList="+ id +"&";
                 }
             }
             window.location.href = url;
         }
     </script>
</body>
</html>