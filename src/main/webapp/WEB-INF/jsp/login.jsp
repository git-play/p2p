<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/head.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户登陆</h1>
<form action="${ctx}/UserInfo/login" method="post">
    帐号：<input type="text" name="uname"><br>
    密码：<input type="password" name="pwd"><br>

    <input type="submit" value="确定">
    <input type="reset" value="重置">
</form>
</body>
</html>
