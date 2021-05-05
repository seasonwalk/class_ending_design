<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2020/3/12
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 align="center">登录时出现错误</h2>
<div align="center">
    <%=request.getAttribute("errMessage")%>
</div>
</body>
</html>
