<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>api player</title>
</head>
<body>
<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>CLB</th>
<th>Nation</th>
<th>Position</th>
</tr>
<c:forEach items="${List}" var="giamkhao" varStatus="tagStatus">
    <tr>
        <td>${giamkhao.id}</td>
        <td>${giamkhao.name}</td>
        <td>${giamkhao.clb}</td>
        <td>${giamkhao.nation}</td>
        <td>${giamkhao.position}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>