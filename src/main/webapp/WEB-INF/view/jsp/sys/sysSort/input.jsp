<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>系统参数维护</title>
    <%@ include file="../../comm/inputhead.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("#submitForm").Validform({
                btnSubmit:"#btn_sub",
                tiptype: 2,
                ajaxPost:true,
                callback: function (form) {
                   // formsave();
                }
            });
        });

        function saveCallBack(data){
            if(data!=null){
                $("#id").val(data.id);
            }
        }
    </script>
</head>
<body>
<div class="pd-20">
    <form action="<%=path%>/sys/sort/save" method="post" class="form form-horizontal" id="submitForm" onsubmit="return false;">
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
            <label class="form-label col-3">备注：</label>
            <div class="formControls col-5">
                <textarea name="flag" cols="" rows="" class="textarea" placeholder="说点什么...100个字符以内" dragonfly="true" onKeyUp="textarealength(this,100)">${obj.flag}</textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
            </div>
            <div class="col-4"></div>
        </div>
        <div class="row cl">
            <div class="col-9 col-offset-3">
                <input class="btn btn-primary radius" id="btn_sub" type="button" value="&nbsp;&nbsp;保存&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</div>
</body>
</html>