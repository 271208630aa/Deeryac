<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>系统参数维护</title>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/html5.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/respond.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/PIE_IE678.js"></script>
    <![endif]-->
    <link href="<%=path%>/resources/uiframe/css/H-ui.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path%>/resources/uiframe/css/H-ui.admin.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path%>/resources/uiframe/lib/Hui-iconfont/1.0.6/iconfont.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path%>/resources/uiframe/css/style.css" rel="stylesheet" type="text/css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/layer/2.1/layer.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/icheck/jquery.icheck.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/lib/Validform/5.3.2/Validform.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/js/H-ui.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/js/H-ui.admin.js"></script>
    <script type="text/javascript">
        var baseurl = "<%=path%>";
        var thisurl = window.location.href;
        var base_requrl = thisurl.substring(thisurl.indexOf(baseurl));
        base_requrl = base_requrl.substring(0, base_requrl.lastIndexOf("/"));
        $(function () {
            $('.skin-minimal input').iCheck({
                checkboxClass: 'icheckbox-blue',
                radioClass: 'iradio-blue',
                increaseArea: '20%'
            });

            $("#form-admin-add").Validform({
                tiptype: 2,
                callback: function (form) {
                    form[0].submit();
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.$('.btn-refresh').click();
                    parent.layer.close(index);
                }
            });
        });
    </script>
</head>
<body>
<div class="pd-20">
    <form action="" method="post" class="form form-horizontal" id="form-admin-add">
        <input type="hidden" name="id" id="id" value="${obj.id}">
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>编码：</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" placeholder="编码" id="code" name="code" value="${obj.code}" datatype="*2-25" nullmsg="代码不能为空">
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>名称：</label>
            <div class="formControls col-5">
                <input type="text" placeholder="名称" class="input-text" value="${obj.name}" id="name" name="name"
                       datatype="*1-50" nullmsg="名称不能为空！">
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-3"><span class="c-red">*</span>备注：</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" value="${obj.flag}" id="flag" name="flag">
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-3">备注：</label>
            <div class="formControls col-5">
                <textarea name="flag" cols="" rows="" class="textarea" placeholder="说点什么...100个字符以内" dragonfly="true"
                          onKeyUp="textarealength(this,100)"></textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <div class="col-9 col-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;保存&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</div>
</body>
</html>