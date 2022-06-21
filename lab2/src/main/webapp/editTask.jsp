<%@ page import="org.linkdew.daopattern.entities.Task" %><%--
  Created by IntelliJ IDEA.
  User: lamp
  Date: 21.06.2022
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task editing</title>
</head>
<body>
<h1 style="text-align: center; background-color: yellow;">edit task</h1>
<form style="text-align: center;" action="/editTask" method="POST">
    <%String message = (String) request.getAttribute("message");
        if (message == null) {
            message = "";
        }
        Task task = (Task) request.getAttribute("task");
        %>

    task priority: <label>
    <input type="number" name="newPriority" value="<%=task.getPriority()%>"/>
    </label> <br>
    <p></p>
    task status: <label>
    <input type="text" name="newStatus" value="<%=task.getStatus()%>"/>
    </label> <br>
    <input type="hidden" name="taskId" value="<%=task.getTaskId()%>"/>
    <p  style="color: red; font-size: 14px">
        <%=message%>
    </p>
    <input type="submit" class="form-submit-button" value="confirm"/>
</form>
</body>
</html>
