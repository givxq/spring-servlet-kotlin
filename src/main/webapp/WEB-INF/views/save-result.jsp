<%@ page import="com.example.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: boyoung
  Date: 2023/08/16
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}<li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
