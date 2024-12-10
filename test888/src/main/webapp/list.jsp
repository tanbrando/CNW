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
    <div style="width: 100%;
                display: flex;
                justify-content: space-between;">
        <div>
            <form action="list" method="get">
                <select name="department" style="height:32px">
                    <option value="">--Chọn Khoa--</option>
                    <option value="Khoa Toán">Khoa Toán</option>
                    <option value="Khoa Vật Lý">Khoa Vật Lý</option>
                    <option value="Khoa Hóa">Khoa Hóa</option>
                    <option value="Khoa Công Nghệ Thông Tin">Khoa Công Nghệ Thông Tin</option>
                </select>
                <button type="submit" style="height:32px">Tìm</button>
            </form>
        </div>

        <a  href="../Student/insert" 
            style="text-decoration: none;
                   padding: 10px 20px;
                   background-color: #333;
                   color: #fff;">
            Thêm
        </a>
    </div>
    <table width="100%">
        <tr style="border-bottom: #333 2px solid;
                   background-color: #777;
        		   height:32px; ">
            <th>ID</th>
            <th>Họ tên</th>
            <th>Giới tính</th>
            <th>Khoa</th>
            <th></th>
        </tr>

        <%
            ArrayList<Student> studentList = (ArrayList<Student>) request.getAttribute("studentList");
            for(int i = 0; i < studentList.size(); i++) {
                Student student = studentList.get(i);
        %>
        <tr style="border-bottom: #333 1px solid;
        		   height:32px;	">
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getGender() %></td>
            <td><%= student.getDepartment() %></td>
            <td style="display: flex;
                       justify-content: center;">
                <a href="../Student/delete?id=<%= student.getId()%>" style="text-decoration: none; color: #f00;">Xóa</a>
                <a href="../Student/edit?id=<%= student.getId()%>" style="text-decoration: none; color: #00f; margin-left:10px;">Sửa</a>
            </td>
        </tr>
        <%  }   %>
    </table>
</body>
</html>