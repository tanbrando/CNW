<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<title>Đăng nhập</title>
</head>
<body>
	<jsp:include page="/partials/navbar.jsp"/>
	<div class="formBox">
        <p class="title">Tìm kiếm nhân viên</p>
        <form method="POST" action="login">
            <div class="inputGroup">
                <label for='username'>Tên đăng nhập: </label>
                <input type='text' id='username' name='username' required>
            </div>
            <div class="inputGroup">
                <label for='password'>Mật khẩu : </label>
                <input type='password' id='password' name='password' required>
            </div>
            <div class="inputGroup--btn">
                <input type='submit' value='OK'>
                <button type='reset'>Reset</button>
            </div>  
        </form>
    </div>
</body>
</html>