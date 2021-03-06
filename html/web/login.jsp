
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="css/登陆界面.css">
</head>
<body>
<div id="log_in">
    <div class="log_in_top">
        <div class="log_in_img_1">
            <img src="img/logo_login.png">
        </div>
    </div>
    <div class="log_in_img">
        <div class="log_in_img_2">
            <img src="img/img_login.png">
        </div>
    </div>
    <div id="log_in_right">
        <div class="log_in_textbox">
            <form action="${pageContext.request.contextPath}/loginServlet" method="post">
                <table>
                    <tr>
                        <td class="log_in_td_top" colspan="2">
                            登陆账号
                        </td>
                    </tr>
                    <tr>
                        <td class="log_in_td_left">用户名</td>
                        <td class="log_in_td_right"><input type="text" name="username" id="username"></td>
                    </tr>
                    <tr>
                        <td class="log_in_td_left">密码</td>
                        <td class="log_in_td_right"><input type="password" name="password" id="password"></td>
                    </tr>
                    <tr>
                        <td id="log_in_td_sub" colspan="2">
                            <input type="submit" id="log_in_btn_sub" name="log_in" value="登陆">
                        </td>
                    </tr>
                    <tr>
                        <td id="log_in_reg" colspan="2">
                            <p>还没有账号？<a href="注册界面.html" >免费注册</a></p></td>
                    </tr>
                </table>
            </form>
            <div class="alert alert-warning alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" >
                    <span>&times;</span></button>
                <strong>${msg_login}</strong>
            </div>
        </div>
    </div>
    <div id="log_in_sign"><p>Copyright@rj1705-TTMS</p></div>
</div>
</body>
</html>