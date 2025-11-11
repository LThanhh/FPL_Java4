<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bai2</title>
</head>
<body>
    <c:url value="/calculate" var="cal"/>
    <form method="post">
        <input name="a"><br>
        <input name="b"><br>
        <button formaction="${cal}/add">+</button>
        <button formaction="${cal}/sub">-</button>
    </form>
    <p style="color:blue">${message}</p>
</body>
</html>
