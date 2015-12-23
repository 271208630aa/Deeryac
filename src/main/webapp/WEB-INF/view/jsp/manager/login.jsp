<!DOCTYPE HTML>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <LINK rel="Bookmark" href="<%=path%>/resources/uiframe/favicon.ico">
    <LINK rel="Shortcut Icon" href="<%=path%>/resources/uiframe/favicon.ico"/>
    <title>校园足球联盟赛事平台</title>
    <meta name="keywords" content="校园足球,校园足球联盟系统,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="实时发布赛事新闻，展示最新校园赛事咨询，更新比赛事比赛结果。">
    <!--[if lt IE 9]>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/html5.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/respond.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/PIE_IE678.js"></script>
    <![endif]-->
    <link href="<%=path%>/resources/uiframe/css/H-ui.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path%>/resources/uiframe/css/H-ui.login.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path%>/resources/uiframe/lib/Hui-iconfont/1.0.6/iconfont.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path%>/resources/uiframe/css/style.css" rel="stylesheet" type="text/css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <script type="text/javascript">

        function refreshCaptcha(){
            var millseconds = new Date().getMilliseconds();
            $("#captchapic").attr("src","<%=path%>/authImage?reqtime="+millseconds);
        }

        var maskid;
        //打开遮罩
        function openMask(){
            maskid = layer.msg('加载中', {icon: 16,time : -1,shade: [0.8]});
        }

        //关闭遮罩
        function closeMask(){
            layer.close(maskid);
        }

        function dologin(){
            var loginid = $("#loginid").val();
            if (typeof(loginid) === "undefined" || loginid === null || loginid === ''){
                layer.alert('请输入用户名！', {icon: 5,end : function(){
                    $("#loginid").focus();
                }});
                return ;
            }
            var password = $("#password").val();
            if (typeof(password) === "undefined" || password === null || password === ''){
                layer.alert('请输入密码！', {icon: 5,end : function(){
                    $("#password").focus();
                }});
                return ;
            }
            var captcha = $("#captcha").val();
            if (typeof(captcha) === "undefined" || captcha === null || captcha === '' || captcha==='验证码'){
                layer.alert('请输入验证码！', {icon: 5,end : function(){
                    $("#captcha").focus();
                }});
                return ;
            }
            var formdata = $("#subForm").serialize();
            var url = baseurl+"/login/ajaxLogin";
            openMask();
            $.post(url, formdata,function(data){
                  closeMask();
                if (typeof(data) !== "undefined" && data !== null && data !== ''){
                  var data = eval("("+data+")");
                    var state = data.state;
                    if(state!=1){
                        layer.alert(data.msg,{icon: 5,end : function(){
                            refreshCaptcha();
                        }});
                    }else{
                        location.replace(location.href);
                    }
                }

                }
            );
        }
    </script>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value=""/>
<div class="header"></div>
<div class="loginWraper">
    <div id="loginform" class="loginBox">
        <form class="form form-horizontal" action="/" method="post" id="subForm">
            <div class="row cl">
                <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                <div class="formControls col-8">
                    <input id="loginid" name="loginid" type="text" placeholder="用户名" class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                <div class="formControls col-8">
                    <input id="password" name="password" type="password" placeholder="密码" class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-3 "><i class="Hui-iconfont Hui-iconfont-userid"></i></label>
                <div class="formControls col-8">
                    <input class="input-text size-L" name="captcha" id="captcha" type="text" placeholder="验证码" style="width:150px;">
                    <img src="<%=path%>/authImage" id="captchapic" name="captchapic" style="width: 100px; height: 41px;" > <a id="kanbuq" href="javascript:refreshCaptcha();">看不清，换一张</a>
                </div>
            </div>
            <div class="row">
                <div class="formControls col-8 col-offset-3">
                    <label for="online">
                        <input type="checkbox" name="online" id="online" value="">
                        使我保持登录状态</label>
                </div>
            </div>
            <div class="row">
                <div class="formControls col-8 col-offset-3">
                    <input name="loginin" id="loginin" type="button" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;" />
                    <input name="reset" id="reset" type="button" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;" />
                </div>
            </div>
        </form>
    </div>
</div>
<div class="footer">Copyright &copy;南京爱蜂动体育发展有限公司</div>
<script type="text/javascript" src="<%=path%>/resources/uiframe/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/uiframe/js/H-ui.js"></script>
<script type="text/javascript" src="<%=path%>/resources/uiframe/lib/layer/2.1/layer.js"></script>
<script>
    var baseurl = '<%=path%>';
    $(document).ready(function(){
       $("#loginin").bind("click",function(){
           dologin();
       })
    });
</script>
</body>
</html>