<%@ page import="domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% User user = (User) request.getSession().getAttribute("user"); %>
<%--
  Created by IntelliJ IDEA.
  User: cc_FF
  Date: 2019/5/4
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h1><%= user.getUsername()%>，欢迎您</h1><br>

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
</table>
</body>
</html>
