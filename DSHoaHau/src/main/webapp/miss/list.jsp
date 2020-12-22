<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 20/12/2020
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Miss</title>
    <style>
        img{
        width: 50px;
        height: 50px;}
    </style>
</head>
<body>

<p>
    <a href="/addMiss">Crete new Miss</a>
    <a href="/listPass">List Pass Miss</a>
</p>
<p>
    <c:if test="${message != null}">
        <span class="message">${message}</span>
    </c:if>
</p>
<table border="1" cellpadding="5">
    <tr>
        <th>Name</th>
        <th>Birth Day</th>
        <th>Address</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Passport</th>
        <th>Job</th>
        <th>Level</th>
        <th>Nation</th>
        <th>Work Unit</th>
        <th>Height</th>
        <th>Weight</th>
        <th>Gifted</th>
        <th>Image</th>
        <th>Province</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach var="miss" items="${listMiss}">
        <tr>

            <td><c:out value="${miss.name}"/></td>
            <td><c:out value="${miss.birthDay}"/></td>
            <td><c:out value="${miss.address}"/></td>
            <td><c:out value="${miss.email}"/></td>
            <td><c:out value="${miss.numberPhone}"/></td>
            <td><c:out value="${miss.passport}"/></td>
            <td><c:out value="${miss.job}"/></td>
            <td><c:out value="${miss.level}"/></td>
            <td><c:out value="${miss.nation}"/></td>
            <td><c:out value="${miss.workUnit}"/></td>
            <td><c:out value="${miss.height}"/></td>
            <td><c:out value="${miss.weight}"/></td>
            <td><c:out value="${miss.gifted}"/></td>
            <td><img  src="<c:url value="${miss.image}"/>" alt="image of Miss"></td>
            <td><c:out value="${miss.province}"/></td>
            <td><a href="/approvalMiss?passport=${miss.passport}">${miss.getStatus()}</a></td>
            <td>
                <a href="/viewMiss?passport=${miss.passport}">view</a>
                <a href="/editMiss?passport=${miss.getPassport()}">edit</a>
                <a href="/deleteMiss?passport=${miss.passport}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
