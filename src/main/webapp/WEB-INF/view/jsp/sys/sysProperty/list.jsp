<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
%>
<!doctype html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
  <title>系统参数维护</title>
  <meta name="keywords" content="校园足球,成绩系统,成绩管理系统">
  <meta name="description" content="校园足球联盟系统">
  <link rel="Bookmark" href="<%=path%>/resources/uiFrame/favicon.ico" />
  <link rel="Shortcut Icon" href="<%=path%>/resources/uiFrame/favicon.ico" />
  <!--[if lt IE 9]>
  <script type="text/javascript" src="<%=path%>/resources/uiFrame/lib/html5.js"></script>
  <script type="text/javascript" src="<%=path%>/resources/uiFrame/lib/respond.min.js"></script>
  <script type="text/javascript" src="<%=path%>/resources/uiFrame/lib/PIE-2.0beta1/PIE_IE678.js"></script>
  <![endif]-->

  <link href="<%=path%>/resources/uiFrame/static/h-ui/css/H-ui.css" rel="stylesheet" type="text/css" />
  <link href="<%=path%>/resources/uiFrame/lib/Hui-iconfont/1.0.6/iconfont.css" rel="stylesheet" type="text/css" />
  <link href="<%=path%>/resources/uiFrame/static/h-ui/css/style.css" rel="stylesheet" type="text/css" /><!--自己的样式-->
  <!--[if IE 6]>
  <script type="text/javascript" src="<%=path%>/resources/uiFrame/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
  <script>DD_belatedPNG.fix('.pngfix,.icon');</script>
  <![endif]-->
  <script type="text/javascript" src="<%=path%>/resources/uiFrame/lib/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" src="<%=path%>/resources/uiFrame/static/h-ui/js/H-ui.js"></script>
  <script type="text/javascript">
    $(function(){
      $.Huifold("#Huifold1 .item h4","#Huifold1 .item .info","fast",1,"click"); /*5个参数顺序不可打乱，分别是：相应区,隐藏显示的内容,速度,类型,事件*/
    });
  </script>
</head>
<body>

<ul id="Huifold1" class="Huifold">
  <li class="item">
    <h4>标题<b>+</b></h4>
    <div class="info"> 内容<br>很多内容 </div>
  </li>
  <li class="item">
    <h4>标题<b>+</b></h4>
    <div class="info"><img src="pic/2.png" ></div>
  </li>
  <li class="item">
    <h4>标题<b>+</b></h4>
    <div class="info"><img src="pic/1.png" ></div>
  </li>
</ul>


<header>网站头部</header>
<div>

  <div class="row cl">
    <div class="col-2">2/12(1/6)</div>
    <div class="col-4">4/12(1/3)</div>
    <div class="col-6">6/12(1/2)</div>
  </div>

  <table class="table table-border table-bg table-bordered radius">
    <thead>
      <tr>
        <th width="20%">Class</th>
        <th>描述</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th>.active</th>
        <td>悬停在行</td>
      </tr>
      <tr>
        <th>.success</th>
        <td>成功或积极</td>
      </tr>
      <tr>
        <th>.warning</th>
        <td>警告或出错</td>
      </tr>
      <tr>
        <th>.danger</th>
        <td>危险</td>
      </tr>
    </tbody>
  </table>
</div>
<footer>页脚</footer>
</body>
</html>
