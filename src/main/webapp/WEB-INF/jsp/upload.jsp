<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<h1>文件上传</h1>
<form action="${ctx}/myFile/upload" method="post" enctype="multipart/form-data">
<input type="text" name="bookId" value="${param.bookId}">
    <input type="file" name="file">
    <input type="submit"value="上传">
</form>
</body>
</html>
