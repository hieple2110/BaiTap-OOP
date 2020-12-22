<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 21/12/2020
  Time: 09:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Miss</title>
</head>
<body>
<p>
    <c:if test="${requestScope['message']!= null}">
        <span class="message">${requestScope['message']}</span>
    </c:if>
</p>
<form action="/addMiss" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Birth Day</td>
            <td><input type="text" name="birthday"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>Number Phone</td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>PassPort</td>
            <td><input type="text" name="passport"></td>
        </tr>
        <tr>
            <td>Job</td>
            <td><input type="text" name="job"></td>
        </tr>
        <tr>
            <td>Level</td>
            <td><input type="text" name="level"></td>
        </tr>
        <tr>
            <td>Nation</td>
            <td><input type="text" name="nation"></td>
        </tr>
        <tr>
            <td>Work Unit</td>
            <td><input type="text" name="workunit"></td>
        </tr>
        <tr>
            <td>Height</td>
            <td><input type="text" name="height"></td>
        </tr>
        <tr>
            <td>Weight</td>
            <td><input type="text" name="weight"></td>
        </tr>
        <tr>
            <td>Gifted</td>
            <td><input type="text" name="gifted"></td>
        </tr>
        <tr>
            <td>Image</td>
            <td><input type="text" name="image"></td>
        </tr>
        <tr>
            <td>Status</td>
            <td><input type="text" name="status"></td>
        </tr>
        <tr>
            <td>Province</td>
            <td>
                <select name="province">
                    <c:forEach items="${listProvince}" var="list">
                        <option value="${list.nameProvince}">${list.nameProvince}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td> <a href="/listMiss">Back list</a></td>
            <td><input type="submit" value="Create"></td>
        </tr>

    </table>
</form>

</body>
</html>
