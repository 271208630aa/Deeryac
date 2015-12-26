/**
 * 自己写的部分辅助框架
 *
 **/

var maskid;
//打开遮罩
function openMask() {
    maskid = layer.msg('加载中', {icon: 16, time: -1, shade: [0.8]});
}

//关闭遮罩
function closeMask() {
    layer.close(maskid);
}
/**
 * 表单保存方法
 */
var saveSuccess = "保存成功！";//保存成功提示文字
var saveClose = false;//保存成功是否关闭提示框
var saveAfterMethod = true;//保存成功是否调用回调方法
var saveUrl = null;
function formsave() {
    var pathurl = "";
    if (saveUrl == null || saveUrl == "") {
        pathurl = base_requrl + "/save";
    } else {
        pathurl = saveUrl;
    }
    alert(pathurl)
    timeout_i = 15;
    isOut = true;
    openMask();
    $.post(pathurl, $("#submitForm").serialize(), function (data) {
        closeMask();
        if (typeof(data) !== "undefined" && data !== null && data !== '') {
            if (data.state == null || data.state == 1) {
                layer.alert(data.msg, {
                    icon: 0
                });
                return ;
            }

        }
        layer.alert("保存失败！", {
            icon: 1
        });
        return;
    });

   /* $.ajax({
        url: pathurl,
        type: "POST",
        dataType: "json",
        data: $("#submitForm").serialize(),
        timeout: 1000 * 100,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            closeMask();
            layer.alert('请求超时！', {
                icon: 0
            });
        },
        success: function (data) {
            closeMask();
            if (typeof(data.state) !== "undefined" && data.state != null && data.state != '' && data.state != 0) {
                parent.layer.alert(data.msg, {
                    icon: 0,
                    skin: 'layer-ext-seaning'
                });
            } else {
                if (saveClose) {
                    if (saveAfterMethod) {
                        saveCallBack(data);
                    }
                } else {
                    layer.alert(saveSuccess, {
                        icon: 1,
                        skin: 'layer-ext-seaning'
                    }, function () {
                        if (saveAfterMethod) {
                            saveCallBack(data);
                        }
                    });
                }
            }
        }
    });*/
}

/**
 * 回调函数
 * @param data
 */
function saveCallBack(data) {
}

/**
 * 添加
 * @param url 路径
 * @param title 标题
 * @param width 宽度
 * @param height 高度
 */
function add(url, title, width, height) {
    if (typeof(title) === "undefined" || title === null || title === '') {
        title = "【" + document.title + "】 -> 维护"
    }
    if (typeof(url) === "undefined" || url === null || url === '') {
        url = base_requrl + "/openinput?reqtime=" + new Date().getMilliseconds();
    }
    if (typeof(width) === "undefined" || width === null || width === '') {
        width = document.body.clientWidth - 100;
    }
    if (typeof(height) === "undefined" || height === null || height === '') {
        height = document.body.clientHeight - 30;
    }
    layer_show(title, url, width, height);
}
/**
 * 编辑
 * @param id 主键
 * @param title 标题
 * @param url 路径
 */
function edit(id, title, url) {
    if (typeof(title) === "undefined" || title === null || title === '') {
        title = "【" + document.title + "】 -> 维护"
    }
    if (typeof(url) === "undefined" || url === null || url === '') {
        url = base_requrl + "/load?reqtime=" + new Date().getMilliseconds();
    }
    if (typeof(id) === "undefined" || id === null || id === '') {
        var slength = getCheckedCount();
        if (slength == 1) {
            id = getCheckBoxValueAsString("listCheck");
        } else {
            layer.alert("请勾选一条记录！", {icon: 5});
            return;
        }
    }
    url = url + "&id=" + id;

    if (typeof(width) === "undefined" || width === null || width === '') {
        width = document.body.clientWidth - 100;
    }
    if (typeof(height) === "undefined" || height === null || height === '') {
        height = document.body.clientHeight - 30;
    }
    layer_show(title, url, width, height);
}

/**
 * 删除
 */
function del() {
    var slength = getCheckedCount();
    if (slength > 0) {
        var ids = getCheckBoxValueAsString("listCheck");
        layerid = layer.confirm('确认要删除吗？', {
            btn: ['确认', '取消'] //按钮
        }, function () {
            openMask()
            $.post(base_requrl + "/remove", {'id': ids}, function (data) {
                closeMask();
                if (data.state == 1) {
                    layer.alert("已成功删除！", {icon: 3});
                } else {
                    layer.alert("删除失败！", {icon: 5});
                }
            });
        }, function () {
            layer.close(layerid)
        });

    } else {
        layer.alert("请勾选记录！", {icon: 5});
    }
}

function getCheckedCount() {
    slength = 0;
    var a = document.getElementsByName("listCheck");
    for (var i = 0; i < a.length; i++) {
        if (a[i].checked) {
            slength += 1;
        }
    }
    return slength;
}

/**
 * 创建新页面（tab）
 * @param titleName
 * @param href
 */
function addTab(titleName, href) {
    creatIframe(href, titleName);
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


/**
 * 把被选中的checkbox的值以字符串返回，用英文逗号隔开
 * @param {Object} checkboxName
 */
function getCheckBoxValueAsString(checkboxName) {
    var tmp = "";
    var a = document.getElementsByName(checkboxName);
    for (var i = 0; i < a.length; i++) {
        if (a[i].checked) {
            tmp += a[i].value + ",";
        }
    }
    tmp = tmp.substring(0, tmp.length - 1);
    return tmp;
}