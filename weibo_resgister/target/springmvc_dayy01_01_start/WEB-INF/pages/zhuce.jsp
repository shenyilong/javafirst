<%--
  Created by IntelliJ IDEA.
  User: 沈一龙
  Date: 2020/7/16
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>Reg</title>

    <style type="text/css">
        .label
        {
            width:20%;
        }
        .controler
        {
            width:80%;
        }
    </style>

</head>
<body>
<h1>注册界面</h1>
<hr>
<form name="regForm" action="authReg.do" method="post">
    <table border="0" width="800" cellsapcing="0" cellpadding="0">
        <tr>
            <td class="label">用户名</td>
            <td class="controler"><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td class="label">密码</td>
            <td class="controler"><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td class="label">确认密码</td>
            <td class="controler"><input type="password" name="confirmpass" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="注册"/>&nbsp;&nbsp;
                <input type="reset" value="取消"/>&nbsp;&nbsp;
            </td>
        </tr>
    </table>
</form>

</body>
</html>