<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cc_FF
  Date: 2019/5/5
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<%

    List list = new ArrayList();
    list.add(new User("简十初","ljfwww666",1,new Date()));
    list.add(new User("简十遇","ljfmmm666",2,new Date()));
    list.add(new User("十初十遇","ljf666",3,new Date()));
    request.setAttribute("list",list);
%>

<table border="1",width="500" align="center" >
    <tr>
        <td>用户名</td>
        <td>密码</td>
        <td>id</td>
        <td>日期</td>
    </tr>

    <c:forEach items="${list}" var="dd" varStatus="s">
    <tr>
        <td>${dd.username}</td>
        <td>${dd.password}</td>
        <td>${dd.id}</td>
        <td>${dd.dateStr}</td>
    </tr>
    </c:forEach>
</body>
</html>
