<%--
  Created by IntelliJ IDEA.
  User: cc_FF
  Date: 2019/5/4
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

    <script>
        window.onload = function () {
            var checkCode =document.getElementById("checkCode");
            checkCode.onclick = function () {
                var date = new Date();

                checkCode.src = "/cookie_session_war_exploded/checkServlet?"+date.getTime();
            }
        }
    </script>

    <style>
        div {
            color: red;
        }

        body{
            background: url(${pageContext.request.contextPath}/img/1.png)no-repeat;
        }

        table{
            display: inline-block;
            vertical-align: middle;
            align-self: center;
        }
    </style>
</head>
<body>

    <form action="/cookie_session_war_exploded/loginServlet" method="post" >
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>

            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>

            <tr>
                <td>验证码</td>
                <td><input type="text" name="checkCode"></td>
            </tr>

            <tr>
                <td colspan="2"><img id="checkCode" src="/cookie_session_war_exploded/checkServlet"></td>
            </tr>

            <tr>
                <td colspan="2"><input type="submit" value="登陆"></td>
            </tr>
        </table>

        <div><%=request.getAttribute("checkCodeError") == null ? "" :request.getAttribute("checkCodeError")%></div>
        <div><%=request.getAttribute("userError") == null ? "" :request.getAttribute("userError")%></div>
    </form>
</body>
</html>
