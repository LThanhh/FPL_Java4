<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Bai3</title>
</head>
<body>
  <h3>Thông tin sản phẩm</h3>
  <ul>
    <li><b>Name:</b> ${item.name}</li>
    <li><b>Price:</b>
      <fmt:formatNumber value="${item.price}" pattern="#,###.00" />
    </li>
    <li><b>Date:</b>
      <fmt:formatDate value="${item.date}" pattern="MMM dd, yyyy" />
    </li>
  </ul>
</body>
</html>