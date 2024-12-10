<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test888</title>
</head>
<body>
    <div style="width: 400px;
                margin: 0 auto;">
        <h1>Đăng nhập hệ thống</h1>
        <form action="" method="post">
            <div style="display: flex;
                        justify-content: space-between;
                        width: 100%;
                        height:32px;
                        margin: 10px 0;">
                <label for="username">Tên đăng nhập</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div style="display: flex;
                        justify-content: space-between;
                        width: 100%;
                        height:32px;
                        margin: 10px 0;">
                <label for="password">Mật khẩu:</label>
                <input type="password" id="password" name="password" required>
            </div>

            <div style="display: flex;
                        justify-content: center;
                        width: 100%;
                        height:32px;
                        margin: 10px 0;">
                <input type="submit" value="Đăng nhập">
                <button type="reset" style="margin-left: 10px;">Hủy</button>
            </div>
        </form>
    </div>
</body>
</html>