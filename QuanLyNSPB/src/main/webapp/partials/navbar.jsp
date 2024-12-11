<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="header">
	    <h3 class="logo">QLNSPB</h3>
	    <div class="navbar">
	        <ul>
	            <li>
	                <a href="${pageContext.request.contextPath}/Department/list" class="navbar__item">Danh sách phòng ban</a>
	            </li>
	            <li>
	                <a href="${pageContext.request.contextPath}/Staff/list" class="navbar__item">Danh sách nhân viên</a>
	            </li>
	            <li>
	                <a href="${pageContext.request.contextPath}/Staff/search" class="navbar__item">Tìm kiếm nhân viên</a>
	            </li>
	        </ul>
	        <ul>
	        	<%
	        		Object account = session.getAttribute("account");
	        		if (account != null) {
	        	%>
        		<li><a href="${pageContext.request.contextPath}/Staff/insert" class="navbar__item">Chèn nhân viên</a></li>
               	<li><a href="${pageContext.request.contextPath}/Department/editList" class="navbar__item">Cập nhật phòng ban</a></li>
               	<li><a href="${pageContext.request.contextPath}/Staff/delete" class="navbar__item">Xóa nhân viên</a></li>
                <li><a href="${pageContext.request.contextPath}/Staff/deleteAll" class="navbar__item">Xóa nhiều nhân viên</a></li>
                <li><a href="${pageContext.request.contextPath}/Auth/logout" class="navbar__item">Đăng xuất</a></li>
                <% } else { %>
                <li><a href="${pageContext.request.contextPath}/Auth/login" class="navbar__item">Đăng nhập</a></li>
                <% } %>
	        </ul>
	    </div>
	</div>
	<div style="height:120px"></div>