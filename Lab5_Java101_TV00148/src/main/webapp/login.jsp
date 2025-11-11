<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bai3</title>
</head>
<body>
<h2>Đăng nhập</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
    Username: <input name="username" value="${username != null ? username : ''}"><br><br>
    Password: <input name="password" type="password" value="${password != null ? password : ''}"><br><br>
    <input type="checkbox" name="remember-me" ${username != null ? "checked" : ""}> Remember me<br><br>
    <button type="submit">Login</button>
</form>

<p style="color:red">${message}</p>
</body>
</html>
