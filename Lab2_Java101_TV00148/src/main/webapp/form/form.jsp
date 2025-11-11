<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bai3</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/form/update" method="post">

    <div>Fullname:</div>
    <input name="fullname" value="${user.fullname}"><br>

    <div>Gender:</div>
    <input type="radio" name="gender" value="true" ${user.gender ? "checked" : ""}>Nam
    <input type="radio" name="gender" value="false" ${!user.gender ? "checked" : ""}>Nữ<br>

    <div>Country:</div>
    <select name="country">
        <option value="VN" ${user.country == 'VN' ? 'selected' : ''}>Việt Nam</option>
        <option value="US" ${user.country == 'US' ? 'selected' : ''}>Mỹ</option>
        <option value="CN" ${user.country == 'CN' ? 'selected' : ''}>Trung Quốc</option>
    </select><br><br>

    <button formaction="${pageContext.request.contextPath}/form/create">Create</button>
    <button>Update</button>
    ${capnhat}
</form>

</body>
</html>
