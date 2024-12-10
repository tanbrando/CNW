<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/main.css">
    <title>Test666</title>
</head>
<body>
    <div class="form">
        <h1>Đăng nhập</h1>
        <form action="./controller/AuthController.php?action=login" method="POST">
            <div class="input-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="input-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="input-group--btn">
                <input type="submit" value="Đăng nhập">
                <button type="reset">Làm mới</button>
            </div>
        </form>
    </div>
</body>
</html>