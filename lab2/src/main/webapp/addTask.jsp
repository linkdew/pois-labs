<%--
  Created by IntelliJ IDEA.
  User: lamp
  Date: 21.06.2022
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center; background-color: yellow;">add task</h1>
<form style="text-align: center;" action="/addTask" method="POST">

  task name: <label>
  <input type="text" name="name"/>
  </label> <br>
  <p></p>
  task description: <label>
  <input type="text" name="description" />
  </label> <br>
  <p></p>
  task status: <label>
  <input type="text" name="status"/>
  </label> <br>
  <p></p>
  task priority: <label>
  <input type="number" name="priority"/>
  </label> <br>
  <p></p>

  <input type="submit" class="form-submit-button" value="confirm"/>
</form>
</body>
</html>
