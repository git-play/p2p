<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/head.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户登陆</h1>
<div style="color: red"></div>
<form action="${ctx}/UserInfo/zc" method="post">
    帐号：<input type="text" name="uname"><f:errors path="uname" cssClass="valid"></f:errors><br>
    密码：<input type="password" name="pwd"><f:errors path="pwd" cssClass="valid"></f:errors><br>
    电话号码（选填）：<input type="text" name="phone"><br>

    <input type="submit" value="确定">
    <input type="reset" value="重置">
</form>
</body>
</html>
