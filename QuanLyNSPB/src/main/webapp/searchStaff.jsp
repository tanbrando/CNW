<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
	<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/partials/navbar.jsp"/>
	<div class="formBox">
        <p class="title">Tìm kiếm nhân viên</p>
        <form method="get" action="list">
            <div class="inputGroup--radio">
                <div class="radioGroup">
                    <label for='idnv'>IDNV</label>
                    <input type='radio' id='idnv' name='searchObject' value='IDNV' style="margin:auto 4px">
                </div>
                <div class="radioGroup">
                    <label for='hoten'>Họ Tên</label>
                    <input type='radio' id='hoten' name='searchObject' value='Hoten' style="margin:auto 4px">
                </div>
                <div class="radioGroup">
                    <label for='diachi'>Địa Chỉ</label>
                    <input type='radio' id='diachi' name='searchObject' value='Diachi' style="margin:auto 4px">
                </div>
            </div>
            <div class="inputGroup">
                <label for='searchData'>Nhập vào thông tin : </label>
                <input type='text' id='searchData' name='searchData'>
            </div>
            <div class="inputGroup--btn">
                <input type='submit' value='OK'>
                <button type='reset'>Reset</button>
            </div>  
        </form>
    </div>
</body>
</html>