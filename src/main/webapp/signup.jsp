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
  <script src="static/js/jquery-1.11.3.min.js"></script>
  <script>
    $(function(){
      $('#username').blur(function(){        //鼠标移开用户名
        var username=$('#username').val();    //username取值
        $.ajax({                                //异步请求提交
          type:'post',                         //解决提交后，用户名查询判断不了问题
          url:'/user/check',
          data:{"username":username} ,        //取键值给服务器
          dataType:'json',
          success:function(result){           // {"isUsernameExist":true}
            if (result.isUsernameExist) {
              $('#hint').text("username is exist!");
            } else {
              $('#hint').text("username is available!");
            }
          }
        });
      })
    });
  </script>
</head>
<body>
<h1>sign up page</h1>
<form action="/user/add" method="post">
  username:<input id="username" name="username"><span id="hint"></span><br/>
  password:<input name="password" type="password"><br/>
  <input type="submit" value="SIGN UP">
</form>
${requestScope.message}
</body>
</html>
