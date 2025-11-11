<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bai3</title>
</head>
<body>
    <h2>Đăng Ký</h2>

    <form action="${pageContext.request.contextPath}/register" method="post">
        Tên đăng nhập: <input type="text" name="username"><br><br>
		Mật khẩu: <input type="password" name="password"><br><br>

        Giới tính:
        <input type="radio" name="gender" value="Nam">Nam
        <input type="radio" name="gender" value="Nữ">Nữ<br><br>

        Đã có gia đình?
        <input type="checkbox" name="married" value="yes"><br><br>

        Quốc tịch:
        <select name="country">
            <option>Vietnam</option>
            <option>United States</option>
            <option>Japan</option>
            <option>France</option>
        </select><br><br>

        Sở thích: <br>
        <input type="checkbox" name="hobbies" value="Đọc sách">Đọc sách
        <input type="checkbox" name="hobbies" value="Du lịch">Du lịch
        <input type="checkbox" name="hobbies" value="Âm nhạc">Âm nhạc
        <input type="checkbox" name="hobbies" value="Khác">Khác<br><br>

        Ghi chú: <br>
        <textarea name="note" rows="3" cols="40"></textarea><br><br>

        <button type="submit">Đăng ký</button>
    </form>

    <hr>
    <h3>Kết quả:</h3>
    <p>${message}</p>
</body>
</html>
