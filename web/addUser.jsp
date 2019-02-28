<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<button onclick="location.href='/list'">List users</button><br>
<div>
    <c:if test="not empty errStatus" var="status">
        <p>${status}</p>
    </c:if>
    <c:if test="not empty okStatus" var="status">
        <p>${status}</p>
    </c:if>
</div>
<div>
    <form method="post">
            <label>Login name</label>
            <input name="login" value="" type="text">
        <br>
            <label>Password</label>
            <input name="password" value="" type="password">
        <br>
            <label>Confirm password</label>
            <input name="confPassword" value="" type="password">
        <br>
            <label>Nick name</label>
            <input name="name" value="" type="text">
        <br>
            <label>eMail</label>
            <input name="email" value="" type="email">
        <br>
        <div>
            <button type="submit" name="add">Add user</button>
        </div>
    </form>
</div>
</body>
</html>
