<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Bai2</title>
</head>
<body>
  <h3>Danh sách quốc gia</h3>
  <table border="1" cellpadding="5" cellspacing="0">
    <thead>
      <tr>
        <th>No.</th>
        <th>Id</th>
        <th>Name</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="ct" items="${countries}" varStatus="vs">
        <tr>
          <td>${vs.count}</td>
          <td>${ct.id}</td>
          <td>${ct.name}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
