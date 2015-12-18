<%--
  Created by IntelliJ IDEA.
  User: BH00350
  Date: 2015/12/10
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit page</title>
</head>
<body>
<h1>edit page</h1>

<form action="word" method="post">
  <input type="hidden" name="action" value="update"/>
  <input type="hidden" name="id" value="${sessionScope.word.id}">
  english:<input name="english" value="${sessionScope.word.english}"><br/>
  chinese:<input name="chinese" value="${sessionScope.word.chinese}"><br/>
  <input type="submit" value="UPDATE">
</form>
</body>
</html>
