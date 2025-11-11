<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bai2</title>
</head>
<body>
<h2>Gửi Email</h2>
<form action="${pageContext.request.contextPath}/sendmail" method="post">
    <label>From:</label><br>
    <input name="from" placeholder="example@gmail.com"><br><br>

    <label>To:</label><br>
    <input name="to" placeholder="recipient@gmail.com"><br><br>

    <label>Subject:</label><br>
    <input name="subject" placeholder="Tiêu đề email"><br><br>

    <label>Body:</label><br>
    <textarea name="body" rows="5" cols="40" placeholder="Nội dung email"></textarea><br><br>

    <button type="submit">Gửi Email</button>
</form>
</body>
</html>
