<%@ page import="cn.web.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) request.getSession().getAttribute("user"); %>
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

    <!--自己调试的CSS-->
    <link href="css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<!--导航条-->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display  影院品牌logo-->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img src="img/logo.png"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling 收集导航链接，表单和其他内容以进行切换-->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">影片<span class="sr-only">(current)</span></a></li>
                <li><a href="#">购票</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">影院特色<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">不知道有啥特色</a></li>
                        <li><a href="#">不知道有啥特色</a></li>
                        <li><a href="#">不知道有啥特色</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">不知道有啥特色</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">不知道有啥特色</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="复仇者联盟4">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><%
                    if (user!=null){
                        out.print(user.getUsername()+"欢迎您");
                    }
                    %>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人中心<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">我的钱包</a></li>
                        <li><a href="#">查看影票</a></li>
                        <li><a href="#">充值中心</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">客服服务</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!--轮播图-->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img  src="img/banner4.jpg" alt="...">
        </div>
        <div class="item">
            <img src="img/banner5.jpg" alt="...">
        </div>
        <div class="item">
            <img src="img/banner6.jpg" alt="...">
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!--正在上映-->
<div class="row" >
    <div>
        <h2 class="stl_ing">正在热映&nbsp;&nbsp;(很多部)</h2>
        <a href="#"><span class="stl_ing_a">全部&nbsp;&gt;</span></a>
    </div>
    <div class="col-sm-6 col-md-4 stl_left">
        <div class="thumbnail">
            <img  src="img/SLT.jpg" alt="...">
            <div class="caption">
                <h3 class="SLT_text" >复仇者联盟4</h3>
                <p align="center"><a href="play.html" class="btn btn-primary" role="button" >选座购票</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-6 col-md-4 ">
        <div class="thumbnail">
            <img src="img/STL1.jpg" alt="...">
            <div class="caption">
                <h3 class="SLT_text" >何以为家</h3>
                <p align="center"><a href="#" class="btn btn-primary" role="button" >选座购票</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-6 col-md-4 ">
        <div class="thumbnail">
            <img src="img/STL2.jpg" alt="...">
            <div class="caption" style="margin-top: 12px">
                <h3 class="SLT_text" >下一任：前任</h3>
                <p align="center"><a href="#" class="btn btn-primary" role="button" >选座购票</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
            <img src="img/STL3.jpg" alt="...">
            <div class="caption">
                <h3 class="SLT_text" >雪暴</h3>
                <p align="center"><a href="#" class="btn btn-primary" role="button" >选座购票</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
            <img src="img/SLT4.jpg" alt="...">
            <div class="caption">
                <h3 class="SLT_text" >罗马</h3>
                <p align="center"><a href="#" class="btn btn-primary" role="button" >选座购票</a></p>
            </div>
        </div>
    </div>
</div>
<!--中间图-->
<div class="process-wrap"></div>
<!--即将上映-->
<div class="row" >
    <div>
        <h2 class="stl_will">即将上映&nbsp;&nbsp;(很多部)</h2>
        <a href="#"><span class="stl_will_a">全部&nbsp;&gt;</span></a>
    </div>
    <div class="col-sm-6 col-md-4 stl_left">
        <div class="thumbnail">
            <img  src="img/wslt1.jpg" alt="...">
            <div class="caption">
                <h3 class="SLT_text" >大侦探皮卡丘</h3>
                <p align="center"><a href="#" class="btn btn-primary" role="button" >选座购票</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-6 col-md-4 ">
        <div class="thumbnail">
            <img src="img/wslt2.jpg" alt="...">
            <div class="caption">
                <h3 class="SLT_text" >母亲的复仇</h3>
                <p align="center"><a href="#" class="btn btn-primary" role="button" >选座购票</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-6 col-md-4 ">
        <div class="thumbnail">
            <img src="img/wslt3.jpg" alt="...">
            <div class="caption" style="margin-top: 12px">
                <h3 class="SLT_text" style="margin-top: 10px;">进京城</h3>
                <p align="center"><a href="#" class="btn btn-primary" role="button" >选座购票</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
            <img src="img/wslt4.jpg" alt="...">
            <div class="caption">
                <h3 class="SLT_text" >欢迎来到北方II</h3>
                <p align="center"><a href="#" class="btn btn-primary" role="button" >选座购票</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
            <img src="img/wslt5.jpg" alt="...">
            <div class="caption">
                <h3 class="SLT_text" >半边天</h3>
                <p align="center"><a href="#" class="btn btn-primary" role="button" >选座购票</a></p>
            </div>
        </div>
    </div>
</div>
<!--页脚-->
<div class="footer">
    <p class="friendly-links">
        关于万达 ：
        <a href="#">关于我们</a>
        <span></span>
        <a href="#">联系我们</a>
        <span></span>
        <a href="#">投资账号</a>
        <span></span>
        <a href="#">不买票就滚</a>
        &nbsp;&nbsp;&nbsp;&nbsp;
        友情链接 ：
        <a href="#">QQ</a>
        <span></span>
        <a href="#">微信</a>
        <span></span>
        <a href="#">支付宝</a>
    </p>
</div>
</body>
</html>
