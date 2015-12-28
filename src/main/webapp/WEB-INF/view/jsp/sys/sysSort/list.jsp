<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>数据字典</title>
    <%@ include file="../../comm/listhead.jsp" %>
    <script type="text/javascript"></script>

</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span
        class="c-gray en">&gt;</span> 系统参数维护 <a class="btn btn-success radius r mr-20"
                                                style="line-height:1.6em;margin-top:3px"
                                                href="javascript:location.replace(location.href);" title="刷新">
    <i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
    <form action="" method="post" id="searchForm">
        <input type="hidden" name="currentPageno" id="currentPageno" value="${pager.currentPageno}">
    <div class="text-l responsive">
        <div class="row cl">
            <div class="col-2">代码：<input type="text" class="input-text" style="width:120px;" placeholder="代码" name="code" id="code" value="${obj.code}"></div>
            <div class="col-2">名称：<input type="text" class="input-text" style="width:120px;" placeholder="名称" name="name" id="name" value="${obj.name}"></div>
            <div class="col-2"><button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 查询</button></div>
        </div>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a class="btn btn-primary radius" onclick="add()" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i>
                新增</a>
            <a class="btn btn-warning radius" onclick="edit()" href="javascript:;"><i class="Hui-iconfont">&#xe6df;</i>
                修改</a>
            <a class="btn btn-danger radius" onclick="del()" href="javascript:;"><i class="Hui-iconfont">&#xe6e2;</i> 删除</a>
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
            <c:forEach items="${result}" var="dataobj">
                <tr class="text-c">
                    <td><input type="checkbox" value="${dataobj.id}" id="${dataobj.id}" name="listCheck"></td>
                    <td><span style="cursor:pointer" class="text-primary" onClick="edit('${dataobj.id}')" title="查看">${dataobj.code}</span></td>
                    <td><span style="cursor:pointer" class="text-primary" onClick="edit('${dataobj.id}')" title="查看">${dataobj.name}</span></td>
                    <td><a class="badge badge-success "  onclick="addTab('数据字典子集','<%=path%>/sys/code/list?sortcode=${dataobj.code}')" title="维护子集">${dataobj.codecount}</a></td>
                    <td class="f-14 td-manage">
                        <a style="text-decoration:none" class="ml-5" onClick="edit('${dataobj.id}')" href="javascript:;"
                           title="类别修改"><i class="Hui-iconfont"> &#xe6df;</i></a>
                        <a style="text-decoration:none" class="ml-5" onClick="del('${dataobj.id}')" href="javascript:;"
                           title="类别删除"><i class="Hui-iconfont"> &#xe6e2;</i></a>
                        <a style="text-decoration:none" class="ml-5" href="javascript:;"
                           onclick="addTab('数据字典子集','<%=path%>/sys/code/list?sortcode=${dataobj.code}')" title="维护子集"><i
                                class="Hui-iconfont"> &#xe715;</i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="row cl bg-1 bk-gray mt-20" style="height: 50px; line-height: 50px;" >
            <div class="col-6 text-l pl-10"  >当前第1页，共100页，每页显示 <select name="eachPageRows" id="eachPageRows"><option value="15">15</option><option value="30">30</option><option value="50">50</option><option value="75">75</option><option value="100">100</option></select> 条。本次共查询100条数据</div>
            <div id="pager" class="col-6 text-r" style="vert-align: middle"></div>
        </div>
    </div>
    </form>
</div>
</body>
</html>