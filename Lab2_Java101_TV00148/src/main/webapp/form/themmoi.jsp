<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin mới thêm</title>
</head>
<body>
<h2>Thông tin bạn vừa tạo mới</h2>
<hr>

<p><b>Họ và tên:</b> ${user.fullname}</p>
<p><b>Giới tính:</b> 
    ${user.gender == 'true' ? 'Nam' : 'Nữ'}
</p>
<p><b>Quốc gia:</b>
    <span>
        ${user.country == 'VN' ? 'Việt Nam' : 
         user.country == 'US' ? 'Mỹ' :
         user.country == 'CN' ? 'Trung Quốc' : 'Không xác định'}
    </span>
</p>

<hr>
<a href="${pageContext.request.contextPath}/form/${caller}">⬅ Quay lại Form</a>

</body>
</html>
