<%--
  Created by IntelliJ IDEA.
  User: 沈一龙
  Date: 2020/7/16
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
<body>
<div class="container">
    <form  action="use/authlogin" method="post">


        <label for="username">Username:</label><input type="usern0ame" id="username" name="username" class="form-control"/>
        <label for="password">Password:</label><input type="password" id="password" name="password" class="form-control"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        <button class="btn btn-lg btn-primary btn-block" type="reset">重置</button>
        <a href="use/zhuce" class="btn btn-default btn-lg active" role="button">注册</a>

    </form>

</div>

</body>
</html>