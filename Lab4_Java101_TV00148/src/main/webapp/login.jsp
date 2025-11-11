<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bai1</title>
</head>
<body>
    <c:url value="/account/login" var="url"/>
    <form action="${url}" method="post">
        <label>Username:</label><br>
        <input name="username"><br>
        <label>Password:</label><br>
        <input name="password" type="password"><br><br>
        <button>Login</button>
    </form>

    <p style="color:blue">${message}</p>
</body>
</html>