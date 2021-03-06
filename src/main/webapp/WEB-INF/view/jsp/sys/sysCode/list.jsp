<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>数据字典</title>
    <%@ include file="../../comm/listhead.jsp" %>
    <script type="text/javascript">
        $('.table-sort').dataTable({
            "aaSorting": [[1, "desc"]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable": false, "aTargets": [0, 8]}// 制定列不参与排序
            ]
        });
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
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">
                &#xe6e2;</i> 删除</a>
            <a class="btn btn-primary radius" data-title="新增" _href="article-add.html" onclick="Hui_admin_tab(this)"
               href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 新增</a>
        </span>
        <span class="r">共有数据：<strong>54</strong> 条</span></div>
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
                    <td><u style="cursor:pointer" class="text-primary" onClick="edit('${obj.id}')"
                           title="查看">${obj.code}</u></td>
                    <td><u style="cursor:pointer" class="text-primary" onClick="edit('${obj.id}')"
                           title="查看">${obj.name}</u></td>
                    <td><span class="badge badge-success">${obj.codecount}</span></td>
                    <td class="f-14 td-manage">
                        <a style="text-decoration:none" class="ml-5" onClick="edit('10001')" href="javascript:;" title="编辑类别"><i class="Hui-iconfont"> &#xe6df;</i></a>
                        <a style="text-decoration:none" class="ml-5" onClick="del(this,'10001')" href="javascript:;" title="删除类别"><i class="Hui-iconfont"> &#xe6e2;</i></a>
                        <a style="text-decoration:none" class="ml-5" href="javascript:;" data-title="数据字典子集" _href="" onclick="addTab('数据字典子集','<%=path%>/sys/code')" title="维护子集"><i class="Hui-iconfont Hui-iconfont-gengduo"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>