<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
	<title>Chèn thông tin nhân viên</title>
</head>
<body>
	<jsp:include page="/partials/navbar.jsp"/>
	<div class="formBox">
        <h3 class="title">
            Chèn thông tin nhân viên
        </h3>
        <form action="insert" method="post">
            <div class="inputGroup">
                <label for="IDNV">Mã nhân viên</label>
                <input type="text" id="IDNV" name="IDNV">
            </div>
            <div class="inputGroup">
                <label for="Hoten">Họ tên</label>
                <input type="text" id="Hoten" name="Hoten">
            </div>
            <div class="inputGroup">
                <label for="IDPB">Mã phòng ban</label>
                <select id="IDPB" name="IDPB">
	                <%
	                	ArrayList<String> departmentIDList = (ArrayList<String>) request.getAttribute("departmentIDList");
	                	
	                	for (int i = 0; i<departmentIDList.size();i++) {
	                		
	                %>
                	<option value="<%= departmentIDList.get(i)%>"><%= departmentIDList.get(i)%></option>
                	<% } %>
                </select>
            </div>
            <div class="inputGroup">
                <label for="Diachi">Địa chỉ</label>
                <input type="text" id="Diachi" name="Diachi">
            </div>
            <div class="inputGroup--btn">
                <input type="submit" value="OK" id="submitBtn">
                <button type="reset">Reset</button>            
            </div>
        </form>
        <script type="text/javascript">
            document.getElementById('submitBtn').onclick = function(event) {
                var IDNV = document.getElementById('IDNV').value;
                var IDNVList = [
                	<%
                		ArrayList<String> idList = (ArrayList<String>) request.getAttribute("idList");
                		for (int i = 0;i < idList.size();i++) {
                	%>	
                	"<%=idList.get(i)%>"<%= i < idList.size() - 1 ? "," : " " %>
                	<% } %>
                ];
                if (IDNVList.includes(IDNV)) {
                    event.preventDefault();
                    alert("Mã nhân viên đã tồn tại!");
                }
            }

        </script>
    </div>
</body>
</html>