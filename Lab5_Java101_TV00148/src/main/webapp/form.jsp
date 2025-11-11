<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bai1</title>
</head>
<body>
<h2>Nhập thông tin nhân viên</h2>

<c:url value="/save" var="url"/>
<form action="${url}" method="post">
  
  <!-- Họ tên -->
  <label>Họ và tên:</label><br>
  <input name="fullname" placeholder="Nhập họ và tên"><br><br>

  <!-- Ngày sinh -->
  <label>Ngày sinh (MM/dd/yyyy):</label><br>
  <input name="birthday" placeholder="VD: 11/10/2025"><br><br>

  <!-- Giới tính -->
  <label>Giới tính:</label><br>
  <input type="radio" name="gender" value="true"> Nam
  <input type="radio" name="gender" value="false"> Nữ<br><br>

  <!-- Sở thích -->
  <label>Sở thích:</label><br>
  <input type="checkbox" name="hobbies" value="Reading"> Đọc sách
  <input type="checkbox" name="hobbies" value="Traveling"> Du lịch
  <input type="checkbox" name="hobbies" value="Music"> Âm nhạc<br><br>

  <!-- Quốc gia -->
  <label>Quốc gia:</label><br>
  <select name="country">
    <option value="VN">Việt Nam</option>
    <option value="US" selected>Hoa Kỳ</option>
  </select><br><br>

  <!-- Lương -->
  <label>Mức lương:</label><br>
  <input name="salary" placeholder="Nhập lương (VD: 5000)"><br><br>

  <hr>
  <button type="submit">Gửi thông tin</button>
</form>

</body>
</html>
