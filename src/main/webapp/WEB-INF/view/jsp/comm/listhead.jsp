<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%@ include file="ie678.jsp" %>
<%@ include file="base.jsp" %>
<script type="text/javascript" src="<%=path%>/resources/uiframe/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    var baseurl = "<%=path%>";
    var thisurl = window.location.href;
    var base_requrl = thisurl.substring(thisurl.indexOf(baseurl));
    base_requrl = base_requrl.substring(0, base_requrl.lastIndexOf("/"));
    $(document).ready(function () {
        laypage({
            cont: 'pager',
            pages: ${pager.totalPages}, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
            curr: function () { //通过url获取当前页，也可以同上（pages）方式获取
                var page = $("#currentPageno").val();
                return page ? page : 1;
            }(),
            skip: true, //是否开启跳页
            skin: 'molv',
            groups: 8, //连续显示分页数
            jump: function (e, first) { //触发分页后的回调
                if (!first) { //一定要加此判断，否则初始时会无限刷新
                    $("#currentPageno").val(e.curr);
                    document.forms[0].submit();
                }
            }
        });
    });

</script>
