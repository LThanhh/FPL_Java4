<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Bai4</title>
</head>
<body>
  <h2>Upload file hình ảnh</h2>

  <c:url value="/upload" var="url"/>
  <form action="${url}" method="post" enctype="multipart/form-data">
    <input name="photo" type="file" accept="image/*"><br><br>
    <button>Upload</button>
  </form>

  <p style="color:blue">${message}</p>

  <c:if test="${not empty photoPath}">
    <div>
      <p>Ảnh đã lưu:</p>
      <img src="${photoPath}" width="240">
    </div>
  </c:if>
</body>
</html>
