<%--
  Created by IntelliJ IDEA.
  User: lamp
  Date: 21.06.2022
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<main>
    <h1 style="text-align: center; background-color: yellow;">Login Page</h1>
    <form style="text-align: center;" action="/login" method="POST">
        <%String message = (String) request.getAttribute("message");
            if (message == null) {
                message="";
            }%>
        username: <label>
        <input type="text" name="username"/>
        <p></p>
        </label> <br>
        password: <label>

        <input type="password" name="password"/>
        </label> <br>
        <p  style="color: red; font-size: 14px">
            <%=message%>
        </p>

        <input type="submit" class="form-submit-button" value="login"/>
    </form><br><br>
</main>
</body>
</html>
