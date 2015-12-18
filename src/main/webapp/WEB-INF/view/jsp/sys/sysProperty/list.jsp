<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <LINK rel="Bookmark" href="<%=path%>/resources/uiframe/favicon.ico">
    <LINK rel="Shortcut Icon" href="<%=path%>/resources/uiframe/favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/html5.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/respond.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/PIE_IE678.js"></script>
    <![endif]-->
    <link href="<%=path%>/resources/uiframe/css/H-ui.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path%>/resources/uiframe/css/H-ui.admin.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path%>/resources/uiframe/lib/Hui-iconfont/1.0.6/iconfont.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path%>/resources/uiframe/skin/blue/skin.css" rel="stylesheet" type="text/css" id="skin"/>
    <link href="<%=path%>/resources/uiframe/css/style.css" rel="stylesheet" type="text/css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>校园足球联盟赛事平台</title>
    <meta name="keywords" content="校园足球,校园足球联盟系统,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="实时发布赛事新闻，展示最新校园赛事咨询，更新比赛事比赛结果。">
</head>
<body>
<%@include file="../../comm/_header.jsp" %>
<%@include file="../../comm/_left.jsp" %>
<div class="dislpayArrow"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active"><span title="我的桌面" data-href="welcome.html">我的桌面</span><em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S"
                                                  href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a
                id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">
            &#xe6d7;</i></a></div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            <iframe scrolling="yes" frameborder="0" src="welcome.html"></iframe>
        </div>
    </div>
</section>
<%@include file="../../comm/_footer.jsp"%>
</body>
</html>