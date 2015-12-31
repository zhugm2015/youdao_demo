<%--
  Created by IntelliJ IDEA.
  User: BH00350
  Date: 2015/12/7
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>default page</title>
</head>
<body>
<h1>default page</h1>
<form action="/user/login" method="post">
  username:<input name="username" value="a"><br/>
  password:<input name="password" type="password"/><br/>
  <input type="submit" value="LOGIN">
</form>
${requestScope.message}<br/>
<a href="/signup.jsp">SIGN UP</a>
</body>
</html>
