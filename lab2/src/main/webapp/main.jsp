<%@ page import="org.linkdew.daopattern.entities.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="org.linkdew.daopattern.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: lamp
  Date: 21.06.2022
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
    <style>
        @keyframes slideInFromLeft {
            0% {
                transform: translateX(-100%);
            }
            100% {
                transform: translateX(0);
            }
        }
    </style>
</head>
<body style = "background-color: #e0e0e0; padding: 0; margin: 0">

<%
    User user = (User) request.getSession().getAttribute("user");
%>

<h2 style="animation: 1s ease-out 0s 1 slideInFromLeft;text-align: center; background-color: deeppink;" >logged in as user <%= user.getUsername()%></h2>
<a style=" animation: 1s ease-out 0s 1 slideInFromLeft;float: right; text-decoration: none; text-align: center; padding: 10px; background-color: darkred; border: 1px deeppink solid; border-radius: 3px; margin: 10px; color: white;" href = "/logout">logout</a>
<a style=" animation: 1s ease-out 0s 1 slideInFromLeft;float: right; text-decoration: none; text-align: center; padding: 10px; background-color: #63ff7d; border: 1px deeppink solid; border-radius: 3px; margin: 10px;" href = "/addTask">add task</a>
<%
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
    if (tasks == null) {
        out.println("<p>no tasks</p>");
        return;
    }

    for (Task task : tasks) {
        out.println("<div style =\" animation: 1s ease-out 0s 1 slideInFromLeft; background-color: #85c2ff; text-align: center; display: inline-block; padding: 10px; margin: 10px\">");
        out.println("<p>" + "<b>Task Id:</b> " + task.getTaskId() + "</p>" +
                    "<p>" + "<b>Task Name:</b> " + task.getTaskName() + "</p>" +
                    "<p>" + "<b>Task Description:</b> " + task.getTaskDescription() + "</p>" +
                     "<p>" + "<b>Status:</b> " + task.getStatus() + "</p>" +
                    "<p>" + "<b>Priority:</b> " + task.getPriority() + "</p><br>");
        out.println("<p><a href = \"/editTask?taskId="+ task.getTaskId() +"\">edit</a></p>");
        out.println("<p><a style = \"background-color: red; color: black\"href = \"/deleteTask?taskId=" + task.getTaskId() +"\">delete</a></p>");
        out.println("</div>");
    }
%>

</body>
</html>
