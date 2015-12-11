<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index page</title>
    <script>
        function del(){
            return confirm("DEL?")
        }
    </script>
</head>
<body>
<c:if test="${sessionScope.username eq null}">
    <c:redirect url="/"/>
</c:if>
<h1>indext page</h1>
welcom:${sessionScope.username}<br/>
<a href="user?action=logout">LOG OUT</a>
<hr/>
<form action="word" method="post">
    <input type="hidden" name="action" value="add"/>
    english:<input name="english"/><br/>
    chinese:<input name="chinese"/><br/>
    <input type="submit" value="ADD"/>
</form>
<hr/>
<table border="1">
    <c:choose>
        <c:when test="${sessionScope.words[0] eq null}">
            No record
        </c:when>
        <c:otherwise>
            <tr>
                <th>ID</th>
                <th>ENGLISH</th>
                <th>CHINESE</th>
                <th COLSPAN="2">OPERATION</th>
            </tr>
        </c:otherwise>
    </c:choose>
    <%--<c:forEach>为循环控制，它可以将集合(Collection)中的成员循序浏览一遍。
    var：迭代参数的名称。items：要进行迭代的集合。varStatus：迭代变量的名称，用来表示迭代的状态，可以访问到迭代自身的信息。--%>
    <c:forEach var="word" items="${sessionScope.words}" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${word.english}</td>
            <td>${word.chinese}</td>
            <td><a href="word?action=search&id=${word.id}">EDIT</a></td>
            <td><a href="word?action=delete&id=${word.id}" onclick="return del()">DELETE</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
