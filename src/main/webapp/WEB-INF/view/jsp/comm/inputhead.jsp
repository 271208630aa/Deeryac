<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%@ include file="ie678.jsp"%>
<%@ include file="base.jsp"%>
<script type="text/javascript" src="<%=path%>/resources/uiframe/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript">
    var baseurl = "<%=path%>";
    var thisurl = window.location.href;
    var base_requrl = thisurl.substring(thisurl.indexOf(baseurl));
    base_requrl = base_requrl.substring(0, base_requrl.lastIndexOf("/"));
    var saveSuccess = "保存成功！";//保存成功提示文字

    $(function () {
        $("#submitForm").Validform({
            btnSubmit: "#btn_sub",
            tiptype: 2,
            ajaxPost: true,
            callback: function (data) {
                if (typeof(data) !== "undefined" && data !== null && data !== '') {
                    if (data.state == null || data.state == 1) {
                        layer.alert(saveSuccess, {
                            icon: 1
                        });
                        saveCallBack(data);
                        return;
                    }
                }
                layer.alert("保存失败！", {
                    icon: 1
                });
            }
        });
    });

    /**
     * 回调函数
     * @param data
     */
    function saveCallBack(data) {}
</script>
