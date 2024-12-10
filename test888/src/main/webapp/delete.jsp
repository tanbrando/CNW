<%@ page import="java.util.ArrayList, model.BEAN.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div style="width: 400px;
                margin: 0 auto;">
        <h1>Thêm mới sinh viên</h1>
        <form action="" method="post">
            <%
                Student student = (Student) request.getAttribute("student");
            %>
            <div style="display: flex;
                        justify-content: space-between;
                        width: 100%;
                        height:32px;
                        margin: 10px 0;">
                <label for="id">Mã SV</label>
                <input type="text" id="id" name="id" required readonly value="<%=student.getId()%>">
            </div>
            <div style="display: flex;
                        justify-content: space-between;
                        width: 100%;
                        height:32px;
                        margin: 10px 0;">
                <label for="name">Họ tên</label>
                <input type="text" id="name" name="name" readonly required value="<%=student.getName()%>">
            </div>
            <div style="display: flex;
                        justify-content: space-between;
                        width: 100%;
                        height:32px;
                        margin: 10px 0;">
                <label for="gender">Giới tính</label>
                <div style="display:flex;
                			align-items:center;">
                <% if (student.getGender().equals("nam")) {%>
                    <input type="radio" id="male" name="gender" value="Nam" readonly checked>
                    <label for="male">Nam</label>
                    <input type="radio" id="female" name="gender" readonly value="Nữ">
                    <label for="female">Nữ</label>
                <% } else { %>
                    <input type="radio" id="male" name="gender" readonly value="Nam">
                    <label for="male">Nam</label>
                    <input type="radio" id="female" name="gender" readonly value="Nữ" checked>
                    <label for="female">Nữ</label>
                <% } %>
                </div>
            </div>

            <div style="display: flex;
                        justify-content: space-between;
                        width: 100%;
                        height:32px;
                        margin: 10px 0;">
                <label for="department">Khoa</label>
                <select name="department" id="department" disabled value="<%=student.getDepartment()%>">
                    <option value="">--Chọn Khoa--</option>
                    <option value="Khoa Toán">Khoa Toán</option>
                    <option value="Khoa Vật Lý">Khoa Vật Lý</option>
                    <option value="Khoa Hóa">Khoa Hóa</option>
                    <option value="Khoa Công Nghệ Thông Tin">Khoa Công Nghệ Thông Tin</option>
                </select>
            </div>

            <div style="display: flex;
                        justify-content: center;
                        width: 100%;
                        height:32px;
                        margin: 10px 0;">
                <input type="submit" value="Xóa">
                <button type="reset" style="margin-left: 10px;" onclick="javascript:history.back()">Quay lại</button>
            </div>
        </form>
    </div>
</body>
</html>