<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Bai1</title>
</head>
<body>
  <h3>Chọn quốc gia:</h3>
  <form method="post">
    <select name="country">
      <c:forEach var="ct" items="${countries}">
        <option value="${ct.id}">${ct.name}</option>
      </c:forEach>
    </select>
  </form>
</body>
</html>
