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
</script>
