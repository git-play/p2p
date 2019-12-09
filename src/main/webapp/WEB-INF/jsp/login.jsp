<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/head.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户登陆</h1>
<div style="color: red">${message}</div>
<form action="${ctx}/UserInfo/zc" method="post">
    帐号：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    电话号码（选填）：<input type="text" name="iphone"><f:errors path="iphone" cssClass="valid"></f:errors><br>

    <input type="submit" value="确定">
    <input type="reset" value="重置">
</form>
</body>
</html>
