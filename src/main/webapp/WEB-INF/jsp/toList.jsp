
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<form action="${ctx}/s/toList" method="post">
书本名字：<input type="text" name="bookName">
    <input type="submit" value="搜索">
</form>
<table border="1px" width="100%">
    <tr>
        <td>书本编号</td>
        <td>书本名称</td>
        <td>书本价格</td>
        <td>书本图片</td>
        <td>操作</td>
    </tr>
    <c:forEach var="a" items="${bookList}">
   <tr>
           <td>${a.bookId}</td>
           <td>${a.bookName}</td>
           <td>${a.price}</td>
           <td><img style="width: 100px;height: 100px" src="${ctx}/myFile/download?fileId=${v.img}"></td>
       <td >
           <%--<a href="${ctx}/myFile/upload?bookId=${a.bookId}">图片上传</a>--%>
           <a href="${ctx}/myFile/toUpload?bookId=${a.bookId}">图片上传</a>
       </td>
   </tr>
    </c:forEach>
</table>
${pageBean}
<br>

</body>
</html>
