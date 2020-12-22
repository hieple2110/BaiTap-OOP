<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 21/12/2020
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Miss</title>
</head>
<body>
<form action="/editMiss" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" id="name" name="name" value="${requestScope['miss'].getName()}"></td>
        </tr>
        <tr>
            <td>Birth Day</td>
            <td><input type="text"id="birthday" name="birthday" value="${requestScope['miss'].getBirthDay()}"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" id="address" name="address" value="${requestScope['miss'].getAddress()}"></td>
        </tr>
        <tr>
            <td>Number Phone</td>
            <td><input type="text" id="phone" name="phone" value="${requestScope['miss'].getNumberPhone()}"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" id="email" name="email" value="${requestScope['miss'].getEmail()}"></td>
        </tr>
        <tr>
            <td>PassPort</td>
            <td><input type="text" id="passport" name="passport" value="${requestScope['miss'].getPassport()}"></td>
        </tr>
        <tr>
            <td>Job</td>
            <td><input type="text" id="job" name="job" value="${requestScope['miss'].getJob()}"></td>
        </tr>
        <tr>
            <td>Level</td>
            <td><input type="text" id="level" name="level" value="${requestScope['miss'].getLevel()}"></td>
        </tr>
        <tr>
            <td>Nation</td>
            <td><input type="text" id="nation" name="nation" value="${requestScope['miss'].getNation()}"></td>
        </tr>
        <tr>
            <td>Work Unit</td>
            <td><input type="text" id="workunit" name="workunit" value="${requestScope['miss'].getWorkUnit()}"></td>
        </tr>
        <tr>
            <td>Height</td>
            <td><input type="text" id="height" name="height" value="${requestScope['miss'].getHeight()}"></td>
        </tr>
        <tr>
            <td>Weight</td>
            <td><input type="text" id="weight" name="weight" value="${requestScope['miss'].getWeight()}"></td>
        </tr>
        <tr>
            <td>Gifted</td>
            <td><input type="text" id="gifted" name="gifted" value="${requestScope['miss'].getGifted()}"></td>
        </tr>
        <tr>
            <td>Image</td>
            <td><input type="text" id="image" name="image" value="${requestScope['miss'].getImage()}"></td>
        </tr>
        <tr>
            <td>Province</td>
            <td>
                <select id="province" name="province">
                    <option value="${requestScope["miss"].getProvince()}">${requestScope["miss"].getProvince()}</option>
                    <c:forEach items="${listProvince}" var="list">
                        <option value="${list.getNameProvince()}">${list.getNameProvince()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td><a href="/listMiss">Back list</a></td>
            <td><input type="submit" value="Edit"></td>
        </tr>
    </table>
</form>
</body>
</html>
