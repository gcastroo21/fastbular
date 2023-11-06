<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
  <div>

    <c:if test="${sessionScope.loggedUser != null}">
        <span>${sessionScope.loggedUser}</span>
        <a href="/logout">Logout</a>
    </c:if>

    <h1>Unis</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <c:if test="${sessionScope.loggedUser != null}">
                <th>Actions</th>
            </c:if>
        </tr>
        <c:forEach var="uni" items="${unis}">
            <tr>
                <td>${uni.id}</td>
                <td>${uni.name}</td>
                <td>
                    <c:if test="${sessionScope.loggedUser != null}">
                        <form action="/delete-uni" method="post">
                            <input type="hidden" id="id" name="id" value="${uni.id}">
                            <button type="submit">Delete</button>
                            <span> | </span>
                            <a href="index.jsp?id=${uni.id}&name=${uni.name}">Update</a>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
  </div>
</body>
</html>