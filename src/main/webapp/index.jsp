<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index page</title>
    <script>
        function del() {
            return confirm("DEL?");
        }
    </script>
</head>
<body>
<c:if test="${sessionScope.user eq null}">
    <c:redirect url="/"/>
</c:if>
<h1>index page</h1>
welcome: ${sessionScope.user.username}<br/>
<a href="/user/logout">LOG OUT</a>
<hr/>
<form action="/word/queryWordByEnglish" method="post">
    <input name="english"/>
    <input type="submit" value="SEARCH">
</form>
<hr>
<div id="word_wrapper">
    <div id="word">
        ${sessionScope.word.english}
    </div>
    <hr>
    <div id="word_definition">
        <c:forEach var="definition" items="${sessionScope.word.wordDefinitions}" varStatus="vs">
            ${vs.count}: ${definition.partOfSpeech} - ${definition.chinese}<br>
        </c:forEach>
    </div>
    <hr>
    <div id="word_sentence">
        <c:forEach var="sentence" items="${sessionScope.word.wordSentences}" varStatus="vs">
            ${vs.count}: ${sentence.english}<br>
            ${vs.count}: ${sentence.chinese}<br>
        </c:forEach>
    </div>
</div>
</body>
</html>
