<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<div>
    <button onclick="location.href='/logout'">Logout</button>
    <br>
</div>
<div>
    Local addr: <%= request.getLocalAddr() %>
    <br>
    User role: <%= request.getSession().getAttribute("role") %>
    <br>
    Session id: <%= request.getRequestedSessionId()%>
</div>
</body>
</html>
