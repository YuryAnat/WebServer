<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<button onclick="location.href='/list'">List users</button><br>
<div>
    <c:if test="not empty sessionScope.errStatus">
        <c:out value="${sessionScope.errStatus}"/>
    </c:if>
    <c:if test="not empty sessionScope.okStatus">
        <c:out value="${sessionScope.okStatus}"/>
    </c:if>
</div>
<div>
    <form method="post">
            <br>
            <label>Login name</label>
            <input name="login" value="${user.login}" type="text">
            <br>
            <label>Password</label>
            <input name="password" value="${user.password}" type="password">
            <br>
            <label>Confirm password</label>
            <input name="confPassword" value="${user.password}" type="password">
            <br>
            <label>Nick name</label>
            <input name="name" value="${user.name}" type="text">
            <br>
            <label>eMail</label>
            <input name="email" value="${user.email}" type="email">
            <br>
        <div>
            <button type="submit" name="edit">Edit user</button>
        </div>
    </form>
</div>
</body>
</html>
