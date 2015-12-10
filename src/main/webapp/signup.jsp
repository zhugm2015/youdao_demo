<%--
  Created by IntelliJ IDEA.
  User: BH00350
  Date: 2015/12/7
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sign up page</title>
</head>
<body>
<h1>sign up page</h1>
<form action="user" method="post">
  <input type="hidden" name="action" value="signup"/>
  username:<input name="username"/><br/>
  password:<input name="password" type="password"/><br/>
  <input type="submit" value="SIGN UP"/>
</form>

</body>
</html>
