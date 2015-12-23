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
    <script type="text/javascript">
        var baseurl = "<%=path%>";
        var thisurl = window.location.href;
        var base_requrl = thisurl.substring(thisurl.indexOf(baseurl));
        base_requrl = base_requrl.substring(0,base_requrl.lastIndexOf("/"));
        $('.table-sort').dataTable({
            "aaSorting": [[1, "desc"]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable": false, "aTargets": [0, 8]}// 制定列不参与排序
            ]
        });

        /*资讯-添加*/
        function add(title, url, width, height) {
            // '查看','./sysSort/input',
            if (typeof(title) === "undefined" || title === null || title === ''){
                title = "【"+document.title+"】 -> 维护"
            }
            if (typeof(url) === "undefined" || url === null || url === ''){
                url = base_requrl+"/newInput?reqtime="+new Date().getMilliseconds();
            }
            if (typeof(width) === "undefined" || width === null || width === ''){
                width = document.body.clientWidth - 100;
            }
            if (typeof(height) === "undefined" || height === null || height === ''){
                height = document.body.clientHeight - 30;
            }

            layer_show(title,url,width,height);
        }
        /*资讯-编辑*/
        function edit(id,title,url) {
            // '查看','./sysSort/input',
            if (typeof(title) === "undefined" || title === null || title === ''){
                title = "【"+document.title+"】 -> 维护"
            }
            if (typeof(url) === "undefined" || url === null || url === ''){
                url = base_requrl+"/load?reqtime="+new Date().getMilliseconds();
            }
            url = url+"&id="+id;

            if (typeof(width) === "undefined" || width === null || width === ''){
                width = document.body.clientWidth - 100;
            }
            if (typeof(height) === "undefined" || height === null || height === ''){
                height = document.body.clientHeight - 30;
            }
            alert(url);
            layer_show(title,url,width,height);
        }
        /*资讯-删除*/
        function del(obj, id) {
            layer.confirm('确认要删除吗？', function (index) {
                $(obj).parents("tr").remove();
                layer.msg('已删除!', 1);
            });
        }
        /*资讯-审核*/
        function article_shenhe(obj, id) {
            layer.confirm('审核文章？', {
                        btn: ['通过', '不通过'],
                        shade: false
                    },
                    function () {
                        $(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
                        $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
                        $(obj).remove();
                        layer.msg('已发布', {icon: 6, time: 1000});
                    },
                    function () {
                        $(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
                        $(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
                        $(obj).remove();
                        layer.msg('未通过', {icon: 5, time: 1000});
                    });
        }
        /*资讯-下架*/
        function article_stop(obj, id) {
            layer.confirm('确认要下架吗？', function (index) {
                $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
                $(obj).remove();
                layer.msg('已下架!', {icon: 5, time: 1000});
            });
        }

        /*资讯-发布*/
        function article_start(obj, id) {
            layer.confirm('确认要发布吗？', function (index) {
                $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
                $(obj).remove();
                layer.msg('已发布!', {icon: 6, time: 1000});
            });
        }
        /*资讯-申请上线*/
        function article_shenqing(obj, id) {
            $(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
            $(obj).parents("tr").find(".td-manage").html("");
            layer.msg('已提交申请，耐心等待审核!', {icon: 1, time: 2000});
        }

    </script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/js/H-ui.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/uiframe/js/H-ui.admin.js"></script>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span
        class="c-gray en">&gt;</span> 系统参数维护 <a class="btn btn-success radius r mr-20"
                                                style="line-height:1.6em;margin-top:3px"
                                                href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
    <div class="text-c"> <span class="select-box inline">
		<select name="" class="select">
            <option value="0">全部分类</option>
            <option value="1">分类一</option>
            <option value="2">分类二</option>
        </select>
		</span> 日期范围：
        <input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}'})" id="logmin"
               class="input-text Wdate" style="width:120px;">
        -
        <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d'})" id="logmax"
               class="input-text Wdate" style="width:120px;">
        <input type="text" name="" id="" placeholder=" 资讯名称" style="width:250px" class="input-text">
        <button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜资讯</button>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20"><span class="l"><a href="javascript:;" onclick="datadel()"
                                                               class="btn btn-danger radius"><i class="Hui-iconfont">
        &#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" _href="article-add.html"
                                 onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i>
        添加资讯</a></span> <span class="r">共有数据：<strong>54</strong> 条</span></div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="indexCheck"></th>
                <th>代码</th>
                <th>名称</th>
                <th>子集</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${result}" var="obj">
                <tr class="text-c">
                    <td><input type="checkbox" value="${obj.id}" name="listCheck"></td>
                    <td><u style="cursor:pointer" class="text-primary" onClick="edit('${obj.id}')" title="查看">${obj.code}</u></td>
                    <td><u style="cursor:pointer" class="text-primary" onClick="edit('${obj.id}')" title="查看">${obj.name}</u></td>
                    <td>${obj.codecount}</td>
                    <td class="f-14 td-manage">
                        <a style="text-decoration:none" class="ml-5" onClick="edit('10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont"> &#xe6df;</i></a>
                        <a style="text-decoration:none" class="ml-5" onClick="del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>